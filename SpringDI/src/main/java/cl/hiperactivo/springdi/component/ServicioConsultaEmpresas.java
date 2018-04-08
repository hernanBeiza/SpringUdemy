package cl.hiperactivo.springdi.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

// esta clase debe ser detectada como un componente
@Component
public class ServicioConsultaEmpresas {

	private IntegradorCotizaciones integrador;
	private float cotizacion = 0;

	public ServicioConsultaEmpresas(IntegradorCotizaciones integrador){
		this.integrador = integrador;
	}
	@PostConstruct
	public void init(){
		this.cotizacion = this.integrador.obtenMediaDiariaCotizaciones();
	}
	// este servicio necesita de un integrador de cotizaciones para devolver la informacion
	// declarad la dependencia y haced que Spring la resuelva
	

	// modificad este metodo para cambiar el 0 por el valor obtenidor de ClienteCotizacionesWS
	public String infoEmpresa(String empresa) {

		//return "La empresa " + empresa + " cotiza a 0";
		return "La empresa " + empresa + " cotiza a "+this.integrador.obtenCotitzacion(empresa);

	}

	
	// modificad este metodo para cambiar el 0 por el valor obtenido del clienteCotizacionesWS
	// esta es, seguramente, la parte mas dificil!
	// ¿Como hariais para que el metodo infoDiaria de obtenMediaDiariaCotizaciones solo se llamase una vez?
	// Pista: si solo de debe llamar una vez ... deberemos guardar el resultado en alguna parte ...
	public String infoDiaria() {
		//System.out.println("media diaria " + this.integrador.obtenMediaDiariaCotizaciones());
		//return "La cotizacion media diaria es 0";
		return "La cotizacion media diaria es "+this.cotizacion;
	}

}
