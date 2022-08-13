
package com.CrudStuden.Repositorio;

import com.CrudStuden.Entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {
    
    
    
}
