package ru.javajoy.jps.w17;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * @author Artem Zhukov
 */
public class Goods implements Serializable{

    private ImageIcon imageIcon;
    private String name;
    private String category;
    private Double price;
    private Color color;
    private Boolean availability;

    public Goods(String name, Double price, Boolean availability) {
        imageIcon = new ImageIcon("src/ru/javajoy/jps/w17/icon/default.jpg");
        imageIcon.setDescription("default");
        if (name != null){
            this.name = name;
        }else {
            this.name = "no name";
        }
        category = "default";
        if (price != null){
            this.price = price;
        }else {
            this.price = 0.0;
        }
       color = new Color(255,255,255);
        this.availability = availability != null;
    }

    public Object[] toArray() {
        Object[] array = new Object[6];
        array[0] = this.imageIcon;
        array[1] = this.name;
        array[2] = this.category;
        array[3] = this.price;
        array[4] = this.color;
        array[5] = this.availability;
        return array;
    }


}