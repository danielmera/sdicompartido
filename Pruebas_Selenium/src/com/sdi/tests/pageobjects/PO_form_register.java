package com.sdi.tests.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_form_register {

	public static void rellenarFormulario(WebDriver driver,String login,String username,String surname,
			String email,String password,String repassword){
		WebElement fieldLogin = driver.findElement(By.id("form:username"));
		fieldLogin.click();
		fieldLogin.clear();
		fieldLogin.sendKeys(login);
		WebElement fieldName = driver.findElement(By.id("form:nombre"));
		fieldName.click();
		fieldName.clear();
		fieldName.sendKeys(username);
		WebElement fieldSurname = driver.findElement(By.id("form:apellidos"));
		fieldSurname.click();
		fieldSurname.clear();
		fieldSurname.sendKeys(surname);
		WebElement fieldEmail = driver.findElement(By.id("form:email"));
		fieldEmail.click();
		fieldEmail.clear();
		fieldEmail.sendKeys(email);
		WebElement fieldPassword = driver.findElement(By.id("form:password"));
		fieldPassword.click();
		fieldPassword.clear();
		fieldPassword.sendKeys(password);
		WebElement fieldRePassword = driver.findElement(By.id("form:repassword"));
		fieldRePassword.click();
		fieldRePassword.clear();
		fieldRePassword.sendKeys(repassword);
		By boton = By.id("form:submitButton");
		driver.findElement(boton).click();
	}
	
	public static void rellenarFormularioRegViajeAdressPoint(WebDriver driver,String calleSalida,String ciudadSalida,
			String provinciaSalida,String paisSalida,String zipSalida,String latitudSalida,String longitudSalida,
			String calleLLegada, String ciudadLLegada, String provinciaLLegada, String paisLLegada, String zipLLegada,
			String latitudLlegada,String longitudLlegada,String plazasTotales,String plazasLibres, String coste,
			String comentarios,String fechaSalida,String fechaCierre,String fechaLlegada){
		//Address Point de Salida junto con la fecha de salida
		WebElement fieldCalleSalida = driver.findElement(By.id("form:calleSalida"));
		fieldCalleSalida.click();
		fieldCalleSalida.clear();
		fieldCalleSalida.sendKeys(calleSalida);
		WebElement fieldCiudadSalida = driver.findElement(By.id("form:ciudadSalida"));
		fieldCiudadSalida.click();
		fieldCiudadSalida.clear();
		fieldCiudadSalida.sendKeys(ciudadSalida);
		WebElement fieldProvinciaSalida = driver.findElement(By.id("form:provinciaSalida"));
		fieldProvinciaSalida.click();
		fieldProvinciaSalida.clear();
		fieldProvinciaSalida.sendKeys(provinciaSalida);
		WebElement fieldPaisSalida = driver.findElement(By.id("form:paisSalida"));
		fieldPaisSalida.click();
		fieldPaisSalida.clear();
		fieldPaisSalida.sendKeys(paisSalida);
		WebElement fieldZipSalida = driver.findElement(By.id("form:zipSalida"));
		fieldZipSalida.click();
		fieldZipSalida.clear();
		fieldZipSalida.sendKeys(zipSalida);
		WebElement fieldLatitudSalida = driver.findElement(By.id("form:latitudSalida"));
		fieldLatitudSalida.click();
		fieldLatitudSalida.clear();
		fieldLatitudSalida.sendKeys(latitudSalida);
		WebElement fieldLongitudSalida = driver.findElement(By.id("form:longitudSalida"));
		fieldLongitudSalida.click();
		fieldLongitudSalida.clear();
		fieldLongitudSalida.sendKeys(longitudSalida);
		WebElement fieldFechaSalida = driver.findElement(By.id("form:fechaSalida"));
		fieldFechaSalida.click();
		driver.findElement(By.linkText("Next")).click();
		driver.findElement(By.linkText(fechaSalida)).click();
		
		//Address Point de LLegada junto con la fecha de LLegada
		WebElement fieldCalleLLegada = driver.findElement(By.id("form:calleLlegada"));
		fieldCalleLLegada.click();
		fieldCalleLLegada.clear();
		fieldCalleLLegada.sendKeys(calleLLegada);
		WebElement fieldCiudadLLegada = driver.findElement(By.id("form:ciudadLlegada"));
		fieldCiudadLLegada.click();
		fieldCiudadLLegada.clear();
		fieldCiudadLLegada.sendKeys(ciudadLLegada);
		WebElement fieldProvinciaLLegada = driver.findElement(By.id("form:provinciaLlegada"));
		fieldProvinciaLLegada.click();
		fieldProvinciaLLegada.clear();
		fieldProvinciaLLegada.sendKeys(provinciaLLegada);
		WebElement fieldPaisLLegada = driver.findElement(By.id("form:paisLlegada"));
		fieldPaisLLegada.click();
		fieldPaisLLegada.clear();
		fieldPaisLLegada.sendKeys(paisLLegada);
		WebElement fieldZipLLegada = driver.findElement(By.id("form:zipLlegada"));
		fieldZipLLegada.click();
		fieldZipLLegada.clear();
		fieldZipLLegada.sendKeys(zipLLegada);
		WebElement fieldLatitudLLegada = driver.findElement(By.id("form:latitudLlegada"));
		fieldLatitudLLegada.click();
		fieldLatitudLLegada.clear();
		fieldLatitudLLegada.sendKeys(latitudLlegada);
		WebElement fieldLongitudLLegada = driver.findElement(By.id("form:longitudLlegada"));
		fieldLongitudLLegada.click();
		fieldLongitudLLegada.clear();
		fieldLongitudLLegada.sendKeys(longitudLlegada);
		WebElement fieldFechaLlegada = driver.findElement(By.id("form:fechaLlegada"));
		fieldFechaLlegada.click();
		driver.findElement(By.linkText("Next")).click();
		driver.findElement(By.linkText(fechaLlegada)).click();
		
		// Campos restantes
		WebElement fieldFechaCierre = driver.findElement(By.id("form:fechaCierre"));
		fieldFechaCierre.click();
		driver.findElement(By.linkText("Next")).click();
		driver.findElement(By.linkText(fechaCierre)).click();
		WebElement fieldPlazasTotales = driver.findElement(By.id("form:plazasTotales"));
		fieldPlazasTotales.click();
		fieldPlazasTotales.clear();
		fieldPlazasTotales.sendKeys(plazasTotales);
		WebElement fieldPlazasLibres = driver.findElement(By.id("form:plazasLibres"));
		fieldPlazasLibres.click();
		fieldPlazasLibres.clear();
		fieldPlazasLibres.sendKeys(plazasLibres);
		WebElement fieldCoste = driver.findElement(By.id("form:coste"));
		fieldCoste.click();
		fieldCoste.clear();
		fieldCoste.sendKeys(coste);
		WebElement fieldComentarios = driver.findElement(By.id("form:comentarios"));
		fieldComentarios.click();
		fieldComentarios.clear();
		fieldComentarios.sendKeys(comentarios);
		By boton = By.id("form:registrar");
		driver.findElement(boton).click();
	}
	
}
