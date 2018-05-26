package com.traffic_lights.controller;

public interface TrafficLights {
    public enum State {
        Red,
        Green,
        Yellow,
        RedYellow,
        Off,
        Flash
    }

    public void turn(State state);
}
