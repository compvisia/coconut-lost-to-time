package com.compvisia.coconut.common.Math;

import java.nio.FloatBuffer;

public class Matrix4f {

    private final float[][] m = new float[4][4];

    public Matrix4f() {
        m[0][0] = 1; m[0][1] = 0; m[0][2] = 0; m[0][3] = 0;
        m[1][0] = 0; m[1][1] = 1; m[1][2] = 0; m[1][3] = 0;
        m[2][0] = 0; m[2][1] = 0; m[2][2] = 1; m[2][3] = 0;
        m[3][0] = 0; m[3][1] = 0; m[3][2] = 0; m[3][3] = 1;
    }

    public void getBuffer(FloatBuffer b) {
        b.put(m[0][0]).put(m[0][1]).put(m[0][2]).put(m[0][3]).put(m[1][0]).put(m[1][1]).put(m[1][2]).put(m[1][3]).put(m[2][0]).put(m[2][1]).put(m[2][2]).put(m[2][3]).put(m[3][0]).put(m[3][1]).put(m[3][2]).put(m[3][3]).flip();
    }

    public Matrix4f ortho(float l, float r, float b, float t, float n, float f) {
        Matrix4f mat = new Matrix4f();

        mat.m[0][0] = 2f/(r-l);
        mat.m[1][1] = 2f/(t-b);
        mat.m[2][2] = -2f/(f-n);

        mat.m[3][0] = -(r+l)/(r-l);
        mat.m[3][1] = -(t+b)/(t-b);
        mat.m[3][2] = -(f+n)/(f-n);

        return mat;
    }

}