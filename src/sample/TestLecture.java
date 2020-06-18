package sample;

import java.io.File;
import net.sourceforge.tess4j.*;

public class TestLecture {

    public static void main(String[] args) {
        File imageFile = new File("image2.jpg");
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        instance.setDatapath("tessdata"); // path to tessdata directory

        try {
            String result = instance.doOCR(imageFile);
            System.out.println("message = " + result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}