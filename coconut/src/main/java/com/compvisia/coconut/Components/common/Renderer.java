package com.compvisia.coconut.Components.common;

import com.compvisia.coconut.Graphics.Texture;

public class Renderer {

    private final Texture t;

    private Transform transform;

    public Renderer(String path) { t = new Texture(path); }

    public void render() { if(transform != null) t.render(transform); }

    public void changePath(String path) { t.create(path); }

    // Attachments
    public void attach(Transform transform) { this.transform = transform; }

}
