package fonyou.pruebafonyou.entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "personaje")

public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String nombre;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column
    private Boolean estado;

    @Column(nullable = false)
    private String imagenUrl;


    public Personaje() {
    }

    public Personaje(Long id, String nombre, String role, String descripcion, LocalDateTime fechaCreacion, Boolean estado, String imagenUrl) {
        this.nombre = nombre;
        this.id = id;
        this.role = role;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.imagenUrl = imagenUrl;
    }



    public Long getId() {
        return id;
    }

    public Personaje setId(Long identificacion) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Personaje setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getRole() {
        return role;
    }

    public Personaje setRole(String role) {
        this.role = role;
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Personaje setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Personaje setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public Boolean getEstado() {
        return estado;
    }

    public Personaje setEstado(Boolean estado) {
        this.estado = estado;
        return this;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public Personaje setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
        return this;
    }


}