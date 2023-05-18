package com.compvisia.coconut.Components.common;

import com.compvisia.coconut.common.Collision.CollisionType;
import com.compvisia.coconut.common.Collision.Rectangle;
import com.compvisia.coconut.common.Math.Vector2f;


public class Collider {

    private Transform transform;

    public Collider() {}

    public CollisionType hasCollided(Rectangle rectangle) {
        return transform.rectangle.hasCollided(rectangle);
    }
    public CollisionType hasCollided(Vector2f collision) { if(collision == null) return CollisionType.Null; return this.hasCollided(new Rectangle(collision.x, collision.y, 1,1)); }

    // Attachments
    public void attach(Transform transform) { this.transform = transform; }
}