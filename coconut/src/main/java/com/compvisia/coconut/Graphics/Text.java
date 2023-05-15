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

    private Texture t;
    private BufferedImage b;

    private String text, font;
    private int s;

    private Vector4f v;

    private Color c, bg;

    public Text(String text, String font, Vector4f v, Color c, Color bg) {
        this.text = text; this.font = font; this.v=v; this.c = c; this.bg = bg;

        create();
    }

    public Text(String text, String font, Vector4f v) {
        this.text = text; this.font = font; this.v = v; this.c = new Color(0,0,0,255); this.bg = new Color(255,255,255,255);

        create();
    }

    private void create() {
        setBufferedImage();

        t = new Texture();
        t.create(setData(), new Vector2i(s,s));
    }

    private void setBufferedImage() {
        s = (int)(text.length()*v.w*1.4f);
        b = new BufferedImage(s, s, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = b.createGraphics();

        g.setBackground(bg);
        g.setColor(c);

        g.setFont(new Font(font, Font.PLAIN, (int) v.w));
        g.drawString(text, 0, v.w);
    }

    private ByteBuffer setData() {
        int co = b.getColorModel().getNumComponents();

        byte[] d = new byte[co * s * s];
        b.getRaster().getDataElements(0, 0, s, s, d);

        ByteBuffer data = BufferUtils.createByteBuffer(d.length);
        data.put(d);
        data.rewind();
        return data;
    }

    public void changeText(String text) {
        this.text = text;
        setBufferedImage();

        t.create(setData(),new Vector2i(s,s));
    }

    public void render() {
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_COLOR,GL_ONE_MINUS_SRC_COLOR);
        t.render(new Vector4f(v.x,v.y,s,s));
        glBlendFunc(GL_SRC_COLOR,GL_SRC_COLOR);
        glDisable(GL_BLEND);
    }

    //public void renderWith() { t.render(); }

    public void setAll(String text, String font, Vector4f v, Color c, Color bg) { this.text = text; this.font = font; this.v = v; this.c = c; this.bg = bg; }


}
