package cn.hbu.cs.maingrid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BroadcastReceiverLifeCycle extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        String Intent_Action = intent.getAction();
        if ("cn.hbu.cs.maingrid".equals(Intent_Action)) {
            Log.e("David", "onReceive");
            Toast.makeText(context, "收到广播！", Toast.LENGTH_SHORT).show();
        }
    }
}