package com.compvisia.coconut.common.Math;

public class Math {

    // Constants
    public static final double PI_DIVIDED_2 = 1.5707963267948966;   // π / 2
    public static final double PI = 3.141592653589793;              // π
    public static final double PI_SQUARED = 9.869604401089358;      // π²
    public static final double PI_CUBED = 31.006276680299816;       // π³

    public static final double TAU = 6.283185307179586;             // τ = π * 2
    public static final double TAU_SQUARED = 39.47841760435743;     // τ²
    public static final double TAU_CUBED = 248.05021344239853;      // τ³


    // SQRT
    public static float  sqrt(float a)       { return (float) java.lang.Math.sqrt(a); }
    public static double sqrt(double a)      { return         java.lang.Math.sqrt(a); }

    public static float  invsqrt(float a)  { return 1.0f / (float) java.lang.Math.sqrt(a); }
    public static double invsqrt(double a) { return 1.0  /         java.lang.Math.sqrt(a); }


    // Triangles
    public static float  tan(float a)       { return (float) java.lang.Math.tan(a); }
    public static double tan(double a)      { return         java.lang.Math.tan(a); }

    public static float  cos(float a)       { return (float) java.lang.Math.cos(a); }
    public static double cos(double a)      { return         java.lang.Math.cos(a); }

    public static float  sin(float a)       { return (float) java.lang.Math.sin(a); }
    public static double sin(double a)      { return         java.lang.Math.sin(a); }

    public static float  pythagoras(float a, float b)      { return a*a+b*b; }
    public static double pythagoras(double a, float b)     { return a*a+b*b; }

    public static float  pythagorasSQRT(float a, float b)  { return sqrt(pythagoras(a,b)); }
    public static double pythagorasSQRT(double a, float b) { return sqrt(pythagoras(a,b)); }

    public static float  atan(float a)  { return (float) java.lang.Math.atan(a); }
    public static double atan(double a) { return         java.lang.Math.atan(a); }

    public static float  asin(float a)  { return (float) java.lang.Math.asin(a); }
    public static double asin(double a) { return         java.lang.Math.asin(a); }


    // Absolute
    public static float  abs(float a)   { return java.lang.Math.abs(a); }
    public static double abs(double a)  { return java.lang.Math.abs(a); }


    // Min, Max, Clamp
    public static int    min(int a, int b)       { return java.lang.Math.min(a,b); }
    public static float  min(float a, float b)   { return java.lang.Math.min(a,b); }
    public static double min(double a, double b) { return java.lang.Math.min(a,b); }

    public static int    max(int a, int b)       { return java.lang.Math.max(a,b); }
    public static float  max(float a, float b)   { return java.lang.Math.max(a,b); }
    public static double max(double a, double b) { return java.lang.Math.max(a,b); }

    public static int    clamp(int a, int b, int val)          { return max(a,min(b, val)); }
    public static float  clamp(float a, float b, float val)    { return max(a,min(b, val)); }
    public static double clamp(double a, double b, double val) { return max(a,min(b, val)); }


    // Round, Floor, Ceil
    public static float  round(float a)  { return java.lang.Math.round(a); }
    public static double round(double a) { return java.lang.Math.round(a); }

    public static float  floor(float a)  { return (float) java.lang.Math.floor(a); }
    public static double floor(double a) { return         java.lang.Math.floor(a); }

    public static float  ceil(float a)   { return (float) java.lang.Math.ceil(a); }
    public static double ceil(double a)  { return         java.lang.Math.ceil(a); }


    // FMA
    public static float  fma(float a, float b, float c)    { return a*b+c; }
    public static double fma(double a, double b, double c) { return a*b+c; }


    // Lerp methods
    public static float  lerp(float a, float b, float t)    { return fma(b-a,t,a); }
    public static double lerp(double a, double b, double t) { return fma(b-a,t,a); }

    public static float  biLerp(float q00, float q01, float q10, float q11, float tx, float ty) { return lerp(lerp(q00,q10,tx),lerp(q01,q11,tx),ty); }
    public static double biLerp(double q00, double q01, double q10, double q11, double tx, double ty) { return lerp(lerp(q00,q10,tx),lerp(q01,q11,tx),ty); }

    public static float  biLerp(Vector2f a, Vector2f b, Vector2f t) { return biLerp(a.x, a.y, b.x, b.y, t.x, t.y); }
    public static double biLerp(Vector2d a, Vector2d b, Vector2d t) { return biLerp(a.x, a.y, b.x, b.y, t.x, t.y); }


    // Signum
    public static float  signum(float a)     { return java.lang.Math.signum(a); }
    public static double signum(double a)    { return java.lang.Math.signum(a); }

}
