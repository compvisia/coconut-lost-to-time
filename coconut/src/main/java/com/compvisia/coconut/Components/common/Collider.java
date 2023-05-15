package com.compvisia.coconut.Components.common;

import com.compvisia.coconut.Input.Mouse;
import com.compvisia.coconut.common.Collision.CollisionType;
import com.compvisia.coconut.common.Math.Vector2f;
import com.compvisia.coconut.common.Math.Vector4f;


public class Collider {

    private Transform transform;

    public Collider() {}

    public CollisionType hasCollided(Vector4f collision) {
        if(!transform.intersects(collision)) return CollisionType.None;
        if(!Mouse.MouseClick.buttons[0]) return CollisionType.Collision;
        return CollisionType.Clicked;
    }
    public CollisionType hasCollided(Vector2f collision) { if(collision == null) return CollisionType.Null; return this.hasCollided(new Vector4f(collision.x,collision.y,1,1)); }

    // Attachments
    public void attach(Transform transform) { this.transform = transform; }
}