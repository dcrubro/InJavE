package UserScripts.player

import InJavE2D.`object`.GameObject
import InJavE2D.`object`.Transform
import InJavE2D.`object`.components.SpriteRenderer
import InJavE2D.scene.Scene
import InJavE2D.scripting.InJavEScript
import org.joml.Vector2f
import org.joml.Vector4f

class TestKotlinScript(currentScene: Scene?) : InJavEScript(currentScene) {

    override fun awake() {

    }

    override fun start() {

    }

    override fun update(deltaTime: Float) {
        var go1: GameObject = GameObject("go1", Transform(Vector2f(-100f,-100f), Vector2f(100f, 100f)))
        go1.addComponent(SpriteRenderer(Vector4f(100f, 100f, 1f, 1f)))
        currentScene.addGameObjectToScene(go1)
    }
}