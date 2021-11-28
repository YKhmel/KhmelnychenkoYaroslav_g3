package libs;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Utils {

    private final Logger logger = Logger.getLogger(getClass());

    /**
     * Taking screenshot into patch
     * @param patchToScreemShot
     * @param webDriver
     */
    public void screenShot(String patchToScreemShot, WebDriver webDriver) {
        File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(patchToScreemShot));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hardWait(int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
