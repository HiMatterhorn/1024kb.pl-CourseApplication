package parser;

import entity.enums.SkinType;
import entity.parse.SkinParser;
import org.junit.Assert;
import org.junit.Test;

public class SkinParserTest {
    @Test
    public void testNaturalSkin() {
        String givenSkin = "NATURAL";

        Assert.assertEquals(SkinType.NATURAL, SkinParser.parseStringToSkinType(givenSkin));
    }

    @Test
    public void testArtificialSkin() {
        String givenSkin = "artIFCIal";

        Assert.assertEquals(SkinType.ARTIFICIAL, SkinParser.parseStringToSkinType(givenSkin));
    }

    @Test
    public void testSkinType() {
        String givenSkin = "any_not_exist";

        Assert.assertEquals(SkinType.ARTIFICIAL, SkinParser.parseStringToSkinType(givenSkin));
    }
}
