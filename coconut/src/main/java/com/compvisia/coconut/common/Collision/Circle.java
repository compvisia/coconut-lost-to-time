package com.compvisia.coconut.common.Collision;

import com.compvisia.coconut.Input.Mouse;
import com.compvisia.coconut.common.Math.*;

public class Circle {

    private double radius;
    private Vector2d pos;

    public Circle(Vector2d pos, double radius) { this.pos=pos; this.radius=radius; }
    public Circle(Vector2f pos, float radius)  { this.pos = new Vector2d(pos.x,pos.y); this.radius=radius; }

    public CollisionType hasCollided(Circle c) {
        if(c == null) return CollisionType.Null;

        double distance = (c.pos.x-pos.x)*(c.pos.x-pos.x)+(c.pos.y-pos.y)*(c.pos.y-pos.y);
        if(!(distance > (radius+c.radius)*(radius+c.radius))) return CollisionType.None;
        if(!Mouse.MouseClick.buttons[0]) return CollisionType.Collision;
        return CollisionType.Clicked;
    }

}
