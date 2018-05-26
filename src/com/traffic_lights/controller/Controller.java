package com.traffic_lights.controller;

public interface Controller extends  Runnable {
    public void addTrafficLights(TrafficLights trafficLights,String purpose);

    public void addPedestrianCrossingLights(PedestrianCrossingLights pedestrianCrossingLights, String purpose);

    public void addPedestrianInput(PedestrianInput pedestrianInput, String purpose);
}
