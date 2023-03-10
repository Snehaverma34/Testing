package AutomationProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//
//import dataDrivenFramework.WritableSheet;
//import dataDrivenFramework.WritableWorkbook;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;



public class AppLaunch {

public WebDriver driver;
@BeforeTest	
	public void launchApp() throws Exception {

	
	System.setProperty("webdriver.chrome.driver",
			"C:\\eclipse-committers-2022-03-R-win32-x86_64\\eclipse\\jar\\chrome\\chromedriver.exe");

	driver = new ChromeDriver();
	driver.get("https://test-nf.com/english.html");
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().window().maximize();

}

@Test
public void available() {
	SoftAssert s = new SoftAssert();
	PageObject p = PageFactory.initElements(driver, PageObject.class);
	boolean home = p.Home.isDisplayed();
	s.assertEquals(home, true);
	boolean football = p.fBall.isDisplayed();
	s.assertEquals(football, true);
	boolean Baskket = p.bBall.isDisplayed();
	Assert.assertEquals(Baskket, true);
	boolean kriket =  p.Kriket.isDisplayed();
	Assert.assertEquals(kriket, true);
	boolean Cibersport =  p.Cibersport.isDisplayed();
	s.assertEquals(Cibersport, true);
}

@Test
public void storeUrls() throws Exception {
	FileOutputStream fo = new FileOutputStream("C:\\Users\\sneha\\OneDrive\\Desktop\\App.xls");
	
	jxl.write.WritableWorkbook wb = Workbook.createWorkbook(fo);
	
	jxl.write.WritableSheet ws = wb.createSheet("Sheet1", 1);
	PageObject p = PageFactory.initElements(driver, PageObject.class);
	
	p.Home.click();
	String HomeUrl =driver.getCurrentUrl() ;

	Label l = new Label (0,0,"HomeURL:" +HomeUrl);
	
	ws.addCell(l);
	
	 Thread.sleep(2000);
	p.fBall.click();
	String FootballUrl =driver.getCurrentUrl();

	Label fl = new Label (1,1,"FootballURL:" +FootballUrl);
	
	ws.addCell(fl);
	 Thread.sleep(2000);

	
	p.bBall.click();
	String BasketballUrl =driver.getCurrentUrl() ;

	
	Label bl = new Label (1,2,"BasketBallURL:" +BasketballUrl);
	
	ws.addCell(bl);

	p.Kriket.click();
	String CricketUrl =driver.getCurrentUrl();

	Label cl = new Label (1,3,"CricketURL:" +CricketUrl);
	
	ws.addCell(cl);
	
	p.Cibersport.click();
	String CiberSportUrl =driver.getCurrentUrl() ;

	
	Label csl = new Label (1,4,"CiberSportURL:" +CiberSportUrl);
	
	ws.addCell(csl);
	

	
	
	wb.write();
	wb.close();
}

@Test
public void Url() throws Exception {

FileInputStream f = new FileInputStream("C:\\Users\\sneha\\OneDrive\\Desktop\\App.xls");
Workbook wb = Workbook.getWorkbook(f);
Sheet s = wb.getSheet("Sheet1");
PageObject p = PageFactory.initElements(driver, PageObject.class);


String HomeTitle = p.Home.getText();
String HomeCont = s.getCell(0, 0).getContents();

if(HomeTitle.contains(HomeCont)) {
	System.out.println("Pass: The Url contains Tab Title" +HomeTitle);

}
else {
	System.out.println("Fail: the url doesn't contain Tab Title Expected:" +HomeTitle+" Actual: english "  );
}

String FootlballTitle = p.fBall.getText();
String FootballCont = s.getCell(1, 1).getContents();

if(FootlballTitle.contains(FootballCont)) {
	System.out.println("Pass: The Url contains Tab Title" +FootlballTitle);

}
else {
	System.out.println("Fail: the url doesn't contain Tab Title Expected:" +FootlballTitle+ " Actual " +FootlballTitle.toLowerCase());
}

String BasketBallTitle = p.bBall.getText();
String BasketBallCont = s.getCell(1, 2).getContents();



if(BasketBallTitle.contains(BasketBallCont)) {
	System.out.println("Pass: The Url contains Tab Title" +BasketBallTitle);

}
else {
	System.out.println("Fail: the url doesn't contain Tab Title Expected:" +BasketBallTitle+ " Actual " +BasketBallTitle.toLowerCase());
}

String CricketTitle = p.Kriket.getText();
String  CricketCont = s.getCell(1, 3).getContents();



if(CricketTitle.contains(CricketCont)) {
	System.out.println("Pass: The Url contains Tab Title" +CricketTitle);

}
else {
	System.out.println("Fail: the url doesn't contain Tab Title Expected:" +CricketTitle+ " Actual " +CricketTitle.toLowerCase());
}


String CibersportTitle = p.Cibersport.getText();
String  CibersportCont = s.getCell(1, 4).getContents();



if(CibersportTitle.contains(CibersportCont)) {
	System.out.println("Pass: The Url contains Tab Title" +CibersportTitle);

}
else {
	System.out.println("Fail: the url doesn't contain Tab Title Expected:" +CibersportTitle+ " Actual " +CibersportTitle.toLowerCase());
}


}

@AfterTest
public void close() {
	driver.close();
}
	
	
	
	
}
