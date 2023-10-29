import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class widgets extends JPanel{
    DB data = new DB();
    JPanel pnl;
    JTextField txt_name;
    JTextField txt_diagnosis;
    JTextField txt_prescription;
    JTextField txt_description;
    DB database = new DB();
    public widgets () {
        JPanel pnl_entries = new JPanel();
        JLabel lbl_name = new JLabel("Name: ");
        txt_name = new JTextField(10);
        pnl_entries.add(lbl_name);
        pnl_entries.add(txt_name);

        JLabel lbl_diagnosis = new JLabel("Diagnosis: ");
        txt_diagnosis = new JTextField(10);
        pnl_entries.add(lbl_diagnosis);
        pnl_entries.add(txt_diagnosis);
    
        JLabel lbl_prescription = new JLabel("Prescription: ");
        txt_prescription = new JTextField(10);
        pnl_entries.add(lbl_prescription);
        pnl_entries.add(txt_prescription);

        JLabel lbl_description = new JLabel("Description: ");
        txt_description = new JTextField(10);
        pnl_entries.add(lbl_description);
        pnl_entries.add(txt_description);

        JPanel pnl_buttons = new JPanel();
        // System.out.println(txt_diagnosis.getText() + "this is it");
        // System.out.println(txt_name.getText()+ txt_diagnosis.getText()+ txt_prescription.getText()+ txt_description.getText());
        // JButton btn_add = new AddBtn(txt_name.getText(), txt_diagnosis.getText(), txt_prescription.getText(), txt_description.getText());
        JButton btn_add = new JButton("Add"); 

        btn_add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    data.insert(txt_name.getText(), txt_diagnosis.getText(), txt_prescription.getText(), txt_description.getText());
                    System.out.println("working!");
                }
                catch (Exception err){
                    System.out.println(err);
    
                }            
            }});


        
        // JButton btn_close = new CloseBtn();
        JButton btn_close = new JButton("Close");
        btn_close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(ABORT);
            }
        });
        pnl_buttons.add(btn_close);
        pnl_buttons.add(btn_add);
        this.add(pnl_entries);
        this.add(pnl_buttons);
        // btn_add.addActionListener(e -> database.insert(txt_name.getText(), txt_diagnosis.getText(), txt_prescription.getText(), txt_description.getText()));       
        
        pnl_entries.setLayout(new GridLayout(4,1,1,1));
        this.setLayout(new GridLayout(2,1,1,1));
        this.setAlignmentY(BOTTOM_ALIGNMENT);
    }
    public void insertToDB(String name, String diagnosis, String prescription, String description) throws Exception{
        database.insert(name, diagnosis, prescription, description);
    }
}

public class insert extends JFrame {
    JFrame frm;
    insert (){
        this.setTitle("add records");;
        this.setSize(300, 300);
        widgets items = new widgets();
        this.add(items);
        // this.add();
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args){
        new insert();
    }
}