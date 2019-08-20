package Tests;

import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;
public class TestRunnerClassForAllure {
	
	static TestNG testNG;
	public static void main(String[] args) {
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add("C:\\Users\\dheeraj.singh\\git\\AllureReportDemoTest\\AllureReportDemoTest\\LoginTest_testng.xml");//path to xml..in src
		testng.setTestSuites(suites);
		testng.run();
	}

}
