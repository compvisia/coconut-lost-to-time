package com.compvisia.coconut.Components.common;

import com.compvisia.coconut.common.Math.Vector.Vector4f;

public class Transform {

    public Vector4f v;

    public Transform(Vector4f v) { this.v=v; }


    public boolean intersects(Vector4f v) { return (this.v.x<v.x+v.z && this.v.x+this.v.z>v.x && this.v.y<v.y+v.w && this.v.y+this.v.w>v.y); }

}
