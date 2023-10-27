import javax.swing.*;
import java.awt.*;

// import java.awt.Label;
import java.util.LinkedList;

class Menu extends JMenuBar{
    JMenuBar mb;
    Menu(){
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        
        add(file);
        add(help);

        JMenuItem mItm1 = new JMenuItem("Chuchu");
        JMenuItem mItm2 = new JMenuItem("Help");
        JMenuItem mItm3 = new JMenuItem("Help");

        file.add(mItm1);
        file.add(mItm2);
        help.add(mItm3);
    }
}

class SideBar extends JPanel{
    JPanel pnl;
    SideBar(){
        JButton btn_one = new JButton("one");
        // btn_one.setSize(200, 200);
        JButton btn_two = new JButton("two");
        JButton btn_three = new JButton("three");
        JButton btn_four = new JButton("four");
        JButton btn_five = new JButton("five");
        setLayout(new GridLayout(5,1,1,1));
        
        add(btn_one);
        add(btn_two);
        add(btn_three);
        add(btn_four);
        add(btn_five);
    }
}

class Label extends JLabel {
    JLabel lbl;
    Label(String name){
        this.setText(name);
    }
}

class Data extends JPanel{
    JPanel pnl;
    JScrollPane scroll;
    Data(){
        try {
            LinkedList<String> labels = new DB().select();
            Object[] objArr = labels.toArray();
            String[] strArr = new String[objArr.length];
            for (int i = 0; i < objArr.length; i++){
                strArr[i] = labels.get(i);
            }
            JList list = new JList(strArr);
            scroll = new JScrollPane(list);
        } catch (Exception e){
            System.out.println(e);
        }
        
        scroll.setPreferredSize(new Dimension(650,460));
        // setLayout(new GridBagLayout());
        
        // scroll.setPreferredSize(new Dimension( 800,300));
        // setPreferredSize(new Dimension(WIDTH, 420));
        // setAutoscrolls(true);
        add(scroll);
        // add(scroll);
        // setSize(420, 420);
    }
}

public class main_file extends JFrame{
    JFrame frm;
    main_file(){
        // pack();
        JMenuBar menu = new Menu();
        add(BorderLayout.NORTH, menu);        
        add(BorderLayout.WEST, new SideBar());
        add(BorderLayout.CENTER, new Data());
        
        setSize(820, 520); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args){
        new main_file();
        // selectAll all = new selectAll();
    }
}