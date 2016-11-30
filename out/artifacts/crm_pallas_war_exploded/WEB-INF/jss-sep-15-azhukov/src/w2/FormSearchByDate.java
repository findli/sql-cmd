package w2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class FormSearchByDate extends JFrame {
    private JPanel panelForLb = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel panelForTf = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel panelForBut = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JLabel label1 = new JLabel("Date from");
    private JLabel label2 = new JLabel("           Date till");
    private JTextField dateFromTf = new JTextField();
    private JButton okBut = new JButton("      Ok       ");
    private JButton cancelBut = new JButton("   Cancel   ");
    private JTextField dateTillTf = new JTextField();
    private JFrame frame = new JFrame();
    private Form form;
    private static String getFromDate;
    //private static DBConnection conn = DBConnection.getConnection("photogallery");

    public FormSearchByDate(final Form form) {
        frame.setName("Date");
        this.form = form;
        frame.setSize(200, 130);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        panels();
        okBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //getFromDate = dateFromTf.getText();
                Statement stm;
                try {
                    stm = Form.getConn().createStatement();
                    form.tableModel = new DefaultTableModel();
                    form.jTable.setModel(form.tableModel);
                    form.tableModel.addColumn("url photo");
                    form.tableModel.addColumn("date photo");
                    String strDateFromTf = dateTillTf.getText();
                    if (strDateFromTf == null) {
                        // strDateFromTf = Date
                    }
                    String sql = "select url_photo, date_photo from photo where date_photo BETWEEN {d '" + dateFromTf.getText() + "'}" +
                            " and {d '" + strDateFromTf + "'}";
                    ResultSet rs = stm.executeQuery(sql);
                    ResultSetMetaData meta = rs.getMetaData();
                    int column = meta.getColumnCount();
                    String[] row = new String[column];
                    while (rs.next()) {
                        for (int i = 1; i <= column; i++) {
                            row[i - 1] = rs.getString(i);
                        }
                        form.tableModel.addRow(row);
                    }
                    rs.close();
                    form.displayPhoto();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        cancelBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }

    private void panels() {
        panelForLb.add(label1);
        panelForLb.add(label2);
        Dimension dimension = new Dimension(90, 25);
        dateFromTf.setPreferredSize(dimension);
        dateTillTf.setPreferredSize(dimension);
        panelForTf.add(dateFromTf);
        panelForTf.add(dateTillTf);
        System.out.println(dateFromTf.getAlignmentX());
        panelForBut.add(okBut);
        panelForBut.add(cancelBut);
        frame.add(panelForLb);
        frame.add(panelForTf);
        frame.add(panelForBut);
    }

    public String getGetFromDate() {
        return getFromDate;
    }
}
