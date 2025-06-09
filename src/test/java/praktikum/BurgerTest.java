package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Аннотация для интеграции Mockito с JUnit 5
@ExtendWith(MockitoExtension.class)
class BurgerTest {

    // Создаем mock-объект для булочки (Bun)
    @Mock
    private Bun bun;

    // Создаем mock-объект для первого ингредиента
    @Mock
    private Ingredient ingredient1;

    // Создаем mock-объект для второго ингредиента
    @Mock
    private Ingredient ingredient2;

    // Тестируемый объект - бургер
    private Burger burger;

    // Метод, который выполняется перед каждым тестом
    @BeforeEach
    void setUp() {
        // Инициализируем новый объект Burger перед каждым тестом
        burger = new Burger();
    }

    // Тест для проверки установки булочек в бургер
    @Test
    void setBuns_shouldSetBun() {
        // Устанавливаем mock-булочку в бургер
        burger.setBuns(bun);
        // Проверяем, что булочка действительно установлена
        assertEquals(bun, burger.bun);
    }

    // Тест для проверки добавления ингредиента в бургер
    @Test
    void addIngredient_shouldAddIngredient() {
        // Добавляем mock-ингредиент в бургер
        burger.addIngredient(ingredient1);
        // Проверяем, что количество ингредиентов стало 1
        assertEquals(1, burger.ingredients.size());
        // Проверяем, что добавленный ингредиент соответствует ожидаемому
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    // Тест для проверки удаления ингредиента из бургера
    @Test
    void removeIngredient_shouldRemoveIngredient() {
        // Добавляем ингредиент
        burger.addIngredient(ingredient1);
        // Удаляем ингредиент по индексу 0
        burger.removeIngredient(0);
        // Проверяем, что список ингредиентов теперь пуст
        assertTrue(burger.ingredients.isEmpty());
    }

    // Тест для проверки перемещения ингредиента в бургере
    @Test
    void moveIngredient_shouldMoveIngredient() {
        // Добавляем два ингредиента
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        // Перемещаем первый ингредиент на позицию 1
        burger.moveIngredient(0, 1);
        // Проверяем новый порядок ингредиентов
        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    // Тест для проверки расчета общей стоимости бургера
    @Test
    void getPrice_shouldReturnCorrectPrice() {
        // Настраиваем mock-объекты:
        // Цена булочки - 100
        when(bun.getPrice()).thenReturn(100f);
        // Цена первого ингредиента - 50
        when(ingredient1.getPrice()).thenReturn(50f);
        // Цена второго ингредиента - 30
        when(ingredient2.getPrice()).thenReturn(30f);

        // Собираем бургер:
        // Устанавливаем булочку
        burger.setBuns(bun);
        // Добавляем ингредиенты
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        // Ожидаемая цена: 2 булочки (100*2) + ингредиенты (50+30) = 280
        float expectedPrice = 100 * 2 + 50 + 30;
        // Проверяем, что расчет цены корректен (с допустимой погрешностью 0.001)
        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }

    // Тест для проверки формирования чека
    @Test
    void getReceipt_shouldReturnCorrectReceipt() {
        // Настраиваем mock-объекты:
        // Название булочки
        when(bun.getName()).thenReturn("black bun");
        // Цена булочки
        when(bun.getPrice()).thenReturn(100f);
        // Тип первого ингредиента - соус
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        // Название ингредиента
        when(ingredient1.getName()).thenReturn("hot sauce");
        // Цена ингредиента
        when(ingredient1.getPrice()).thenReturn(50f);

        // Собираем бургер:
        // Устанавливаем булочку
        burger.setBuns(bun);
        // Добавляем ингредиент
        burger.addIngredient(ingredient1);

        // Формируем ожидаемый чек:
        // 1. Верхняя булочка
        // 2. Ингредиент
        // 3. Нижняя булочка
        // 4. Итоговая цена
        String expectedReceipt = String.format("(==== black bun ====)%n" +
                "= sauce hot sauce =%n" +
                "(==== black bun ====)%n%n" +
                "Price: %f%n", 250f);

        // Проверяем, что сформированный чек соответствует ожидаемому
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}