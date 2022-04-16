package InJavE2D.object;

public abstract class Component {

    public transient GameObject gameObject = null;

    public abstract void start();

    public void update(float deltaTime) { }

    public void imgui() { }
}