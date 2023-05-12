package com.compvisia.coconut.Components.UI;

import com.compvisia.coconut.Components.common.Collider;
import com.compvisia.coconut.Components.common.Renderer;
import com.compvisia.coconut.Components.common.Transform;
import com.compvisia.coconut.Input.Mouse;
import com.compvisia.coconut.common.Math.Vector.Vector4f;

public class Button {

    // Components
    private final Transform trans;
    private final Renderer r;
    private final Collider c;

    private final String[] paths;

    public Button(Vector4f v, String[] paths) {
        this.paths=paths;

        trans = new Transform(v);
        r = new Renderer(this.paths[0]);
        c = new Collider();

        r.attach(trans);
        c.attach(trans);
    }

    public void update() { r.changePath(paths[c.hasCollided(Mouse.MousePos.pos).ordinal()]); }

    public void render() { r.render(); }

}
