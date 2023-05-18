package com.compvisia.coconut.Components.UI;

import com.compvisia.coconut.Components.common.Collider;
import com.compvisia.coconut.Components.common.Renderer;
import com.compvisia.coconut.Components.common.Transform;
import com.compvisia.coconut.Input.Mouse;
import com.compvisia.coconut.common.Collision.Rectangle;

public class Button {

    // Components
    private final Transform transform;
    private final Renderer r;
    private final Collider c;

    private final String[] paths;

    public Button(Rectangle rect, String[] paths) {
        this.paths=paths;

        transform = new Transform(rect);
        r = new Renderer(this.paths[0]);
        c = new Collider();

        r.attach(transform);
        c.attach(transform);
    }

    public void update() { r.changePath(paths[c.hasCollided(Mouse.MousePos.pos).ordinal()]); }

    public void render() { r.render(); }

}
