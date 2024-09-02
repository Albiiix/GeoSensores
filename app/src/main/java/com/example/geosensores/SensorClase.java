package com.example.geosensores;

import android.hardware.Sensor;

import java.util.UUID;

public class SensorClase {

    private String id;
    private Sensor sensor;

    public SensorClase(Sensor sensor){
        this.id = UUID.randomUUID().toString();
        this.sensor = sensor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString(){
        return this.sensor.getName();
    }
}
