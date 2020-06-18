package sample;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    Robot robot;
    enum Direction {RIGHT, LEFT, TOP, BOTTOM};
    Map<Direction, List<Integer>> clickDirection = new HashMap<Direction, List<Integer>>(){{
        put(Direction.RIGHT, new ArrayList<Integer>() {{
            add(1330);
            add(600);
        }});
        put(Direction.LEFT, new ArrayList<Integer>() {{
            add(1230);
            add(600);
        }});
        put(Direction.TOP, new ArrayList<Integer>() {{
            add(1280);
            add(550);
        }});
        put(Direction.BOTTOM, new ArrayList<Integer>() {{
            add(1280);
            add(650);
        }});
    }};

    public Controller() throws AWTException {
        this.robot = new Robot();
    }

    public void newSearch(String x, String y, Direction direction, String object) {
        robot.delay(2000);

        robot.mouseMove(1100,370);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        // saisie du x
        saisie(x);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        // saisie du y
        saisie(y);

        // click de la direction
        robot.mouseMove(clickDirection.get(direction).get(0), clickDirection.get(direction).get(1));
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.delay(500);

        // click de la liste déroulante
        robot.mouseMove(1330,750);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        // saisie de l'objet
        saisie(object);

        // validation
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void saisie(String string) { // Attention aux accents
        for (char c: string.toLowerCase().toCharArray()) {
            if (Character.isDigit(c))
                robot.keyPress(KeyEvent.VK_SHIFT);
            if (c == '-') {
                robot.keyPress(KeyEvent.VK_SUBTRACT);
                robot.keyRelease(KeyEvent.VK_SUBTRACT);
            } else {
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
            }
            if (Character.isDigit(c))
                robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }
}
