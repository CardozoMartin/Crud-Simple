
package com.CrudStuden.Servicio;

import com.CrudStuden.Entidades.Estudiante;
import com.CrudStuden.Repositorio.EstudianteRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServicioImpl implements EstudianteServicio {
    @Autowired
    //con esta anotacion agregamos todas las dependencias
    private EstudianteRepositorio estudianteRepositorio;
    @Override
    public List<Estudiante> listarTodosLosEstudiantes() {
        return estudianteRepositorio.findAll();
    }
    // con este metodo podemos guardar un estudiante
    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepositorio.save(estudiante);
    }
    //con este metodo obtenemos al estudiante por id
    @Override
    public Estudiante obtenerEstudiante(Long id) {
        return estudianteRepositorio.findById(id).get();
    }
    //con este metodo modificamos los datos de algun estudiante
    @Override
    public Estudiante actualizarEstudiante(Estudiante estudiante) {
       return estudianteRepositorio.save(estudiante);
    }
    // con este metodo eliminamos un estudiante mediante su id
    @Override
    public void eliminarEstudiante(Long id) {
        estudianteRepositorio.deleteById(id);
    }
    
}
