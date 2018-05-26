package com.traffic_lights.input;

import com.traffic_lights.controller.PedestrianInput;

public class SimpleButton implements Button, PedestrianInput {
    private State state;
    private String name;

    public SimpleButton(String name) {
        state = State.Resumed;
        this.name = name;
    }

    @Override
    public boolean isSet() {
        return state == State.Pushed;
    }

    @Override
    public void resume() {
        state = State.Resumed;
        System.out.println(this);
    }

    @Override
    public void pause() {
        state = State.Paused;
        System.out.println(this);
    }

    @Override
    public void push() {
        if (state == State.Resumed) {
            state = State.Pushed;
            System.out.println(this);
        }
    }

    @Override
    public String toString() {
        return String.format("SimpleButton %s with State %s", name, state);
    }

    private enum State {
        Pushed,
        Resumed,
        Paused
    }
}
