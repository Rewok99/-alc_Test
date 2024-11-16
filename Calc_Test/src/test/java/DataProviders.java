import org.testng.annotations.DataProvider;

//провайдер для тетсовых данных элементарных операций
public class DataProviders {
    @DataProvider(name = "calcData")
    public static Object[][] calcData() {
        return new Object[][]{
                {"1", "+", "4", "5"}, //сложение
                {"9", "-", "4", "5"}, //вычитание
                {"9", "*", "4", "36"}, //умножение
                {"9", "/", "3", "3"}, //деление
                {"9", "/", "0", "Infinity"} //деление на 0
        };
    }

}