package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber", glue="rahulshettyacademy.stepDefinitions", monochrome=true, tags="@Regression", plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	//we need this testrunner to run our Cucumber feature test 
	//you have to add CucumberOptions then features(which is the feature test file, written in gherkin), glue(which is the actual code) etc.
	
}


//to run our test in the command prompt we use : mvn test -PCucumberTests 
//the CucucmberTests we have added in our pom.xml file 