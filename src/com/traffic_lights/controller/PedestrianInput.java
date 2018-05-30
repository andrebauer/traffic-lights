package com.traffic_lights.controller;

/**
 * The Interface of a PedestrianInput used by the Controller and provided by the input component.
 *
 */
public interface PedestrianInput {

    /**
     * Checks whether the input is set, e.g. the button has been pressed since the input was resumed.
     *
     * @return true iff the input is set since it was resumed.
     */
    public boolean isSet();

    /**
     * Resumes the input, now it can be set by the user.
     */
    public void resume();

    /**
     * Pauses the input, it's state cannot be modified.
     */
    public void pause();
}
