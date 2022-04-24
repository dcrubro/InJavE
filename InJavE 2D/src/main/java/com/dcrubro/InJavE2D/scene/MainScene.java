package com.dcrubro.InJavE2D.scene;

import UserScripts.ghost.GhostMovement;
import com.dcrubro.InJavE2D.object.GameObject;
import com.dcrubro.InJavE2D.object.Transform;
import com.dcrubro.InJavE2D.object.components.Sprite;
import com.dcrubro.InJavE2D.object.components.SpriteRenderer;
import com.dcrubro.InJavE2D.render.Camera;
import com.dcrubro.InJavE2D.scripting.InJavEScript;
import com.dcrubro.InJavE2D.util.AssetPool;
import org.joml.Vector2f;

public class MainScene extends Scene {

    private GameObject player;
    private GameObject ghost;
    private Sprite ghostSprite;

    public MainScene() {

    }

    public void init() {
        loadResources();
        sceneName = this.getClass().getSimpleName();

        this.camera = new Camera(new Vector2f(0, 0));

        this.ghost = new GameObject("Ghost", new Transform(new Vector2f(-20,550), new Vector2f(128, 128)), 1);
        this.ghostSprite = new Sprite();
        this.ghostSprite.setTexture(AssetPool.getTexture("assets/textures/GhostCharacter-Fixed.png"));

        SpriteRenderer ghostRenderer = new SpriteRenderer();
        ghostRenderer.setSprite(this.ghostSprite);

        this.ghost.addComponent(ghostRenderer);

        this.addGameObjectToScene(ghost);

        this.activeGameObject = null;

        this.sceneScripts.add(new GhostMovement(this, ghost));
    }

    @Override
    public void update(float deltaTime) {
        for (GameObject go : this.gameObjects) {
            go.update(deltaTime);
        }

        for (InJavEScript scr : sceneScripts) {
            scr.update(deltaTime);
        }

        this.renderer.render();
    }

    public Scene getCurrentScene() {
        return this;
    }

    @Override
    public void fixedUpdate(float fixedTimeDelay) { }

    @Override
    public void imgui() {
        super.imgui();
    }

    public void loadResources() {
        AssetPool.getShader("assets/shaders/default.glsl");
    }
}
