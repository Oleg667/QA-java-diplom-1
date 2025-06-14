package praktikum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BunTest {
    // Тест для проверки получения названия булочки
    @Test
    void getName_shouldReturnCorrectName() {
        // Создаем экземпляр булочки с тестовыми данными
        Bun bun = new Bun("black bun", 100);
        // Проверяем, что getName() возвращает ожидаемое название
        assertEquals("black bun", bun.getName());
    }

    // Тест для проверки получения цены булочки
    @Test
    void getPrice_shouldReturnCorrectPrice() {
        // Создаем экземпляр булочки с тестовыми данными
        Bun bun = new Bun("white bun", 200);
        // Проверяем, что getPrice() возвращает ожидаемую цену
        // Третий параметр (дельта) - допустимая погрешность для float
        assertEquals(200, bun.getPrice(), 0.001);
    }

    // Тест для проверки корректности установки полей в конструкторе
    @Test
    void constructor_shouldSetNameAndPrice() {
        // Создаем булочку с тестовыми параметрами
        Bun bun = new Bun("test bun", 123);
        // Проверяем, что поле name установлено правильно
        assertEquals("test bun", bun.name);
        // Проверяем, что поле price установлено правильно
        assertEquals(123, bun.price, 0.001);
    }
}