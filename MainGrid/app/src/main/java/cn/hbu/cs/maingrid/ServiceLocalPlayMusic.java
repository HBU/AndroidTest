package cn.hbu.cs.maingrid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ServiceLocalPlayMusic extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_local);
        this.initView();
    }

    private void initView(){
        Button playButton = super.findViewById( R.id.play );
        Button stopButton = super.findViewById( R.id.stop );
        playButton.setOnClickListener( clickListener );
        stopButton.setOnClickListener( clickListener );
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch ( v.getId() ) {
                case R.id.play:
                    Log.d("David","Start service !");
                    Intent intent = new Intent();
                    intent.setAction("cn.hbu.cs.maingrid.ServiceLocalMusic");
                    intent.setPackage("cn.hbu.cs.maingrid");
                    startService(intent);
                    break;

                case R.id.stop:
                    Log.d("David","Stop service !");
                    Intent intent1 = new Intent();
                    intent1.setAction("cn.hbu.cs.maingrid.ServiceLocalMusic");
                    intent1.setPackage("cn.hbu.cs.maingrid");
                    stopService(intent1);
                    break;

                default:
                    break;
            }

        }
    };
}
