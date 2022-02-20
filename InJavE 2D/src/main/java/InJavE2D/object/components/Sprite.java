package InJavE2D.object.components;

import InJavE2D.object.Component;
import InJavE2D.render.Texture;
import org.joml.Vector2f;
import org.w3c.dom.Text;

public class Sprite {

    private Texture texture;
    private Vector2f[] texCoords;

    public Sprite(Texture texture) {
        this.texture = texture;
        Vector2f[] texCoords = {
                new Vector2f(1,1),
                new Vector2f(1,0),
                new Vector2f(0,0),
                new Vector2f(0,1)
        };
        this.texCoords = texCoords;
    }

    public Sprite(Texture texture, Vector2f[] texCoords) {
        this.texture = texture;
        this.texCoords = texCoords;
    }

    public Texture getTexture() { return this.texture; }
    public Vector2f[] getTexCoords() { return this.texCoords; }
}