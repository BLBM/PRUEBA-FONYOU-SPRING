package fonyou.pruebafonyou.dto;

public class PersonajeDTO {
        private String nombre;
        private String descripcion;
        private String role;
        private String estado;
        private String imagenUrl;

    public String getNombre() {
        return nombre;
    }

    public PersonajeDTO setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public PersonajeDTO setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public String getRole() {
        return role;
    }

    public PersonajeDTO setRole(String role) {
        this.role = role;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public PersonajeDTO setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public PersonajeDTO setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
        return this;
    }
}
