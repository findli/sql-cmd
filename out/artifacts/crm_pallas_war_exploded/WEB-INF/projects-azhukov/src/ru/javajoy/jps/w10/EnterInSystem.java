package ru.javajoy.jps.w10;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

/**
 * Экран для ввода и проверки валидности пары логин-пароль
 * <p/>
 * Экран для ввода и проверки валидности пары логин-пароль, после проверки пары логин-пароль на валидность ,
 * выдает ошибку входа или подтверждение входа. Пара логин-пароль хранится в хэш-таблице.
 *
 * @author Артем
 */
public class EnterInSystem extends JFrame {

    private JTextField userLoginInput = new JTextField(15);
    private JPasswordField userPasswordInput = new JPasswordField(15);

    private JLabel statusLabel;
    private JPanel controlPanelLogin;
    private JPanel controlPanelPassword;
    private JPanel panelButton;

    public EnterInSystem() {
        super("Вход в систему");
        setSize(300, 170);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));
        setLocationRelativeTo(null);
        setResizable(false);
        panels();

        //хэщ-таблица для хранения пары логин-пароль
        final Map<String, String> loginMap = new TreeMap<String, String>();
        loginMap.put("login", "Log");
        loginMap.put("id12", "Qwerty");
        loginMap.put("ivan", "IvanoV");

        //Описание действия кнопки "ОК"
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String keyToMap = userLoginInput.getText().toLowerCase();
                String mapPasswordStr = loginMap.get(keyToMap);
                String passwordInString = new String(userPasswordInput.getPassword());
                if (loginMap.containsKey(keyToMap) && (passwordInString.equals(mapPasswordStr))) {
                    statusLabel.setForeground(Color.GREEN);
                    statusLabel.setText("Вход выполнен");
                } else {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Неправильный логин или пароль");
                }
            }
        });
        //Описание действия кнопки "Отмена"
        JButton cancelButton = new JButton("Отмена");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userLoginInput.setText("");
                userPasswordInput.setText("");
            }
        });

        Font font = new Font(null, Font.BOLD, 12);
        JLabel loginLabel = new JLabel("Логин:     ");
        loginLabel.setFont(font);
        JLabel passwordLabel = new JLabel("Пароль: ");
        passwordLabel.setFont(font);
        controlPanelLogin.add(loginLabel);
        controlPanelLogin.add(userLoginInput);
        controlPanelPassword.add(passwordLabel);
        controlPanelPassword.add(userPasswordInput);
        panelButton.add(okButton);
        panelButton.add(cancelButton);
        setVisible(true);
    }

    //Метод для создания панелей для размещения на экране "Вход в систему".
    public void panels() {

        statusLabel = new JLabel("", JLabel.CENTER);

        controlPanelLogin = new JPanel();
        controlPanelLogin.setLayout(new FlowLayout(FlowLayout.LEFT));

        controlPanelPassword = new JPanel();
        controlPanelPassword.setLayout(new FlowLayout(FlowLayout.LEFT));

        panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));

        add(controlPanelLogin);
        add(controlPanelPassword);
        add(statusLabel);
        add(panelButton);

    }

}
