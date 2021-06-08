package parser;

import entity.enums.Colors;
import entity.parse.ColorParser;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class ColorParserTest {

    @Test
    public void testParseColorRed()

    {
        String testColor = "ReD";

        Assert.assertEquals(Colors.RED, ColorParser.parseStringToColor(testColor));
    }

    @Test
    public void testParseColorBlue()

    {
        String testColor = "Blue";

        Assert.assertEquals(Colors.BLUE, ColorParser.parseStringToColor(testColor));
    }

    @Test
    public void testParseColorGreen()

    {
        String testColor = "gReeN";

        Assert.assertEquals(Colors.GREEN, ColorParser.parseStringToColor(testColor));
    }

    @Test
    public void testParseColorYellow()

    {
        String testColor = "YelOOw";

        Assert.assertEquals(Colors.YELLOW, ColorParser.parseStringToColor(testColor));
    }

    @Test
    public void testParseColorBlack()

    {
        String testColor = "blaCk";

        Assert.assertEquals(Colors.BLACK, ColorParser.parseStringToColor(testColor));
    }

    @Test
    public void testParseColorWhite()

    {
        String testColor = "WhItE";

        Assert.assertEquals(Colors.WHITE, ColorParser.parseStringToColor(testColor));
    }

    @Test
    public void testParseColor()

    {
        String testColor = "asdas";

        Assert.assertEquals(Colors.WHITE, ColorParser.parseStringToColor(testColor));
    }
}