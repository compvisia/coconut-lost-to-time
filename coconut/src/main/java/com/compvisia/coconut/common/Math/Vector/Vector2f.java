package com.compvisia.coconut.common.Math.Vector;

public class Vector2f {

    public float x,y;

    public Vector2f(float x, float y) { this.x=x; this.y=y; }

    // Mathematics
    public Vector2f add(Vector2f a) { return new Vector2f(x+=a.x,y+=a.y); }
    public Vector2f sub(Vector2f a) { return new Vector2f(x-=a.x,y-=a.y); }
    public Vector2f mul(Vector2f a) { return new Vector2f(x*=a.x,y*=a.y); }
    public Vector2f div(Vector2f a) { return new Vector2f(x/=a.x,y/=a.y); }
}
