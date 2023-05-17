
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
public class ImageRotation {
    public static final int ROTATE_LEFT = 1;
    public static final int ROTATE_RIGHT = -1;

    public static void rotate90(File fichierini ,File fichierout ,int direction) {
        try {
            ImageInputStream iis = ImageIO.createImageInputStream(fichierini);
            Iterator<ImageReader> iterator = ImageIO.getImageReaders(iis);
            ImageReader reader = iterator.next();
            String format = reader.getFormatName();

            BufferedImage image = ImageIO.read(iis);
            int width = image.getWidth();
            int height = image.getHeight();

            BufferedImage rotated = new BufferedImage(height ,width,image.getType());

            for (int y=0; y< height;y++) {
                for(int x = 0 ;x < width; x++) {
                    switch(direction) {
                        case ROTATE_LEFT:
                            rotated.setRGB(y, (width-1)-x, image.getRGB(x, y));
                            break;
                        case ROTATE_RIGHT:
                            rotated.setRGB((height-1)-y,x, image.getRGB(x, y));

                    }
                }
            }
            ImageIO.write(rotated, format, fichierout);
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void rotate180(File fichierini ,File fichierout ) {
        try {
            ImageInputStream iis = ImageIO.createImageInputStream(fichierini);
            Iterator<ImageReader> iterator = ImageIO.getImageReaders(iis);
            ImageReader reader = iterator.next();
            String format = reader.getFormatName();

            BufferedImage image = ImageIO.read(iis);
            int width = image.getWidth();
            int height = image.getHeight();

            BufferedImage rotated = new BufferedImage(height ,width,image.getType());

            for (int y=0; y< height;y++) {
                for(int x = 0 ;x < width; x++) {
                    rotated.setRGB((width - 1)-x, (height -1) - y, image.getRGB(x, y));
                }
            }
            ImageIO.write(rotated, format, fichierout);
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File fichierini = new File("C:\\Users\\BIG CHOIX\\Desktop\\JAVA\\project2dparking\\images\\v3.png");
        File fichierout = new File("C:\\Users\\BIG CHOIX\\Desktop\\JAVA\\project2dparking\\images\\v4.png");
        ImageRotation.rotate90(fichierini,fichierout,ImageRotation.ROTATE_RIGHT);
		ImageRotation.rotate180(fichierini,fichierout);

        System.out.println("Finnished !");
    }

}



