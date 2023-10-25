import javax.swing.*;
import java.awt.*;

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
        btn_one.setSize(200, 200);
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

public class main_file extends JFrame{
    JFrame frm;
    main_file(){
        setSize(420, 420); 
        setVisible(true);
        JMenuBar menu = new Menu();
        add(BorderLayout.NORTH, menu);        
        add(BorderLayout.WEST, new SideBar());

    }
    public static void main(String[] args){
        new main_file();
    }
}