import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.net.URISyntaxException;
import java.util.Objects;

public class CustomPanel extends JPanel
{
    private final BufferedImage image;

    public CustomPanel()
    {
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        try
        {
            /*
             * Since Images are Application Resources,
             * it's always best to access them in the
             * form of a URL, instead of File, as you are doing.
             * Uncomment this below line and watch this answer
             * of mine, as to HOW TO ADD IMAGES TO THE PROJECT
             * https://stackoverflow.com/a/9866659/1057230
             * In order to access images with getClass().getResource(path)
             * here your Directory structure has to be like this
             *                 Project
             *                    |
             *         ------------------------
             *         |                      |
             *        bin                    src
             *         |                      |
             *     ---------             .java files
             *     |       |
             *  package   image(folder)
             *  ( or              |
             *   .class        404error.jpg
             *   files, if
             *   no package
             *   exists.)
             */
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource("pictures/enemies/aboleth.jpg")));
//            image = ImageIO.read(new URL("pictures/enemies/aboleth.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * Make this one customary habbit,
     * of overriding this method, when
     * you extends a JPanel/JComponent,
     * to define it's Preferred Size.
     * Now in this case we want it to be
     * as big as the Image itself.
     */
    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(image.getWidth(), image.getHeight()));
    }

    /*
     * This is where the actual Painting
     * Code for the JPanel/JComponent
     * goes. Here we will draw the image.
     * Here the first line super.paintComponent(...),
     * means we want the JPanel to be drawn the usual
     * Java way first, then later on we will
     * add our image to it, by writing the other line,
     * g.drawImage(...).
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
