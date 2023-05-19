package com.compvisia.coconut.Components.UI;

import com.compvisia.coconut.Components.common.*;
import com.compvisia.coconut.Input.Mouse;
import com.compvisia.coconut.common.Collision.Rectangle;
import com.compvisia.coconut.common.Math.Vector2f;

public class Slider {

    private final Object bar, knob;

    private final String[] paths;
    public float value;

    public Slider(Rectangle rectangle, Vector2f knobSize, String[] paths) {
        this.paths=paths;

        bar = new Object(rectangle,this.paths[0]);
        knob = new Object(new Rectangle(0, rectangle.y-knobSize.y/4, knobSize.x, knobSize.y), this.paths[0]);
    }

    public void update() {

        knob.renderer.changePath(paths[0]);
        if(!knob.rectangle.hasCollided(Mouse.MousePos.pos)) return;
        else knob.renderer.changePath(paths[1]);

        if(knob.rectangle.hasCollided(Mouse.MousePos.pos)) knob.rectangle.x = Mouse.MousePos.pos.x-knob.rectangle.w/2;

        value = (knob.rectangle.x-bar.rectangle.x)/bar.rectangle.w+0.25f;
        if(value < 0) { knob.rectangle.x = bar.rectangle.x-knob.rectangle.w/2; value = 0; }
        if(value > 1) { knob.rectangle.x = bar.rectangle.x+bar.rectangle.w-knob.rectangle.w/2; value = 1; }
    }

    public void render() {
        bar.renderer.render();
        knob.renderer.render();
    }

    private static class Object {
        public Renderer renderer;
        public Rectangle rectangle;

        public Object(Rectangle rectangle, String s) {
            this.rectangle = rectangle;
            renderer = new Renderer(s,rectangle);
        }
    }

}
