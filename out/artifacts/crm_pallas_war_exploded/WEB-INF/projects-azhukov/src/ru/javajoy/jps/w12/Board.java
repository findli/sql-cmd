package ru.javajoy.jps.w12;

import ru.javajoy.jps.w12.action.NewGameAction;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Board extends JPanel implements ActionListener {

    private static JLabel lbIcon[][] = new JLabel[Game.getMaxColumn()][Game.getMaxRow()];
    private int iFirstClick;
    private int jFirstClick;
    private int count = 1;
    private String directory = null;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("Файл");
    private JMenu viewMenu = new JMenu("Вид");
    private ActionListener listener = new MenuItemActionListener();
    private JMenu menuChoosePicture = new JMenu("Выберите картинку");
    private JMenu menuColorBorder = new JMenu("Выбор цвета рамки выделения");
    private JMenu menuColorBackground = new JMenu("Выбор цвета фона");
    private Game game;
    public static JPanel panelForImages = new JPanel();

    public Board(Game game) throws CloneNotSupportedException {
        this.game = game;
        createBarMenu();
        createPanel();
        createLabel();
    }

    public void createPanel() {
        panelForImages.setPreferredSize(new Dimension(610, 400));
        panelForImages.setLayout(new GridLayout(4, 4));
        add(panelForImages);
    }

    //Перемещение фрагментов с помощью мыши
    public void mouseAction() {
        for (int i = 0; i < Game.getMaxColumn(); i++) {
            for (int j = 0; j < Game.getMaxRow(); j++) {
                final int finalJ = j;
                final int finalI = i;
                lbIcon[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            try {
                                createContextMenu().show((Component) e.getSource(), e.getX(), e.getY());
                            } catch (CloneNotSupportedException e1) {
                                e1.printStackTrace();
                            }
                        }
                        JLabel forEmptyIcon[][] = new JLabel[Game.getMaxColumn()][Game.getMaxRow()];
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            lbIcon[finalI][finalJ].setBorder(BorderFactory.createLineBorder
                                    (game.getSettings().getColorBorder(), 3));
                            count++;
                            if (count % 2 == 0) {
                                iFirstClick = finalI;
                                jFirstClick = finalJ;
                            } else {
                                //При нажатии на одну и ту же ячейку 2 раза в подряд снимается выделение ячейки
                                if (lbIcon[finalI][finalJ] == lbIcon[iFirstClick][jFirstClick]) {
                                    lbIcon[finalI][finalJ].setBorder(BorderFactory.createLineBorder(null, 0));
                                } else {
                                    game.movePuzzle(iFirstClick, jFirstClick, finalI, finalJ);
                                    if (game.checkEndGame()) {
                                        int response = JOptionPane.showConfirmDialog(null,
                                                "Желаете начать игру сначала", "Конец игры",
                                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                        if (response == JOptionPane.YES_OPTION) {
                                            game.createModel();
                                            panelForImages.removeAll();
                                            revalidate();
                                            try {
                                                createLabel();
                                            } catch (CloneNotSupportedException e1) {
                                                e1.printStackTrace();
                                            }
                                        }
                                    }
                                    Icon iconFirst = lbIcon[iFirstClick][jFirstClick].getIcon();
                                    Icon iconSecond = lbIcon[finalI][finalJ].getIcon();
                                    lbIcon[iFirstClick][jFirstClick].setIcon(iconSecond);
                                    lbIcon[finalI][finalJ].setIcon(iconFirst);
                                    lbIcon[iFirstClick][jFirstClick].setBorder(null);
                                    lbIcon[finalI][finalJ].setBorder(null);
                                    revalidate();
                                    forEmptyIcon[finalI][finalJ] = lbIcon[finalI][finalJ];
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void createLabel() throws CloneNotSupportedException {
        String image = game.getSettings().getImagePath();
        panelForImages.setBackground(game.getSettings().getColorBackground());
        int cell;
        ImageIcon imageIcon[][] = new ImageIcon[Game.getMaxColumn()][Game.getMaxRow()];
        for (int i = 0; i < Game.getMaxColumn(); i++) {
            for (int j = 0; j < Game.getMaxRow(); j++) {
                cell = game.getPuzzleAt(i, j);
                imageIcon[i][j] = new ImageIcon(image + cell + BoardSettings.JPG);
                JLabel lb = new JLabel();
                lb.setIcon(imageIcon[i][j]);
                lbIcon[i][j] = lb;
                panelForImages.add(lb);
            }
        }
        mouseAction();
    }

    public void createBarMenu() throws CloneNotSupportedException {

        JMenuItem newGame = new JMenuItem("Новая игра");
        newGame.setAction(new NewGameAction("Новая игра", KeyEvent.VK_N));
        JMenuItem open = new JMenuItem("Открыть");
        JMenuItem save = new JMenuItem("Сохранить");
        JMenuItem saveAs = new JMenuItem("Сохранить как");
        JMenuItem saveBinary = new JMenuItem("Сохранить бинарный файл");
        JMenuItem openBinary = new JMenuItem("Открыть бинарный файл");
        fileMenu.add(newGame);
        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(saveAs);
        fileMenu.add(saveBinary);
        fileMenu.add(openBinary);
        newGame.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        saveAs.addActionListener(this);
        saveBinary.addActionListener(this);
        openBinary.addActionListener(this);
        fileMenu.addSeparator();
        menuBar.add(fileMenu);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(menuBar);
        ButtonGroup buttonGroupBorder = new ButtonGroup();
        menuColorBorder.add(radioItem("Красный", listener, BoardSettings.BORD, Color.RED, buttonGroupBorder));
        menuColorBorder.add(radioItem("Зеленый", listener, BoardSettings.BORD, Color.GREEN, buttonGroupBorder));
        viewMenu.add(menuColorBorder);
        ButtonGroup buttonGroupBackground = new ButtonGroup();
        menuColorBackground.add(radioItem("Темный", listener, BoardSettings.BACK, Color.BLACK, buttonGroupBackground));
        menuColorBackground.add(radioItem("Светлый", listener, BoardSettings.BACK, Color.WHITE, buttonGroupBackground));
        viewMenu.add(menuColorBackground);
        ButtonGroup buttonGroupPicture = new ButtonGroup();
        menuChoosePicture.add(radioItem("Голландия", listener, buttonGroupPicture, BoardSettings.IMAGE_ACTION_HOLLAND));
        menuChoosePicture.add(radioItem("Австрия", listener, buttonGroupPicture, BoardSettings.IMAGE_ACTION_AUSTRIA));
        viewMenu.add(menuChoosePicture);
        updateMenu();
        menuBar.add(viewMenu);
    }

    private JPopupMenu createContextMenu() throws CloneNotSupportedException {
        JPopupMenu popup = new JPopupMenu();
        JMenu menuColorBorder = new JMenu("Выбор цвета рамки выделения");
        ButtonGroup buttonGroupBorderPopup = new ButtonGroup();
        menuColorBorder.add(radioItem("Красный", listener, BoardSettings.BORD, Color.RED, buttonGroupBorderPopup));
        menuColorBorder.add(radioItem("Зеленый", listener, BoardSettings.BORD, Color.GREEN, buttonGroupBorderPopup));
        if (game.getSettings().getColorBorder().getRGB() == BoardSettings.COLOR_ACTION_RED) {
            menuColorBorder.getItem(0).setSelected(true);
        } else {
            menuColorBorder.getItem(1).setSelected(true);
        }
        popup.add(menuColorBorder);
        JMenu menuColorBackground = new JMenu("Выбор цвета фона");
        ButtonGroup buttonGroupBackgroundPopup = new ButtonGroup();
        popup.add(menuColorBackground);
        menuColorBackground.add(radioItem("Темный", listener, BoardSettings.BACK, Color.BLACK, buttonGroupBackgroundPopup));
        menuColorBackground.add(radioItem("Светлый", listener, BoardSettings.BACK, Color.WHITE, buttonGroupBackgroundPopup));
        if (game.getSettings().getColorBackground().getRGB() == BoardSettings.COLOR_ACTION_BLACK) {
            menuColorBackground.getItem(0).setSelected(true);
        } else {
            menuColorBackground.getItem(1).setSelected(true);
        }
        JMenu menuChoosePicture = new JMenu("Выберите картинку");
        ButtonGroup buttonGroupPicturePopup = new ButtonGroup();
        popup.add(menuChoosePicture);
        menuChoosePicture.add(radioItem("Голландия", listener, buttonGroupPicturePopup, BoardSettings.IMAGE_ACTION_HOLLAND));
        menuChoosePicture.add(radioItem("Австрия", listener, buttonGroupPicturePopup, BoardSettings.IMAGE_ACTION_AUSTRIA));
        if (game.getSettings().getImage() == BoardSettings.IMAGE_ACTION_HOLLAND) {
            menuChoosePicture.getItem(0).setSelected(true);
        } else {
            menuChoosePicture.getItem(1).setSelected(true);
        }
        return popup;
    }

    public static JMenuItem radioItem(String label, ActionListener listener, String destination,
                                      Color color, ButtonGroup mutExGroup) {
        JMenuItem item = new JRadioButtonMenuItem(label, true);
        item.addActionListener(listener);
        item.setActionCommand(destination + String.valueOf(color.getRGB()));
        mutExGroup.add(item);
        return item;
    }

    public void updateMenu() throws CloneNotSupportedException {
        if (game.getSettings().getColorBorder().getRGB() == BoardSettings.COLOR_ACTION_RED) {
            menuColorBorder.getItem(0).setSelected(true);
        } else {
            menuColorBorder.getItem(1).setSelected(true);
        }
        if (game.getSettings().getColorBackground().getRGB() == BoardSettings.COLOR_ACTION_BLACK) {
            menuColorBackground.getItem(0).setSelected(true);
        } else {
            menuColorBackground.getItem(1).setSelected(true);
        }
        if (game.getSettings().getImage() == BoardSettings.IMAGE_ACTION_HOLLAND) {
            menuChoosePicture.getItem(0).setSelected(true);
        } else {
            menuChoosePicture.getItem(1).setSelected(true);
        }
    }

    public static JMenuItem radioItem(String label, ActionListener listener, ButtonGroup mutExGroup, String actionCommand) {
        JMenuItem item = new JRadioButtonMenuItem(label, true);
        item.addActionListener(listener);
        item.setActionCommand((actionCommand != null) ? actionCommand : label);
        mutExGroup.add(item);
        return item;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Новая игра")) {
            game.createModel();
            panelForImages.removeAll();
            revalidate();
            try {
                createLabel();
            } catch (CloneNotSupportedException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getActionCommand().equals("Открыть")) {
            JFileChooser fileOpen = new JFileChooser();
            int ret = fileOpen.showDialog(null, "Открыть файл");
            String directory = String.valueOf(fileOpen.getSelectedFile());
            if (ret == 0) {
                try {
                    game.setNewFile(game.getInput(directory));
                } catch (IOException | ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                panelForImages.removeAll();
                panelForImages.revalidate();
                game.openFromFile();
                try {
                    createLabel();
                } catch (CloneNotSupportedException e1) {
                    e1.printStackTrace();
                }
            }
        }
        if (e.getActionCommand().equals("Сохранить")) {
            try {
                game.saveToTextFile("src/ru/javajoy/jps/w12/SavePuzzle.txt", game.getSettings().
                        getColorBorder(), game.getSettings().getColorBackground());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getActionCommand().equals("Сохранить как")) {
            try {
                FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "*.*");
                JFileChooser save = new JFileChooser();
                save.setFileFilter(filter);
                if (save.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    game.saveToTextFile(save.getSelectedFile().toString() + filter.getDescription(),
                            game.getSettings().getColorBorder(),
                            game.getSettings().getColorBackground());
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getActionCommand().equals("Сохранить бинарный файл")) {
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
                    out.writeObject(game);
                    out.close();
                } catch (IOException e1) {
                    System.out.println("Исключение во время сериализации : " + e);
                }
            }
        }

        if (e.getActionCommand().equals("Открыть бинарный файл")) {
            JFileChooser fileOpen = new JFileChooser(directory);
            int ret = fileOpen.showDialog(null, "Открыть файл");
            String fileName = String.valueOf(fileOpen.getSelectedFile());
            panelForImages.removeAll();
            revalidate();
            if (ret == 0) {
                try {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                        game = (Game) ois.readObject();
                        ois.close();
                    } catch (Exception e1) {
                        System.out.println("Исключение во время сериализации: " + e);
                    }
                    createLabel();
                    updateMenu();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }


    public class MenuItemActionListener extends JPanel implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JMenuItem item = (JMenuItem) e.getSource();
            String cmd = item.getActionCommand();
            String colorString = cmd.substring(4);
            String[] cmdParts = cmd.split("_");
            BoardSettings settings = game.getSettings();
            if (cmd.startsWith(BoardSettings.BORD)) {
                Color color = new Color(Integer.parseInt(colorString));
                settings.setColorBorder(color);
                game.setSettings(settings);
                BorderFactory.createLineBorder(game.getSettings().getColorBorder());
            } else if (cmd.startsWith(BoardSettings.BACK)) {
                Color color = new Color(Integer.parseInt(colorString));
                settings.setColorBackground(color);
                game.setSettings(settings);
                panelForImages.setBackground(game.getSettings().getColorBackground());
            } else if (cmdParts[0].equals("image")) {
                settings.setImage(cmd);
                game.setSettings(settings);
                panelForImages.removeAll();
                panelForImages.revalidate();
                try {
                    createLabel();
                } catch (CloneNotSupportedException e1) {
                    e1.printStackTrace();
                }
            }
            try {
                updateMenu();
            } catch (CloneNotSupportedException e1) {
                e1.printStackTrace();
            }
        }
    }
}
