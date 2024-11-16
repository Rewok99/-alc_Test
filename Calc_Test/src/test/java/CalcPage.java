    import com.codeborne.selenide.SelenideElement;
    import org.openqa.selenium.By;
    import static com.codeborne.selenide.Condition.*;
    import static com.codeborne.selenide.Selenide.*;

    //тетстирование будет произодиться используя архитектуру page object
    public class CalcPage {
        //используемые элементы калькулятора кроме цифр
        private SelenideElement display = $(By.cssSelector(".calculator__display"));
        private SelenideElement addButton = $(By.cssSelector(".calculator__button[value='+']"));
        private SelenideElement subButton = $(By.cssSelector(".calculator__button[value='-']"));
        private SelenideElement mulButton = $(By.cssSelector(".calculator__button[value='*']"));
        private SelenideElement divButton = $(By.cssSelector(".calculator__button[value='/']"));
        private SelenideElement equalButton = $(By.cssSelector(".calculator__key--equal.equal__button"));
        private SelenideElement clearButton = $(By.cssSelector(".calculator__clear.del__button"));
        private SelenideElement backspaceButton = $(By.cssSelector(".calculator__backspace.action__button"));
        private SelenideElement powerButton = $(By.cssSelector(".calculator__power.action__button"));

        //нажатие цифр и точки
        public void clickButton(String value) {
            $(By.cssSelector(".calculator__button[value='" + value + "']")).click();
        }

        //кнопка сложения
        public void clickAdd() {
            addButton.click();
        }
        //кнопка вычитания
        public void clickSubtract() {
            subButton.click();
        }
        //кнопка умножения
        public void clickMultiply() {
            mulButton.click();
        }
        //кнопка деления
        public void clickDivide() {
            divButton.click();
        }
        //кнопка равно
        public void clickEqual() {
            equalButton.click();
        }
        //кнопка очистить
        public void clickClear() {
            clearButton.click();
        }
        //кнопка стереть (Backspace)
        public void clickBackspace() {
            backspaceButton.click();
        }
        //кнопка возведения в квадрат
        public void clickPower() {
            powerButton.click();
        }

        //дисплей - проверка
        public void shouldDisplay(String valueOnDisplay) {
            display.shouldHave(value(valueOnDisplay));
        }
    }

