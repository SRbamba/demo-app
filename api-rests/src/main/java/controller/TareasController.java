package controller;

import entity.Tareas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import service.TareasService;

import java.util.List;

@RestController
@RequestMapping ("tareas")
public class TareasController {

    @Autowired
    private TareasService tareasService;

    // 1. READ ALL (Ya implementado)
    @GetMapping
    public ResponseEntity<List<Tareas>> getAllTareas() {
        List<Tareas> tareas = tareasService.findAll();
        return ResponseEntity.ok(tareas);
    }

    // 2. READ BY ID (Faltante)
    @GetMapping("/{id}")
    public ResponseEntity<Tareas> getTareaById(@PathVariable Long id) {
        // Usamos Optional y el método .of() de ResponseEntity para manejar si no se encuentra
        return tareasService.findById(id)
                .map(ResponseEntity::ok) // Si está presente, devuelve 200 OK con la tarea
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si no está, devuelve 404 Not Found
    }

    // 3. CREATE (Faltante)
    @PostMapping
    public ResponseEntity<Tareas> createTarea(@RequestBody Tareas tarea) {
        Tareas nuevaTarea = tareasService.save(tarea);
        // Retorna 201 Created
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }

    // 4. UPDATE (Faltante)
    @PutMapping("/{id}")
    public ResponseEntity<Tareas> updateTarea(@PathVariable Long id, @RequestBody Tareas tareaDetails) {
        try {
            Tareas tareaActualizada = tareasService.update(id, tareaDetails);
            return ResponseEntity.ok(tareaActualizada);
        } catch (RuntimeException e) {
            // Manejamos la excepción si el ID no se encuentra (como está definida en TareasServiceImpl)
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found
        }
    }

    // 5. DELETE (Faltante)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable Long id) {
        // Asumimos que el servicio maneja la eliminación o lanzará una excepción (que podrías capturar)
        tareasService.deleteById(id);
        // Retorna 204 No Content, que es la respuesta estándar para una eliminación exitosa
        return ResponseEntity.noContent().build();
    }
}
