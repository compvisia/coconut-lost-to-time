package com.compvisia.coconut.common.Math;

public class Vector4i {

    public int x,y,z,w;

    public Vector4i(int x, int y, int z, int w) { this.x=x;this.y=y;this.z=z;this.w=w; }

    // Mathematics
    public Vector4i add(Vector4i a) { return new Vector4i(x+=a.x,y+=a.y,z+=a.z,w+=a.w); }
    public Vector4i sub(Vector4i a) { return new Vector4i(x-=a.x,y-=a.y,z-=a.z,w-=a.w); }
    public Vector4i mul(Vector4i a) { return new Vector4i(x*=a.x,y*=a.y,z*=a.z,w*=a.w); }
    public Vector4i div(Vector4i a) { return new Vector4i(x/=a.x,y/=a.y,z/=a.z,w/=a.w); }

}
