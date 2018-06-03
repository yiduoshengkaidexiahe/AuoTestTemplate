package com.lsc.selenium.num1;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class Login {
	public static void captureScreen(String fileName, String folder) throws Exception {
		 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        // 截图保存的路径 
        File screenFile = new File(fileName);    
        // 如果路径不存在,则创建  
        if (!screenFile.getParentFile().exists()) {  
            screenFile.getParentFile().mkdirs();  
        } 
        //判断文件是否存在，不存在就创建文件
        if(!screenFile.exists()&& !screenFile .isDirectory()) {
            screenFile.mkdir();
        }
        
        File f = new File(screenFile, folder);        
        ImageIO.write(image, "png", f);
        //自动打开
        /*if (Desktop.isDesktopSupported()
                 && Desktop.getDesktop().isSupported(Desktop.Action.OPEN))
                    Desktop.getDesktop().open(f);*/
    }
	  Date dt=new Date();
      SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
      SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMddHHmmss");
      String data=sdf.format(dt);
      String rd=sdf1.format(dt);
	
  @Test
  public void f() {
	  

  	System.setProperty("webdriver.chrome.driver", "E:\\software\\chrome\\chromedriver.exe");    
      
  	ChromeOptions options = new ChromeOptions(); 
  	options.setBinary("C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe"); 
  	ChromeDriver driver = new ChromeDriver(options); 
  	
      //WebDriver driver = new ChromeDriver();    
           
      driver.manage().window().maximize();    
            
      driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);       
       
      driver.get("https://www.baidu.com");  
      try {
		captureScreen("d:\\image\\"+data,"1.png");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      System.out.println("Pass:00000000000000000000000000");
      //判断title是不是 百度一下，你就知道  
      driver.close();
  }
  @BeforeClass
  public void beforeClass() {
	  
  }

  @AfterClass
  public void afterClass() {
  }

}
