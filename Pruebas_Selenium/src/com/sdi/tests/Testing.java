package com.sdi.tests;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sdi.tests.pageobjects.PO_form_register;
import com.sdi.tests.pageobjects.PO_form_signin;
import com.sdi.utils.SeleniumUtils;

public class Testing {

	WebDriver driver;

	public Testing() {
	}

	/**
	 * Instanciamos el driver con FirefoxDriver() y vamos a la página de inicio
	 * de la aplicación
	 */
	@Before
	public void run() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8280/sdi_sharemytrip_jsf/");
	}

	/**
	 * Cerramos el driver cuando finalizamos las pruebas
	 */
	@After
	public void end() {
		// Cerramos el navegador
		driver.quit();
	}

	/**
	 * Registro de usuario con datos válidos
	 */
	// @Test
	// public void RegVal() {
	// driver.findElement(By.id("form-menubar:registrarse")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:fieldsetRegistro",
	// 3);
	// driver.manage().window().maximize();
	// PO_form_register.rellenarFormulario(driver, "user20", "Belen", "López",
	// "belen@mail.com", "user20", "user20");
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:fieldSetLogin",
	// 3);
	// }
	//
	// /**
	// * Registro de usuario con datos inválidos
	// */
	// @Test
	// public void RegInval() {
	// driver.findElement(By.id("form-menubar:registrarse")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:fieldsetRegistro",
	// 3);
	// driver.manage().window().maximize();
	// PO_form_register.rellenarFormulario(driver, "user4", "Belen", "López",
	// "belen@mail.com", "user4", "user");
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:fieldsetRegistro",
	// 3);
	// }
	//
	// /**
	// * Inicio de sesión con credenciales válidas
	// */
	// @Test
	// public void IdVal() {
	// PO_form_signin.rellenarFormulario(driver, "user1", "user1");
	// // Comprobamos que estamos dentro de principal al mirar si existe
	// // el componente table en la vista actual.
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:table", 6);
	// }
	//
	// /**
	// * Inicio de sesión con credenciales inválidas
	// */
	// @Test
	// public void IdInval() {
	// PO_form_signin.rellenarFormulario(driver, "user1", "password");
	// // Comprobamos que seguimos dentro de index.xhmlt con al ver que
	// // el elemento fieldSetLogin está en la vista actúal.
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:fieldSetLogin", 2);
	// }
	//
	// /**
	// * Acceso a una vista restringida para un usuario público.
	// */
	// @Test
	// public void AccInval(){
	// driver.get("http://localhost:8280/sdi_sharemytrip_jsf/restricted/principal.xhtml");
	// //Comprobamos que seguimos en la página de index.xhtml tras
	// //intentar acceder a principal.xhtml
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:fieldSetLogin", 2);
	// }
	//
	// /**
	// * Cambio del idioma por defecto a un segundo idioma.
	// */
	// @Test
	// public void i18N1() throws InterruptedException {
	// SeleniumUtils.ClickSubopcionMenuHover(driver, "form-menubar:options",
	// "form-menubar:english");
	// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// SeleniumUtils.textoPresentePagina(driver, "Language-en");
	// driver.findElement(By.id("form-menubar:registrarse")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:fieldsetRegistro",
	// 3);
	// SeleniumUtils.textoPresentePagina(driver, "User sign-up");
	// driver.findElement(By.id("form-menubar:return")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:fieldSetLogin", 5);
	// driver.findElement(By.id("form-menubar:linkViajes")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:tripsTable", 5);
	// SeleniumUtils.textoPresentePagina(driver, "List of available trips");
	// }
	//
	// /**
	// * Cambio del idioma por defecto a un segundo idioma y vuelta al idioma
	// * por defecto(Pasando por algunas vistas)
	// */
	// @Test
	// public void i18N2() {
	// SeleniumUtils.textoPresentePagina(driver, "Idioma-es");
	// SeleniumUtils.ClickSubopcionMenuHover(driver, "form-menubar:options",
	// "form-menubar:english");
	// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// SeleniumUtils.textoPresentePagina(driver, "Language-en");
	// driver.findElement(By.id("form-menubar:registrarse")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:fieldsetRegistro",
	// 3);
	// SeleniumUtils.textoPresentePagina(driver, "User sign-up");
	// SeleniumUtils.ClickSubopcionMenuHover(driver, "form-menubar:options",
	// "form-menubar:spanish");
	// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// SeleniumUtils.textoPresentePagina(driver, "Registro usuario");
	// driver.findElement(By.id("form-menubar:return")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:fieldSetLogin", 5);
	// SeleniumUtils.textoPresentePagina(driver, "Idioma-es");
	// driver.findElement(By.id("form-menubar:linkViajes")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:tripsTable", 5);
	// SeleniumUtils.textoPresentePagina(driver,
	// "Listado de viajes disponibles");
	// }

	// @Test
	// public void Ins1ViajeAceptVal(){
	// //Accedemos con user4 y solicitamos plaza sobre el viaje 29
	// PO_form_signin.rellenarFormulario(driver, "user4", "user4");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// driver.findElement(By.id("form-menubar:linkViajes")).click();
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// By enlace = By
	// .xpath("//td[contains(text(), '29')]/following-sibling::*/a[contains(@id, 'solicitarPlaza')]");
	// driver.findElement(enlace).click();
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// driver.findElement(By.id("form-menubar:cerrarsesion")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:fieldSetLogin", 5);
	//
	// //Entramos en sesión con el user3 para aceptar la solicitud
	// PO_form_signin.rellenarFormulario(driver, "user1", "user1");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// enlace = By
	// .xpath("//td[contains(text(), '29')]/following-sibling::*/a[contains(@id, 'gestionarSolicitudes')]");
	// driver.findElement(enlace).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// enlace = By
	// .xpath("//td[contains(text(), 'pedro@mail.com')]/following-sibling::*/a[contains(@id, 'confirmar')]");
	// driver.findElement(enlace).click();
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// driver.findElement(By.id("form-menubar:cerrarsesion")).click();
	//
	// //Comprobamos que ha sido admitido el user4
	// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// PO_form_signin.rellenarFormulario(driver, "user4", "user4");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// SeleniumUtils.textoPresentePagina(driver, "ADMITIDO");
	// }

	// @Test
	// public void Ins2ViajeAceptVal(){
	//
	// //Accedemos con user4 y solicitamos plaza sobre el viaje 29
	// PO_form_signin.rellenarFormulario(driver, "user4", "user4");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// driver.findElement(By.id("form-menubar:linkViajes")).click();
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// By enlace = By
	// .xpath("//td[contains(text(), '29')]/following-sibling::*/a[contains(@id, 'solicitarPlaza')]");
	// driver.findElement(enlace).click();
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// driver.findElement(By.id("form-menubar:cerrarsesion")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:fieldSetLogin", 5);
	//
	// //Entramos con el usuario5 y solicitamos plaza
	// PO_form_signin.rellenarFormulario(driver, "user5", "user5");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// driver.findElement(By.id("form-menubar:linkViajes")).click();
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// enlace = By
	// .xpath("//td[contains(text(), '29')]/following-sibling::*/a[contains(@id, 'solicitarPlaza')]");
	// driver.findElement(enlace).click();
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// driver.findElement(By.id("form-menubar:cerrarsesion")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:fieldSetLogin", 5);
	//
	// //Entramos en sesión con el user3 para aceptar la solicitud
	// PO_form_signin.rellenarFormulario(driver, "user1", "user1");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// enlace = By
	// .xpath("//td[contains(text(), '29')]/following-sibling::*/a[contains(@id, 'gestionarSolicitudes')]");
	// driver.findElement(enlace).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// enlace = By
	// .xpath("//td[contains(text(), 'belen@mail.com')]/following-sibling::*/a[contains(@id, 'confirmar')]");
	// driver.findElement(enlace).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// enlace = By
	// .xpath("//td[contains(text(), 'paco@mail.com')]/following-sibling::*/a[contains(@id, 'confirmar')]");
	// driver.findElement(enlace).click();
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// driver.findElement(By.id("form-menubar:cerrarsesion")).click();
	//
	// //Comprobamos que ha sido admitido el user4
	// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// PO_form_signin.rellenarFormulario(driver, "user4", "user4");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// SeleniumUtils.textoPresentePagina(driver, "ADMITIDO");
	// driver.findElement(By.id("form-menubar:cerrarsesion")).click();
	//
	// //Comprobamos que se ha admitido al usuario5
	// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// PO_form_signin.rellenarFormulario(driver, "user5", "user5");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// SeleniumUtils.textoPresentePagina(driver, "ADMITIDO");
	// }

	// Esta prueba no se puede llevar a cabo por que los viajes que
	// se visualizan en listado de viajes disponibles utilizan una consulta
	// que solo muestra aquellos que tienen plazas libres.
	// @Test
	// public void Ins3ViajeAceptVal(){
	// }

	/**
	 * Hace falta el usuario con la plaza en el viaje 29 para esta prueba, meter
	 * esto dentro del test.script
	 */
	// @Test
	// public void CancelNoPromotorVal() {
	// PO_form_signin.rellenarFormulario(driver, "user4", "user4");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 10);
	// SeleniumUtils.textoPresentePagina(driver, "ADMITIDO");
	// By enlace = By
	// .xpath("//td[contains(text(), 'ADMITIDO')]/following-sibling::*/a[contains(@id, 'cancelarPlaza')]");
	// driver.findElement(enlace).click();
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// SeleniumUtils.textoPresentePagina(driver, "No records found");
	// }

	/**
	 * Inscribir en un viaje un usuario que será admitido y después rechazarlo
	 * por el promotor
	 */
