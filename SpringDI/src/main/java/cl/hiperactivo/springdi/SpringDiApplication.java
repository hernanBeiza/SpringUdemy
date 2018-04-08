package cl.hiperactivo.springdi;

import cl.hiperactivo.springdi.component.ServicioConsultaEmpresas;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDiApplication {

	public static void main(String[] args) {


		//SpringApplication.run(SpringDiApplication.class, args);

		ConfigurableApplicationContext ctx = SpringApplication.run(SpringDiApplication.class, args);

		ServicioConsultaEmpresas servicio = ctx.getBean(ServicioConsultaEmpresas.class);

		System.out.println(servicio.infoEmpresa("cervezas.sa"));
		System.out.println(servicio.infoEmpresa("shandies.sa"));
		System.out.println(servicio.infoDiaria());


		ctx.close();

	}
}
