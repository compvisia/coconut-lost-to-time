package com.compvisia.coconut.Input;

import org.lwjgl.glfw.GLFWKeyCallback;

import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class Keyboard extends GLFWKeyCallback {

    public boolean[] keys = new boolean[65535];

    @Override public void invoke(long window, int key, int sc, int act, int mods) { if(key > 0) keys[key] = act != GLFW_RELEASE; }
}