package cn.hbu.cs.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView responseText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseText = (TextView) findViewById(R.id.responseText);
        sendRequest();

    }
    private void sendRequest() {
        // 开启线程来发起网络请求
        Log.e("wyg1","Thread run");
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    //获取到HttpConnection的实例，new出一个URL对象，并传入目标的网址，然后调用一下openConnection（）方法
                    URL url = new URL("http://www.weather.com.cn/data/sk/101090201.html");
                    Log.e("wyg2",url.toString());
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET"); //得到了HttpConnection的实例后，设置请求所用的方法（GET：从服务器获取数据，POST：提交数据给服务器）
                    connection.setConnectTimeout(8000);//设置连接超时，读取的毫秒数
                    connection.setReadTimeout(8000);

                    InputStream in = connection.getInputStream();//利用getInputStream（）方法获取服务器的返回的输入流，然后读取
                    reader = new BufferedReader(new InputStreamReader(in));// 对获取到的输入流进行读取

                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    Log.e("wyg3",response.toString());
                    showResponse(response.toString());//在模拟器显示返回值
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        //调用disconnect（）方法将HTTP连接关闭掉
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }
    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在这里进行UI操作，将结果显示到界面上
                responseText.setText(response);
            }
        });
    }
}
