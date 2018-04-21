package cl.hiperactivo.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Configuracion extends WebSecurityConfigurerAdapter {

    /**
     * Dominio de la configuración
     * @param auth
     * @throws Exception
     */

    @Autowired
    public void configuracionGlobal(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("configuracionGlobal");
        auth.inMemoryAuthentication().withUser("hb").password("9040207").roles("ADMIN");
    }

    public void configure(HttpSecurity http) throws Exception {
        System.out.println("configure();");
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/session").permitAll()
                .antMatchers("/logout").permitAll();
        /*
        http.authorizeRequests()
                .antMatchers("/iniciar").permitAll()
                .antMatchers("/session").authenticated()
                .antMatchers("/logout").authenticated()
                .antMatchers("/public.txt").permitAll()
                .antMatchers("/info.txt").authenticated()
                .antMatchers("/gestion/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin/**").hasAnyRole("ADMIN");
        */
        /*
        http.authorizeRequests()
            .antMatchers("/", "/register", "/about", "/home", "/demo").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/logout")
                //.logoutSuccessUrl("/home")
                .invalidateHttpSession(true);
        */
    }

}
