package AutomationProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObject {

	
	@FindBy(xpath="//*[text()='Home']") WebElement Home;
	@FindBy(xpath="//*[text()='Football']") WebElement fBall;
	@FindBy(xpath="//*[text()='Busketball']") WebElement bBall;
	@FindBy(xpath="//*[text()='Kriket']") WebElement Kriket;
	@FindBy(xpath="//*[text()='Cibersport']") WebElement Cibersport;
}
