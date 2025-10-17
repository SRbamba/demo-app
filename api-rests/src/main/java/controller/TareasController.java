package controller;

import entity.Tareas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TareasService;

import java.util.List;

@RestController
@RequestMapping ("tareas")
public class TareasController {
    @Autowired
    TareasService tareasService;


}
