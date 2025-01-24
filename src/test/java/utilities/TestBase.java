package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class TestBase {

    protected ExtentReports extentReports;//raporlamayi baslatir
    protected ExtentHtmlReporter extentHtmlReporter;// html formatinda rapor olusturur
    protected ExtentTest extentTest;//Test adımlarina bilgi eklenir


    //Extent Report
    public void createExtentReport(String testName) {
        //ExtentReports classindan bir object olusturarak raporlamayi baslatiriz,
        // bu objeyi raporlari olusturmak ve yonetmek icin kullanacağız
        extentReports = new ExtentReports();
        //öncelikle olusturmak istedigimz html reportu projemizde nerede saklamak istiyorsak
        // bu path i kullanakak bir tane html rapor olusturmaliyiz
        // bunun icin ExtentHtmlReporter classindan obje olusturmaliyiz
        // pathin sonunda .html seklinde yazmayi unutmamaliyiz
        String date = DateTimeFormatter.ofPattern("HHmmssddMMyy").format(LocalDateTime.now());
        String path = "target/extentReport/" + date + "htmlReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(path);
        //extentHtmlReporter objesini extentReports objesine ekler
        // böylece extentReports objesi extentHtmlReporter raporlayicisi vasitasiyla HTML raporlarini olusturur
        extentReports.attachReporter(extentHtmlReporter);
        //Bu html raporunda görmek isteyebileceğimiz bilgileri asagidaki gibi ekleyebiliriz
        extentReports.setSystemInfo("Test Automation Engineer", "Ali Can");
        extentReports.setSystemInfo("Enviornment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        //Html dökümanimizin bilgilerini ayarladik, rapor ismi ve döküman ismi ekleyebiliriz
        extentHtmlReporter.config().setDocumentTitle("Batch 291 Test Report");
        extentHtmlReporter.config().setReportName("My Extent Report");
        extentTest = extentReports.createTest(testName, "Test Steps");
    }


    protected static WebDriver driver;


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();

    }

    @AfterEach
    public void tearDown() {

        // driver.quit();
    }


    //DROPDOWN
//    Create a method that select an option from a dropdown index
    public static void dropdownSelectByIndex(WebElement dropdownElement, int index) {

        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }

    public static void dropdownSelectByIndex(By locator, int index) {

        WebElement dropdownElement = driver.findElement(locator);
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }

    public static void dropdownSelectByIndex(String xpath, int index) {

        WebElement dropdownElement = driver.findElement(By.xpath(xpath));
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }

    public static void dropdownSelectByVisibleText(WebElement dropdownElement, String text) {
        //USEFUL
        Select select = new Select(dropdownElement);
        for (int i = 0; i < select.getOptions().size(); i++) {
            if (select.getOptions().get(i).getText().equalsIgnoreCase(text)) {
                select.getOptions().get(i).click();
                break;
            }
        }
    }

    public static void dropdownSelectByValue(WebElement dropdownElement, String value) {

        Select objSelect = new Select(dropdownElement);
        objSelect.selectByValue(value);
    }

    public static void dropdownSelectCustomMethod(WebElement dropdownElement, String textOfDropdown) {

        List<WebElement> options = dropdownElement.findElements(By.tagName("option"));
        for (WebElement option : options) {
            System.out.println(option.getText());
            if (option.getText().equals(textOfDropdown)) {
                option.click();
                break;
            }
        }
    }

    public static WebElement dropdownSelectRandomly(Select select) {

        Random random = new Random();
        List<WebElement> list = select.getOptions();
        int optionIndex = 1 + random.nextInt(list.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }

    public ArrayList<String> dropdownGetSelectedOptions(WebElement dropdownElement) throws Exception {

        if (dropdownElement != null) {
            Select list = new Select(dropdownElement);
            ArrayList<WebElement> allSelectedOptions = (ArrayList<WebElement>) list.getAllSelectedOptions();
            ArrayList<String> result = new ArrayList<String>();
            for (WebElement eachSelected : allSelectedOptions) {
                result.add(eachSelected.getText());
            }
            return result;
        } else {
            throw new Exception("No element is returned");
        }
    }

    //    ALERTS
    public static void alertAccept() {

        driver.switchTo().alert().accept();
    }

    public static void alertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public static String alertGetText() {
        return driver.switchTo().alert().getText();
    }

    public static void alertTypeOnAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //    IFRAMES
    public static void switchIframeByIndex(int index) {
        driver.switchTo().frame(index);
    }

    public static void switchIframeByIdOrName(String idOrName) {
        driver.switchTo().frame(idOrName);
    }

    public static void switchIframeByWebElement(WebElement element) {
        driver.switchTo().frame(element);
    }

    //    WINDOWS !!!
    //    Switch by page index. INDEX starts at (0) : switchNewWindowByIndex(0)
    public static void switchNewWindowByIndex(int windowNumber) {
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

    //    Switch by page title : switchNewWindowByTitle("title of the new page");
    public static void switchNewWindowByTitle(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String childWindow : driver.getWindowHandles()) {
            driver.switchTo().window(childWindow);
            if (driver.getTitle().equals(targetTitle)) {
                System.out.println("Switched to the window : " + targetTitle);
                return;
            }
        }
        driver.switchTo().window(origin);
    }


    //ACTIONS_DOUBLE CLICK : doubleClick(buttonElement)
    public static void actionsDoubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }

    //    ACTIONS_HOVER_OVER
    public static void actionsHoverOnElement(WebElement element) {
        //        Actions actions = new Actions(driver);
        new Actions(driver).moveToElement(element).perform();
    }

    //    ACTIONS_SCROLL_DOWN
    public static void actionsScrollDown() {
        //    Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }

    //    ACTIONS_SCROLL_UP
    public static void actionsScrollUp() {
        //        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }

    //    ACTIONS_SCROLL_RIGHT
    public static void actionsScrollRight() {
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }

    //    ACTIONS_SCROLL_LEFT
    public static void actionsScrollLeft() {
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }

    //    ACTIONS_DRAG_AND_DROP
    public static void actionsDragAndDrop(WebElement source, WebElement target) {
        //        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDrop(source, target).perform();
    }

    //    ACTIONS_DRAG_AND_DROP_BY
    public static void actionsDragAndDrop(WebElement source, int x, int y) {
        //        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDropBy(source, x, y).perform();
    }

    //    JS EXECUTOR METHODS
    /*
    click with JS
    param : WebElement
    action : clicks on the given element
     */
    public static void clickByJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    //    EXPLICITLY WAIT FOR ELEMENT TO BE VISIBLE, SCROLL INTO THE ELEMENT, THEN CLICK BY JS
    public static void clickWithTimeoutByJS(WebElement element) {
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", waitForVisibility(element, 5));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                //waitFor(1);
            }
        }
    }

    /*
    scroll into specific elements
    param : WebElement
    action: scrolls into the given element
     */
    public static void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /*
    scroll all the way down
     */
    public static void scrollAllDownJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    /*
    scroll all the way UP
     */
    public static void scrollAllUpJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    /*
     locating elements by javascript executor-normally we may not need this at all
    param : id of the element
    return WebElement
     */
    public WebElement locateElementByJS(String id) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return ((WebElement) js.executeScript("return document.getElementById('" + id + "')"));
    }
}
