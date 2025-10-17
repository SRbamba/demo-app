package service;

import entity.Tareas;

import java.util.List;
import java.util.Optional;

public interface TareasService {

    List<Tareas> findAll();

    Optional<Tareas> findById(Long id);

    Tareas save(Tareas tarea);

    Tareas update(Long id, Tareas tarea);

    void deleteById(Long id);

}
