package cl.hiperactivo.token.controllers;

import cl.hiperactivo.token.config.ConfigurationProperties;
import cl.hiperactivo.token.models.UsuarioModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
public class UsuarioController {

    @Autowired
    ConfigurationProperties configurationProperties;

    @RequestMapping(path="/login", method={RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Map<String,Object>> login(@RequestParam(value="usuario",required=false) String usuario,
                                                              @RequestParam(value="contrasena",required=false) String contrasena) {
        System.out.println("login();");
        System.out.println(usuario);
        System.out.println(contrasena);

        boolean enviar = true;
        String errores = "Te faltó:\n";
        if(usuario==null){
            enviar = false;
            errores +="Usuario";
        }
        if(contrasena==null){
            enviar = false;
            errores +="Contraseña";
        }

        Map<String, Object> result = new HashMap<String,Object>();
        if(enviar){
            // TODO: Hacer validación contra DB
            result.put("result",true);
            result.put("mensaje","Bienvenido al sistema...");
            UsuarioModel model = new UsuarioModel(1,usuario,null);
            result.put("usuario",model);
            result.put("token","asdfasdfasdf");
            // Guardar en la sessión
            // session.setAttribute("usuario",model);
            // Generar Token
            String jwtToken = Jwts.builder().setSubject(usuario).claim("roles", "user").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "SECRETKEY").compact();
            System.out.println(jwtToken);
            // Add any additional props that you want to add
            result.put("token",jwtToken);
            return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
        } else {
            System.out.println(errores);
            result.put("result",false);
            result.put("errores",errores);
            // Add any additional props that you want to add
            return new ResponseEntity<Map<String,Object>>(result, HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(path="/verificar", method = {RequestMethod.GET,RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Map<String,Object>> verificarToken(@RequestHeader("authorization") String authHeader){
        System.out.println("verificarToken()");
        Map<String, Object> result = new HashMap<String,Object>();
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("Missing or invalid Authorization header");
            result.put("result",false);
            result.put("errores","Missing or invalid Authorization header");
            return new ResponseEntity<Map<String,Object>>(result, HttpStatus.FORBIDDEN);
        } else {

            final String token = authHeader.substring(7);
            System.out.println(token);

            try {
                final Claims claims = Jwts.parser().setSigningKey("SECRETKEY").parseClaimsJws(token).getBody();

                result.put("result",true);
                result.put("mensaje","Token válido");
                return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);

            } catch (final SignatureException e) {
                System.out.println("Invalid token");
                System.out.println(e.getLocalizedMessage());

                result.put("result",false);
                result.put("errores","Token inválido");
                return new ResponseEntity<Map<String,Object>>(result, HttpStatus.FORBIDDEN);

            }
        }

    }

    @RequestMapping(path="/logout", method = {RequestMethod.GET,RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Map<String,Object>> logout(){
        System.out.println("logout()");
        Map<String, Object> result = new HashMap<String,Object>();
        return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
    }
}
