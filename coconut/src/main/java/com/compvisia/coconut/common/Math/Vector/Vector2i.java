package com.compvisia.coconut.common.Math.Vector;

public class Vector2i {

    public int x,y;

    public Vector2i(int x, int y) { this.x=x;this.y=y; }

    // Mathematics
    public Vector2i add(Vector2i a) { return new Vector2i(x+=a.x,y+=a.y); }
    public Vector2i sub(Vector2i a) { return new Vector2i(x-=a.x,y-=a.y); }
    public Vector2i mul(Vector2i a) { return new Vector2i(x*=a.x,y*=a.y); }
    public Vector2i div(Vector2i a) { return new Vector2i(x/=a.x,y/=a.y); }
}
