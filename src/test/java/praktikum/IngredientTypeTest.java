package praktikum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IngredientTypeTest {
    // Тест для проверки значений перечисления
    @Test
    void values_shouldReturnCorrectTypes() {
        // Получаем все значения перечисления
        IngredientType[] types = IngredientType.values();
        // Проверяем количество значений
        assertEquals(2, types.length);
        // Проверяем первое значение
        assertEquals(IngredientType.SAUCE, types[0]);
        // Проверяем второе значение
        assertEquals(IngredientType.FILLING, types[1]);
    }

    // Тест для проверки получения значения перечисления по имени
    @Test
    void valueOf_shouldReturnCorrectType() {
        // Проверяем получение SAUCE по строке
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        // Проверяем получение FILLING по строке
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}