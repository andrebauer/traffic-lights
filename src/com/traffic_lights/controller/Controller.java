package com.traffic_lights.controller;

public interface Controller extends  Runnable {

    /**
     * Connects TrafficLights to the Controller.
     *
     * @param trafficLights The TrafficLights, that should be connected.
     * @param purpose The purpose of the TrafficLights, e.g. the lane or the direction. The expected values
     *                depend on the concrete implementation.
     */    
    void addTrafficLights(TrafficLights trafficLights,String purpose);

    /**
     * Connects PedestrianCrossingLights to the Controller.
     *
     * @param pedestrianCrossingLights The PedestrianCrossingLights, that should be connected.
     * @param purpose The purpose of the PedestrianCrossingLights, e.g. the lane they cross or the direction.
     *                The expected values depend on the concrete implementation.
     */
    void addPedestrianCrossingLights(PedestrianCrossingLights pedestrianCrossingLights, String purpose);
    
    /**
     * Connects a PedestrianInput to the Controller.
     *
     * @param pedestrianInput The PedestrianInput, that should be connected.
     * @param purpose The purpose of the PedestrianInput, e.g. the lane they cross or the direction.
     *                The expected values depend on the concrete implementation.
     */
    void addPedestrianInput(PedestrianInput pedestrianInput, String purpose);
}

