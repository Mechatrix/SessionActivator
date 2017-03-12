package testpack;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class tstSession {

	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException, IOException {
        // TODO Auto-generated method stub
		
		
		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\My\\Downloads\\IEDriverServer_x64_3.3.0\\IEDriverServer.exe");
         driver = new InternetExplorerDriver();
        
        
        
        
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://1ct.es/");
        // gmail login
        //WebDriverWait wait = new WebDriverWait(driver, 60); 
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("loginBox")));
        
        Thread.sleep(1000);
        driver.findElement(By.id("username")).sendKeys("425443");
        //driver.findElement(By.id("next")).click();
        //Thread.sleep(1000);
        driver.findElement(By.id("PasswordInternal")).sendKeys("Jan@2017");
        driver.findElement(By.id("Log_On1")).click();

        // some optional actions for reaching gmail inbox
        
        //driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/div[1]/ul/li[1]/div[1]/div/p[2]")).click();
        
        
       GlobalKeyListenerExample ex= new GlobalKeyListenerExample();
       ex.hook();
        
       while(true)
       {
    	   Date timeNow= new Date();
    	   long min = getSec(ex.getStartTime(),timeNow);
    	   //System.out.println("min:"+min);
    	   if(min>=60 && min<=120){
    		//   break;  //B
    		    refresh();  //A
    		   ex.setStartTime(new Date()); //A
    	   }
       }
       
               
       // refresh();//B
        
      }
	public static void  refresh()
	{
		 driver.navigate().refresh();
	}

	public static long  getMin(Date st,Date end)
	{
	        long diffMs = end.getTime() - st.getTime();
	        long diffSec = diffMs / 1000;
	        long min = diffSec / 60;
	        return min;
	}
	public static long  getSec(Date st,Date end)
	{
	        long diffMs = end.getTime() - st.getTime();
	        long diffSec = diffMs / 1000;
	        return diffSec;
	}

}
