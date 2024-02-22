package mx.com.gestionescolar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/informacion-alumnos")
public class InformacionAlumnosController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CalificacionRepository calificacionRepository;

    @GetMapping
    public List<Alumno> getAllInformacionAlumnos() {
        return alumnoRepository.findAll();
    }

    @PostMapping("/{idAlumno}/agregar-materia")
    public ResponseEntity<String> agregarMateria(@PathVariable Long idAlumno, @RequestBody Calificacion calificacion) {
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(idAlumno);

        return optionalAlumno.map(alumno -> {
            //if (alumno.getCalificaciones().size() > 5) {
                calificacion.setAlumno(alumno);
                calificacionRepository.save(calificacion);

                
                Double promedioGeneral = calcularPromedioGeneral(alumno.getCalificaciones());
                alumno.setPromedioGeneral(promedioGeneral);
                alumnoRepository.save(alumno);

                return ResponseEntity.ok("Materia agregada exitosamente");
            //} else {
                //return ResponseEntity.badRequest().body("El alumno tiene menos de 5 materias, necesita agregar más");
            //}
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private Double calcularPromedioGeneral(List<Calificacion> calificaciones) {
        double sumaNotas = 0.0;
        for (Calificacion calificacion : calificaciones) {
            sumaNotas += calificacion.getNota();
        }
        return sumaNotas / calificaciones.size();
    }
    
     @GetMapping("/{id}")
    public ResponseEntity<InformacionAlumnoDTO> getInformacionAlumnoById(@PathVariable Long id) {
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);

        return optionalAlumno.map(alumno -> {
            InformacionAlumnoDTO informacionAlumnoDTO = new InformacionAlumnoDTO();
            informacionAlumnoDTO.setIdAlumno(alumno.getIdAlumno());
            informacionAlumnoDTO.setNombre(alumno.getNombre());
            informacionAlumnoDTO.setApellido(alumno.getApellido());
            informacionAlumnoDTO.setEmail(alumno.getEmail());
            informacionAlumnoDTO.setTelefono(alumno.getTelefono());
            informacionAlumnoDTO.setDireccion(alumno.getDireccion());
            informacionAlumnoDTO.setPromedioGeneral(alumno.getPromedioGeneral());

            List<MateriaDTO> materias = alumno.getCalificaciones().stream()
                    .map(calificacion -> {
                        MateriaDTO materiaDTO = new MateriaDTO();
                        materiaDTO.setIdMateria(calificacion.getMateria().getIdMateria());
                        materiaDTO.setNombre(calificacion.getMateria().getNombre());
                        materiaDTO.setNota(calificacion.getNota());
                        return materiaDTO;
                    })
                    .collect(Collectors.toList());

            informacionAlumnoDTO.setMaterias(materias);

            return ResponseEntity.ok(informacionAlumnoDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    

}
