import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.*;

class selectedColors {
    Color grayish = new Color(58, 58, 58);
    Color grayish2 = new Color(210, 210, 210);

    Color greenish = new Color(0, 200, 150);
}

class Menu extends JMenuBar {
    JMenuBar mb;

    Menu() {
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");

        this.add(file);
        this.add(help);

        JMenuItem mItm1 = new JMenuItem("Chuchu");
        JMenuItem mItm2 = new JMenuItem("Help");
        JMenuItem mItm3 = new JMenuItem("Help");

        file.add(mItm1);
        file.add(mItm2);
        help.add(mItm3);
    }
}

class SideBar extends JPanel {
    JPanel pnl;
    Image addImage;
    Image removeImage;
    Image updateImage;
    Image refreshImage;

    SideBar(JPanel data) {

        JButton btn_one = new JButton();
        JButton btn_two = new JButton();
        JButton btn_three = new JButton();
        JButton btn_four = new JButton();

        try {
            addImage = ImageIO.read(getClass().getResource(
                    "media/add-circle-svgrepo-com.png"));
            // Image one = ;
            removeImage = ImageIO.read(getClass().getResource(
                    "media/minus-circle-svgrepo-com.png"));
            updateImage = ImageIO.read(getClass()
                    .getResource("media/edit-svgrepo-com.png"));
            refreshImage = ImageIO.read(getClass()
                    .getResource("media/refresh-svgrepo-com.png"));
            JButton[] buttons = { btn_one, btn_two, btn_three, btn_four };
            Image[] images = { addImage, removeImage, updateImage, refreshImage };
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setIcon(new ImageIcon(getScaledImage(images[i], 70, 70)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        btn_one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new insert(data);
            }
        });
        btn_two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new delete(data);
            }
        });
        btn_three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new update(data);
            }
        });

        btn_four.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new refresh(data);
            }
        });

        btn_one.setBackground(new selectedColors().greenish);
        btn_two.setBackground(new selectedColors().greenish);
        btn_three.setBackground(new selectedColors().greenish);
        btn_four.setBackground(new selectedColors().greenish);

        // Dimension minSize = new Dimension(2, 50);
        // Dimension maxSize = new Dimension(Short.MAX_VALUE, 100);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        // btn_one.setMaximumSize(new Dimension(Integer.MAX_VALUE,
        // btn_one.getMinimumSize().height));
        // btn_two.setMaximumSize(new Dimension(Integer.MAX_VALUE,
        // btn_two.getMinimumSize().height));
        // btn_three.setMaximumSize(new Dimension(Integer.MAX_VALUE,
        // btn_three.getMinimumSize().height));
        // btn_four.setMaximumSize(new Dimension(Integer.MAX_VALUE,
        // btn_four.getMinimumSize().height));
        btn_one.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        btn_two.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        btn_three.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        btn_four.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        btn_one.setAlignmentX(CENTER_ALIGNMENT);
        btn_two.setAlignmentX(CENTER_ALIGNMENT);
        btn_three.setAlignmentX(CENTER_ALIGNMENT);
        btn_four.setAlignmentX(CENTER_ALIGNMENT);

        Dimension prefSize = new Dimension(2, 10);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setBackground(new selectedColors().grayish);

        this.add(btn_one);
        this.add(new Box.Filler(prefSize, prefSize, prefSize));
        this.add(btn_two);
        this.add(new Box.Filler(prefSize, prefSize, prefSize));

        this.add(btn_three);
        this.add(new Box.Filler(prefSize, prefSize, prefSize));

        this.add(btn_four);
    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}

class refresh {
    JPanel newdata;

    refresh(JPanel data) {
        newdata = new Data();

        if (data.getComponents().length != 0) {
            data.remove(data.getComponents().length - 1);
            data.revalidate();
            data.add(newdata);
            data.validate();
            data.repaint();
        }
    }
}

class Label extends JLabel {
    JLabel lbl;

    Label(String name) {
        this.setText(name);
    }
}

class Data extends JPanel {
    JPanel pnl;
    JTable tbl;

    Data() {
        try {
            LinkedList<String[]> labels = new DB().select();
            Object[] objArr = labels.toArray();
            String[][] strArr = Arrays.copyOf(objArr, objArr.length, String[][].class);

            String[] columnNames = { "ID", "Name", "Diagnosis", "Prescription", "Description" };
            tbl = new JTable(strArr, columnNames);
            // tbl.setBounds(30, 40, 700, 300);
            // this.setLayout(null);
            this.add(tbl);
            JScrollPane scroll = new JScrollPane(tbl);
            scroll.setViewportView(tbl);
            // scroll.setPreferredSize(new Dimension(800, 400));
            scroll.setPreferredSize(new Dimension(800, 400));
            scroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
            tbl.setPreferredScrollableViewportSize(scroll.getPreferredSize());
            tbl.setFillsViewportHeight(true);
            // scroll.setSize(400, 300);
            tbl.setBackground(new selectedColors().grayish2);
            this.setLayout(new BorderLayout());
            this.add(scroll, BorderLayout.CENTER);

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        this.setBackground(new selectedColors().grayish);
    }
}

public class main_file extends JFrame {
    JFrame frm;
    JPanel data;

    main_file() {
        JMenuBar menu = new Menu();
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, menu);
        data = new Data();
        this.add(BorderLayout.CENTER, data);
        this.add(BorderLayout.WEST, new SideBar(data));
        this.setSize(1020, 480);
        this.setTitle("Medical DB");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].setFullScreenWindow(null);
        ;
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new main_file();

    }
}