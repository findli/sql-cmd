package ru.javajoy.jps.w12.action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Цвет фона
 */
public class ColorBackgroundAction extends AbstractAction {

    public ColorBackgroundAction(String name){
        super(name);
    }

    public ColorBackgroundAction(String text, int mnemonic){
        this(text);
        putValue(MNEMONIC_KEY, mnemonic);
        putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
