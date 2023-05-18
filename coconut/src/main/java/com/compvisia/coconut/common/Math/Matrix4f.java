package com.compvisia.coconut.common.Math;

import java.nio.FloatBuffer;

public class Matrix4f {

    private final float[][] matrix = new float[4][4];

    public Matrix4f() {
        matrix[0][0] = 1; matrix[0][1] = 0; matrix[0][2] = 0; matrix[0][3] = 0;
        matrix[1][0] = 0; matrix[1][1] = 1; matrix[1][2] = 0; matrix[1][3] = 0;
        matrix[2][0] = 0; matrix[2][1] = 0; matrix[2][2] = 1; matrix[2][3] = 0;
        matrix[3][0] = 0; matrix[3][1] = 0; matrix[3][2] = 0; matrix[3][3] = 1;
    }

    public void getBuffer(FloatBuffer b) {
        b.put(matrix[0][0]).put(matrix[0][1]).put(matrix[0][2]).put(matrix[0][3]).put(matrix[1][0]).put(matrix[1][1]).put(matrix[1][2]).put(matrix[1][3]).put(matrix[2][0]).put(matrix[2][1]).put(matrix[2][2]).put(matrix[2][3]).put(matrix[3][0]).put(matrix[3][1]).put(matrix[3][2]).put(matrix[3][3]).flip();
    }

    public Matrix4f ortho(float l, float r, float b, float t, float n, float f) {
        Matrix4f mat = new Matrix4f();

        mat.matrix[0][0] = 2f/(r-l);
        mat.matrix[1][1] = 2f/(t-b);
        mat.matrix[2][2] = -2f/(f-n);

        mat.matrix[3][0] = -(r+l)/(r-l);
        mat.matrix[3][1] = -(t+b)/(t-b);
        mat.matrix[3][2] = -(f+n)/(f-n);

        return mat;
    }

}