import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    Burger burger = new Burger();

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        Assert.assertEquals(bun,burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        Assert.assertEquals(List.of(ingredient1),burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(1);
        Assert.assertEquals(List.of(ingredient1),burger.ingredients);
    }

    @Test
    public void moveIngredientsTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1,0);
        Assert.assertEquals(List.of(ingredient2,ingredient1),burger.ingredients);
    }

    @Test
    public void getBurgerPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(100.0f);
        burger.setBuns(bun);

        Mockito.when(ingredient1.getPrice()).thenReturn(250.0f);
        burger.addIngredient(ingredient1);

        float expectedPrice = 450;
        Assert.assertEquals(expectedPrice,burger.getPrice(),0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100.0f);
        burger.setBuns(bun);

        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getName()).thenReturn("cutlet");
        Mockito.when(ingredient1.getPrice()).thenReturn(250.0f);
        burger.addIngredient(ingredient1);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        List<Ingredient> ingredients = burger.ingredients;

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().name().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        Assert.assertEquals(receipt.toString(),burger.getReceipt());
    }
}
