package cl.hiperactivo.javapi.Models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contacto")
@EntityListeners(AuditingEntityListener.class)
public class ContactoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idcontacto;

    private Long idcampana;

    private String nombre;
    private String rut;
    private String telefono;
    private String email;
    private String mensaje;
    private Date fecha;
    private int valid;

    public ContactoModel() {
    }

    public ContactoModel(Long idcontacto,Long idcampana, String nombre, String rut, String telefono, String email, String mensaje, Date fecha, int valid) {
        this.idcontacto = idcontacto;
        this.idcampana = idcampana;
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
        this.email = email;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.valid = valid;
    }

    public Long getIdcontacto() {
        return idcontacto;
    }

    public void setIdcontacto(Long idcontacto) {
        this.idcontacto = idcontacto;
    }

    public Long getIdcampana() {
        return idcampana;
    }

    public void setIdcampana(Long idcampana) {
        this.idcampana = idcampana;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "ContactoModel{" +
                "idcontacto=" + idcontacto +
                ", idcampana=" + idcampana +
                ", nombre='" + nombre + '\'' +
                ", rut='" + rut + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fecha=" + fecha +
                ", valid=" + valid +
                '}';
    }
}
