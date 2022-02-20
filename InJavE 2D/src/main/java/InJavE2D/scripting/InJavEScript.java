package InJavE2D.scripting;

import InJavE2D.scene.Scene;

public abstract class InJavEScript {

    protected Scene currentScene;

    public InJavEScript(Scene currentScene) {
        this.currentScene = currentScene;
    }

    public void start() { }
    public void awake() { }
    public void update(float deltaTime) { }

    // TODO: Make fixedUpdate work
    public void fixedUpdate() { }
}
