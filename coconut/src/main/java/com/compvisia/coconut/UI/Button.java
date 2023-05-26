package com.compvisia.coconut.UI;

import com.compvisia.coconut.Graphics.Texture;
import com.compvisia.coconut.Input.Mouse;
import com.compvisia.coconut.common.Collision.Rectangle;

public class Button {

    // Components
    private final Texture texture;
    private final Rectangle rectangle;

    private final String[] paths;

    public boolean hovered, clicked;

    public Button(Rectangle rectangle, String[] paths) {
        this.paths=paths; this.rectangle = rectangle;

        texture = new Texture(paths[0]);
    }

    public void update() {
        clicked = hovered = false;
        texture.create(paths[0]);
        if(!rectangle.hasCollided(Mouse.MousePos.pos)) return;
        if(Mouse.MouseClick.buttons[0]) { texture.create(paths[2]); clicked = true; }
        else { texture.create(paths[1]); hovered = true; }
    }

    public void render() { texture.render(rectangle); }

}
