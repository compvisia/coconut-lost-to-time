package com.compvisia.coconut.common.Math;

public class Vector2f {

    public float x,y;

    public Vector2f(float x, float y) { this.x=x; this.y=y; }

    // Mathematics
    public Vector2f add(Vector2f v) { return new Vector2f(x+=v.x,y+=v.y); }
    public Vector2f sub(Vector2f v) { return new Vector2f(x-=v.x,y-=v.y); }
    public Vector2f mul(Vector2f v) { return new Vector2f(x*=v.x,y*=v.y); }
    public Vector2f div(Vector2f v) { return new Vector2f(x/=v.x,y/=v.y); }
}
