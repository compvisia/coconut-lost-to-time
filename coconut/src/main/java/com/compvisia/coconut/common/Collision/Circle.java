package com.compvisia.coconut.common.Collision;

import com.compvisia.coconut.Input.Mouse;
import com.compvisia.coconut.common.Math.Vector2f;

public class Circle {

    public double radius;
    public Vector2f pos;

    public Circle(Vector2f pos, double radius) { this.pos=pos; this.radius=radius; }

    public boolean hasCollided(Circle c) {
        return c != null && (c.pos.x-pos.x)*(c.pos.x-pos.x)+(c.pos.y-pos.y)*(c.pos.y-pos.y) > (radius+c.radius)*(radius+c.radius);
    }

}
