package com.compvisia.coconut.common.Collision;

import com.compvisia.coconut.Input.Mouse;
import com.compvisia.coconut.common.Math.Vector4d;
import com.compvisia.coconut.common.Math.Vector4f;

public class Rectangle {

    private Vector4f outline;
    public float x,y,w,h;

    public Rectangle(Vector4f outline) { this.outline = outline; this.x = outline.x; this.y = outline.y; this.w = outline.z; this.h = outline.w; }
    public Rectangle(float x, float y, float w, float h) { this.outline = new Vector4f(x,y,w,h); this.x = x; this.y = y; this.w = w; this.h = h; }

    public CollisionType hasCollided(Rectangle s) {
        if(s == null) return CollisionType.Null;

        if(!(outline.x<s.outline.x+s.outline.z && outline.x+ outline.z>s.outline.x && outline.y<s.outline.y+s.outline.w && outline.y+ outline.w>s.outline.y)) return CollisionType.None;
        if(!Mouse.MouseClick.buttons[0]) return CollisionType.Collision;
        return CollisionType.Clicked;
    }

}
