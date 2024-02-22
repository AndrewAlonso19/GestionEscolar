package mx.com.gestionescolar;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/materias")
public class MateriaController {
    @Autowired
    private MateriaRepository materiaRepository;

    @GetMapping
    public List<Materia> getAllMaterias() {
        return materiaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable Long id) {
        Optional<Materia> optionalMateria = materiaRepository.findById(id);
        return optionalMateria.map(materia -> ResponseEntity.ok().body(materia))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createMateria(@RequestBody Materia materia) {
        materiaRepository.save(materia);
        return ResponseEntity.ok("Materia creada exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMateria(@PathVariable Long id, @RequestBody Materia updatedMateria) {
        Optional<Materia> optionalMateria = materiaRepository.findById(id);
        return optionalMateria.map(materia -> {
            materia.setNombre(updatedMateria.getNombre());
            materiaRepository.save(materia);
            return ResponseEntity.ok("Materia actualizada exitosamente");
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMateria(@PathVariable Long id) {
        Optional<Materia> optionalMateria = materiaRepository.findById(id);
        return optionalMateria.map(materia -> {
            materiaRepository.delete(materia);
            return ResponseEntity.ok("Materia eliminada exitosamente");
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
