package com.example.hyojin.quickcodingpedometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.content.Context.SENSOR_SERVICE;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    /**  **/
    final double GRAVITY = 9.8 ;

    /**  **/
    SensorManager sensorManager ;
    Sensor sensor ;

    /**  **/
    int up = 0 ;
    int down = 0 ;
    int count = 0 ;

    /**  **/
    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        textView = (TextView) findViewById(R.id.textView) ;
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        double accel = 0 ;

        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            accel =  Math.sqrt(x * x + y * y + z * z);
        }

        if (accel - GRAVITY > 5) { up = 1 ; }
        if (up == 1 && (GRAVITY - accel) > 5) { down = 1 ; }

        if (down == 1) {
            count++;
            textView.setText("Count: " + count);

            up = 0 ;
            down = 0;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {}
}
