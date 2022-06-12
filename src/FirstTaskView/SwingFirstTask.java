package FirstTaskView;

import javax.swing.*;
import java.awt.*;

public class SwingFirstTask extends Canvas {

    JFrame frame;
    JLabel label;
    ImageIcon imageIcon;

    public SwingFirstTask() {

        frame = new JFrame("Image Display");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {

            imageIcon = new ImageIcon(getClass().getResource("image.jpg"));
            label = new JLabel(imageIcon);
            frame.add(label);

        } catch (Exception e) {

            e.printStackTrace();
        }

        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        int wScreen=(int)screenSize.getWidth();
        int hScreen=(int)screenSize.getHeight();
        int wFrame=600;
        int hFrame=500;
        frame.setBounds(wScreen/2-wFrame/2,hScreen/2-hFrame/2,wFrame,hFrame);
        frame.setVisible(true);
    }
}