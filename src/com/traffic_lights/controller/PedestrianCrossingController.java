package com.traffic_lights.controller;

public class PedestrianCrossingController implements Controller {

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

    public PedestrianCrossingController() {

    }

    @Override
    public void addPedestrianCrossingLights(PedestrianCrossingLights pedestrianCrossingLights, String purpose) {
        switch (purpose) {
            case "main":
                this.pedestrianCrossingLights = pedestrianCrossingLights;
                break;
        }
    }

    @Override
    public void addPedestrianInput(PedestrianInput pedestrianInput, String purpose) {
        switch (purpose) {
            case "main":
                this.pedestrianInput = pedestrianInput;
                break;
        }
    }

    @Override
    public void addTrafficLights(TrafficLights trafficLights, String purpose) {
        switch (purpose) {
            case "main":
                this.trafficLights = trafficLights;
                break;
        }
    }

    private void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

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
