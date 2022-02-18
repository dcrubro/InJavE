package InJavE2D.scene;

import InJavE2D.input.KeyListener;
import InJavE2D.object.GameObject;
import InJavE2D.object.Transform;
import InJavE2D.object.components.SpriteRenderer;
import InJavE2D.render.Camera;
import InJavE2D.scripting.InJavEScript;
import InJavE2D.util.AssetPool;
import InJavE2D.util.Debug;
import UserScripts.player.PlayerMovement;
import org.joml.Vector2f;
import org.joml.Vector4f;
import org.lwjgl.system.CallbackI;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT;

public class LevelEditorScene extends Scene {

    private List<InJavEScript> scripts;
    private GameObject player;

    public LevelEditorScene() {

    }

    public void init() {
        this.camera = new Camera(new Vector2f(-340, -180));
        this.scripts = new ArrayList<>();

        GameObject obj1 = new GameObject("Obj1", new Transform(new Vector2f(100,100), new Vector2f(256,256)));
        obj1.addComponent(new SpriteRenderer(AssetPool.getTexture("assets/textures/GhostCharacter-Fixed.png")));
        this.addGameObjectToScene(obj1);

        GameObject obj2 = new GameObject("Obj2", new Transform(new Vector2f(400,100), new Vector2f(256,256)));
        obj2.addComponent(new SpriteRenderer(AssetPool.getTexture("assets/textures/GhostCharacter-Fixed-Blue.jpg")));
        this.addGameObjectToScene(obj2);

        /*int xOffset = 10;
        int yOffset = 10;

        float totalWidth = (float)(600 - xOffset * 2);
        float totalHeight = (float)(300 - yOffset * 2);
        float sizeX = totalWidth / 100.0f;
        float sizeY = totalHeight / 100.0f;

        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                float xPos = xOffset + (x * sizeX);
                float yPos = yOffset + (y * sizeY);

                GameObject go = new GameObject("Obj" + x + "" + y, new Transform(new Vector2f(xPos, yPos), new Vector2f(sizeX, sizeY)));
                go.addComponent(new SpriteRenderer(new Vector4f(xPos / totalWidth, yPos / totalHeight, 1, 1)));
                this.addGameObjectToScene(go);
            }
        }*/

        /*player = new GameObject("Player", new Transform(new Vector2f(-150, -150), new Vector2f(50, 50)));
        player.addComponent(new SpriteRenderer(new Vector4f(50, 50, 1, 1)));
        this.addGameObjectToScene(player);

        scripts.add(new PlayerMovement(player, 100f, this));*/

        loadResources();
        for (InJavEScript scr : scripts) {
            scr.start();
        }

        Debug.log("FixedUpdateDelay: " + String.valueOf(fixedTimeDelay));
    }

    private void loadResources() {
        AssetPool.getShader("assets/shaders/default.glsl");
        //AssetPool.getTexture("assets/shaders/default.glsl");
    }

    @Override
    public void update(float deltaTime) {

        /*camera.position.x -= deltaTime * 50f;
        camera.position.y -= deltaTime * 50f;*/

        Debug.log("FPS: " + (1.0f / deltaTime));

        if (KeyListener.isKeyPressed(GLFW_KEY_RIGHT)) {
            player.transform.position.x += 10f;
        }
        if (KeyListener.isKeyPressed(GLFW_KEY_LEFT)) {
            player.transform.position.x -= 10f;
        }

        for (GameObject go : this.gameObjects) {
            go.update(deltaTime);
        }

        for (InJavEScript scr : scripts) {
            scr.update(deltaTime);
        }

        this.renderer.render();
    }

    @Override
    public void fixedUpdate(float fixedTimeDelay) {

    }
}
