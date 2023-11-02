import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class delete extends JPanel {
    DB data;
    JPanel frm = this;

    delete(JPanel dataGrid) {
        JPanel pnl = new JPanel();
        pnl.setBackground(new selectedColors().grayish);
        JPanel pnl_buttons = new JPanel();

        JLabel lbl_deleteID = new JLabel("Delete record with ID#:");
        lbl_deleteID.setForeground(Color.WHITE);
        JTextField txt_IDNum = new JTextField();
        txt_IDNum.setColumns(20);
        // txt_IDNum.setSize(10,10);

        JButton btn_del = new JButton("Delete");
        btn_del.setBackground(new selectedColors().greenish);
        JButton btn_close = new JButton("Close");
        btn_close.setBackground(new selectedColors().greenish);

        btn_del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    data.del(Integer.parseInt(txt_IDNum.getText()));
                    data.select();
                    new refresh(dataGrid);
                } catch (Exception err) {
                    System.out.println(err);
                }
            }
        });
        // this.setSize(350, 150);
        // this.pack();
        this.setLayout(new BorderLayout());
        pnl_buttons.setLayout(new BorderLayout());
        // pnl.setLayout(new Borde);

        pnl.setBorder(new EmptyBorder(10, 10, 10, 10));
        // pnl.setLayout(new BorderLayout());
        // pnl.add(lbl_deleteID, BorderLayout.WEST);
        // pnl.add(txt_IDNum, BorderLayout.CENTER);
        pnl.add(lbl_deleteID);
        pnl.add(txt_IDNum);
        pnl.add(pnl_buttons);
        this.add(pnl);
        pnl_buttons.add(btn_del, BorderLayout.CENTER);
        // pnl_buttons.add(btn_close, BorderLayout.SOUTH);

        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new delete(null);
    }
}