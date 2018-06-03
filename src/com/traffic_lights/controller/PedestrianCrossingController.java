package com.traffic_lights.controller;

/**
 *  A basic example for a Controller. You can only connect one peripheral of each type.
 */
public class PedestrianCrossingController implements Controller {

    /**
     * The gloabal states of the signals system.
     */
    private enum State {
        CarsCrossing,
        TransitionCarsToPedestrains,
        PedestriansCrossing,
        TransitionPedestriansToCars
    }

    private TrafficLights trafficLights;
    private PedestrianCrossingLights pedestrianCrossingLights;
    private PedestrianInput pedestrianInput;
    private State state;

    /**
     * Creates a new PedestrianCrossingController object.
     */
    public PedestrianCrossingController() {

    }

    /**
     * Set the PedestrianCrossingLights that are user by this controller.
     *
     * @param pedestrianCrossingLights The PedestrianCrossingLights, that should be connected.
     * @param purpose The purpose of the PedestrianCrossingLights, this implementation accepts only 'main' as purpose.
     */
    @Override
    public void addPedestrianCrossingLights(PedestrianCrossingLights pedestrianCrossingLights, String purpose) {
        switch (purpose) {
            case "main":
                this.pedestrianCrossingLights = pedestrianCrossingLights;
                break;
        }
    }

    /**
     * Set the PedestrianInput that are used by this controller.
     *
     * @param pedestrianInput The PedestrianInput, that should be connected.
     * @param purpose The purpose of the PedestrianInput, this implementation accepts only 'main' as purpose.
     */
    @Override
    public void addPedestrianInput(PedestrianInput pedestrianInput, String purpose) {
        switch (purpose) {
            case "main":
                this.pedestrianInput = pedestrianInput;
                break;
        }
    }

    /**
     * Set the TrafficLights that are used by this controller.
     *
     * @param trafficLights The TrafficLights, that should be connected.
     * @param purpose The purpose of the TrafficLights, this implementation accepts only 'main' as purpose.
     */
    @Override
    public void addTrafficLights(TrafficLights trafficLights, String purpose) {
        switch (purpose) {
            case "main":
                this.trafficLights = trafficLights;
                break;
        }
    }

    /**
     * Forces this thread to sleep for the given period of seconds.
     *
      * @param seconds The time in seconds to wait.
     */
    private void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    /**
     * Runs the controller. This thread is implemented as an infinite loop.
     */
    @Override
    public void run() {
        state = State.CarsCrossing;
        trafficLights.turn(TrafficLights.State.Green);
        pedestrianCrossingLights.turn(PedestrianCrossingLights.State.Red);
        while (true) {
            switch (state) {

                case CarsCrossing:
                    if (pedestrianInput.isSet()) {
                        pedestrianInput.pause();
                        state = State.TransitionCarsToPedestrains;
                        wait(5);
                    }
                    wait(1);
                    break;

                case TransitionCarsToPedestrains:
                    trafficLights.turn(TrafficLights.State.Yellow);
                    wait(5);
                    trafficLights.turn(TrafficLights.State.Red);
                    wait(5);
                    pedestrianCrossingLights.turn(PedestrianCrossingLights.State.Green);
                    state = State.PedestriansCrossing;
                    break;

                case PedestriansCrossing:
                    wait(15);
                    state = State.TransitionPedestriansToCars;
                    break;

                case TransitionPedestriansToCars:
                    pedestrianCrossingLights.turn(PedestrianCrossingLights.State.Red);
                    wait(5);
                    trafficLights.turn(TrafficLights.State.RedYellow);
                    wait(5);
                    trafficLights.turn(TrafficLights.State.Green);
                    pedestrianInput.resume();
                    wait(15);
                    state = State.CarsCrossing;
                    break;
            }
        }
    }
}
