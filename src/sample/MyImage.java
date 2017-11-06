package sample;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.imageio.*;

public class MyImage {

    public void readImage(String path) {

        BufferedImage image = null;
        File f = null;

        try {
            f = new File(path); // Image file path USER INPUT NEEDS TO BE TAKEN
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(f);

            System.out.println("READ SUCCESSFUL.")
        } catch(IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void writeImage() {


        try {
            BufferedImage image = getMyImage();
            File outputfile = new File("saved.png");
            ImageIO.write(image, "png", outputfile);

            System.out.println("WRITE SUCCESSFUL");
        } catch(IOException e) {
            System.out.println("Error: " + e);
        }
    }

}
