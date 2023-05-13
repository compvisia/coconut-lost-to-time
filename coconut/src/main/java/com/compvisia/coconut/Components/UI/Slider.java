package com.compvisia.coconut.Components.UI;

import com.compvisia.coconut.Components.common.*;
import com.compvisia.coconut.Input.Mouse;
import com.compvisia.coconut.common.Math.Vector.Vector2f;
import com.compvisia.coconut.common.Math.Vector.Vector4f;

public class Slider {

    private final Object bar, knob;

    private final String[] paths;
    public float value;

    public Slider(Vector4f pos, Vector2f knobSize, String[] paths) {
        this.paths=paths;

        bar = new Object(pos,this.paths[0]);
        knob = new Object(new Vector4f(0, pos.y-knobSize.y/4, knobSize.x, knobSize.y), this.paths[0]);
    }

    public void update() {
        knob.r.changePath(paths[knob.c.hasCollided(Mouse.MousePos.pos).ordinal()]);
        if(knob.c.hasCollided(Mouse.MousePos.pos) == Collider.CollisionType.Clicked) knob.trans.v.x = Mouse.MousePos.pos.x-knob.trans.v.z/2;

        value = (knob.trans.v.x-bar.trans.v.x)/bar.trans.v.z+0.25f;
        if(value < 0) { knob.trans.v.x = bar.trans.v.x-knob.trans.v.z/2; value = 0; }
        if(value > 1) { knob.trans.v.x = bar.trans.v.x+bar.trans.v.z-knob.trans.v.z/2; value = 1; }
    }

    public void render() {
        bar.r.render();
        knob.r.render();
    }

    private static class Object {
        public Transform trans;
        public Renderer r;
        public Collider c;

        public Object(Vector4f v, String s) {
            trans = new Transform(v);
            r = new Renderer(s);
            c = new Collider();

            r.attach(trans);
            c.attach(trans);
        }
    }

}
