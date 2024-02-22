
package mx.com.gestionescolar;


public class MateriaDTO {
    private long idMateria;
    private String nombre;
    private double nota;

    public MateriaDTO() {
        // Constructor vacío necesario para deserialización por Spring
    }

    public MateriaDTO(long idMateria, String nombre, double nota) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.nota = nota;
    }

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

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}