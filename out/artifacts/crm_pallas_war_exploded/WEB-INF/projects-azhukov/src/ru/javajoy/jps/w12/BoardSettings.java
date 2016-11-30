package ru.javajoy.jps.w12;

import java.awt.*;
import java.io.Serializable;

public class BoardSettings implements Serializable {

    public static final String IMAGE_PATH_HOLLAND = "src/ru/javajoy/jps/w12/images/holland/";
    public static final String IMAGE_PATH_AUSTRIA = "src/ru/javajoy/jps/w12/images/austria/";
    public static final String IMAGE_ACTION_HOLLAND = "image_holland";
    public static final String IMAGE_ACTION_AUSTRIA = "image_austria";
    public static final String BORD = "bord";
    public static final String BACK = "back";
    public static final String JPG = ".jpeg";
    private static final Color RED = Color.RED;
    private static final Color BLACK = Color.BLACK;
    public static final int COLOR_ACTION_RED = Color.RED.getRGB();
    public static final int COLOR_ACTION_BLACK = Color.BLACK.getRGB();
    private int colorBorderString = COLOR_ACTION_RED;
    private int colorBackgroundString = COLOR_ACTION_BLACK;
    private Color colorBorder = RED;
    private Color colorBackground = BLACK;
    private String image = IMAGE_ACTION_HOLLAND;

    public BoardSettings() {

    }

    public BoardSettings(BoardSettings bs) {
        colorBorderString = bs.colorBorderString;
        colorBackgroundString = bs.colorBackgroundString;
        colorBorder = new Color(bs.colorBorder.getRGB());
        colorBackground = new Color(bs.colorBackground.getRGB());
        image = bs.image;
    }

    public String getImagePath() {
        switch (image) {
            case IMAGE_ACTION_HOLLAND:
                return IMAGE_PATH_HOLLAND;
            default:
                return IMAGE_PATH_AUSTRIA;
        }
    }

    public Color getColorBorder() {
        return colorBorder;
    }

    public void setColorBorder(Color colorBorder) {
        this.colorBorder = colorBorder;
        this.colorBorderString = colorBorder.getRGB();
    }

    public Color getColorBackground() {
        return colorBackground;
    }

    public void setColorBackground(Color colorBackground) {
        this.colorBackground = colorBackground;
        this.colorBackgroundString = colorBackground.getRGB();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
