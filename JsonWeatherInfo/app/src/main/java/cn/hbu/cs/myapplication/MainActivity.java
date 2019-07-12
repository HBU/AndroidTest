package cn.hbu.cs.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView sp_province;
    TextView tv_sl; //  tv_show;
    String db_name = "weather";
    String db_path ="data/data/cn.hbu.cs.myapplication/database/";

    HttpURLConnection httpConn = null;
    InputStream din =null;
    Button find = null;
    EditText value = null;
    TextView tv_show = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("天气预报JSON");
        find = (Button)findViewById(R.id.find);
        //value = (EditText)findViewById(R.id.value);
        //value.setText("汕头");初始化，给个初值，方便测试
        tv_show = (TextView)findViewById(R.id.tv_show);

        copydb();
        sp_province=(AutoCompleteTextView)findViewById(R.id.sp_province);
        sp_province.setThreshold(1);
        sp_province.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString();
                SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(db_path+db_name,null);
                Cursor cursor = null;
                String sqlWeathers = "select area_name from weathers where area_name like '%"+str+"%'";
                Log.i("weather",sqlWeathers);
                try {
                    cursor = db.rawQuery(sqlWeathers,null);
                    }
                catch (Exception ee){
                    ee.printStackTrace();
                }

                List<String> list = new ArrayList<>();
                String pro="";
                while (cursor.moveToNext()){
                    pro = cursor.getString(cursor.getColumnIndex("area_name"));
                    list.add(pro);
                }
                cursor.close();
                //为下拉列表定义一个适配器，这里就用到前面定义的list
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,list);
                //将适配器添加到下拉列表上
                sp_province.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_show.setText("");//清空数据
                Toast.makeText(MainActivity.this, "正在查询天气信息", Toast.LENGTH_SHORT).show();
                Log.i("weather",sp_province.getText().toString());
                GetJson gd = new GetJson(sp_province.getText().toString());//调用线程类创建的对象
                gd.start();//运行线程对象
            }
        });
    }

    private void copydb() {
        File db_file = new File(db_path+db_name);
        if (!db_file.exists()){
            //如果第一次运行，文件不存在，那么就建立database目录,并从raw目录下复制db_weather.db
            Log.i("weather","数据库创建好了");
            File db_dir = new File(db_path);
            if (!db_dir.exists()){
                db_dir.mkdir();
            }
            InputStream is = getResources().openRawResource(R.raw.weather);
            //获取输入流，就是随程序打包，放到raw目录下的db_weater.db文件
            try {
                OutputStream os = new FileOutputStream(db_path+db_name);
                byte[] buff = new  byte[1024];
                int length = 0;
                while ((length=is.read(buff))>0){
                    os.write(buff,0,length);
                }
                os.flush();
                os.close();
                is.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    private final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 123:
                    showData((String)msg.obj);
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private  void showData(String jData){
        try {
            JSONObject jobj = new JSONObject(jData);
            JSONObject weather = jobj.getJSONObject("data");
            StringBuffer wbf = new StringBuffer();
            wbf.append("天气提示："+weather.getString("ganmao")+"\n");
            wbf.append("当前温度："+weather.getString("wendu")+"\n");
            JSONArray jary = weather.getJSONArray("forecast");
            for(int i=0;i<jary.length();i++){
                JSONObject pobj = (JSONObject)jary.opt(i);
                wbf.append("日期："+pobj.getString("date")+"\n");
                wbf.append("高温："+pobj.getString("high")+"\n");
                wbf.append("低温："+pobj.getString("low")+"\n");
                String s = pobj.getString("fengli");

                String s1 =  s.replace("<![CDATA["," ");
                String s2 = s1.replace("]]>"," ");
                wbf.append("风向："+pobj.getString("fengxiang")+"  风力："+s2+"\n");

                wbf.append("天气："+pobj.getString("type")+"\n");

            }
            tv_show.setText(wbf.toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

    class GetJson extends Thread{

        private String urlstr =  "http://wthrcdn.etouch.cn/weather_mini?city=";
        public GetJson(String cityname){
            try{
                urlstr = urlstr+ URLEncoder.encode(cityname,"UTF-8");
            }catch (Exception ee){

            }
        }

        @Override
        public void run() {
            try {
                URL url = new URL(urlstr);
                httpConn = (HttpURLConnection)url.openConnection();
                httpConn.setRequestMethod("GET");
                din = httpConn.getInputStream();

                InputStreamReader in = new InputStreamReader(din);
                BufferedReader buffer = new BufferedReader(in);
                StringBuffer sbf = new StringBuffer();
                String line = null;
                while( (line=buffer.readLine())!=null) {
                    sbf.append(line);
                }
                Message msg = new Message();
                msg.obj = sbf.toString();
                msg.what = 123;
                handler.sendMessage(msg);
                Looper.prepare(); //在线程中调用Toast，要使用此方法。这里纯粹演示用:)
                Toast.makeText(MainActivity.this,"获取数据成功",Toast.LENGTH_LONG).show();
                Looper.loop(); //在线程中调用Toast，要使用此方法
            }catch (Exception ee){
                Looper.prepare(); //在线程中调用Toast，要使用此方法
                Toast.makeText(MainActivity.this,"获取数据失败，网络连接失败或输入有误",Toast.LENGTH_LONG).show();
                Looper.loop(); //在线程中调用Toast，要使用此方法
                ee.printStackTrace();
            }finally {
                try{
                    httpConn.disconnect();
                    din.close();
                }catch (Exception ee){
                    ee.printStackTrace();
                }
            }
        }
    }
}










