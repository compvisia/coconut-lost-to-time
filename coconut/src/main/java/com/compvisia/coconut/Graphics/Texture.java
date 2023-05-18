package com.compvisia.coconut.Graphics;

import com.compvisia.coconut.Components.common.Transform;
import com.compvisia.coconut.common.Collision.Rectangle;
import com.compvisia.coconut.common.Math.Matrix4f;
import com.compvisia.coconut.common.Math.Vector2f;
import com.compvisia.coconut.common.Math.Vector2i;

import com.compvisia.coconut.common.Math.Vector4f;
import org.lwjgl.BufferUtils;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Objects;

import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.stb.STBImage.*;

public class Texture {

    private Mesh mesh;
    private Shader shader;

    private int width, height;

    private int id;

    private String path;

    public Texture(String path) {
        shader = new Shader();
        mesh = new Mesh();

        this.path = "";

        create(path);
    }

    public Texture() {
        shader = new Shader();
        mesh = new Mesh();
    }

    public void create(ByteBuffer data, Vector2i size) {
        id = glGenTextures();

        glBindTexture(GL_TEXTURE_2D, id);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S,GL_CLAMP);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T,GL_CLAMP);

        this.width = size.x;
        this.height = size.y;

        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, this.width, this.height, 0, GL_RGBA, GL_UNSIGNED_BYTE, data);
    }

    public void create(String path) {
        if(Objects.equals(this.path, path)) return;
        this.path=path;

        id = glGenTextures();

        glBindTexture(GL_TEXTURE_2D, id);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S,GL_CLAMP);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T,GL_CLAMP);

        IntBuffer w = BufferUtils.createIntBuffer(1);
        IntBuffer h = BufferUtils.createIntBuffer(1);
        IntBuffer c = BufferUtils.createIntBuffer(1);

        ByteBuffer d = stbi_load(this.path, w, h, c, 4);

        if(d == null) { System.err.println("Unknown Path: "+this.path); }

        this.width = w.get();
        this.height = h.get();

        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, this.width, this.height, 0, GL_RGBA, GL_UNSIGNED_BYTE, d);

        try { if(d != null) stbi_image_free(d); }
        catch(Exception e) { System.exit(-1); }
    }

    // TODO: Make Settings to Soft code the values to use window size / user entered size.
    private void render(Vector2f[] v) {
        glUseProgram(shader.program);

        shader.setUniform("proj", new Matrix4f().ortho(0, Window.size.x, Window.size.y, 0, -1, 1));
        shader.setUniform("posA", v[0]);
        shader.setUniform("offset", new Vector4f(0,0,1,1));
        shader.setUniform("scale", v[1]);

        glActiveTexture(GL_TEXTURE0);
        glBindTexture(GL_TEXTURE_2D, id);

        mesh.render();

        glBindTexture(GL_TEXTURE_2D, 0);

        glUseProgram(0);
    }

    public void render(Rectangle rect) { this.render(new Vector2f[]{new Vector2f(rect.x,rect.y),new Vector2f(rect.w, rect.h)}); }
    public void render(Vector2f v) { this.render(new Vector2f[]{v,new Vector2f(width, height)}); }
    public void render(Vector4f v) { this.render(new Vector2f[]{new Vector2f(v.x,v.y),new Vector2f(v.z,v.w)}); }
    public void render(Transform transform) { this.render(transform.rectangle); }

    public void delete() {
        mesh.unbind();
        width = 0; height = 0;
        id = -1;
        mesh = null;
        shader = null;
    }

    // Mesh Class
    private static class Mesh {

        private final int vao,ebo;

        private Mesh() {
            final float[] verts = new float[] {1,1,0, 1,0,0, 0,0,0, 0,1,0,  1,1, 1,0, 0,0, 0,1};
            final int[]   indices = new int[] {0,1,2, 2,3,0};

            vao = glGenVertexArrays();
            int vbo = glGenBuffers();
            ebo = glGenBuffers();

            glBindVertexArray(vao);

            glBindBuffer(GL_ARRAY_BUFFER, vbo);
            glBufferData(GL_ARRAY_BUFFER, CreateBuffer(verts), GL_STATIC_DRAW);

            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ebo);
            glBufferData(GL_ELEMENT_ARRAY_BUFFER, CreateBuffer(indices), GL_STATIC_DRAW);

            glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
            glEnableVertexAttribArray(0);

            glVertexAttribPointer(1, 2, GL_FLOAT, false, 0, 12 * Float.BYTES);
            glEnableVertexAttribArray(1);

            glBindBuffer(GL_ARRAY_BUFFER, 0);
            glBindVertexArray(0);
            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
        }

        private void render() {
            glBindVertexArray(vao);

            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ebo);
            glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, 0);

            glBindVertexArray(0);
            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,0);
        }

        private void unbind() {
            glBindBuffer(GL_ARRAY_BUFFER, 0);
            glBindVertexArray(0);
            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
        }

        private FloatBuffer CreateBuffer(float[] buf) { FloatBuffer b = BufferUtils.createFloatBuffer(buf.length); b.put(buf); b.flip(); return b; }
        private IntBuffer   CreateBuffer(int[] buf)   { IntBuffer   b = BufferUtils.createIntBuffer(buf.length);   b.put(buf); b.flip(); return b; }
    }

    // Shader Class
    private static class Shader {

        private final int program;

        private Shader() {
            program = glCreateProgram();

            final int vertexShader = glCreateShader(GL_VERTEX_SHADER);
            glShaderSource(vertexShader, "#version 330 core\nlayout (location = 0) in vec3 pos;\nlayout (location = 1) in vec2 _tex;\nuniform mat4 proj;\nuniform vec2 posA;\nuniform vec2 scale;\nuniform vec4 offset;\nout vec2 tex;\nvoid main() {\ngl_Position = proj * vec4(pos * vec3(scale, 1.0) + vec3(posA,0.0), 1.0);\ntex = _tex * offset.zw + offset.xy;\n}\n\0");

            final int fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
            glShaderSource(fragmentShader, "#version 330 core\nuniform sampler2D s;\nin vec2 tex;\nout vec4 FragColor;\nvoid main() {\nvec4 t = texture2D(s, tex);\nif(t.a < 0.1) discard;\nFragColor = t;\n\n}\n\0");

            glCompileShader(vertexShader);
            if (glGetShaderi(vertexShader, GL_COMPILE_STATUS) != 1) {
                System.err.println(glGetShaderInfoLog(vertexShader));
            }

            glCompileShader(fragmentShader);
            if (glGetShaderi(fragmentShader, GL_COMPILE_STATUS) != 1) {
                System.err.println(glGetShaderInfoLog(fragmentShader));
            }

            glAttachShader(program, vertexShader);
            glAttachShader(program, fragmentShader);

            glLinkProgram(program);
            if (glGetProgrami(program, GL_LINK_STATUS) != 1) {
                System.err.println(glGetProgramInfoLog(program));
                System.exit(-1);
            }

            glDeleteShader(vertexShader);
            glDeleteShader(fragmentShader);
        }
        public void setUniform(String uniformName, Vector2f v) { int l = glGetUniformLocation(program, uniformName); if(l != -1) glUniform2f(l, v.x, v.y); }
        public void setUniform(String uniformName, Vector4f v) { int l = glGetUniformLocation(program, uniformName); if(l != -1) glUniform4f(l, v.x, v.y, v.z, v.w); }
        public void setUniform(String uniformName, Matrix4f m) { int l = glGetUniformLocation(program, uniformName); FloatBuffer b = BufferUtils.createFloatBuffer(16); m.getBuffer(b); if(l != -1) glUniformMatrix4fv(l, false, b); b.flip(); }
    }
}
