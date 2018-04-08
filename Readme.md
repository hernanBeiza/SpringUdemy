#Apuntes Spring, SpringBoot de Udemy
 Algunos apuntes que encontré interesante acerca de este curso que te pueden servir para crear APIs Rest con Java, SpringBoot y SpringMVC
 
## Herramienta utilizada
* IntelliJ IDEA
* Maven
* Spring Boot

## Apuntes 
##Application Context
* Es un conjunto de beans ya funcionales
* Dependencias resueltas entre el bean y la dependencia
* ComponentScan
* Busca en todas las clases si tienen una anotación. Permite identificar si existe un bean para la anotación
* Se realiza desde un package inicial hacia adentro
 
###@Component
* Generica
* Define un componente en el ApplicationContext
###@Controller
* Es en base un@Component
* Componente destinado para atender peticiones web, como @RequestMapping
* Detecta peticiones web
* @RequestMapping(path=“/info”)
* @ReponseBody

###@Service
* Es en base un @Component
* Componente con la lógica de negocio

###@Repository
* Componente de acceso a base de datos

###@Configuration
* Componente que participará en la construcción del application context

## Proyectos
### Proyecto Spring
Ejemplo de como definir un compnent que resonde a un llamado de una ruta o path usando la anotación **@Controller**

### Proyecto SpringDI
Ejemplo de inyección de dependencias usando beans, y anotaciones para el **Component Scan**. Realizado por **Udemy**, corregido por mi =) , como parte del ejercicio propuesto

### Proyecto Get
Ejemplo de como capturar variables través de la URL, definir métodos **GET o POST**.