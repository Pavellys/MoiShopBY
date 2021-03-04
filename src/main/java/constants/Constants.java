package constants;

import org.openqa.selenium.By;

public interface Constants {
    By MY_ACCOUNT = By.xpath("//*[@alt='User']");
    By BUTTON_ENTER = By.xpath("//*[contains(text(),'Войти')]");
    String MAIN_URL = "https://moishop.by";
}
