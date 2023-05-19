package com.compvisia.coconut.common.Math;

public class Vector3f {

    public float x,y,z;

    public Vector3f(float x, float y, float z) { this.x=x;this.y=y;this.z=z; }

    // Mathematics
    public Vector3f add(Vector3f v) { return new Vector3f(x+=v.x,y+=v.y,z+=v.z); }
    public Vector3f sub(Vector3f v) { return new Vector3f(x-=v.x,y-=v.y,z-=v.z); }
    public Vector3f mul(Vector3f v) { return new Vector3f(x*=v.x,y*=v.y,z*=v.z); }
    public Vector3f div(Vector3f v) { return new Vector3f(x/=v.x,y/=v.y,z/=v.z); }

}
