import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;
/*
Путем ручного тестирования было определено что для расчетов используется формат double
max: 1.79769e+308
min: 2.22507e-308
*/
public class CalcTest {
    private CalcPage calculatorPage;

    @BeforeClass
    public void setUp() {
        Configuration.browser = "edge"; // Устанавливаем браузер
        calculatorPage = new CalcPage(); // Инициализируем Page Object
    }

    @BeforeMethod
    public void openCalc() {
        open("https://ecalc.ru/simple"); // Открываем страницу калькулятора
    }

    @Test(description = "Тестирование цифровых кнопок")
    public void numButtonTest() {
        calculatorPage.clickButton("1");
        calculatorPage.clickButton("2");
        calculatorPage.clickButton("3");
        calculatorPage.clickButton("4");
        calculatorPage.clickButton("5");
        calculatorPage.clickButton("6");
        calculatorPage.clickButton("7");
        calculatorPage.clickButton("8");
        calculatorPage.clickButton("9");
        calculatorPage.clickButton("0");
        calculatorPage.shouldDisplay("1234567890");
    }


    @Test(description = "Тестирование элементарных операций", dataProvider = "calcData", dataProviderClass = DataProviders.class)
    public void operationTest(String num1, String operator, String num2, String expectedResult) {
        calculatorPage.clickButton(num1);
        switch (operator) {
            case "+":
                calculatorPage.clickAdd();
                break;
            case "-":
                calculatorPage.clickSubtract();
                break;
            case "*":
                calculatorPage.clickMultiply();
                break;
            case "/":
                calculatorPage.clickDivide();
                break;
        }
        calculatorPage.clickButton(num2);
        calculatorPage.clickEqual();
        calculatorPage.shouldDisplay(expectedResult);
    }

    @Test(description = "Тестирование потока действий")
    public void streamTest() {
        calculatorPage.clickButton("9");
        calculatorPage.clickDivide();
        calculatorPage.clickButton("3");
        calculatorPage.clickAdd();
        calculatorPage.clickButton("7");
        calculatorPage.clickMultiply();
        calculatorPage.clickButton("5");
        calculatorPage.clickSubtract();
        calculatorPage.clickButton("6");
        calculatorPage.clickEqual();
        calculatorPage.shouldDisplay("32");
    }

    @Test(description = "Тестирование работы с отрицательными числами")
    public void negativeNumTest() {
        calculatorPage.clickSubtract();
        calculatorPage.clickButton("3");
        calculatorPage.clickAdd();
        calculatorPage.clickButton("3");
        calculatorPage.clickEqual();
        calculatorPage.shouldDisplay("0");
    }

    @Test(description = "Тестирование работы с числами с точкой")
    public void floatTest() {
        calculatorPage.clickButton("3");
        calculatorPage.clickButton(".");
        calculatorPage.clickButton("5");
        calculatorPage.clickAdd();
        calculatorPage.clickButton("3");
        calculatorPage.clickButton(".");
        calculatorPage.clickButton("5");
        calculatorPage.clickEqual();
        calculatorPage.shouldDisplay("7");
    }

    @Test(description = "Тестирование кнопки С (Clear)")
    public void clearTest() {
        calculatorPage.clickButton("3");
        calculatorPage.clickButton("3");
        calculatorPage.clickClear();
        calculatorPage.shouldDisplay("0");
    }

    @Test(description = "Тестирование функции последовательного стирания")
    public void backTest() {
        calculatorPage.clickButton("3");
        calculatorPage.clickButton("3");
        calculatorPage.clickBackspace();
        calculatorPage.shouldDisplay("3");
    }

    @Test(description = "Тестирование функции возведения в квадрат")
    public void powTest() {
        calculatorPage.clickButton("3");
        calculatorPage.clickPower();
        calculatorPage.shouldDisplay("9");
    }

}
