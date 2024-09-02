package com.example.geosensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<SensorClase> listAdapter;
    private TextView salida;
    private List<SensorClase> listSensorCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listaSensor);
        SensorManager sensorManager =(SensorManager) getSystemService(SENSOR_SERVICE);

        listSensorCustom = new ArrayList<>();

        for(Sensor sensor: sensorManager.getSensorList(Sensor.TYPE_ALL)) listSensorCustom.add(new SensorClase(sensor));

        listAdapter = new ArrayAdapter<SensorClase>(this, android.R.layout.simple_list_item_1, listSensorCustom);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SensorClase actual = listAdapter.getItem(i);
                CharSequence texto = "Seleccionado: " + actual.getSensor().getVendor();

                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                intent.putExtra("ID", actual.getId());
                intent.putExtra("nombre", actual.getSensor().getName());
                intent.putExtra("power", actual.getSensor().getPower());
                intent.putExtra("resolucion", actual.getSensor().getResolution());
                intent.putExtra("tipo", actual.getSensor().getType());
                intent.putExtra("vendor", actual.getSensor().getVendor());
                intent.putExtra("version", actual.getSensor().getVersion());
                startActivity(intent);
            }
        });
    }
}