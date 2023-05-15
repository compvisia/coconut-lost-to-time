package com.compvisia.coconut.common.Collision;

import com.compvisia.coconut.Input.Mouse;
import com.compvisia.coconut.common.Math.Vector4d;
import com.compvisia.coconut.common.Math.Vector4f;

public class Square {

    private Vector4d sq;

    public Square(Vector4d sq) { this.sq=sq; }
    public Square(Vector4f sq) { this.sq=new Vector4d(sq.x,sq.y,sq.z,sq.w); }

    public CollisionType hasCollided(Square s) {
        if(s == null) return CollisionType.Null;

        if(!(sq.x<s.sq.x+s.sq.z && sq.x+sq.z>s.sq.x && sq.y<s.sq.y+s.sq.w && sq.y+sq.w>s.sq.y)) return CollisionType.None;
        if(!Mouse.MouseClick.buttons[0]) return CollisionType.Collision;
        return CollisionType.Clicked;
    }

}
