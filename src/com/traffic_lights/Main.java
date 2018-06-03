package com.traffic_lights;

import com.traffic_lights.controller.Controller;
import com.traffic_lights.controller.PedestrianCrossingController;
import com.traffic_lights.controller.PedestrianCrossingLights;
import com.traffic_lights.controller.TrafficLights;
import com.traffic_lights.input.SimpleButton;
import com.traffic_lights.user.RandomUser;
import com.traffic_lights.view.SimplePedestrianCrossingLights;
import com.traffic_lights.view.SimpleTrafficLights;

/**
 * Connects all components and starts the controller and user threads.
 */
public class Main {

    public static void main(String[] args) {

        SimpleButton button1 = new SimpleButton("B1");
        RandomUser user1 = new RandomUser("Random",button1);
        Thread userThread1 = new Thread(user1);
        PedestrianCrossingLights spcl = new SimplePedestrianCrossingLights("PS1");
        TrafficLights stl = new SimpleTrafficLights("TS1");
        Controller pedestrianCrossingController = new PedestrianCrossingController();
        pedestrianCrossingController.addPedestrianCrossingLights(spcl,"main");
        pedestrianCrossingController.addTrafficLights(stl,"main");
        pedestrianCrossingController.addPedestrianInput(button1,"main");
        Thread controllerThread = new Thread(pedestrianCrossingController);
        System.out.println(user1);
        System.out.println(spcl);
        System.out.println(stl);
        System.out.println(button1);
        controllerThread.start();
        userThread1.start();
        System.out.println("System and User started");
    }
}
