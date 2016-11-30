package JSS.w02;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Cyrill on 12.09.2014.
 */
public class JDBCTableViewer {
    private static JFrame frame;
    private JPanel clientPanel;
    private JList lstTables;
    private JTable tableData;
    private JButton butReferesh;
    private DefaultListModel listModel = new DefaultListModel();
    private DefaultTableModel tableModel = null;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/Personnel";
    // Database credentials
    static final String USER = "root";
    static final String PASS = "1234";

    private static Connection conn = null;

    public JDBCTableViewer() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            frame.dispose();
        }
        butReferesh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTablesList();

            }
        });
        lstTables.setModel(listModel);
        lstTables.setVisibleRowCount(10);
        lstTables.setPrototypeCellValue("xxxxxxxxxxxxxxxx");

        lstTables.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                refreshData();
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

    private void refreshTablesList() {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            DatabaseMetaData metadata = conn.getMetaData();
            ResultSet rsTables = metadata.getTables(null, null, null, null);
            printResultSet(rsTables);
            rsTables.beforeFirst();
            listModel.clear();
            while( rsTables.next() ) {
                listModel.addElement(rsTables.getString("table_name"));
            }
            rsTables.close();
            tableModel = new DefaultTableModel(0,0);
            tableData.setModel(tableModel);
        } catch( SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private void refreshData() {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            tableModel = new DefaultTableModel(0,0);
            if (lstTables.getSelectedIndex()>=0) {
                String sql = "SELECT * FROM " + lstTables.getSelectedValue().toString();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();
            String[] row = new String[columnCount];
            for (int i = 1; i<=columnCount; i++) {
                tableModel.addColumn(meta.getColumnLabel(i));
            }
            while (rs.next()) {
                for (int i = 1; i<=columnCount; i++) {
                    row[i-1] = rs.getString(i);
                }
                tableModel.addRow(row);
            }
            rs.close();
        }
        tableData.setModel(tableModel);
        } catch( SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    static void printResultSet(ResultSet rs) throws SQLException{
        ResultSetMetaData meta = rs.getMetaData();
        int columnCount = meta.getColumnCount();
        String[] row = new String[columnCount];
        for (int i =1; i<=columnCount; i++) {
            System.out.print(meta.getColumnName(i)+"\t");
        }
        System.out.println();
        while (rs.next()) {
            for (int i = 1; i<=columnCount; i++) {
                System.out.print(rs.getString(i)+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        frame = new JFrame("JDBCTableView");
        frame.setContentPane(new JDBCTableViewer().clientPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
