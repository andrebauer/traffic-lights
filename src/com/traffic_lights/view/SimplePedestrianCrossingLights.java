package com.traffic_lights.view;

import com.traffic_lights.controller.PedestrianCrossingLights;

/**
 * A basic PedestrianCrossingLights implementation that prints every change to its internal state to standard out.
 *
 * @author Andr&eacute; Bauer
 */
public class SimplePedestrianCrossingLights implements PedestrianCrossingLights {

    private String name;
    private State state;

    /**
     * Creates a new SimplePedestrianCrossingLights object.
     *
     * @param name The name of the SimplePedestrianCrossingLights.
     */
    public SimplePedestrianCrossingLights(String name) {
        this.name = name;
        state = State.Red;
    }

    /**
     * Switches the PedestrianCrossingLights to the given state.
     *
     * @param state The new state for the PedestrianCrossingLights.
     */
    @Override
    public void turn(State state) {
        this.state = state;
        System.out.println(this);
    }


    /**
     * Creates a string representation.
     *
     * @return A string representation.
     */
    @Override
    public String toString() {
        return String.format("Simple Pedestrian Crossing Lights %s: %s", name, state);
    }

}


