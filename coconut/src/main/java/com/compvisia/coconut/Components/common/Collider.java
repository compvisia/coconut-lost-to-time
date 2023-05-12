package com.compvisia.coconut.Components.common;

import com.compvisia.coconut.Input.Mouse;
import com.compvisia.coconut.common.Math.Vector.Vector2f;
import com.compvisia.coconut.common.Math.Vector.Vector4f;


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

    // Enum
    public enum CollisionType {
        Null,
        None,
        Collision,
        Clicked
    }
}