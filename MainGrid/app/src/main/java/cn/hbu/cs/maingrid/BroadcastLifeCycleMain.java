package cn.hbu.cs.maingrid;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BroadcastLifeCycleMain extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_lifecycle);
        Button button = super.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String Intent_Action = "cn.hbu.cs.maingrid";
                Intent intent = new Intent(Intent_Action);
                //Android8在静态广播的使用上做了一些限制
                //https://blog.csdn.net/yegshun/article/details/81232775
                intent.setComponent(new ComponentName("cn.hbu.cs.maingrid","cn.hbu.cs.maingrid.BroadcastReceiverLifeCycle"));

                sendBroadcast(intent);
                Log.e("David","send broadcast");
            }
        });

    }
}