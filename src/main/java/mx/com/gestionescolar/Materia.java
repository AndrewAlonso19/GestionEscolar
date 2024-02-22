package mx.com.gestionescolar;

import javax.persistence.*;
import java.util.List;

@Entity
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMateria", nullable = false, unique = true, columnDefinition = "int")
    private long idMateria;

    @Column(name = "nombre", nullable = false, columnDefinition = "varchar(255)")
    private String nombre;
    

    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
    private List<Calificacion> calificaciones;

    public long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(long idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }
    
    

  
}
