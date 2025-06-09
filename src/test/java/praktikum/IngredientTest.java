package praktikum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {
    // Параметризованный тест для проверки типа ингредиента
    @ParameterizedTest  // Позволяет запустить тест с разными параметрами
    @EnumSource(IngredientType.class)  // Используем все значения перечисления как параметры
    void getType_shouldReturnCorrectType(IngredientType type) {
        // Создаем ингредиент с текущим типом (параметр теста)
        Ingredient ingredient = new Ingredient(type, "test", 100);
        // Проверяем, что тип установлен правильно
        assertEquals(type, ingredient.getType());
    }

    // Тест для проверки получения названия ингредиента
    @Test
    void getName_shouldReturnCorrectName() {
        // Создаем ингредиент-соус с тестовыми данными
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        // Проверяем корректность получения названия
        assertEquals("hot sauce", ingredient.getName());
    }

    // Тест для проверки получения цены ингредиента
    @Test
    void getPrice_shouldReturnCorrectPrice() {
        // Создаем ингредиент-начинку с тестовыми данными
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        // Проверяем корректность получения цены
        assertEquals(100, ingredient.getPrice(), 0.001);
    }
}