package sample;

import java.awt.*;

public class TestEcriture {

    public static void main(String[] args) throws AWTException {
        Controller controller = new Controller();
        controller.newSearch("-3", "23", Controller.Direction.LEFT, "Squelette de Dragodinde");
    }
}
