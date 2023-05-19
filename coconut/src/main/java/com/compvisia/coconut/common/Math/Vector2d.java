package com.compvisia.coconut.common.Math;

public class Vector2d {

    public double x,y;

    public Vector2d(double x, double y) { this.x=x; this.y=y; }

    // Mathematics
    public Vector2d add(Vector2d v) { return new Vector2d(x+=v.x,y+=v.y); }
    public Vector2d sub(Vector2d v) { return new Vector2d(x-=v.x,y-=v.y); }
    public Vector2d mul(Vector2d v) { return new Vector2d(x*=v.x,y*=v.y); }
    public Vector2d div(Vector2d v) { return new Vector2d(x/=v.x,y/=v.y); }
}
