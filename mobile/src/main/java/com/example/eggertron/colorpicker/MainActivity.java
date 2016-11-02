package com.example.eggertron.colorpicker;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

/*
    Color Picker App: First app created for use with Android Wear
    SETUP 1:
    Create new project and check boxes for Phone and Tablet and Wear.
    Select Minimum SDK API 21: 5.0 Lollipop
    Select "Always On Wear Activity"
    SETUP 2:
    Implement the UI
    SETUP 3: goto MainActivity Code
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ScrollView bg; // Reference to the ScrollView
    int colorIndex = 0; // saves current color index.
    TextView blue, yellow, maroon, orange;

    /*
        Gets the string in the TextView and changes the colorIndex.
     */
    public void ChangeColor(View view) {
        String color = ((TextView) view).getText().toString();
        switch (color) {
            case "Blue":
                colorIndex = 0;
                break;
            case "Yellow":
                colorIndex = 1;
                break;
            case "Maroon":
                colorIndex = 2;
                break;
            case "Orange":
                colorIndex = 3;
                break;
        }
    }

    /*
        Changes the background color based on colorIndex.
     */
    public void updateColor(int colorIndex) {
        switch (colorIndex) {
            case 0:
                bg.setBackgroundColor(Color.BLUE);
                break;
            case 1:
                bg.setBackgroundColor(Color.YELLOW);
                break;
            case 2:
                bg.setBackgroundColor(Color.rgb(102, 0, 0));
                break;
            case 3:
                bg.setBackgroundColor(Color.rgb(255, 102, 0));
                break;
        }
    }

    @Override
    public void onClick(View v) {
        String color = ((TextView) v).getText().toString();
        switch (color) {
            case "Blue":
                colorIndex = 0;
                break;
            case "Yellow":
                colorIndex = 1;
                break;
            case "Maroon":
                colorIndex = 2;
                break;
            case "Orange":
                colorIndex = 3;
                break;
        }
        updateColor(colorIndex);

        /*
            The simplest way to make the watch interact with the
            mobile is using notification. You don’t even have to code
            anything for the mobile side. To do that you can use
            NotificationCompat and NotificationManagerCompat.
        */
        //Send a notification to the watch
        int notificationID = 1;
        //The intent allows user opens the activity on the phone
        Intent viewIntent = new Intent(this, MainActivity.class);
        PendingIntent viewPendingIntent = PendingIntent.getActivity(this, 0, viewIntent, 0);
        //Use the notification builder to create a notification
        NotificationCompat.Builder notificationBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.cast_ic_notification_small_icon)
                        .setContentTitle("Simple Color Picker")
                        .setContentText("User has picked color : " + color)
                        .setContentIntent(viewPendingIntent);
        //Send the notification
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(notificationID, notificationBuilder.build());
    }

    // Go and update the UI of the watch face.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bg = (ScrollView) findViewById(R.id.bg);
        blue = (TextView) findViewById(R.id.blue);
        yellow = (TextView) findViewById(R.id.yellow);
        maroon = (TextView) findViewById(R.id.maroon);
        orange = (TextView) findViewById(R.id.orange);
        blue.setOnClickListener(this);
        yellow.setOnClickListener(this);
        maroon.setOnClickListener(this);
        orange.setOnClickListener(this);
    }
}
