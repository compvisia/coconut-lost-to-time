package com.compvisia.coconut.Graphics;

import com.compvisia.coconut.Input.Mouse;
import com.compvisia.coconut.common.Math.Vector2i;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.opengl.GL;

import java.nio.ByteBuffer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glViewport;
import static org.lwjgl.stb.STBImage.stbi_load;

public class Window {

    public final long window;
    public static Vector2i size;

    public static Mouse m;

    public Window(String name, Vector2i size, String icon) {
        glfwInit();

        Window.size = size;

        window = glfwCreateWindow(size.x, size.y, name, 0L, 0L);

        glfwMakeContextCurrent(window);
        glfwSwapInterval(0);
        GL.createCapabilities();

        glfwSetWindowIcon(window,getImage(icon));
        updateFrame();

        glfwShowWindow(window);

        m = new Mouse();

        glfwSetCursorPosCallback(window, m.MousePosCallback);
        glfwSetMouseButtonCallback(window, m.MouseClickCallback);
    }

    // 64x64 Image Recommended
    private GLFWImage.Buffer getImage(String icon) {
        int[] w = new int[1],h = new int[1],c = new int[1];
        ByteBuffer d = stbi_load(icon, w, h, c, 4);
        assert d != null;
        GLFWImage i = GLFWImage.malloc(); i.set(512,512,d);
        GLFWImage.Buffer b = GLFWImage.malloc(1);
        b.put(i); i.free(); b.position(0);
        return b;
    }

    public void updateFrame() {
        int[] x = new int[1],y = new int[1];
        glfwGetWindowSize(window,x,y);

        if(size.x==x[0]&&size.y==y[0]) return;

        size.x = x[0];
        size.y = y[0];

        glViewport(0,0,size.x, size.y);
    }

}
