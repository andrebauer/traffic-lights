package com.traffic_lights.input;

import com.traffic_lights.controller.PedestrianInput;

/**
 * A basic implementation of an user input.
 */
public class SimpleButton implements Button, PedestrianInput {
    private State state;
    private String name;

    /**
     * Creates a button object with a given name.
     *
     * @param name The name of the button.
     */
    public SimpleButton(String name) {
        state = State.Resumed;
        this.name = name;
    }

    /**
     * Checks wheter the state is Pushed.
     *
     * @return true iff the input is set since it was resumed.
     */
    @Override
    public boolean isSet() {
        return state == State.Pushed;
    }

    /**
     * Turns the state to Resumed.
     */
    @Override
    public void resume() {
        state = State.Resumed;
        System.out.println(this);
    }

    /**
     * Turns the state to Paused. In this state using push won't have an effect.
     */
    @Override
    public void pause() {
        state = State.Paused;
        System.out.println(this);
    }

    /**
     * Turns the state to Pushed iff the currect state is Resumed.
     */
    @Override
    public void push() {
        if (state == State.Resumed) {
            state = State.Pushed;
            System.out.println(this);
        }
    }

    /**
     * Creates a string representation.
     *
     * @return The string representation.
     */
    @Override
    public String toString() {
        return String.format("SimpleButton %s with State %s", name, state);
    }

    /**
     * The three possible states of a SimpleButton.
     */
    private enum State {
        Pushed,
        Resumed,
        Paused
    }
}
