package uo.sdi.tests;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.Before;
import org.junit.Test;


// COMPROBAR QUE EL ID DEL VIAJE EN LA LINEA 141. Ha de ser un viaje que aparezca en Viajes Disponibles!
public class TestShareMyTrip {
	
	private WebTester test;

	@Before
	public void prepare() {
		test = new WebTester();
		test.setBaseUrl("http://localhost:8280");
	}
	
	@Test
	public void testCompleto(){
		testAux("marcosruiz");
	}
	
	
	public void testAux(String username){
		testRegistroIncorrecto(username);
		testRegistroCorrectoUsername(username);
		testLoginIncorrecto(username);
		testRegistroViaje(username);
		testSolicitarPlaza(username);
	}
	
	
	public void testAux2(String username){
		testRegistroCorrectoUsername(username);
		testRegistroViaje(username);
	}
	

	public void testLoginCorrecto() {
		test.beginAt("/sesion4.MVCCasero/");
		test.assertTitleEquals("ShareMyTrip - Inicie sesión");
		test.assertTextPresent("Iniciar sesión");
		test.assertTextPresent("Login:");
		test.assertTextPresent("Password:");
		test.setTextField("nombreUsuario", "user1");
		test.setTextField("password", "user1");
		test.clickButtonWithText("Aceptar");
		test.assertTitleEquals("ShareMyTrip - Página principal ShareMyTrip.com");
	}
	

	public void testLoginIncorrecto(String username) {
		test.beginAt("/sesion4.MVCCasero/");
		test.assertTitleEquals("ShareMyTrip - Inicie sesión");
		test.assertTextPresent("Iniciar sesión");
		test.setTextField("nombreUsuario", username);
		test.setTextField("password", "passwordincorrecta");
		test.clickButtonWithText("Aceptar");
		test.assertTitleEquals("ShareMyTrip - Inicie sesión");
		test.assertTextPresent("Password incorrecta, prueba con otra");
		test.assertLinkPresentWithText("Registrarse");
		test.assertLinkNotPresentWithText("Cerrar Sesión");
		test.assertLinkNotPresentWithText("Home");
		test.assertLinkNotPresentWithText("Perfil");
	}
	
	
	public void testRegistroIncorrecto(String username) {
		test.beginAt("/sesion4.MVCCasero/registro.jsp");
		test.assertTitleEquals("ShareMyTrip - Registro de usuario");
		test.assertTextPresent("Registrarse como usuario");
		test.assertTextPresent("Login:");
		test.setTextField("login", username);
		test.assertTextPresent("Nombre:");
		test.setTextField("name", username);
		test.assertTextPresent("Apellidos:");
		test.setTextField("surname", username);
		test.assertTextPresent("Email:");
		test.setTextField("email", username + "@" + username + ".com");
		test.assertTextPresent("Password:");
		test.setTextField("password", username);
		test.assertTextPresent("Reintroduzca la password:");
		test.setTextField("repassword", "passwordincorrecta");
		test.assertButtonPresentWithText("Registrarse");
		test.assertButtonPresentWithText("Cancelar");
		test.clickButtonWithText("Registrarse");
		test.assertTitleEquals("ShareMyTrip - Registro de usuario");
		test.assertTextPresent("Ambas contraseñas han de ser iguales");
		test.assertButtonPresentWithText("Registrarse");
		test.assertButtonPresentWithText("Cancelar");
		test.assertLinkPresentWithText("Volver a login");
	}
	
