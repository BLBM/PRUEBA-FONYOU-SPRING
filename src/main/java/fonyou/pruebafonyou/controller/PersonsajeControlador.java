package fonyou.pruebafonyou.controller;

import fonyou.pruebafonyou.dto.PersonajeDTO;
import fonyou.pruebafonyou.entity.Personaje;
import fonyou.pruebafonyou.service.PersonajeService;

import fonyou.pruebafonyou.util.ValidarResquest;
import org.springframework.cache.annotation.CacheEvict;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/personajes/")
public class PersonsajeControlador {

    private final PersonajeService personajeService;

    private final ValidarResquest validarResquest;

    public  PersonsajeControlador(PersonajeService personajeService, ValidarResquest validarResquest){
        this.personajeService = personajeService;
        this.validarResquest = validarResquest;
    }


    @GetMapping("/prueba")
    public String saludar() {
        return "prueba";
    }

    @GetMapping
    public List<Personaje>  listarPersonajes(){
        return  personajeService.findAll();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Personaje> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(personajeService.findById(id));
    }

    @GetMapping("ordenPorNombre")
    public List<Personaje> listarPersonajesPorNombre(){
        return personajeService.personajesPorNombre();
    }

    @GetMapping("ordenPorFecha")
    public List<Personaje> listarPersonajesPorFecha(){
        return personajeService.personajesPorFecha();
    }

    @CacheEvict(value = "personajes", allEntries = true)
    @PostMapping
    public ResponseEntity<Personaje> crearPersonaje(@RequestBody Personaje personaje){
    validarResquest.validarPersonaje(personaje);

        Personaje personajeGuardado = personajeService.save(personaje);
        return ResponseEntity.accepted().body(personajeGuardado);
    }

    @CacheEvict(value = "personajes", allEntries = true)
    @PutMapping("/{id}")
    public ResponseEntity<Personaje> actualizarPersonaje(
            @PathVariable Long id,
            @RequestBody PersonajeDTO personajeDTO) {
        validarResquest.validarPersonajeDTO(personajeDTO);

        Personaje personajeActualizado = personajeService.update(id, personajeDTO);
        return ResponseEntity.ok(personajeActualizado);
    }

    @CacheEvict(value = "personajes", allEntries = true)
    @DeleteMapping("/{id}")
    public ResponseEntity<Personaje> borrarPersonaje(@PathVariable Long id) {

        return ResponseEntity.ok(personajeService.delete(id));
    }

}
