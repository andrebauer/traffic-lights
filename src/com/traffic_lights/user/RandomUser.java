package com.traffic_lights.user;

import com.traffic_lights.input.Button;

import java.util.Random;

/**
 * Simulations a Pedestrian that pushes a button by chance between zero and twenty seconds.
 *
 * @author Andr&eacute; Bauer
 */
public class RandomUser implements  Runnable {

    private Button button;
    private String name;

    /**
     * Creates an RandomUser object with a given name and the button the user should periodically push.
     *
     * @param name The name of the RandomUser.
     * @param button The button the user should periodically push.
     */
    public RandomUser(String name, Button button) {
        this.name = name;
        this.button = button;
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
     * Runs the RandomUser thread. This thread will call turn on the button in between zero and
     * twenty seconds.
     */
    @Override
    public void run() {
        while (true) {
            wait((int) Math.round(Math.random() * 20));
            System.out.printf("%s pressed button %s\n",this,button);
            button.push();
        }
    }

    /**
     * Returns a string representation of the user.
     *
     * @return A string representation of the user.
     */
    @Override
    public String toString() {
        return String.format("User %s", name);
    }
}