	public void testRegistroViaje(String username){

		testLoginCorrecto(username);
		test.assertTextInElement("example","Fecha de cierre");
		test.assertTableRowCountEquals("example", 1);
		test.clickLinkWithText("Registrar viaje");
		test.assertTitleEquals("ShareMyTrip - Registro de viaje");
		test.assertTextPresent("Registrar un viaje");
		
		test.setTextField("calle","Avenida de Galicia, 10");
		test.setTextField("ciudad", "Oviedo");
		test.setTextField("provincia", "Asturias");
		test.setTextField("pais","España");
		test.setTextField("zipcode", "33012");
		test.setTextField("latitud", "2344.1");
		test.setTextField("longitud", "1503.6");
		
		test.setTextField("fechasalida", "2016-03-02T13:00:00.00");

		test.setTextField("calledest","Avenida de Madrid, 12");
		test.setTextField("ciudaddest", "Santiago de Compostela");
		test.setTextField("provinciadest", "Galicia");
		test.setTextField("zipcode", "32115");
		test.setTextField("paisdest","España");
		test.setTextField("latituddest", "1809.1");
		test.setTextField("longituddest", "1667.6");
		
		test.setTextField("fechallegada", "2016-03-02T15:00:00.00");
		test.setTextField("fechalimite", "2016-03-02T12:00:00.00");
		
		test.setTextField("comentarios", "proba");
		test.setTextField("maxpax", "3");
		test.setTextField("coste","333");
		
		test.assertButtonPresentWithText("Registrar viaje");
		test.clickButtonWithText("Registrar viaje");
		test.assertTitleEquals("ShareMyTrip - Registro de viaje");
		test.assertTextPresent("El viaje se ha registrado correctamente, para ver el viaje vaya a la pestaña de 'Viajes'");
		
		test.clickLinkWithText("Home");
		test.assertTitleEquals("ShareMyTrip - Página principal ShareMyTrip.com");
		test.assertTableRowCountEquals("example", 2);
		test.assertTextInElement("example", "PROMOTOR");
		
		test.clickLinkWithText("Cerrar Sesión");	
	}
	
	
	public void testSolicitarPlaza(String username){
		testLoginCorrecto("marcosruiz");
		test.assertTableRowCountEquals("example", 2);
		test.clickLinkWithText("Viajes");
		test.clickLinkWithText("34"); // OJO COMPROBAR ANTES DE ENTREGAR!!!!!
		test.assertTitleEquals("ShareMyTrip - Detalles del viaje");
		test.assertButtonPresent("solicitarPlaza");
		test.clickButton("solicitarPlaza");
		test.assertTitleEquals("ShareMyTrip - Página principal ShareMyTrip.com");
		test.assertTableRowCountEquals("example", 3);
		test.clickLinkWithText("Cerrar Sesión");
	}
	
	public void testRegistroCorrectoUsername(String username) {
		test.beginAt("/sesion4.MVCCasero/registro.jsp");
		test.assertTitleEquals("ShareMyTrip - Registro de usuario");
		test.assertTextPresent("Registrarse como usuario");
		test.assertTextPresent("Login:");
		test.setTextField("login", username);
		test.assertTextPresent("Nombre:");
		test.setTextField("name", username);
		test.assertTextPresent("Apellidos:");
		test.setTextField("surname", username);
		test.assertTextPresent("Email:");
		test.setTextField("email", username + "@" + username + ".com");
		test.assertTextPresent("Password:");
		test.setTextField("password", username);
		test.assertTextPresent("Reintroduzca la password:");
		test.setTextField("repassword", username);
		test.assertButtonPresentWithText("Registrarse");
		test.assertButtonPresentWithText("Cancelar");
		test.clickButtonWithText("Registrarse");
		test.assertTitleEquals("ShareMyTrip - Inicie sesión");
	}
	
	public void testLoginCorrecto(String username) {
		test.beginAt("/sesion4.MVCCasero/");
		test.assertTitleEquals("ShareMyTrip - Inicie sesión");
		test.assertTextPresent("Iniciar sesión");
		test.assertTextPresent("Login:");
		test.assertTextPresent("Password:");
		test.setTextField("nombreUsuario", username);
		test.setTextField("password", username);
		test.clickButtonWithText("Aceptar");
		test.assertTitleEquals("ShareMyTrip - Página principal ShareMyTrip.com");
	}

}
