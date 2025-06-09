package praktikum;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    // Тест для проверки получения списка булочек
    @Test
    void availableBuns_shouldReturnNonEmptyList() {
        // Создаем экземпляр базы данных
        Database database = new Database();
        // Получаем список булочек
        List<Bun> buns = database.availableBuns();

        // Проверяем что список не null
        assertNotNull(buns);
        // Проверяем что список не пустой
        assertFalse(buns.isEmpty());
        // Проверяем количество булочек
        assertEquals(3, buns.size());
    }

    // Тест для проверки получения списка ингредиентов
    @Test
    void availableIngredients_shouldReturnNonEmptyList() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();

        assertNotNull(ingredients);
        assertFalse(ingredients.isEmpty());
        assertEquals(6, ingredients.size());
    }

    // Тест для проверки наличия конкретных булочек в базе
    @Test
    void availableBuns_shouldContainSpecificBuns() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();

        // Проверяем наличие булочек по названию через stream
        assertTrue(buns.stream().anyMatch(b -> b.getName().equals("black bun")));
        assertTrue(buns.stream().anyMatch(b -> b.getName().equals("white bun")));
        assertTrue(buns.stream().anyMatch(b -> b.getName().equals("red bun")));
    }

    // Тест для проверки наличия конкретных ингредиентов в базе
    @Test
    void availableIngredients_shouldContainSpecificIngredients() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();

        // Проверяем наличие соуса hot sauce
        assertTrue(ingredients.stream()
                .anyMatch(i -> i.getType() == IngredientType.SAUCE && i.getName().equals("hot sauce")));

        // Проверяем наличие начинки cutlet
        assertTrue(ingredients.stream()
                .anyMatch(i -> i.getType() == IngredientType.FILLING && i.getName().equals("cutlet")));
    }

    // Тест для проверки инициализации данных в конструкторе
    @Test
    void constructor_shouldInitializeData() {
        // Создаем базу данных
        Database db = new Database();
        // Проверяем что списки инициализированы
        assertNotNull(db.availableBuns());
        assertNotNull(db.availableIngredients());
    }
}