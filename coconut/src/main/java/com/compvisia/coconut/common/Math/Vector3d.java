package com.compvisia.coconut.common.Math;

public class Vector3d {

    public double x,y,z;

    public Vector3d(double x, double y, double z) { this.x=x;this.y=y;this.z=z; }

    // Mathematics
    public Vector3d add(Vector3d v) { return new Vector3d(x+=v.x,y+=v.y,z+=v.z); }
    public Vector3d sub(Vector3d v) { return new Vector3d(x-=v.x,y-=v.y,z-=v.z); }
    public Vector3d mul(Vector3d v) { return new Vector3d(x*=v.x,y*=v.y,z*=v.z); }
    public Vector3d div(Vector3d v) { return new Vector3d(x/=v.x,y/=v.y,z/=v.z); }

}
