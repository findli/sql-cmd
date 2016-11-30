package ru.javajoy.jps.w17;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ImageRenderer extends JLabel implements TableCellRenderer, ListCellRenderer {

    public ImageRenderer(){
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setHorizontalAlignment(CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setIcon((ImageIcon) value);
        return this;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        setIcon((ImageIcon) value);
        return this;
    }
}

