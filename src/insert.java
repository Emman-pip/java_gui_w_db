import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class widgets extends JPanel {
    DB data = new DB();
    JPanel pnl;
    JTextField txt_name;
    JTextField txt_diagnosis;
    JTextField txt_prescription;
    JTextField txt_description;
    DB database = new DB();
    JButton btn_close;

    public widgets(JPanel dataGrid) {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setBackground(new selectedColors().grayish);
        JPanel pnl_entries = new JPanel();
        pnl_entries.setBackground(new selectedColors().grayish);
        JLabel lbl_name = new JLabel("Name: ");
        lbl_name.setForeground(Color.WHITE);
        txt_name = new JTextField(10);
        pnl_entries.add(lbl_name);
        pnl_entries.add(txt_name);

        JLabel lbl_diagnosis = new JLabel("Diagnosis: ");
        lbl_diagnosis.setForeground(Color.WHITE);
        txt_diagnosis = new JTextField(10);
        pnl_entries.add(lbl_diagnosis);
        pnl_entries.add(txt_diagnosis);

        JLabel lbl_prescription = new JLabel("Prescription: ");
        lbl_prescription.setForeground(Color.WHITE);
        txt_prescription = new JTextField(10);
        pnl_entries.add(lbl_prescription);
        pnl_entries.add(txt_prescription);

        JLabel lbl_description = new JLabel("Description: ");
        lbl_description.setForeground(Color.WHITE);
        txt_description = new JTextField(10);
        pnl_entries.add(lbl_description);
        pnl_entries.add(txt_description);

        JPanel pnl_buttons = new JPanel();
        pnl_buttons.setBackground(new selectedColors().grayish);
        // System.out.println(txt_diagnosis.getText() + "this is it");
        // System.out.println(txt_name.getText()+ txt_diagnosis.getText()+
        // txt_prescription.getText()+ txt_description.getText());
        // JButton btn_add = new AddBtn(txt_name.getText(), txt_diagnosis.getText(),
        // txt_prescription.getText(), txt_description.getText());
        JButton btn_add = new JButton("Add");
        btn_add.setBackground(new selectedColors().greenish);

        btn_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    data.insert(txt_name.getText(), txt_diagnosis.getText(), txt_prescription.getText(),
                            txt_description.getText());
                    System.out.println("working!");
                    new refresh(dataGrid);
                } catch (Exception err) {
                    System.out.println(err);

                }
            }
        });

        // JButton btn_close = new CloseBtn();
        btn_close = new JButton("Close");
        btn_close.setBackground(new selectedColors().greenish);
        pnl_buttons.add(btn_close);
        pnl_buttons.add(btn_add);
        this.add(pnl_entries);
        this.add(pnl_buttons);
        // btn_add.addActionListener(e -> database.insert(txt_name.getText(),
        // txt_diagnosis.getText(), txt_prescription.getText(),
        // txt_description.getText()));

        pnl_entries.setLayout(new GridLayout(4, 1, 1, 1));
        this.setLayout(new GridLayout(2, 1, 1, 1));
        this.setAlignmentY(BOTTOM_ALIGNMENT);
    }

    public void insertToDB(String name, String diagnosis, String prescription, String description) throws Exception {
        database.insert(name, diagnosis, prescription, description);
    }
}

public class insert extends JInternalFrame {
    JInternalFrame frm = this;

    insert(JPanel dataGrid) {
        this.setClosable(true);
        this.setResizable(true);
        this.setTitle("add records");
        ;
        this.setSize(300, 300);

        widgets items = new widgets(dataGrid);
        items.btn_close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frm.dispose();
            }
        });
        this.add(items);
        // this.add(pnl);
        // this.add();
        this.pack();
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new insert(null);
    }
}