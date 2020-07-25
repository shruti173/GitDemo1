package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports report;
	
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html"; // get the project path until extent report
		ExtentSparkReporter reporter  = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Tests results");
		
	    report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Shruti Dhingra");
		return report;
	}

}
