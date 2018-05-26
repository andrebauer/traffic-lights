package com.traffic_lights.controller;

public interface PedestrianCrossingLights {
    public enum State {
        Red,
        Green,
        Off
    }

    public void turn(State state);
}

