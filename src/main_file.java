import javax.swing.*;
import java.awt.*;

class menu extends JMenuBar{
    JMenuBar mb;
    menu(){
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

public class main_file extends JFrame{
    JFrame frm;
    main_file(){
        setSize(420, 420); 
        setVisible(true);
        add(BorderLayout.NORTH, new menu());
    }
    public static void main(String[] args){
        new main_file();
    }
}