package com.compvisia.coconut.Components.UI;

import com.compvisia.coconut.Components.common.Renderer;
import com.compvisia.coconut.Input.Mouse;
import com.compvisia.coconut.common.Collision.Rectangle;

public class Button {

    // Components
    private final Renderer renderer;
    private final Rectangle rectangle;

    private final String[] paths;

    public Button(Rectangle rectangle, String[] paths) {
        this.paths=paths;

        this.rectangle = rectangle;

        renderer = new Renderer(this.paths[0], rectangle);
    }

    public void update() {
        renderer.changePath(paths[0]);
        if(!rectangle.hasCollided(Mouse.MousePos.pos)) return;
        if(Mouse.MouseClick.buttons[0]) renderer.changePath(paths[2]);
        else renderer.changePath(paths[1]);
    }

    public void render() { renderer.render(); }

}
