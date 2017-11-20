import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * Created by macbook on 11/14/17.
 */

// пример теста в самом простом варианте

public class SampleTest {

    // обозначает, что метод нужно запустить особым образом
    // результат запуска записать в отчет с помощью библиотеки TestNG
    @Test
    public void successfulTest() {
        assertEquals(1, 1); // проверка, что ожидаемое значение соответствует тому,
                                            // что пришло от сервера в UI или BE
    }

    @Test
    public void failedTest() {
        assertEquals(1, 2);
    }

}