//	@Test
//	public void Rech1ViajeVal() {
//		//Entramos en sesión con user3 y solicitamos plaza en el viaje 29
//		PO_form_signin.rellenarFormulario(driver, "user3", "user3");
//		SeleniumUtils.EsperaCargaPagina(driver, "id", "form:table", 10);
//		driver.findElement(By.id("form-menubar:linkViajes")).click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		By enlace = By
//				.xpath("//td[contains(text(), '29')]/following-sibling::*/a[contains(@id, 'solicitarPlaza')]");
//		driver.findElement(enlace).click();
//		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-menubar:linkViajes", 10);
//		driver.findElement(By.id("form-menubar:cerrarsesion")).click();
//		SeleniumUtils.EsperaCargaPagina(driver, "id", "form:fieldSetLogin", 10);
//		
//		//Añadimos al usuario3 (Daniel Mera) y despues lo excluimos del viaje
//		PO_form_signin.rellenarFormulario(driver, "user1", "user1");
//		SeleniumUtils.EsperaCargaPagina(driver, "id", "form:table", 10);
//		enlace = By
//				.xpath("//td[contains(text(), '29')]/following-sibling::*/a[contains(@id, 'gestionarSolicitudes')]");
//		driver.findElement(enlace).click();
//		SeleniumUtils.EsperaCargaPagina(driver, "id", "form:table", 10);
//		enlace = By
//				.xpath("//td[contains(text(), 'Daniel')]/following-sibling::*/a[contains(@id, 'confirmar')]");
//		driver.findElement(enlace).click();
//		SeleniumUtils.EsperaCargaPagina(driver, "id", "form:table", 10);
//		driver.findElement(By.id("form-menubar:goHome")).click();
//		SeleniumUtils.EsperaCargaPagina(driver, "id", "form:table", 10);
//		enlace = By
//				.xpath("//td[contains(text(), '29')]/following-sibling::*/a[contains(@id, 'gestionarPlazas')]");
//		driver.findElement(enlace).click();
//		SeleniumUtils.EsperaCargaPagina(driver, "id", "form:table", 10);
//		enlace = By
//				.xpath("//td[contains(text(), 'Mera')]/following-sibling::*/a[contains(@id, 'excluir')]");
//		driver.findElement(enlace).click();
//		SeleniumUtils.EsperaCargaPagina(driver, "id", "form:table", 10);
//		driver.findElement(By.id("form-menubar:cerrarsesion")).click();
//		SeleniumUtils.EsperaCargaPagina(driver, "id", "form:fieldSetLogin", 10);
//
//
//		//Entramos en sesión con user3 para ver que el usuario ha sido rechazados por el promotor
//		//y en el viaje 29 aparece como rechazado/excluido
//		PO_form_signin.rellenarFormulario(driver, "user3", "user3");
//		SeleniumUtils.EsperaCargaPagina(driver, "id", "form:table", 10);
//		SeleniumUtils.textoPresentePagina(driver, "EXCLUIDO");
//	}

	// /**
	// * Registro de un viaje nuevo con datos válidos
	// */
	// @Test
	// public void RegViajeVal(){
	// PO_form_signin.rellenarFormulario(driver, "user1", "user1");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// driver.findElement(By.id("form-menubar:registrarViajes")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form-menubar:linkVolver",
	// 5);
	// driver.manage().window().maximize();
	// PO_form_register.rellenarFormularioRegViajeAdressPoint(driver,
	// "CallePruebaSalida",
	// "CiudadPruebaSalida", "ProvinciaSalida", "PaisSalida", "10101", "1000.1",
	// "1000.1","CallePruebaLlegada","CiudadPruebaLlegada","ProvinciaLlegada","PaisLlegada",
	// "20202","2000.2","2000.2","5","5","50.0","ComentarioPrueba","27","26","28");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 10);
	// SeleniumUtils.textoPresentePagina(driver,"Viajes del usuario");
	// }

	/**
	 * Registro de un viaje nuevo con datos inválidos (la fecha de cierre ha de
	 * ser anterior a la fecha de sálida, por eso no deja confirmar el registro
	 * de este viaje)
	 */
	// @Test
	// public void RegViajInVal(){
	// PO_form_signin.rellenarFormulario(driver, "user1", "user1");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// driver.findElement(By.id("form-menubar:registrarViajes")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form-menubar:linkVolver",
	// 5);
	// driver.manage().window().maximize();
	// PO_form_register.rellenarFormularioRegViajeAdressPoint(driver,
	// "CallePruebaSalida",
	// "CiudadPruebaSalida", "ProvinciaSalida", "PaisSalida", "10101", "1000.1",
	// "1000.1","CallePruebaLlegada","CiudadPruebaLlegada","ProvinciaLlegada","PaisLlegada",
	// "20202","2000.2","2000.2","5","5","50.0","ComentarioPrueba","26","27","28");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form-menubar:linkVolver",
	// 5);
	// driver.findElement(By.id("messages")).getText().
	// equals("La fecha límite ha de ser previa a la fecha de salida");
	// }
	//
	/**
	 * Edición de un viaje existente con datos válidos Necesarios user1 y el
	 * viaje 29 para esta prueba
	 */
	// @Test
	// public void EditViajeVal(){
	// PO_form_signin.rellenarFormulario(driver, "user1", "user1");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// By enlace = By
	// .xpath("//td[contains(text(), '29')]/following-sibling::*/a[contains(@id, 'editarViaje')]");
	// driver.findElement(enlace).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "editButton", 5);
	// driver.manage().window().maximize();
	// WebElement fieldComentarios =
	// driver.findElement(By.id("form:comentarios"));
	// fieldComentarios.getText().equals("Buen rollo4");
	// fieldComentarios.click();
	// fieldComentarios.clear();
	// fieldComentarios.sendKeys("Editado comentario del viaje 29");
	// driver.findElement(By.id("form:editButton")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:table", 5);
	// driver.findElement(enlace).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "editButton", 5);
	// driver.findElement(By.id("form:comentarios")).getText().equals("Editado comentrio del viaje 29");
	// }

	/**
	 * Edición de un viaje existente con datos inválidos
	 */
	// @Test
	// public void EditViajeInVal(){
	// PO_form_signin.rellenarFormulario(driver, "user1", "user1");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// By enlace = By
	// .xpath("//td[contains(text(), '29')]/following-sibling::*/a[contains(@id, 'editarViaje')]");
	// driver.findElement(enlace).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "editButton", 10);
	// driver.manage().window().maximize();
	// //Editamos las fechas para que la fecha de cierre sea después que la
	// fecha de salida
	// WebElement fieldFechaCierre =
	// driver.findElement(By.id("form:fechaCierre"));
	// fieldFechaCierre.click();
	// driver.findElement(By.linkText("Next")).click();
	// driver.findElement(By.linkText("27")).click();
	// WebElement fieldFechaSalida =
	// driver.findElement(By.id("form:fechaSalida"));
	// fieldFechaSalida.click();
	// driver.findElement(By.linkText("Next")).click();
	// driver.findElement(By.linkText("28")).click();
	// driver.findElement(By.id("form:editButton")).click();
	// //Comprobamos que seguimos en la página de editar, ya que no se confirmo
	// la operación
	// SeleniumUtils.EsperaCargaPagina(driver, "id", "form:editButton", 5);
	// }
	//
	 /**
	 * Cancelación de un viaje existente por un promotor
	 */
	@Test
	 public void CancelViajeVal(){
		PO_form_signin.rellenarFormulario(driver, "user1", "user1");
		SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 10);
		By enlace1 = By.
				xpath("//td[contains(text(), '52')]/following-sibling::*/a[contains(@id, 'editarViaje')]");
		driver.findElement(enlace1).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id","form:editButton", 10);
		String value = driver.findElement(By.id("form:status")).getAttribute("value");
		assertEquals("OPEN",value);
		driver.findElement(By.id("form-menubar:linkVolver")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 10);
		driver.findElement(By.xpath("//td[contains(text(), '52')]")).click();
		driver.findElement(By.id("form:cancelTrips")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 10);
		driver.findElement(enlace1).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id","form:editButton", 10);
		String value2 = driver.findElement(By.id("form:status")).getAttribute("value");
		assertEquals("CANCELLED",value2);
	}
	//
	// /**
	// * Cancelación de múltiples viajes existentes por un promotor
	// */
	// public void CancelMulViajeVal(){
	//
	// }

	// /**
	// * Carga datos de ejemplo que se pueden usar para registrar un nuevo
	// * viaje.
	// */
	// @Test
	// public void RegViajePrecargaDatosDeFormulario(){
	// PO_form_signin.rellenarFormulario(driver, "user1", "user1");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// driver.findElement(By.id("form-menubar:registrarViajes")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form-menubar:linkVolver",
	// 5);
	// driver.manage().window().maximize();
	// driver.findElement(By.id("form:precargar")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form-menubar:linkVolver",
	// 5);
	// driver.findElement(By.id("form:calleSalida")).getText().equals("CallePrecargada1");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form-menubar:linkVolver",
	// 5);
	// driver.findElement(By.id("form:calleLlegada")).getText().equals("CallePrecargada2");
	// }

	// /**
	// * Limpiar la mayoría de los datos del formulario de Registro de Viajes
	// */
	// @Test
	// public void RegViajeLimiparDatosDeFormulario(){
	// PO_form_signin.rellenarFormulario(driver, "user1", "user1");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form:table", 5);
	// driver.findElement(By.id("form-menubar:registrarViajes")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form-menubar:linkVolver",
	// 5);
	// driver.manage().window().maximize();
	// driver.findElement(By.id("form:precargar")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form-menubar:linkVolver",
	// 5);
	// driver.findElement(By.id("form:calleSalida")).getText().equals("CallePrecargada1");
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form-menubar:linkVolver",
	// 5);
	// driver.findElement(By.id("form:limpiar")).click();
	// SeleniumUtils.EsperaCargaPagina(driver, "id","form-menubar:linkVolver",
	// 5);
	// driver.findElement(By.id("form:calleSalida")).getText().equals("");
	// }
}
