package InJavE2D.scene;

import InJavE2D.object.GameObject;
import InJavE2D.render.Camera;
import InJavE2D.render.Renderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Scene {

    protected Renderer renderer = new Renderer();
    protected Camera camera;
    protected float fixedTimeDelay;
    private boolean isRunning = false;
    protected List<GameObject> gameObjects = new ArrayList<>();

    public Scene() { }

    public void init() { }

    public void start() {
        for (GameObject gameobject : gameObjects) {
            gameobject.start();
            this.renderer.add(gameobject);
        }
        isRunning = true;
    }

    public void addGameObjectToScene(GameObject gameObject) {
        if (!isRunning) {
            gameObjects.add(gameObject);
        } else {
            gameObjects.add(gameObject);
            gameObject.start();
            this.renderer.add(gameObject);
        }
    }

    public abstract void update(float deltaTime);

    // TODO: Fix the 'fixedUpdate()' function to work.
    public abstract void fixedUpdate(float fixedTimeDelay);

    public Camera getCamera() {
        return this.camera;
    }

    // Fixed time delay getter/setter
    public float getFixedTimeDelay() { return this.fixedTimeDelay; }
    public void setFixedTimeDelay(float fixedTimeDelay) { this.fixedTimeDelay = fixedTimeDelay; }
}
