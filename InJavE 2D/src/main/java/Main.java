import InJavE2D.Window;
import InJavE2D.logging.Log4j;

public class Main {
    public static void main(String[] args) {
        new Log4j();
        Window window = Window.get();
        window.run(false, 0.1f);
    }
}
