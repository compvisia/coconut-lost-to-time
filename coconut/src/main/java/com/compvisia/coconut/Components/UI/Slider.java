package com.compvisia.coconut.Components.UI;

import com.compvisia.coconut.Components.common.*;
import com.compvisia.coconut.Input.Mouse;
import com.compvisia.coconut.common.Collision.CollisionType;
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
        knob.renderer.changePath(paths[knob.collider.hasCollided(Mouse.MousePos.pos).ordinal()]);
        if(knob.collider.hasCollided(Mouse.MousePos.pos) == CollisionType.Clicked) knob.transform.rectangle.x = Mouse.MousePos.pos.x-knob.transform.rectangle.w/2;

        value = (float) ((knob.transform.rectangle.x-bar.transform.rectangle.x)/bar.transform.rectangle.w+0.25f);
        if(value < 0) { knob.transform.rectangle.x = bar.transform.rectangle.x-knob.transform.rectangle.w/2; value = 0; }
        if(value > 1) { knob.transform.rectangle.x = bar.transform.rectangle.x+bar.transform.rectangle.w-knob.transform.rectangle.w/2; value = 1; }
    }

    public void render() {
        bar.renderer.render();
        knob.renderer.render();
    }

    private static class Object {
        public Transform transform;
        public Renderer renderer;
        public Collider collider;

        public Object(Rectangle rectangle, String s) {
            transform = new Transform(rectangle);
            renderer = new Renderer(s);
            collider = new Collider();

            renderer.attach(transform);
            collider.attach(transform);
        }
    }

}
