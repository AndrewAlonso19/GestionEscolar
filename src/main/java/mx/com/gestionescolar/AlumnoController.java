package mx.com.gestionescolar;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);
        return optionalAlumno.map(alumno -> ResponseEntity.ok().body(alumno))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createAlumno(@RequestBody Alumno alumno) {
        alumnoRepository.save(alumno);
        return ResponseEntity.ok("Alumno creado exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAlumno(@PathVariable Long id, @RequestBody Alumno updatedAlumno) {
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);
        return optionalAlumno.map(alumno -> {
            alumno.setNombre(updatedAlumno.getNombre());
            alumno.setApellido(updatedAlumno.getApellido());
            alumno.setEmail(updatedAlumno.getEmail());
            alumno.setTelefono(updatedAlumno.getTelefono());
            alumno.setDireccion(updatedAlumno.getDireccion());
            alumno.setPromedioGeneral(updatedAlumno.getPromedioGeneral());
            alumnoRepository.save(alumno);
            return ResponseEntity.ok("Alumno actualizado exitosamente");
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlumno(@PathVariable Long id) {
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);
        return optionalAlumno.map(alumno -> {
            alumnoRepository.delete(alumno);
            return ResponseEntity.ok("Alumno eliminado exitosamente");
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    
}
