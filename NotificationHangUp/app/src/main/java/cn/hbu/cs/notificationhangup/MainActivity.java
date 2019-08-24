package cn.hbu.cs.notificationhangup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

//https://blog.csdn.net/guolin_blog/article/details/79854070 郭霖

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickMe(View view){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "007";
            String channelName = "James Bond";
            NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
            Notification notification = new NotificationCompat.Builder(this, "007")
                .setContentTitle("What is 5G ?")
                .setContentText("But before we get to the smart phones, let's simply figure out what 5G is.")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.berry)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.berry))
                .setAutoCancel(true)
                .build();
            notificationManager.notify(1, notification);
        }
    }
}
