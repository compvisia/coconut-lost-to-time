package com.compvisia.coconut.Input;

import com.compvisia.coconut.common.Math.Vector.Vector2f;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class Mouse {

    public MouseClick MouseClickCallback;
    public MousePos MousePosCallback;

    public Mouse() {
        MouseClickCallback = new MouseClick();
        MousePosCallback = new MousePos();
    }

    public static class MouseClick extends GLFWMouseButtonCallback {
        public static boolean[] buttons = new boolean[8];

        @Override public void invoke(long window, int button, int act, int mods) { buttons[button] = act != GLFW_RELEASE; }
    }

    public static class MousePos extends GLFWCursorPosCallback {

        public static Vector2f pos = new Vector2f(0,0);

        @Override
        public void invoke(long window, double x, double y) {
            if(pos == null) return;
            if(pos.x == x && pos.y == y) return;
            pos.x=(float)x;pos.y=(float)y;
        }
    }
}
