package com.adactincucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src//test//resources//com//adactincucumber//featurefile", glue="com.adactincucumber",
dryRun=false,
tags=("@SanityTest"),
plugin= {"html:Report/html_Report",
"pretty",
"json:Report/CucumberJSON_Report",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner {

}
