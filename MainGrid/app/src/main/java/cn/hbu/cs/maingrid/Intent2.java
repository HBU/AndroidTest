package cn.hbu.cs.maingrid;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

public class Intent2 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intent2);

    }
}