import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class update extends JFrame {
    JFrame frm;

    update(JPanel dataGrid) {
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

        this.add(lbl_ID);
        this.add(txt_ID);
        this.add(lbl_name);
        this.add(txt_name);
        this.add(lbl_diagnosis);
        this.add(txt_diagnosis);
        this.add(lbl_prescription);
        this.add(txt_prescription);
        this.add(lbl_description);
        this.add(txt_description);
        this.add(btn_show);
        this.add(btn_update);

        this.setLayout(new GridLayout(6, 2));

        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("update records");
        this.setSize(400, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new update(null);
    }
}