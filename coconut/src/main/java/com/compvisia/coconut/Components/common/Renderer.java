package com.compvisia.coconut.Components.common;

import com.compvisia.coconut.Graphics.Texture;
import com.compvisia.coconut.common.Collision.Rectangle;

public class Renderer {

    private final Texture texture;

    private Rectangle rectangle;

    public Renderer(String path, Rectangle rectangle) { this.rectangle=rectangle; texture = new Texture(path); }

    public void render() { texture.render(rectangle); }

    public void changePath(String path) { texture.create(path); }
}
