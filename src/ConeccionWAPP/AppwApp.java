package ConeccionWAPP;

import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver
;

public class AppwApp implements WebDriver {

    WebDriver webDriver;

    public AppwApp() throws Exception{

        JOptionPane.showMessageDialog(null, 1);

        System.setProperty("web","C:\\Users\\jumaj\\OneDrive\\Escritorio\\DESKTOP\\inicios\\PPI\\WonderPets\\src\\_CromeDriver\\chromedriver.exe");
        JOptionPane.showMessageDialog(null, 2);
        webDriver = new ChromeDriver();
        JOptionPane.showMessageDialog(null, 3);
        webDriver.get("https://web.whatsapp.com/");


        Thread.sleep(900);
        JOptionPane.showMessageDialog(null, 4);
        JOptionPane.showMessageDialog(null, webDriver.getTitle());
        
        JOptionPane.showMessageDialog(null, 5);
        webDriver.quit();
        JOptionPane.showMessageDialog(null, "fin");
    }

    @Override
    public void get(String url) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public String getCurrentUrl() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentUrl'");
    }

    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTitle'");
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webDriver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findElement'");
    }

    @Override
    public String getPageSource() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPageSource'");
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'close'");
    }

    @Override
    public void quit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quit'");
    }

    @Override
    public Set<String> getWindowHandles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWindowHandles'");
    }

    @Override
    public String getWindowHandle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWindowHandle'");
    }

    @Override
    public TargetLocator switchTo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'switchTo'");
    }

    @Override
    public Navigation navigate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'navigate'");
    }

    @Override
    public Options manage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'manage'");
    }
    
}
