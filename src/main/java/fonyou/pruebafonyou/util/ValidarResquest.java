package fonyou.pruebafonyou.util;

import fonyou.pruebafonyou.dto.PersonajeDTO;
import fonyou.pruebafonyou.entity.Personaje;
import fonyou.pruebafonyou.excepciones.JsonInvalidoException;
import org.springframework.stereotype.Component;

@Component
public class ValidarResquest {

    public void validarPersonaje(Personaje personaje) {

        if (personaje == null) {
            throw new JsonInvalidoException("El JSON enviado está vacío o malformado.");
        }

        // Valida el campo 'nombre'
        if (personaje.getNombre() == null || personaje.getNombre().isBlank()) {
            throw new JsonInvalidoException("El campo 'nombre' es obligatorio y no puede estar vacío.");
        }


        if (personaje.getDescripcion() == null || personaje.getDescripcion().isBlank()) {
            throw new JsonInvalidoException("El campo 'descripcion' es obligatorio y no puede estar vacío.");
        }


        if (personaje.getRole() == null || personaje.getRole().isBlank()) {
            throw new JsonInvalidoException("El campo 'role' es obligatorio y no puede estar vacío.");
        }


        if (personaje.getImagenUrl() == null || personaje.getImagenUrl().isBlank()) {
            throw new JsonInvalidoException("El campo 'imagenUrl' es obligatorio y no puede estar vacío.");
        }

        // Valida que 'imagenUrl' sea una URL válida (simple regex para validar formato básico)
        if (!personaje.getImagenUrl().matches("https?://.*\\.(jpg|jpeg|png|gif)")) {
            throw new JsonInvalidoException("El campo 'imagenUrl' debe ser una URL válida que termine en .jpg, .jpeg, .png o .gif.");
        }
    }

    public void validarPersonajeDTO(PersonajeDTO personajeDTO) {

        if (personajeDTO == null) {
            throw new JsonInvalidoException("El JSON enviado está vacío o malformado.");
        }

        // Valida el campo 'nombre'
        if (personajeDTO.getNombre() == null || personajeDTO.getNombre().isBlank()) {
            throw new JsonInvalidoException("El campo 'nombre' es obligatorio y no puede estar vacío.");
        }


        if (personajeDTO.getDescripcion() == null || personajeDTO.getDescripcion().isBlank()) {
            throw new JsonInvalidoException("El campo 'descripcion' es obligatorio y no puede estar vacío.");
        }


        if (personajeDTO.getRole() == null || personajeDTO.getRole().isBlank()) {
            throw new JsonInvalidoException("El campo 'role' es obligatorio y no puede estar vacío.");
        }


        if (personajeDTO.getImagenUrl() == null || personajeDTO.getImagenUrl().isBlank()) {
            throw new JsonInvalidoException("El campo 'imagenUrl' es obligatorio y no puede estar vacío.");
        }

        // Valida que 'imagenUrl' sea una URL válida (simple regex para validar formato básico)
        if (!personajeDTO.getImagenUrl().matches("https?://.*\\.(jpg|jpeg|png|gif)")) {
            throw new JsonInvalidoException("El campo 'imagenUrl' debe ser una URL válida que termine en .jpg, .jpeg, .png o .gif.");
        }
    }
}
