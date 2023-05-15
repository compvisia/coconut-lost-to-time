package com.compvisia.coconut.common.Math;

public class Vector3d {

    public double x,y,z;

    public Vector3d(double x, double y, double z) { this.x=x;this.y=y;this.z=z; }

    // Mathematics
    public Vector3d add(Vector3d a) { return new Vector3d(x+=a.x,y+=a.y,z+=a.z); }
    public Vector3d sub(Vector3d a) { return new Vector3d(x-=a.x,y-=a.y,z-=a.z); }
    public Vector3d mul(Vector3d a) { return new Vector3d(x*=a.x,y*=a.y,z*=a.z); }
    public Vector3d div(Vector3d a) { return new Vector3d(x/=a.x,y/=a.y,z/=a.z); }

}
