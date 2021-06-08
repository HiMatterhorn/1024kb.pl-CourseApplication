package entity.enums;

import api.ColorOperation;

import java.awt.*;

public enum Colors implements ColorOperation {
BLACK("#000000"),WHITE("#FFFFFF"),RED("#FF0000"),GREEN("#008000"),BLUE("#0000FF"),YELLOW("#FFFF00");

private String hexColor;
private int red;
private int green;
private int blue;


Colors (String hexColor){
    this.hexColor = hexColor;
}
    @Override
    public String getHexColor() {
        return hexColor;
    }

    @Override
    public int getRGB() {
        Color color = Color.getColor(hexColor);
        red = color.getRed();
        green = color.getGreen();
        blue = color.getBlue();
        return new Color(red, green, blue).getRGB();
    }

}
