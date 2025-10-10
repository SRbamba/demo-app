package repository;

import entity.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareasRepository extends JpaRepository <Tareas, Long> {
}
