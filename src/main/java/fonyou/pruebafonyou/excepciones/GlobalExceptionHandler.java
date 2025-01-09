package fonyou.pruebafonyou.excepciones;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(PersonajeNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlePersonajeNotFoundException(PersonajeNotFoundException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(JsonInvalidoException.class)
    public ResponseEntity<?> handleJsonInvalidoException(JsonInvalidoException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "error", "Formato JSON no válido",
                        "mensaje", ex.getMessage(),
                        "ejemplo", Map.of(
                                "nombre", "Juan Perez",
                                "descripcion", "Personaje valiente",
                                "estado", "Activo",
                                "fechaCreacion", "2025-01-01",
                                "imagenUrl", "https://example.com/imagen.jpg",
                                "role", "Heroe"
                        )
                ));
    }
}
