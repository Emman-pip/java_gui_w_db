import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class update extends JPanel {
    JFrame frm;
    JPanel pnl;

    update(JPanel dataGrid) {
        pnl = new JPanel();
        this.setBackground(new selectedColors().grayish);
        JLabel lbl_ID = new JLabel("ID:", JLabel.CENTER);
        JTextField txt_ID = new JTextField();
        JLabel lbl_name = new JLabel("name:", JLabel.CENTER);
        JTextField txt_name = new JTextField();
        JLabel lbl_diagnosis = new JLabel("diagnosis:", JLabel.CENTER);
        JTextField txt_diagnosis = new JTextField();
        JLabel lbl_prescription = new JLabel("prescription:", JLabel.CENTER);
        JTextField txt_prescription = new JTextField();
        JLabel lbl_description = new JLabel("description:", JLabel.CENTER);
        JTextField txt_description = new JTextField();
        JButton btn_show = new JButton("Check ID");

        btn_show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    LinkedList<String> fetchedData = new DB().selectWithID(txt_ID.getText());
                    System.out.println(fetchedData);
                    txt_name.setText(fetchedData.get(1));
                    txt_diagnosis.setText(fetchedData.get(2));
                    txt_prescription.setText(fetchedData.get(3));
                    txt_description.setText(fetchedData.get(4));

                } catch (Exception err) {
                    System.out.println(err);
                }
            }
        });

        JButton btn_update = new JButton("update");
        btn_show.setBackground(new selectedColors().greenish);
        btn_update.setBackground(new selectedColors().greenish);

        btn_update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new DB().update(txt_ID.getText(), txt_name.getText(), txt_diagnosis.getText(),
                            txt_prescription.getText(), txt_description.getText());
                    new refresh(dataGrid);
                } catch (Exception err) {
                    System.out.println(err);
                }
            }
        });

        JLabel[] lbl_list = { lbl_ID, lbl_name, lbl_diagnosis, lbl_prescription, lbl_description };
        JTextField[] txt_list = { txt_ID, txt_name, txt_diagnosis, txt_prescription, txt_description };

        for (int i = 0; i < lbl_list.length; i++) {
            pnl.add(lbl_list[i]);
            pnl.add(txt_list[i]);

        }
        pnl.add(btn_show);
        pnl.add(btn_update);

        pnl.setLayout(new GridLayout(6, 2));
        pnl.setBorder(new EmptyBorder(0, 10, 10, 10));
        pnl.setBackground(new selectedColors().grayish);

        for (JLabel lbl : lbl_list) {
            lbl.setForeground(Color.WHITE);
        }
        this.setLayout(new BorderLayout());
        this.add(pnl);
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // this.setTitle("update records");
        this.setSize(400, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new update(null);
    }
}