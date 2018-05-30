package com.traffic_lights.user;

import com.traffic_lights.input.Button;

import java.util.Random;

/**
 * Simulations a Pedestrian that pushes a button by chance between zero and twenty seconds.
 */
public class RandomUser implements  Runnable {

    private Button button;
    private String name;

    public RandomUser(String name, Button button) {
        this.name = name;
        this.button = button;
    }

    @Override
    public void run() {
        while (true) {
            int wait = (int) Math.round(Math.random() * 20000);
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.printf("%s pressed button %s\n",this,button);
            button.push();
        }
    }

    @Override
    public String toString() {
        return String.format("User %s", name);
    }
}

