package com.traffic_lights.controller;

public interface Controller extends  Runnable {

    /**
     * Connects TrafficLights to the Controller.
     *
     * @param trafficLights The TrafficLights, that should be connected.
     * @param purpose The purpose of the TrafficLights, e.g. the lane or the direction. The expected values
     *                depend on the concrete implementation.
     */    
    public void addTrafficLights(TrafficLights trafficLights,String purpose);

    /**
     * Connects PedestrianCrossingLights to the Controller.
     *
     * @param pedestrianCrossingLights The PedestrianCrossingLights, that should be connected.
     * @param purpose The purpose of the PedestrianCrossingLights, e.g. the lane they cross or the direction.
     *                The expected values depend on the concrete implementation.
     */
    public void addPedestrianCrossingLights(PedestrianCrossingLights pedestrianCrossingLights, String purpose);
    
    /**
     * Connects a PedestrianInput to the Controller.
     *
     * @param pedestrianInput
     * @param purpose
     */
    public void addPedestrianInput(PedestrianInput pedestrianInput, String purpose);
}

