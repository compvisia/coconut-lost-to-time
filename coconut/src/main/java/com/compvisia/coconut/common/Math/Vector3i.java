package com.compvisia.coconut.common.Math;

public class Vector3i {

    public int x,y,z;

    public Vector3i(int x, int y, int z) { this.x=x;this.y=y;this.z=z; }

    // Mathematics
    public Vector3i add(Vector3i v) { return new Vector3i(x+=v.x,y+=v.y,z+=v.z); }
    public Vector3i sub(Vector3i v) { return new Vector3i(x-=v.x,y-=v.y,z-=v.z); }
    public Vector3i mul(Vector3i v) { return new Vector3i(x*=v.x,y*=v.y,z*=v.z); }
    public Vector3i div(Vector3i v) { return new Vector3i(x/=v.x,y/=v.y,z/=v.z); }

}
