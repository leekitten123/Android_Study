package com.example.hyojin.quickcordingsensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    /**  **/
    SensorManager sensorManager;

    /**  **/
    TextView textGravity, textAccel, textLinear, textGyro ;
    Sensor sensorGravity, sensorAccel, sensorLinear, sensorGyro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorGravity = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensorAccel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorLinear = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensorGyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        textGravity = (TextView) findViewById(R.id.textGravity) ;
        textAccel = (TextView) findViewById(R.id.textAccel) ;
        textLinear = (TextView) findViewById(R.id.textLinear) ;
        textGyro = (TextView) findViewById(R.id.textGyro) ;
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorGravity, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, sensorAccel, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, sensorLinear, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, sensorGyro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch(event.sensor.getType()){
            case Sensor.TYPE_GRAVITY:
                textGravity.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2] + "\n\n");
                break;
            case Sensor.TYPE_ACCELEROMETER:
                textAccel.setText("X : " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2] + "\n\n");
                break;
            case Sensor.TYPE_LINEAR_ACCELERATION:
                textLinear.setText("X : " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2] + "\n\n");
                break;
            case Sensor.TYPE_GYROSCOPE:
                textGyro.setText("X : " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2]);
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}