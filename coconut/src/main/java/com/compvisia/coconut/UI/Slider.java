package com.compvisia.coconut.UI;

import com.compvisia.coconut.Graphics.Texture;
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

        knob.texture.create(paths[0]);
        if(!knob.rectangle.hasCollided(Mouse.MousePos.pos)) return;
        else knob.texture.create(paths[1]);

        if(knob.rectangle.hasCollided(Mouse.MousePos.pos)) knob.rectangle.x = Mouse.MousePos.pos.x-knob.rectangle.w/2;

        value = (knob.rectangle.x-bar.rectangle.x)/bar.rectangle.w+0.25f;
        if(value < 0) { knob.rectangle.x = bar.rectangle.x-knob.rectangle.w/2; value = 0; }
        if(value > 1) { knob.rectangle.x = bar.rectangle.x+bar.rectangle.w-knob.rectangle.w/2; value = 1; }
    }

    public void render() {
        bar.texture.render(bar.rectangle);
        knob.texture.render(knob.rectangle);
    }

    private static class Object {
        public Texture texture;
        public Rectangle rectangle;

        public Object(Rectangle rectangle, String s) {
            this.rectangle = rectangle;
            texture = new Texture(s);
        }
    }

}
