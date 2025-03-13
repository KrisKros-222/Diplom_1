import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientsData() {
        return new Object[][] {
                {IngredientType.SAUCE,"hot sauce",100},
                {IngredientType.FILLING,"cutlet",200},
        };
    }

    @Test
    public void getData() {
        Ingredient ingredient = new Ingredient(type,name,price);
        IngredientType actualType = ingredient.getType();
        String actualName = ingredient.getName();
        float actualPrice = ingredient.getPrice();

        Assert.assertEquals(type,actualType);
        Assert.assertEquals(name,actualName);
        Assert.assertEquals(price,actualPrice,0);
    }
}
