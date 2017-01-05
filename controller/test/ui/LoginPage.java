package ui;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.UserDao;
import com.becomejavasenior.bean.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class LoginPage {
    private static final String DOMAIN_PORT = "http://localhost:8080";
//    @Autowired
//    @Qualifier("userDao")
    public UserDao<User> userDao;
    By usernameElementLocator = By.id("email");
    By passwordElementLocator = By.id("password");
    By loginElementLocator = By.cssSelector("input[type=submit]");
    By loginOutElementLocator = By.cssSelector("input[type=submit]");
    private WebDriver driver;

    @Before
    public void setUp() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

        System.setProperty("webdriver.gecko.driver", "/Users/miiix/Documents/geckodriver");
        this.driver = new FirefoxDriver();

        driver.navigate().to(DOMAIN_PORT);
        // Check that we're on the right page.
        if (!"Login".equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }
    }

    @After
    public void tearDown() {
//        driver.close();
//        driver.quit();
    }

    public LoginPage typeUsername(String username) {
        driver.findElement(usernameElementLocator).sendKeys(username);

        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
        return this;
    }

    public void typePassword(String password) {
        driver.findElement(passwordElementLocator).sendKeys(password);

        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
    }

    // The login page allows the user to submit the login form
    public void submitLogin() {
        // This is the only place that submits the login form and expects the destination to be the home page.
        // A seperate method should be created for the instance of clicking login whilst expecting a login failure.
        driver.findElement(loginElementLocator).submit();

        // Return a new page object representing the destination. Should the login page ever
        // go somewhere else (for example, a legal disclaimer) then changing the method signature
        // for this method will mean that all tests that rely on this behaviour won't compile.
//        return new HomePage();
    }

    @Test
    public void submitLoginExpectingFailure() {
        // given
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginElementLocator));

        // when
        typeUsername("random" + Math.random());
        typePassword("random" + Math.random());
        driver.findElement(loginElementLocator).submit();

        // then
        assertEquals(driver.getCurrentUrl(), DOMAIN_PORT + "/user-validator");
        assertTrue(driver.getPageSource().contains("Wrong user/password"));
    }


    @Test
    // Conceptually, the login page offers the user the service of being able to "log into"
    // the application using a user name and password.
    public void loginAs() throws DaoException, ClassNotFoundException {
        // given
        // you wait to load
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginElementLocator));

        User user = getSomeUserFromDb();
        // when
        // The PageObject methods that enter username, password & submit login have already defined and should not be repeated here.
        typeUsername(user.getEmail());
        typePassword(user.getPassword());
        submitLogin();

        // then
        assertEquals(driver.getCurrentUrl(), DOMAIN_PORT + "/user-validator");
        assertTrue(driver.getPageSource().contains("You have logged in."));
    }

    @Test
    public void logoutUser() {
        // given
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginOutElementLocator));

        // when
        driver.get("/");
        driver.findElement(loginOutElementLocator).click();

        // then
        assertEquals(driver.getCurrentUrl(), DOMAIN_PORT + "/user-logout");
    }

    private User getSomeUserFromDb() throws ClassNotFoundException, DaoException {
        List<User> users = userDao.getAll();
        User user = users.get(0);
        if (user != null) {
            return user;
        }
        return null;
    }
}
