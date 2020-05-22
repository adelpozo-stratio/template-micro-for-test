package com.stratio.financial.test.integration;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
    features = {"src/test/resources/features"}
)

public class IntegrationTest {

}
