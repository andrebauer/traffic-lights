package com.traffic_lights.view;

import com.traffic_lights.controller.TrafficLights;

/**
 * A basic TrafficLights implementation that prints every change to its internal state to standard out.
 *
 * @author Andr&eacute; Bauer
 */
public class SimpleTrafficLights implements TrafficLights {

    private String name;
    private State state;

    /**
     * Creates a new SimpleTrafficLights object.
     *
     * @param name The name of the SimpleTrafficLights object.
     */
    public SimpleTrafficLights(String name) {
        this.name = name;
        state = State.Red;
    }

    /**
     * Switches the TrafficLights to the given state.
     *
     * @param state The new state of the TrafficLights.
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
        return String.format("Simple Traffic Lights %s: %s", name, state);
    }
}
