package cn.hbu.cs.maingrid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Intent4 extends Activity {
    public TextView textView ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent4);
        Button button = (Button) findViewById( R.id.getPara);
        textView = (TextView)findViewById(R.id.textPara) ;
        button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                String university = bundle.getString("University");
                String college = bundle.getString("College");
                textView.setText(university + ":" +college);

//                Intent intent=getIntent();
//                String string=intent.getStringExtra("data");
//                textView.setText(string);
            }
        });
    }
}
