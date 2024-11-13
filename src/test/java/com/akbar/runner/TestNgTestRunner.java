package com.akbar.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src\\test\\java\\com\\akbar\\features",
        glue = "com.akbar.stepdefinitions",
        monochrome = true,
        dryRun = false,
        tags = "@PlaceOrder or @OffersPage",
        plugin = {"pretty", "html:target\\cucumber.html",
                "json:target\\cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target\\failed_scenarios.txt"
                //aKBAR
        }
)
public class TestNgTestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    /*
        Q: How to run the application using JUnit

        Steps:

        1. Add the `cucumber-junit` dependency to your project.
        2. Add the `junit` dependency and update the project.
        3. Create a class named `JUnitTestRunnerTest` (copy the existing TestNG runner class).
        * **Note:** Ensure the class name ends with `Test`.
        4. Add `@RunWith(Cucumber.class)` at the top of the class.
        5. Import necessary packages from JUnit.
        6. Remove `AbstractTestNGCucumberTests`, if it was previously extended.
        7. Remove any `scenarios` methods.
        8. Replace TestNG assertions with JUnit assertions throughout the project.
     */

    /*
    Q: How to run tests in parallel

        Steps:
        1. Add the following configuration details to your `pom.xml` file.
        <build>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version>3.0.0-M5</version>
                    <configuration>
                        <parallel>methods</parallel>
                        <useUnlimitedThreads>true</useUnlimitedThreads>
                    </configuration>
                </plugin>
            </plugins>
        </build>

        Note: Cucumber can be executed in parallel using JUnit and
        Maven test execution plugins. In JUnit the feature files are run in parallel
        rather than scenarios, which means all the scenarios in a feature file
        will be executed by the same thread

        For more information, refer to: [Parallel Execution Guide]
        (https://cucumber.io/docs/guides/parallel-execution/?lang=java).
     */
}
