package com.compvisia.coconut.common.Collision;

import com.compvisia.coconut.common.Math.Vector2f;
import com.compvisia.coconut.common.Math.Vector4f;

import static com.compvisia.coconut.common.Math.Math.*;

public class Rectangle {

    private Vector4f outline;
    public float x,y,w,h;

    public Rectangle(Vector4f outline) { this.outline = outline; this.x = outline.x; this.y = outline.y; this.w = outline.z; this.h = outline.w; }
    public Rectangle(float x, float y, float w, float h) { this.outline = new Vector4f(x,y,w,h); this.x = x; this.y = y; this.w = w; this.h = h; }

    public boolean hasCollided(Rectangle s) {;
        return s != null && outline.x < s.outline.x + s.outline.z && outline.x + outline.z > s.outline.x && outline.y < s.outline.y + s.outline.w && outline.y + outline.w > s.outline.y;
    }
    public boolean hasCollided(Vector2f v) { return hasCollided(new Rectangle(v.x,v.y,1,1)); }

    public boolean hasCollided(Circle c) {
        Vector2f center = new Vector2f(x+w/2f,y+h/2f);
        Vector2f distance = new Vector2f(c.pos.x, c.pos.y).sub(center);

        Vector2f closest = new Vector2f(clamp(distance.x,-center.x,center.x),clamp(distance.x,-center.x,center.x)).add(center);

        distance = new Vector2f(closest.x,closest.y).sub(c.pos);

        return (distance.x+distance.y) < c.radius;
    }

}
