package w2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class Add extends JFrame implements ActionListener {

    public static final String DOTS = "...";
    public static final String OK = "OK";
    public static final String CANCEL = "Cancel";
    private JButton urlBut = new JButton(DOTS);
    private JTextField personField = new JTextField();
    private JTextField dateField = new JTextField();
    private JTextField placeField = new JTextField();
    private JTextField urlField = new JTextField();
    private JButton okBut = new JButton(OK);
    private JButton canBut = new JButton(CANCEL);
    private JPanel panelPerson = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel panelDate = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel panelPlace = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel panelBut = new JPanel();
    private JPanel panelUrl = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private Form form = new Form();

    public Add() {
        super("Add photo");
        setSize(500, 310);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 1));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        panels();
        urlField.setEnabled(false);
        okBut.addActionListener(this);
        urlBut.addActionListener(this);
        canBut.addActionListener(this);
    }

    private void panels() {
        JPanel personPanelLB = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel urlPanelLB = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel datePanelLB = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel placePanelLB = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel personLb = new JLabel("personField (some persons enter via , without space)");
        JLabel urlLb = new JLabel("enter urlField photo ");
        JLabel dateLb = new JLabel("yyyy-mm-dd");
        JLabel placeLb = new JLabel("placeField of photo");
        Dimension dimension = new Dimension(400, 25);
        urlField.setPreferredSize(dimension);
        personField.setPreferredSize(dimension);
        dateField.setPreferredSize(dimension);
        placeField.setPreferredSize(dimension);
        urlPanelLB.add(urlLb);
        panelUrl.add(urlField);
        panelUrl.add(urlBut);
        personPanelLB.add(personLb);
        panelPerson.add(personField);
        datePanelLB.add(dateLb);
        panelDate.add(dateField);
        placePanelLB.add(placeLb);
        panelPlace.add(placeField);
        panelBut.add(okBut);
        panelBut.add(canBut);
        add(urlPanelLB);
        add(panelUrl);
        add(personPanelLB);
        add(panelPerson);
        add(datePanelLB);
        add(panelDate);
        add(placePanelLB);
        add(panelPlace);
        add(panelBut);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(DOTS)) {
            JFileChooser fileChooser = new JFileChooser();
            final int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                urlField.setText(String.valueOf(selectedFile));
            }
        } else if (e.getActionCommand().equals(OK)) {
            String person = personField.getText();
            String url = urlField.getText();
            String date = dateField.getText();
            String place = placeField.getText();
            CallableStatement setPlace;
            try {
                setPlace = Form.getConn().prepareCall("{call photogallery.addPlace(?,?)}");
                setPlace.setString(1, place);
                setPlace.execute();
                setPlace.registerOutParameter(2, Types.INTEGER);
                int idPlace = setPlace.getInt(2);
                System.out.println("ID Place: " + idPlace);
                CallableStatement setUrlPhoto = Form.getConn().prepareCall("{call photogallery.addUrlPhoto(?,?,?,?,?)}");
                setUrlPhoto.setInt(1, idPlace);
                setUrlPhoto.setString(2, place);
                setUrlPhoto.setString(3, url);
                setUrlPhoto.setString(4, date);
                setUrlPhoto.execute();
                setUrlPhoto.registerOutParameter(5, Types.INTEGER);
                System.out.println("ID Photo: " + setUrlPhoto.getInt(5));
                String[] command = person.split(",");
                CallableStatement setPerson = Form.getConn().prepareCall("{call photogallery.addPerson(?,?)}");
                int[] idPerson = new int[command.length];
                for (int i = 0; i < command.length; i++) {
                    setPerson.setString(1, command[i]);
                    setPerson.execute();
                    setPerson.registerOutParameter(2, Types.INTEGER);
                    idPerson[i] = setPerson.getInt(2);
                    System.out.println("ID Person: " + idPerson[i]);
                }
                CallableStatement setPhotoPeople = Form.getConn().prepareCall("call photogallery.addPhotoPeople(?,?,?)");
                setPhotoPeople.setString(2, url);
                int[] id = new int[command.length];
                for (int i = 0; i < command.length; i++) {
                    setPhotoPeople.setString(1, command[i]);
                    setPhotoPeople.execute();
                    setPhotoPeople.registerOutParameter(3, Types.INTEGER);
                    id[i] = setPhotoPeople.getInt(3);
                    System.out.println("ID:" + id[i]);
                }
                form.updateListUrl();
                dispose();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else if (e.getActionCommand().equals(CANCEL)) {
            dispose();
        }
    }

}
