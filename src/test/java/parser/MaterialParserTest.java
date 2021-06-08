package parser;

import entity.enums.Material;
import entity.parse.MaterialParser;
import org.junit.Assert;
import org.junit.Test;

public class MaterialParserTest {
    @Test
    public void testParseLeather(){
        String givenMaterial = "LEATHER";

        Assert.assertEquals(Material.LEATHER, MaterialParser.parseStringToMaterial(givenMaterial));
    }

    @Test
    public void testParseFur(){
        String givenMaterial = "fUr";

        Assert.assertEquals(Material.FUR, MaterialParser.parseStringToMaterial(givenMaterial));
    }

    @Test
    public void testParseCotton(){
        String givenMaterial = "CoTToN";

        Assert.assertEquals(Material.COTTON, MaterialParser.parseStringToMaterial(givenMaterial));
    }

    @Test
    public void testParseWool(){
        String givenMaterial = "wOoL";

        Assert.assertEquals(Material.WOOL, MaterialParser.parseStringToMaterial(givenMaterial));
    }

    @Test
    public void testParsePolyesters(){
        String givenMaterial = "POLyEsterS";

        Assert.assertEquals(Material.POLYESTERS, MaterialParser.parseStringToMaterial(givenMaterial));
    }

    @Test
    public void testParseMaterial(){
        String givenMaterial = "any-not-exist";

        Assert.assertEquals(Material.WOOL, MaterialParser.parseStringToMaterial(givenMaterial));
    }
}
