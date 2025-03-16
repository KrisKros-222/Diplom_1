import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private String name = "black bun";
    private float price = 100;

    @Test
    public void bunNameCheck() {
        Bun bun = new Bun(name,price);
        Assert.assertEquals(name,bun.getName());
    }

    @Test
    public void bunPriceCheck() {
        Bun bun = new Bun(name,price);
        Assert.assertEquals(price,bun.getPrice(),0);
    }

}
