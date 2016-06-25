package com.sdi.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_form_signin {

	public static void rellenarFormulario(WebDriver driver,String login,String password){
		WebElement fieldLogin = driver.findElement(By.id("form:username"));
		fieldLogin.click();
		fieldLogin.clear();
		fieldLogin.sendKeys(login);
		WebElement fieldPassword = driver.findElement(By.id("form:password"));
		fieldPassword.click();
		fieldPassword.clear();
		fieldPassword.sendKeys(password);
		By boton = By.id("form:submitButton");
		driver.findElement(boton).click();
	}
}
