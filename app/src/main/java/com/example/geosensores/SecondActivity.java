package com.example.geosensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements SensorEventListener {

    private TextView nombre, tipo, vendor, resolucion, power, version, medicion;
    private SensorManager sensorManager;
    private Sensor dataSensor;

    String tipoS = "-1";
    float valor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getExtras();
        String idS = bundle.get("ID").toString();
        String nombreS = bundle.get("nombre").toString();
        tipoS = bundle.get("tipo").toString();
        String vendorS = bundle.get("vendor").toString();
        String resolucionS = bundle.get("resolucion").toString();
        String powerS = bundle.get("power").toString();
        String versionS = bundle.get("version").toString();

        nombre = findViewById(R.id.txtNombre);
        tipo = findViewById(R.id.txtTipoSensor);
        vendor = findViewById(R.id.txtVendor);
        resolucion = findViewById(R.id.txtResolucion);
        power = findViewById(R.id.txtPoder);
        version = findViewById(R.id.txtVersion);
        medicion= findViewById(R.id.txtInfoSensor);

        nombre.setText(nombreS);
        tipo.setText(tipoS);
        vendor.setText(vendorS);
        resolucion.setText(resolucionS);
        power.setText(powerS);
        version.setText(versionS);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        switch (Integer.parseInt(tipoS)){
            //Sensores de movimiento
            case Sensor.TYPE_ACCELEROMETER:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                break;

            case Sensor.TYPE_ACCELEROMETER_UNCALIBRATED:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER_UNCALIBRATED);
                break;

            case Sensor.TYPE_GRAVITY:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
                break;

            case Sensor.TYPE_GYROSCOPE:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
                break;

            case Sensor.TYPE_GYROSCOPE_UNCALIBRATED:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE_UNCALIBRATED);
                break;

            case Sensor.TYPE_LINEAR_ACCELERATION:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
                break;

            case Sensor.TYPE_ROTATION_VECTOR:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
                break;

            case Sensor.TYPE_STEP_COUNTER:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
                break;

            //Sensores de entorno
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
                break;

            case Sensor.TYPE_LIGHT:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
                break;

            case Sensor.TYPE_PRESSURE:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
                break;

            case Sensor.TYPE_RELATIVE_HUMIDITY:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
                break;

            //Sensores de posicion
            case Sensor.TYPE_GAME_ROTATION_VECTOR:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);
                break;

            case Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);
                break;

            case Sensor.TYPE_MAGNETIC_FIELD:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
                break;

            case Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED);
                break;

            case Sensor.TYPE_ORIENTATION:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
                break;

            case Sensor.TYPE_PROXIMITY:
                dataSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
                break;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        sensorManager.registerListener((SensorEventListener) this, dataSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        sensorManager.unregisterListener((SensorEventListener) this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch ( Integer.parseInt(tipoS) )
        {
            //Sensores de movimiento
            case Sensor.TYPE_ACCELEROMETER:
                medicion.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2]);
                break;

            case Sensor.TYPE_ACCELEROMETER_UNCALIBRATED:
                medicion.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2]);
                break;

            case Sensor.TYPE_GRAVITY:
                medicion.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2]);
                break;

            case Sensor.TYPE_GYROSCOPE:
                medicion.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2]);
                break;

            case Sensor.TYPE_GYROSCOPE_UNCALIBRATED:
                medicion.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2]);
                break;

            case Sensor.TYPE_LINEAR_ACCELERATION:
                medicion.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2]);
                break;

            case Sensor.TYPE_ROTATION_VECTOR:
                medicion.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2]);
                break;

            case Sensor.TYPE_STEP_COUNTER:
                valor = event.values[0];
                medicion.setText(valor+" Steps");
                break;

            //Sensores de entorno
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                valor = event.values[0];
                medicion.setText(valor+" ºC");
                break;

            case Sensor.TYPE_LIGHT:
                valor = event.values[0];
                medicion.setText(valor+" lux");
                break;

            case Sensor.TYPE_PRESSURE:
                valor = event.values[0];
                medicion.setText(valor+" hPa");
                break;

            case Sensor.TYPE_RELATIVE_HUMIDITY:
                valor = event.values[0];
                medicion.setText(valor+" %");
                break;

            //Sensores de posicion
            case Sensor.TYPE_GAME_ROTATION_VECTOR:
                medicion.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2]);
                break;

            case Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR:
                medicion.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2]);
                break;

            case Sensor.TYPE_MAGNETIC_FIELD:
                medicion.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2]);
                break;

            case Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED:
                medicion.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2]);
                break;

            case Sensor.TYPE_ORIENTATION:
                medicion.setText("X: " + event.values[SensorManager.DATA_X] + "\nY: " + event.values[SensorManager.DATA_Y] + "\nZ: " + event.values[SensorManager.DATA_Z]);
                break;

            case Sensor.TYPE_PROXIMITY:
                valor = event.values[0];
                medicion.setText(valor+" cm");
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}