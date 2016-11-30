package w2;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class Form implements ActionListener {

    public static final String SLASHFORBD = "\\\\";
    public static final String BY_DATE = "By date";
    public static final String BY_NAME = "By name";
    public static final String ADD = "Add";
    public static final String REMOVE = "Remove";
    private static JFrame frame;
    private JPanel clientPanel;
    public JTable jTable;
    private JLabel imageLb;
    private JScrollPane scrollPanePhoto;
    public DefaultTableModel tableModel = null;


    private static Connection conn = DBConnection.getConnection("photogallery");

    public Form() {
        Dimension dimensionScrollPanePhoto = new Dimension(380, 250);
        scrollPanePhoto.setMinimumSize(dimensionScrollPanePhoto);
        updateListUrl();
        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);
        JMenuItem byName = new JMenuItem(BY_NAME);
        JMenuItem byDate = new JMenuItem(BY_DATE);
        JMenuItem add = new JMenuItem(ADD);
        JMenuItem remove = new JMenuItem(REMOVE);
        JMenu filter = new JMenu("Filter");
        JMenu edit = new JMenu("Edit");
        filter.add(byName);
        filter.add(byDate);
        edit.add(add);
        edit.add(remove);
        menu.add(edit);
        menu.add(filter);
        byName.addActionListener(this);
        byDate.addActionListener(this);
        add.addActionListener(this);
        remove.addActionListener(this);
        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Statement stm = null;
                try {
                    stm = conn.createStatement();
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        jTable.getSelectedRow();
                        if (jTable.getSelectionModel().getValueIsAdjusting())
                            return;
                        String cellValue = (String) jTable.getModel().getValueAt(jTable.rowAtPoint(e.getPoint()), 0);
                        System.out.println(cellValue);
                        String[] path = cellValue.split(SLASHFORBD);
                        StringBuilder newPath = new StringBuilder();
                        for (int i = 0; i < path.length; i++) {
                            if (i == path.length - 1) {
                                newPath.append(path[i]);
                            } else {
                                newPath.append(path[i]).append(SLASHFORBD);
                            }
                        }
                        String sql = "select person_name from person\n" +
                                "inner join photo_has_people on photo_has_people.idPerson = person.idPerson\n" +
                                "inner join photo on photo.idPhoto = photo_has_people.idPhoto\n" +
                                "where url_photo =  " + "'" + newPath.toString() + "'";
                        try {
                            ResultSet rs = stm.executeQuery(sql);
                            ResultSetMetaData meta = rs.getMetaData();
                            int columnCount = meta.getColumnCount();
                            while (rs.next()) {
                                for (int i = 1; i <= columnCount; i++) {
                                    System.out.print(rs.getString(i) + "\t");
                                }
                                System.out.println();
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        super.finalize();
    }

    public static void main(String[] args) {
        frame = new JFrame("Gallery");
        frame.setContentPane(new Form().clientPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void updateListUrl() {
        Statement stm = null;
        try {
            stm = conn.createStatement();
            tableModel = new DefaultTableModel();
            jTable.setModel(tableModel);
            tableModel.addColumn("url photo");
            tableModel.addColumn("date photo");
            String sql = "SELECT url_photo, date_photo FROM photo";
            ResultSet rs = stm.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int column = meta.getColumnCount();
            String[] row = new String[column];
            while (rs.next()) {
                for (int i = 1; i <= column; i++) {
                    row[i - 1] = rs.getString(i);
                }
                tableModel.addRow(row);
            }
            jTable.setModel(tableModel);
            rs.close();
            displayPhoto();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void filterByDate() {
        new FormSearchByDate(this);

    }

    private void filterByName() {
        Statement stm;
        try {
            stm = conn.createStatement();
            tableModel = new DefaultTableModel();
            jTable.setModel(tableModel);
            tableModel.addColumn("person's name");
            tableModel.addColumn("url");
            String input = JOptionPane.showInputDialog(null, "Enter Input:", "Dialog for Input",
                    JOptionPane.WARNING_MESSAGE);
            String sql = "select person_name, url_photo from person\n" +
                    "inner join photo_has_people on photo_has_people.idPerson = person.idPerson\n" +
                    "inner join photo on photo_has_people.idPhoto = photo.idphoto\n" +
                    "where person_name =" + "'" + input + "'";
            ResultSet rs = stm.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int column = meta.getColumnCount();
            String[] row = new String[column];
            while (rs.next()) {
                for (int i = 1; i <= column; i++) {
                    row[i - 1] = rs.getString(i);
                }
                tableModel.addRow(row);
            }
            rs.close();
            displayPhoto();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayPhoto() {
        jTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                    return;
                String cellValue = (String) jTable.getModel().getValueAt(jTable.getSelectedRow(), 0);
                ImageIcon imageIcon = new ImageIcon(cellValue);
                Image image = imageIcon.getImage();
                Image newimg = image.getScaledInstance(380, 250, java.awt.Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(newimg);
                imageLb.setIcon(imageIcon);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(BY_NAME)) {
            filterByName();
        } else if (e.getActionCommand().equals(BY_DATE)) {
            filterByDate();
        } else if (e.getActionCommand().equals(ADD)) {
            new Add();
        } else if (e.getActionCommand().equals(REMOVE)) {
            new FormRemove();
        }
    }

    public static Connection getConn() {
        return conn;
    }

}
