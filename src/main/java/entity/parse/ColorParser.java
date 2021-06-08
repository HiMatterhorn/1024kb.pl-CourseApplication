package entity.parse;

import entity.enums.Colors;

import java.awt.*;

public class ColorParser {

public static Colors parseStringToColor (String str){
    String color = str.toUpperCase();

    if (color.equals("BLACK")){
        return Colors.BLACK;
    }

    else if (color.equals("WHITE")){
        return Colors.RED;
    }

    else if (color.equals("RED")){
        return Colors.RED;
    }

    else if (color.equals("GREEN")){
        return Colors.GREEN;
    }

    else if (color.equals("BLUE")){
        return Colors.BLUE;
    }

    else if (color.equals("YELLOW")){
        return Colors.YELLOW;
    }

    return Colors.WHITE;
}
}
