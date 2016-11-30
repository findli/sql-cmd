package ru.javajoy.jps.w12.action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Новая игра
 */
public class NewGameAction extends AbstractAction {

    public NewGameAction(String name) {
        super(name);
    }

    public NewGameAction(String text, int mnemonic){
        this(text);
        putValue(MNEMONIC_KEY, mnemonic);
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
