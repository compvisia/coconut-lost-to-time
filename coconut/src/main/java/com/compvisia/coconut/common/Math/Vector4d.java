package com.compvisia.coconut.common.Math;

public class Vector4d {

    public double x,y,z,w;

    public Vector4d(double x, double y, double z, double w) { this.x=x;this.y=y;this.z=z;this.w=w; }

    // Mathematics
    public Vector4d add(Vector4d v) { return new Vector4d(x+=v.x,y+=v.y,z+=v.z,w+=v.w); }
    public Vector4d sub(Vector4d v) { return new Vector4d(x-=v.x,y-=v.y,z-=v.z,w-=v.w); }
    public Vector4d mul(Vector4d v) { return new Vector4d(x*=v.x,y*=v.y,z*=v.z,w*=v.w); }
    public Vector4d div(Vector4d v) { return new Vector4d(x/=v.x,y/=v.y,z/=v.z,w/=v.w); }

}
