import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;

public class FristTest {
    WebDriver driver = null;
    void createDriver()
    {
        //1. 打开浏览器 使用驱动来打开
        WebDriverManager.chromedriver().setup();
        //增加浏览器配置：创建驱动对象要强制指定允许访问所有的链接
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.get("file:///D:/file/%E6%AF%94%E7%89%B9%E6%95%99%E5%8A%A1/%E6%B5%8B%E8%AF%95/selenium4html/selenium-html/alert.html#");

    }
    void getScreenShot(String str) throws IOException {
        SimpleDateFormat sim1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sim2 = new SimpleDateFormat("HHmmssSS");

        String dirTime = sim1.format(System.currentTimeMillis());
        String fileTime = sim2.format(System.currentTimeMillis());

        //./src/test/image/2024-07-17/test01-174530.png
        String filename ="./src/test/image/"+ dirTime +"/" + str + "-" + fileTime+".png";
        System.out.println("filename:"+filename);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //srcFile放到指定位置
        FileUtils.copyFile(srcFile,new File(filename));
    }

    void test04() throws InterruptedException, IOException {
        createDriver();
        getScreenShot(getClass().getName());

        //点击新闻
        driver.findElement(By.cssSelector("#s-top-left > a:nth-child(1)")).click();

        String curHandle = driver.getWindowHandle();

        Set<String> allHandles =  driver.getWindowHandles();
        for(String handle : allHandles)
        {
            if(handle != curHandle)
            {
                //切换driver---百度新闻
                driver.switchTo().window(handle);
            }
        }

        getScreenShot(getClass().getName());

        driver.findElement(By.cssSelector("#headline-tabs > ul"));

        Thread.sleep(3000);
        driver.close();//关闭当前的标签页

        driver.switchTo().window(curHandle);
        //切换窗口
        Set<String> Handles =  driver.getWindowHandles();
        for(String handle : Handles)
        {
            System.out.println("handle:"+handle);
        }

//        Thread.sleep(3000);
        driver.close();//关闭当前的标签页

        driver.quit();
    }
    //测试百度搜索关键词；迪丽热巴
    void test01() throws InterruptedException {
        //1. 打开浏览器 使用驱动来打开
        WebDriverManager.chromedriver().setup();
        //增加浏览器配置：创建驱动对象要强制指定允许访问所有的链接
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        Thread.sleep(3000);

        //2. 输入完整的网址：https://www.baidu.com
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);

        //3. 找到输入框，并输入关键词：迪丽热巴
        driver.findElement(By.cssSelector("#kw")).sendKeys("迪丽热巴");
        Thread.sleep(3000);

        //4. 找到百度一下按钮，并点击
        driver.findElement(By.cssSelector("#su")).click();
        Thread.sleep(3000);

        //5. 关闭浏览器
        driver.quit();
    }
    void test02() throws InterruptedException {
        //1. 打开浏览器 使用驱动来打开
        WebDriverManager.chromedriver().setup();
        //增加浏览器配置：创建驱动对象要强制指定允许访问所有的链接
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        Thread.sleep(3000);

        //2. 输入完整的网址：https://www.baidu.com
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);

        //3. 找到输入框，并输入关键词：迪丽热巴
        driver.findElement(By.cssSelector("#hotsearch-content-wrapper > li:nth-child(5) > a > span.title-content-title")).click();
        Thread.sleep(3000);



        //5. 关闭浏览器
        driver.quit();
    }
}