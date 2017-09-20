package zhiping.tvmall.appium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;


import java.io.File;
import java.net.URL;
import java.util.Set;

public class TvmallTest {
    private AppiumDriver<AndroidElement> driver;

    @BeforeClass
    public void setUp() throws Exception {
        // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/apps");
        File app = new File(appDir, "TVTaobao_v2.2.4_20160729_xiaomi_debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","11608V181277759");
        capabilities.setCapability("platformVersion", "5.1");
        //      capabilities.setCapability("automationName","selendroid");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "rca.rc.tvtaobao");
        //capabilities.setCapability("appActivity", ".activity.loading.LoadingActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        
    }

    @AfterClass
    public void tearDown() throws Exception {
       driver.quit();
    }

  //  @Test          
    public void indexPage() throws Exception{   	
    	//SwitchtoWebViewModel(driver); 
        String	tt = driver.getContext();
        System.out.println(tt);
    	System.out.println(driver.getPageSource());
    	Thread.sleep(5000);
   	
    	//验证成功进入首页
    	String index_pagename = driver.getTitle();
    	System.out.println(index_pagename);
    	
    	//Assert.assertEquals(actual, expected, message);
    	Assert.assertEquals(index_pagename,"电视淘宝首页");
    	System.out.println("open sucess!");
    	
    	//验证电话号码是正确的
    	String tel_number = driver.findElementByXPath(("//*[@id='contact']/span")).getText();	
    	System.out.println(tel_number);
    	Assert.assertEquals(tel_number,"客服电话：0571-85135297");
    }
    
   // @Test          
    public void phoneRecharge() throws Exception{   	
    	//SwitchtoWebViewModel(driver); 	
    	//System.out.println(driver.getPageSource());
    	Thread.sleep(5000);
        //验证话费充值的链接是否正确
        String recharge_url = driver.findElementByXPath(("//*[@id='nav-item-1']/input")).getAttribute("value");
        System.out.println(recharge_url);
        Assert.assertEquals(recharge_url,"/cms/phone_trade/phone_recharge?id=5603cfdc4661df8618008357");       
    }
    
   // @Test          
    public void search() throws Exception{   	
    	//SwitchtoWebViewModel(driver); 	
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
