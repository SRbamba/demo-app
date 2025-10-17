package service;

import entity.Tareas;
import org.springframework.beans.factory.annotation.Autowired;
import repository.TareasRepository;

import java.util.List;
import java.util.Optional;

public class TareasServiceImpl implements TareasService {

    @Autowired
    private TareasRepository tareasRepository;

    @Override
    public List<Tareas> findAll() {
        return tareasRepository.findAll();
    }

    @Override
    public Optional<Tareas> findById(Long id) {
        return tareasRepository.findById(id);
    }

    @Override
    public Tareas save(Tareas tarea) {
        return tareasRepository.save(tarea);
    }

    @Override
    public Tareas update(Long id, Tareas tareaDetails) {
        Tareas tareaExistente = tareasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la tarea con el id: " + id));

        tareaExistente.setNombre(tareaDetails.getNombre());
        tareaExistente.setDescripcion(tareaDetails.getDescripcion());
        tareaExistente.setCompletada(tareaDetails.isCompletada());
        tareaExistente.setFecha(tareaDetails.getFecha());

        return tareasRepository.save(tareaExistente);
    }

    @Override
    public void deleteById(Long id) {
        tareasRepository.deleteById(id);
    }
}