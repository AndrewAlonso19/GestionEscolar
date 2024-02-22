package mx.com.gestionescolar;


import java.util.List;

public class InformacionAlumnoDTO {
    private long idAlumno;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
    private Double promedioGeneral;
    private List<MateriaDTO> materias;

    public InformacionAlumnoDTO() {
        // Constructor vacío necesario para deserialización por Spring
    }

    public InformacionAlumnoDTO(long idAlumno, String nombre, String apellido, String email, String telefono, String direccion, Double promedioGeneral, List<MateriaDTO> materias) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.promedioGeneral = promedioGeneral;
        this.materias = materias;
    }

    public long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getPromedioGeneral() {
        return promedioGeneral;
    }

    public void setPromedioGeneral(Double promedioGeneral) {
        this.promedioGeneral = promedioGeneral;
    }

    public List<MateriaDTO> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaDTO> materias) {
        this.materias = materias;
    }
}
