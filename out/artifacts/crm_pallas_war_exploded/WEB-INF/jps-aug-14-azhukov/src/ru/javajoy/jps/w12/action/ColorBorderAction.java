package ru.javajoy.jps.w12.action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Цвет рамки
 */
public class ColorBorderAction extends AbstractAction {


    public ColorBorderAction(String name){
        super(name);
    }

    public ColorBorderAction(String text, int mnemonic){
        this(text);
        putValue(MNEMONIC_KEY, mnemonic);
        putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
