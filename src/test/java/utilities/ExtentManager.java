package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String reportName = "Test-Report-" + timestamp + ".html";
            String directory = System.getProperty("user.dir") + "/reports/";
            
            new File(directory).mkdirs();
            
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(directory + reportName);
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("AutoQA Pro Automation Report");
            sparkReporter.config().setReportName("E-Commerce Test Execution Results");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Project", "AutoQA Pro");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
            extent.setSystemInfo("OS", System.getProperty("os.name"));
        }
        return extent;
    }
}
