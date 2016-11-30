package ru.javajoy.jps.w17;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Created by Артем on 09.02.2015.
 */
public class ColorCellRendered extends JLabel implements TableCellRenderer {

    public ColorCellRendered(){
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setBackground((Color) value);
        return this;
    }
}
