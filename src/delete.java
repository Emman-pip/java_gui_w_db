import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class delete extends JFrame {
    DB data;
    JFrame frm;

    delete() {
        JPanel pnl = new JPanel();
        JPanel pnl_buttons = new JPanel();

        JLabel lbl_deleteID = new JLabel("Delete record with ID#:");
        JTextArea txt_IDNum = new JTextArea();
        txt_IDNum.setColumns(20);
        // txt_IDNum.setSize(10,10);

        JButton btn_del = new JButton("Delete");
        JButton btn_close = new JButton("Close");

        btn_del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    data.del(Integer.parseInt(txt_IDNum.getText()));
                    data.select();
                } catch (Exception err) {
                    System.out.println(err);
                }
            }
        });

        btn_close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(ABORT);
            }
        });
        // this.add(lbl_deleteID);
        // this.add(txt_IDNum);
        this.setTitle("delete records");
        this.setSize(350, 150);
        // this.pack();
        this.setLayout(new BorderLayout());
        pnl_buttons.setLayout(new BorderLayout());

        this.getContentPane().add(pnl, BorderLayout.CENTER);
        this.getContentPane().add(pnl_buttons, BorderLayout.SOUTH);

        pnl.setBorder(new EmptyBorder(10, 10, 10, 10));
        // pnl.setLayout(new BorderLayout());
        // pnl.add(lbl_deleteID, BorderLayout.WEST);
        // pnl.add(txt_IDNum, BorderLayout.CENTER);
        pnl.add(lbl_deleteID);
        pnl.add(txt_IDNum);
        pnl_buttons.add(btn_del, BorderLayout.CENTER);
        pnl_buttons.add(btn_close, BorderLayout.SOUTH);

        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new delete();
    }
}