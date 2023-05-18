package com.compvisia.coconut.Graphics;

import com.compvisia.coconut.common.Math.Vector2i;
import com.compvisia.coconut.common.Math.Vector4f;
import org.lwjgl.BufferUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_SRC_COLOR;

public class Text {

    private Texture texture;
    private BufferedImage buffer;

    private String text, font;
    private int scale;

    private Vector4f rect;

    private Color color, background;

    public Text(String text, String font, Vector4f rect, Color color, Color background) {
        this.text = text; this.font = font; this.rect = rect; this.color = color; this.background = background;

        create();
    }

    public Text(String text, String font, Vector4f rect) {
        this.text = text; this.font = font; this.rect = rect; this.color = new Color(0,0,0,255); this.background = new Color(255,255,255,255);

        create();
    }

    private void create() {
        setBufferedImage();

        texture = new Texture();
        texture.create(setData(), new Vector2i(scale, scale));
    }

    private void setBufferedImage() {
        scale = (int)(text.length()* rect.w*1.4f);
        buffer = new BufferedImage(scale, scale, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = buffer.createGraphics();

        g.setBackground(background);
        g.setColor(color);

        g.setFont(new Font(font, Font.PLAIN, (int) rect.w));
        g.drawString(text, 0, rect.w);
    }

    private ByteBuffer setData() {
        int co = buffer.getColorModel().getNumComponents();

        byte[] d = new byte[co * scale * scale];
        buffer.getRaster().getDataElements(0, 0, scale, scale, d);

        ByteBuffer data = BufferUtils.createByteBuffer(d.length);
        data.put(d);
        data.rewind();
        return data;
    }

    public void changeText(String text) {
        this.text = text;
        setBufferedImage();

        texture.create(setData(),new Vector2i(scale, scale));
    }

    public void render() {
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_COLOR,GL_ONE_MINUS_SRC_COLOR);
        texture.render(new Vector4f(rect.x, rect.y, scale, scale));
        glBlendFunc(GL_SRC_COLOR,GL_SRC_COLOR);
        glDisable(GL_BLEND);
    }

    //public void renderWith() { t.render(); }

    public void setAll(String text, String font, Vector4f rect, Color color, Color background) { this.text = text; this.font = font; this.rect = rect; this.color = color; this.background = background; }


}
