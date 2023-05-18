package com.compvisia.coconut.Components.common;

import com.compvisia.coconut.Graphics.Texture;

public class Renderer {

    private final Texture texture;

    private Transform transform;

    public Renderer(String path) { texture = new Texture(path); }

    public void render() { if(transform != null) texture.render(transform); }

    public void changePath(String path) { texture.create(path); }

    // Attachments
    public void attach(Transform transform) { this.transform = transform; }

}
