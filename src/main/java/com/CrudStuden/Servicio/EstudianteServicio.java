
package com.CrudStuden.Servicio;

import com.CrudStuden.Entidades.Estudiante;
import java.util.List;


public interface EstudianteServicio {
    // con este metodo es para listar todos los estudiantes agregados
    public List<Estudiante>  listarTodosLosEstudiantes();
        
    // con este metodo podemos guardar un estudiante
    public Estudiante guardarEstudiante(Estudiante estudiante);
    
    public Estudiante obtenerEstudiante(Long id);
    
    public Estudiante actualizarEstudiante(Estudiante estudiante);
    
    public void eliminarEstudiante(Long id);
    
}
