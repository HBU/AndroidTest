package cn.hbu.cs.maingrid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ServiceLifeCycle extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_lifecycle);
        Button StartService = findViewById(R.id.start_service_button);
        Button StopService = findViewById(R.id.stop_service_button);
        StartService.setOnClickListener(this);
        StopService.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_service_button:
                Intent startIntent = new Intent(ServiceLifeCycle.this, ServiceLife.class);
                startService(startIntent);
                break;
            case R.id.stop_service_button:
                Intent stopIntent = new Intent(ServiceLifeCycle.this, ServiceLife.class);
                stopService(stopIntent);
                break;
            default:
                break;
        }
    }
}
