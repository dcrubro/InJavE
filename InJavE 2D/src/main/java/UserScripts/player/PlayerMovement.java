package UserScripts.player;

import InJavE2D.input.KeyListener;
import InJavE2D.object.GameObject;
import InJavE2D.object.components.SpriteRenderer;
import InJavE2D.scene.Scene;
import InJavE2D.scripting.InJavEScript;

import static org.lwjgl.glfw.GLFW.*;

public class PlayerMovement extends InJavEScript {

    private GameObject player;
    private float moveSpeed;
    private Scene currentScene;

    public PlayerMovement(GameObject player, float moveSpeed, Scene currentScene) {
        this.player = player;
        this.moveSpeed = moveSpeed;
        this.currentScene = currentScene;
    }

    public void start() {

    }

    public void update(float deltaTime) {
        /*if (KeyListener.isKeyPressed(GLFW_KEY_RIGHT)) {
            player.transform.position.x += moveSpeed;
            currentScene.Update(deltaTime);
            //player.update(deltaTime);
        }
        if (KeyListener.isKeyPressed(GLFW_KEY_LEFT)) {
            player.transform.position.x -= moveSpeed;
            currentScene.Update(deltaTime);
            //player.update(deltaTime);
        }*/
    }
}
