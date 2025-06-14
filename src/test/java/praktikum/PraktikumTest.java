package praktikum;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class PraktikumTest {
    // Тест для проверки что main выполняется без ошибок
    @Test
    void main_shouldRunWithoutExceptions() {
        // Проверяем что метод main не выбрасывает исключений
        assertDoesNotThrow(() -> Praktikum.main(new String[]{}));
    }

    // Тест для проверки вывода в консоль
    @Test
    void main_shouldCreateBurgerWithIngredients() {
        // Сохраняем оригинальный System.out для восстановления после теста
        PrintStream originalOut = System.out;

        try {
            // Создаем поток для перехвата вывода
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            // Устанавливаем новый PrintStream для перехвата вывода
            System.setOut(new PrintStream(outContent));

            // Вызываем основной метод приложения
            Praktikum.main(new String[]{});

            // Получаем перехваченный вывод
            String output = outContent.toString();
            // Проверяем что вывод содержит элементы бургера
            assertTrue(output.contains("(===="), "Output should contain burger buns");
            // Проверяем что вывод содержит цену
            assertTrue(output.contains("Price:"), "Output should contain price");
        } finally {
            // Восстанавливаем оригинальный System.out
            System.setOut(originalOut);
        }
    }
}