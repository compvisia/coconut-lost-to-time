package com.compvisia.coconut.common.Math;

public class Vector4f {

    public float x,y,z,w;

    public Vector4f(float x, float y, float z, float w) { this.x=x;this.y=y;this.z=z;this.w=w; }

    // Mathematics
    public Vector4f add(Vector4f v) { return new Vector4f(x+=v.x,y+=v.y,z+=v.z,w+=v.w); }
    public Vector4f sub(Vector4f v) { return new Vector4f(x-=v.x,y-=v.y,z-=v.z,w-=v.w); }
    public Vector4f mul(Vector4f v) { return new Vector4f(x*=v.x,y*=v.y,z*=v.z,w*=v.w); }
    public Vector4f div(Vector4f v) { return new Vector4f(x/=v.x,y/=v.y,z/=v.z,w/=v.w); }

}
