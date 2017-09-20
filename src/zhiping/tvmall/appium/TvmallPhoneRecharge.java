package zhiping.tvmall.appium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;


import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class TvmallPhoneRecharge {
    private AppiumDriver<AndroidElement> driver;

    @BeforeClass
    public void setUp() throws Exception {
        // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/apps");
        File app = new File(appDir, "TVTaobao_v2.2.4_20160729_xiaomi_debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformVersion", "5.1.1");
        //capabilities.setCapability("automationName","selendroid");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "rca.rc.tvtaobao");
       // capabilities.setCapability("appActivity", ".activity.IndexPageActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        
    }

    @AfterClass
    public void tearDown() throws Exception {
       driver.quit();
    }

    @Test          
    public void recharge() throws Exception{   	
    	SwitchtoWebViewModel(driver); 	
    	Thread.sleep(5000);
    	
   	 //进入充值页面
    	Actions actions = new Actions(driver);  
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_LEFT).perform();
        Thread.sleep(1000);      
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(10000);
        
        
//        driver.context("NATIVE_APP");
        List<AndroidElement> textField = driver.findElements(By.id("rca.rc.tvtaobao:id/numberInput"));
        System.out.print(textField.isEmpty());
        textField.get(0).sendKeys("13486189926");
        
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_LEFT).perform();
        Thread.sleep(1000);
   
    	System.out.println(driver.getContextHandles());
    	//driver.context("NATIVE_APP");
    	driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[1]").click();
   	 
    	System.out.print(driver.findElementByName("手机号码：").getText());
    	 Thread.sleep(10000);
    	driver.findElementById("rca.rc.tvtaobao:id/num_button_2").click();
    	 Thread.sleep(10000);
    	driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[1]").click();
    	 Thread.sleep(10000);
    	driver.findElementById("rca.rc.tvtaobao:id/num_button_3").click();
    	 Thread.sleep(10000);
//    	driver.findElementByName("30").click();
//    	driver.findElementByName("1").click();
    	actions.sendKeys("1");
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_LEFT).perform();
        Thread.sleep(1000);      
        actions.sendKeys(Keys.ENTER).perform();
    	
    	
    }
    

       
    public void search() throws Exception{   	
    	SwitchtoWebViewModel(driver); 	
    	System.out.println(driver.getContextHandles());
    	//System.out.println(driver.getPageSource());
    	Thread.sleep(5000);
       //验证搜索的链接是否正确
        String search_url = driver.findElementByXPath(("//*[@id='search-bar']/input")).getAttribute("value");
        System.out.println(search_url);
        Assert.assertEquals(search_url,"/search/common/item/search.html");
    	
    	
    	Actions actions = new Actions(driver);   	
    	 //进入搜索页面
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_LEFT).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_LEFT).perform();
        Thread.sleep(1000);      
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        //搜索nike
        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_LEFT).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_LEFT).perform();
        Thread.sleep(1000); 
        actions.sendKeys(Keys.ARROW_LEFT).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000); 
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000); 
        //进入商品列表页面
        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(10000);        
    }
    
//切换webview的方法
	public void SwitchtoWebViewModel(AppiumDriver<AndroidElement> driver) throws Exception {
        Thread.sleep(8000);
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            // System.out.println(contextName);
             if (contextName.contains("WEBVIEW")){
              driver.context(contextName);
              //System.out.println(contextName);
              Thread.sleep(1000); 
           }
        }
    }
        
}
