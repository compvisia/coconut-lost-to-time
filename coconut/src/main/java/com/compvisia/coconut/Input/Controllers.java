package com.compvisia.coconut.Input;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;

public class Controllers {

    public List<Controller> controllers;

    public Controllers() {
        controllers = new ArrayList<>();

        if(!glfwJoystickPresent(0)) return;

        int i=0;
        while(glfwJoystickPresent(i)) { controllers.add(new Controller(i));i++; }
    }

    public void poll() { controllers.forEach(Controller::poll); }

    public static class Controller {

        public static final int LEFT_STICK=0;
        public static final int RIGHT_STICK=1;

        public FloatBuffer axes;
        public ByteBuffer buttons, hats;
        public int joystick;

        public Controller(int joystick) {
            this.joystick = joystick;
        }

        public void poll() {
            axes = glfwGetJoystickAxes(joystick);
            buttons = glfwGetJoystickButtons(joystick);
            hats = glfwGetJoystickHats(joystick);
        }
    }

    public static class Axis {

        private final Controller controller;

        public int binding;

        public float[] rawInput;

        public Axis(Controller controller, int binding) {
            this.controller = controller; this.binding=binding;
            rawInput = new float[2];
        }

        public void setBindings(int binding) { this.binding=binding; }

        public void poll() {
            if(binding == Controller.LEFT_STICK)  { rawInput[0] = controller.axes.get(0); rawInput[1] = controller.axes.get(1); }
            if(binding == Controller.RIGHT_STICK) { rawInput[0] = controller.axes.get(2); rawInput[1] = controller.axes.get(3); }
        }
    }
}
