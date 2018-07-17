package cl.hiperactivo.javapi.Models;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "campana")
@EntityListeners(AuditingEntityListener.class)
public class Campana implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcampana")
    private Long id;

    @NotBlank
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha")
    private String fecha;

    @NotBlank
    @Column(name = "url")
    private String url;

    @NotBlank
    @Column(name = "email")
    private String email;

    @Column(name = "valid")
    private int valid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "Campana{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", url='" + url + '\'' +
                ", email='" + email + '\'' +
                ", valid=" + valid +
                '}';
    }
}