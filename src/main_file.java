import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

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

    SideBar() {
        JButton btn_one = new JButton("Add record");
        btn_one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new insert();
            }
        });
        JButton btn_two = new JButton("Delete record");
        btn_two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new delete();
            }
        });
        JButton btn_three = new JButton("Update record");
        btn_three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new update();
            }
        });

        JButton btn_four = new JButton("refresh");
        // TODO: ADD FUNCTIONALITY TO THE REFRESH BUTTON
        btn_four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Data();
            }
        });
        this.setLayout(new GridLayout(4, 1, 1, 1));
        this.add(btn_one);
        this.add(btn_two);
        this.add(btn_three);
        this.add(btn_four);
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

            String[] columnNames = { "ID", "Namer", "Diagnosis", "Prescription", "Description" };
            tbl = new JTable(strArr, columnNames);
            // tbl.setBounds(30, 40, 700, 300);
            // this.setLayout(null);
            this.add(tbl);
            JScrollPane scroll = new JScrollPane(tbl);
            scroll.setViewportView(tbl);
            scroll.setPreferredSize(new Dimension(800, 400));
            // scroll.setSize(400, 300);
            this.add(scroll);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class main_file extends JFrame {
    JFrame frm;

    main_file() {
        JMenuBar menu = new Menu();
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, menu);
        this.add(BorderLayout.WEST, new SideBar());
        this.add(BorderLayout.CENTER, new Data());
        this.setSize(1020, 480);
        // this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new main_file();
    }
}