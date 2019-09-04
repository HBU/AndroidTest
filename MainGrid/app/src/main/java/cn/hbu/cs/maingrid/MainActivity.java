package cn.hbu.cs.maingrid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonCalculator,buttonLifeCycle,buttonIntent,buttonDialog,buttonMenu,buttonToast,buttonNotification,
    buttonListView,buttonServiceLocal,buttonServiceLifeCycle,buttonServiceBindDemo,buttonBroadcast1,buttonBroadcast2,buttonSharedPreferences,
    buttonDatabaseSQLite,buttonContentProvider,buttonWeatherJSON,buttonThreadUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取按钮的id
        buttonCalculator    = findViewById(R.id.buttonCalculator);
        buttonLifeCycle     = findViewById(R.id.buttonLifeCycle);
        buttonIntent        = findViewById(R.id.buttonIntent);
        buttonDialog        = findViewById(R.id.buttonDialog);
        buttonMenu          = findViewById(R.id.buttonMenu);
        buttonToast         = findViewById(R.id.buttonToast);
        buttonNotification  = findViewById(R.id.buttonNotification);
        buttonListView      = findViewById(R.id.buttonListView);
        buttonServiceLocal  = findViewById(R.id.buttonServiceLocal);
        buttonServiceLifeCycle = findViewById(R.id.buttonServiceLifeCycle);
        buttonServiceBindDemo = findViewById(R.id.buttonServiceBindDemo);
        buttonBroadcast1    = findViewById(R.id.buttonBroadcast1);
        buttonBroadcast2    = findViewById(R.id.buttonBroadcast2);
        buttonSharedPreferences = findViewById(R.id.buttonSharedPreferences);
        buttonDatabaseSQLite    = findViewById(R.id.buttonDatabaseSQLite);
        buttonContentProvider   = findViewById(R.id.buttonContentProvider);
        buttonWeatherJSON       = findViewById(R.id.buttonWeatherJSON);
        buttonThreadUpdate      = findViewById(R.id.buttonThreadUpdate);
        //为按钮添加监听器
        buttonCalculator.setOnClickListener(onClickListener);
        buttonLifeCycle.setOnClickListener(onClickListener);
        buttonIntent.setOnClickListener(onClickListener);
        buttonDialog.setOnClickListener(onClickListener);
        buttonMenu.setOnClickListener(onClickListener);
        buttonToast.setOnClickListener(onClickListener);
        buttonNotification.setOnClickListener(onClickListener);
        buttonListView.setOnClickListener(onClickListener);
        buttonServiceLocal.setOnClickListener(onClickListener);
        buttonServiceLifeCycle.setOnClickListener(onClickListener);
        buttonServiceBindDemo.setOnClickListener(onClickListener);
        buttonBroadcast1.setOnClickListener(onClickListener);
        buttonBroadcast2.setOnClickListener(onClickListener);
        buttonSharedPreferences.setOnClickListener(onClickListener);
        buttonDatabaseSQLite.setOnClickListener(onClickListener);
        buttonContentProvider.setOnClickListener(onClickListener);
        buttonWeatherJSON.setOnClickListener(onClickListener);
        buttonThreadUpdate.setOnClickListener(onClickListener);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {//侦听器
        @Override
        public void onClick(View view) {//点击事件
            Button button = (Button)view;   //把点击获得的id信息传递给button
            try{
                switch(button.getId())//获取点击按钮的ID，通过ID选择对应的选项执行
                {
                    case R.id.buttonCalculator://如果点击了按钮：“1”
                    {
                        Toast.makeText(getApplicationContext(), "计算器", Toast.LENGTH_SHORT).show();
                        //注意一定要把Activity注册到manifest文件
                        Intent intent = new Intent( MainActivity.this,CalculatorActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.buttonLifeCycle://2
                    {
                        Toast.makeText(getApplicationContext(), "Activity生命周期", Toast.LENGTH_SHORT).show();
                        //注意一定要把Activity注册到manifest文件
                        Intent intent = new Intent( MainActivity.this,LifeCycle1.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.buttonIntent://3
                    {
                        //注意一定要把Activity注册到manifest文件
                        Intent intent = new Intent( MainActivity.this,Intent1.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "界面跳转", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.buttonDialog://4
                    {
                        //注意一定要把Activity注册到manifest文件
                        Intent intent = new Intent( MainActivity.this,DialogMain.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "对话框", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.buttonMenu://5
                    {
                        Toast.makeText(getApplicationContext(), "菜单", Toast.LENGTH_SHORT).show();
                        //注意一定要把Activity注册到manifest文件
                        Intent intent = new Intent( MainActivity.this,MenuActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.buttonToast://6
                    {
                        Toast.makeText(getApplicationContext(), "吐司", Toast.LENGTH_SHORT).show();
                        //注意一定要把Activity注册到manifest文件
                        Intent intent = new Intent( MainActivity.this,ToastActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.buttonNotification://7
                    {
                        Toast.makeText(getApplicationContext(), "通知栏", Toast.LENGTH_SHORT).show();
                        //注意一定要把Activity注册到manifest文件
                        Intent intent = new Intent( MainActivity.this, NotificationActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.buttonListView://8
                    {
                        Toast.makeText(getApplicationContext(), "列表", Toast.LENGTH_SHORT).show();
                        //注意一定要把Activity注册到manifest文件
                        Intent intent = new Intent( MainActivity.this, ListMain.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.buttonServiceLocal://9
                    {
                        Toast.makeText(getApplicationContext(), "本地服务(音乐播放器)", Toast.LENGTH_SHORT).show();
                        //注意一定要把Activity注册到manifest文件
                        Intent intent = new Intent( MainActivity.this, ServiceLocalPlayMusic.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.buttonServiceLifeCycle://0 .setOnClickListener(onClickListener);
                    {
                        Toast.makeText(getApplicationContext(), "远程服务", Toast.LENGTH_SHORT).show();
//注意一定要把Activity注册到manifest文件
                        Intent intent = new Intent( MainActivity.this, ServiceLifeCycle.class);
                        startActivity(intent);
                        break;
                    }

                    case R.id.buttonServiceBindDemo://0 .setOnClickListener(onClickListener);
                    {
                        Toast.makeText(getApplicationContext(), "band服务", Toast.LENGTH_SHORT).show();
//注意一定要把Activity注册到manifest文件
                        Intent intent = new Intent( MainActivity.this, ServiceBindDemo.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.buttonBroadcast1://Clear
                    {
                        Toast.makeText(getApplicationContext(), "广播1", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent( MainActivity.this, BroadcastLifeCycleMain.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.buttonBroadcast2://.
                    {
                        Toast.makeText(getApplicationContext(), "广播2", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent( MainActivity.this, BroadcastBattery.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.buttonSharedPreferences://操作符+
                    {
                        Toast.makeText(getApplicationContext(), "共享参数", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent( MainActivity.this, SharedPreferencesDemo.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.buttonDatabaseSQLite://操作符-
                    {
                        Toast.makeText(getApplicationContext(), "本地数据库", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent( MainActivity.this, DatabaseMain.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.buttonContentProvider://操作符*
                    {
                        Toast.makeText(getApplicationContext(), "内容提供器", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent( MainActivity.this, ContentProviderDemo.class);
                        startActivity(intent);
                        break;
                    }

                    case R.id.buttonWeatherJSON://操作符 /
                    {
                        Toast.makeText(getApplicationContext(), "JSON天气预报", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent( MainActivity.this, JsonDemo.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.buttonThreadUpdate://操作符 =
                    {
                        Toast.makeText(getApplicationContext(), "子线程更新UI", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent( MainActivity.this, ThreadDemo.class);
                        startActivity(intent);
                        break;
                    }
                    default:
                        break;
                }
            }catch(Exception e){
                Log.e("David","error");
            }
        }
    };

}
