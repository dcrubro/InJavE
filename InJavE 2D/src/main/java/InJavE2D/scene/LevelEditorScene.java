package InJavE2D.scene;

import InJavE2D.input.KeyListener;
import InJavE2D.logging.Log4j;
import InJavE2D.object.GameObject;
import InJavE2D.object.Transform;
import InJavE2D.object.components.Sprite;
import InJavE2D.object.components.SpriteRenderer;
import InJavE2D.object.components.Spritesheet;
import InJavE2D.render.Camera;
import InJavE2D.render.Texture;
import InJavE2D.scripting.InJavEScript;
import InJavE2D.util.AssetPool;
import InJavE2D.util.Debug;
import UserScripts.player.TestKotlinScript;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import imgui.ImGui;
import jdk.jshell.spi.SPIResolutionException;
import org.joml.Vector2f;
import org.joml.Vector4f;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT;

public class LevelEditorScene extends Scene {

    private GameObject player;
    private GameObject obj1;
    private GameObject obj2;
    private SpriteRenderer obj1sprite;
    private Sprite obj2sprite;

    private transient Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private Spritesheet sprites;

    public LevelEditorScene() {

    }

    public void init() {
        loadResources();

        this.camera = new Camera(new Vector2f(-340, -180));

        this.sprites = AssetPool.getSpritesheet("assets/spritesheets/spritesheet.png");

        this.obj1 = new GameObject("Obj1", new Transform(new Vector2f(200,100), new Vector2f(256,256)), -1);

        this.obj1sprite = new SpriteRenderer();
        obj1sprite.setColor(new Vector4f(1,0,0,1));

        this.obj1.addComponent(obj1sprite);


        this.obj2 = new GameObject("Obj2", new Transform(new Vector2f(400,100), new Vector2f(256, 256)), 3);

        SpriteRenderer obj2SpriteRenderer = new SpriteRenderer();

        this.obj2sprite = new Sprite();

        this.obj2sprite.setTexture(AssetPool.getTexture("assets/textures/blendImage2.png"));

        obj2SpriteRenderer.setSprite(this.obj2sprite);

        this.obj2.addComponent(obj2SpriteRenderer);

        this.addGameObjectToScene(this.obj1);
        this.addGameObjectToScene(this.obj2);

        this.activeGameObject = this.obj1;

        /*GameObject launchImGui = new GameObject("LaunchImGui", new Transform(new Vector2f(0,-100), new Vector2f(256,128)), 2);
        launchImGui.addComponent(new SpriteRenderer(
                new Sprite(AssetPool.getTexture("assets/textures/launchimgui.png"))
        ));
        this.addGameObjectToScene(launchImGui);*/

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
        this.addGameObjectToScene(player);*/

        this.addScriptToScene(new TestKotlinScript(getCurrentScene()));

        Debug.log("FixedUpdateDelay: " + String.valueOf(fixedTimeDelay));
    }

    private void loadResources() {
        AssetPool.getShader("assets/shaders/default.glsl");
        AssetPool.addSpritesheet("assets/spritesheets/spritesheet.png",
                                 new Spritesheet(AssetPool.getTexture("assets/spritesheets/spritesheet.png"),
                                                 16, 16, 26, 0));
    }

    private int spriteIndex = 0;
    private float spriteFlipTime = 0.2f;
    private float spriteFlipTimeLeft = 0.0f;

    @Override
    public void update(float deltaTime) {

        /*camera.position.x -= deltaTime * 50f;
        camera.position.y -= deltaTime * 50f;*/
        //System.out.println(gson.toJson(obj1sprite));

        if (KeyListener.isKeyPressed(GLFW_KEY_RIGHT)) {
            this.obj1.transform.position.x += 60f * deltaTime;
        }
        if (KeyListener.isKeyPressed(GLFW_KEY_LEFT)) {
            this.obj1.transform.position.x -= 60f * deltaTime;
        }

        for (GameObject go : this.gameObjects) {
            go.update(deltaTime);
        }

        for (InJavEScript scr : sceneScripts) {
            scr.update(deltaTime);
        }

        this.renderer.render();
    }

    @Override
    public void fixedUpdate(float fixedTimeDelay) {

    }

    @Override
    public Scene getCurrentScene() {
        return this;
    }

    @Override
    public void imgui() {
        ImGui.begin("Test window");
        ImGui.text("Some random text lmao");
        ImGui.end();
    }
}
