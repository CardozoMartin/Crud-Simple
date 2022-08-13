package com.CrudStuden.Controlador;

import com.CrudStuden.Entidades.Estudiante;
import com.CrudStuden.Servicio.EstudianteServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstudianteControlador {

    @Autowired
    private EstudianteServicio servicio;

    //con esta anotacion estamos indicando el url y el html que se mostrara en pantall
    @GetMapping({"/estudiantes", "/"})
    public String listarEstudiantes(Model modelo) {
        modelo.addAttribute("estudiantes", servicio.listarTodosLosEstudiantes());
        return "estudiantes"; // nos retorna al archivo estudiantes
    }

    // en este metodo estamos pasando un nuevo objeto para crearlo y poder retornarlo
    @GetMapping("/estudiantes/nuevo")
    public String mostrarFormularioDeRegistrtarEstudiante(Model modelo) {
        Estudiante estudiante = new Estudiante();
        modelo.addAttribute("estudiante", estudiante);
        return "crear_estudiante";
    }

    //con esta funcion guardamos un nuevo estudiante que carguemos por la pantalla
    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        servicio.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    //con el pathvariable recibimos el id para poder modificar el estudiante
    // con este metodo podemos obtener la funcion del estudiante buscado por el id
    @GetMapping("/estudiantes/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("estudiante", servicio.obtenerEstudiante(id));
		return "editar_estudiante";
	}

    //en este post mapping vamos actualizar o modificar los datos de algun estudiante cargado ya en la base
    //le pasamos un pathvariable para recibir el id
    //le cargamos un model atribute para recibir los datos cargados y modificarlo
    @PostMapping("/estudiantes/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante,Model modelo) {
        //creamos un nuevo objeto estudiante para obtener o poder modificar por el id
        Estudiante estudianteExistente = servicio.obtenerEstudiante(id);
        // obtenemos los setter y agregamos los get del estudiante
        estudianteExistente.setId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());
        //por ultimo cargamos todo en el metodo estudiante
        servicio.actualizarEstudiante(estudianteExistente);
        return "redirect:/estudiantes";
    }
    //en este ultimo metodo es para pader eliminar a un estudiante mediante su id
    // agregamos el pathvariable para obtener los datos por el id asi poder eliminarlo
    @GetMapping("/estudiantes/{id}")
    public String EliminarEstudiante(@PathVariable Long id) {
        //agregamos el metodo eliminar estudiante por el id
        servicio.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}
