package cl.hiperactivo.internacionalizacion;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ConfigResources {

    //Encargado de cargar la localización desde la carpeta "resources/i18n"

    @Bean
    public MessageSource messageSource(){
        System.out.println("messageSource");
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/principal");
        messageSource.setDefaultEncoding("UTF8");
        return messageSource;
    }
}
