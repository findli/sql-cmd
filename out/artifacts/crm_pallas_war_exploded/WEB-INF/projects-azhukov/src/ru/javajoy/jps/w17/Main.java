package ru.javajoy.jps.w17;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Vector;

/**
 * @author Artem Zhukov
 */
/*
1.Разработайте программу, которая отображает прайс-лист магазина в виде таблицы.
        Столбцы таблицы:
        - Картинка товара (ImageIcon)
        - Наименование (String)
        - Категория (String, для редактирования - выпадающий список)
        - Cтоимость(Float)
        - Цвет (Color, отображается в виде JLabel)
        - Наличие на складе (Boolean)
        2. Реализуйте операции:
        - «добавить товар», «удалить товар»
        - «открыть прайс из файла» и «сохранить прайс»*/

public class Main implements Serializable {

    public static ImageIcon[] imageIcons;
    public static String[] imagesString = {"default", "apple", "bananas", "beet", "cherry", "eggplant", "grapes", "onion",
            "orange", "peach", "raspberry", "strawberry", "tomato"};
    private String directory = null;
    public JTable myTable = new JTable(createDefaultTableModel());
    public DefaultTableModel dtm = (DefaultTableModel) myTable.getModel();


    public static void main(String[] args) {
        Main main = new Main();
        main.buildTable();
    }

    private void comboImage() {
        imageIcons = new ImageIcon[imagesString.length];
        for (int i = 0; i < imagesString.length; i++) {
            imageIcons[i] = createImageIcon("src/ru/javajoy/jps/w17/icon/" + imagesString[i] + ".jpg");
            if (imageIcons[i] != null) {
                imageIcons[i].setDescription(imagesString[i]);
            }
        }
    }

    private ImageIcon createImageIcon(String path) {
        if (path != null) {
            return new ImageIcon(path);
        } else {
            System.err.println("Couldn't find file");
            return null;
        }
    }

    private JTable buildTable() {
        final JFrame frame = createFrame();
        frame.getContentPane().add(new JScrollPane(myTable), BorderLayout.CENTER);
        frame.setVisible(true);
        comboImage();

        //Make Buttons
        JButton add = new JButton("+");
        JButton delete = new JButton("-");
        JButton save = new JButton("Save");
        JButton open = new JButton("Open");

        //Make createPanel
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(add);
        panel.add(delete);
        panel.add(save);
        panel.add(open);
        frame.getContentPane().add(panel, BorderLayout.EAST);
        frame.revalidate();

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) throws NumberFormatException {
                String name = JOptionPane.showInputDialog("Enter name");
                if (name == null) {
                    name = "No name";
                }
                Double price;
                while (true) {
                    String priceString = JOptionPane.showInputDialog("Enter price");
                    if (priceString == null) {
                        priceString = "0";
                    }
                    try {
                        price = Double.valueOf(priceString);

                        break;
                    } catch (NumberFormatException ignored) {
                    }
                }
                Double roundPrice = new BigDecimal(price).setScale(2, RoundingMode.UP).doubleValue();
                dtm.addRow(new Goods(name, roundPrice, true).toArray());
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!myTable.getSelectionModel().isSelectionEmpty()) {
                    dtm.removeRow(myTable.getSelectedRow());
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOutputStream fos;
                ObjectOutputStream out;
                FileNameExtensionFilter filter = new FileNameExtensionFilter(".dat", "*.*");
                JFileChooser chooserDirectory = new JFileChooser(directory);
                chooserDirectory.setFileFilter(filter);
                int ret = chooserDirectory.showDialog(null, "Сохранить файл");
                if (ret == 0) {
                    try {
                        directory = String.valueOf(chooserDirectory.getSelectedFile());
                        fos = new FileOutputStream(directory);
                        out = new ObjectOutputStream(fos);
                        out.writeObject(dtm.getDataVector());
                        out.close();
                    } catch (IOException e1) {
                        System.out.println("Исключение во время сериализации : " + e);
                    }
                }
            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileOpen = new JFileChooser(directory);
                int ret = fileOpen.showDialog(null, "Открыть файл");
                String fileName = String.valueOf(fileOpen.getSelectedFile());
                myTable.setAutoCreateColumnsFromModel(false);
                if (ret == 0) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                        Vector<String> columnNames = new Vector<String>();
                        myTable.getModel().getColumnCount();
                        for (int i = 0; i < dtm.getColumnCount(); i++) {
                            columnNames.add(dtm.getColumnName(i));
                        }
                        ((DefaultTableModel) myTable.getModel()).setDataVector((Vector) ois.readObject(), columnNames);
                    } catch (Exception e1) {
                        System.out.println("Исключение во время сериализации: " + e1);
                    }
                }
            }
        });

        myTable.setAutoCreateColumnsFromModel(true);
        TableColumn column = myTable.getColumnModel().getColumn(2);

        //Make comboBox Category
        JComboBox<String> listCategory = new JComboBox<String>();
        listCategory.addItem("Fruits");
        listCategory.addItem("Vegetables");
        listCategory.addItem("Berries");
        listCategory.addItem("Other");
        column.setCellEditor(new DefaultCellEditor(listCategory));

        //Set size cell
        TableColumnModel tableColumnModel = myTable.getColumnModel();
        TableColumn tableColumn = tableColumnModel.getColumn(0);
        tableColumn.setMinWidth(55);
        tableColumn.setMaxWidth(60);
        myTable.setRowHeight(55);

        //Make ComboBox Image
        column = myTable.getColumnModel().getColumn(0);
        myTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
        JComboBox<ImageIcon> plantList = new JComboBox<ImageIcon>(imageIcons);
        ImageRenderer renderer = new ImageRenderer();
        renderer.setPreferredSize(new Dimension(55, 55));
        plantList.setRenderer(renderer);
        plantList.setMaximumRowCount(5);
        column.setCellEditor(new DefaultCellEditor(plantList));

        //Make color cell
        TableColumn columnColor = myTable.getColumnModel().getColumn(4);
        columnColor.setCellEditor(new ColorEditor());
        TableCellRenderer tableCellRenderer = new ColorCellRendered();
        columnColor.setCellRenderer(tableCellRenderer);

        // Renderer boolean cell
        TableColumn columnCheckBox = myTable.getColumnModel().getColumn(5);
        columnCheckBox.setCellRenderer(myTable.getDefaultRenderer(Boolean.class));
        columnCheckBox.setCellEditor(myTable.getDefaultEditor(Boolean.class));

        TableRowSorter<javax.swing.table.TableModel> sorter = new TableRowSorter<>(myTable.getModel());
        myTable.setRowSorter(sorter);
        return myTable;
    }

    private JFrame createFrame() {
        JFrame frame = new JFrame("PriceList");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        frame.setSize(800, 400);
        frame.revalidate();
        return frame;
    }

    private DefaultTableModel createDefaultTableModel() {
        Vector<String> columnNames = getColumnNames();
        return new DefaultTableModel(columnNames, 0);
    }

    private Vector<String> getColumnNames() {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Image");
        columnNames.add("Name");
        columnNames.add("Category");
        columnNames.add("Price");
        columnNames.add("Color");
        columnNames.add("Availability");
        return columnNames;
    }

}
