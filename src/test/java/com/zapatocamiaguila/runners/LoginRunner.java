package com.zapatocamiaguila.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
		features="src/test/resources/features/Login.feature",
		glue = "com.zapatocamiaguila.stepsdefinition",
		snippets = CAMELCASE,
        tags = "@loginExitoso"
		)
public class LoginRunner {
}
