package org.example.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;


import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver webDriver;

    @BeforeClass
    public static void initializeDriver(){
        webDriver = DriverFactory.getDriver();
        webDriver.manage().timeouts().pageLoadTimeout((long) 50, TimeUnit.SECONDS);
    }

    @Before
    public void beforeScenario(){
        webDriver.manage().deleteAllCookies();
    }

    @After
    public void closeDriver(){
        webDriver.quit();
    }

    @AfterClass
    public void afterScenario(){
        webDriver.manage().deleteAllCookies();    }


}
