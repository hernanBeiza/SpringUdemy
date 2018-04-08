package cl.hiperactivo.springdi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import cl.hiperactivo.springdi.component.ClienteCotizacionesWS;
import cl.hiperactivo.springdi.component.IntegradorCotizaciones;
import cl.hiperactivo.springdi.component.ServicioConsultaEmpresas;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDiApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired(required=false)
	private IntegradorCotizaciones clienteWS;

	@Autowired(required=false)
	private ServicioConsultaEmpresas servicio;

	/**
	 * Modificad la clase ClienteCotizacionesWS para que sea un componente detectado por Spring
	 */
	@Test
	public void test_clientWS_component() {
		assertNotNull("ClienteCotizacionesWS no es un componente ",clienteWS);
	}

	/**
	 * Modificad la clase ServicioConsultaEmpresas para que sea un componente detectado por Spring
	 */
	@Test
	public void test_servicioConsultaEmpresas_component() {
		assertNotNull("ServicioConsultaEmpresas no es un componente ",servicio);
	}

	/**
	 * Modificad ServicioConsultaEmpresas para que, en lugar de devolver siempre 0, use los metodos de IntegradorCotizaciones
	 */
	@Test
	public void test_consulta_cotizacion_empresa() {
		assertNotNull("ServicioConsultaEmpresas no es un component ",servicio);
		assertEquals("consulta cotizacion", "La empresa cervezas.sa cotiza a 30.0", servicio.infoEmpresa("cervezas.sa"));
		assertEquals("consulta cotizacion", "La empresa shandies.sa cotiza a 10.0", servicio.infoEmpresa("shandies.sa"));
	}

	/**
	 * Para este ejercicio supondremos dos cosas:
	 *   - la aplicacion se lanza cada dia, por tanto la consulta a infoDiaria siempre sera la misma durante toda la ejecucion
	 *   - consultar obtenMediaDiariaCotizaciones es muuuuy lento, y no queremos hacerlo para cada invocacion a infoDiaria(), ya que
	 *     hemos dicho que siempre devolvera el mismo resultado
	 * Modificad la clase ServicioConsultaEmpresas para que muestre la informacion de obtenMediaDiariaCotizaciones
	 * pero haciendo la consulta SOLO UNA VEZ.
	 */
	@Test
	public void test_infoDiari() {
		assertNotNull("ServicioConsultaEmpresas no es un component ",servicio);
		assertEquals("consulta info diaria", "La cotizacion media diaria es 20.0", servicio.infoDiaria());

		// no comprobamos el resultado de esta segunda invocacion, solo es para comprobar que se
		// esta reusando el resultado de obtenMediaDiariaCotizaciones() anterior
		servicio.infoDiaria();

		ClienteCotizacionesWS client  = (ClienteCotizacionesWS) clienteWS;
		assertEquals("Solo se ha invocado obtenMediaDiariaCotizaciones() una vez",1,client.numeroInvocaciones);
	}
}
