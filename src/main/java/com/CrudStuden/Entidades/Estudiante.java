
package com.CrudStuden.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//con esta anotacion creamos una tabla en la base de datos del nombre estudiante
@Table(name="estudiantes")
public class Estudiante {
    
    //con esta anotacion hacemos que se cree el id en la base de datos
    //y sea autoincrementable 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    //con esta anotacion creamos la columna en la base de datos con el nombre "nombre" y decimos que se cargue
    //el atributo nombre que cargamos en esta tabla
    @Column(name = "nombre",nullable = false,length =50)
    private String nombre;
    
    @Column(name = "apellido",nullable = false,length =50)
    private String apellido;
    
    @Column(name = "email",nullable = false,length =100, unique = true)
    private String email;

    public Estudiante() {
    }

    public Estudiante(long id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + '}';
    }
    
    
    
}
