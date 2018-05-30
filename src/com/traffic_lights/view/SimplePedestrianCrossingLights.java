package com.traffic_lights.view;

import com.traffic_lights.controller.PedestrianCrossingLights;

/**
 * A basic PedestrianCrossingLights implementation that prints every change to its internal state to standard out.
 */
public class SimplePedestrianCrossingLights implements PedestrianCrossingLights {

    private String name;
    private State state;

    public SimplePedestrianCrossingLights(String name) {
        this.name = name;
        state = State.Red;
    }

    @Override
    public void turn(State state) {
        this.state = state;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("Simple Pedestrian Crossing Lights %s: %s", name, state);
    }

}


