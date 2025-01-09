package fonyou.pruebafonyou.service;

import fonyou.pruebafonyou.dto.PersonajeDTO;
import fonyou.pruebafonyou.entity.Personaje;
import fonyou.pruebafonyou.excepciones.PersonajeNotFoundException;
import fonyou.pruebafonyou.repository.PersonajeRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService {

    private final PersonajeRepository personajeRepository;

    public PersonajeService(PersonajeRepository personajeRepository){
        this.personajeRepository = personajeRepository;
    }

    @Cacheable(value = "personajes", key = "'personajesPorID'")
    public List<Personaje> findAll(){
        return personajeRepository.findAll();
    }

    @Cacheable(value = "personajes", key = "'personajesPorNombre' + #nombre")
    public List<Personaje> personajesPorNombre(){
        return personajeRepository.findAll(Sort.by(Sort.Order.asc("nombre")));
    }


    @Cacheable(value = "personajes", key = "'personajesPorFecha' + #fechaCreacion")
    public List<Personaje> personajesPorFecha(){
        return personajeRepository.findAll(Sort.by(Sort.Order.asc("fechaCreacion")));
    }



    @Cacheable(value = "personajes" , key="#id")
    public Personaje findById(Long id) {
        return personajeRepository.findById(id)
                .orElseThrow(() -> new PersonajeNotFoundException(id));
    }

    @CachePut(value = "personaje",key = "#result.id")
    public Personaje save(Personaje personaje){
        return personajeRepository.save(personaje);
    }

    @CachePut(value = "personaje",key = "#result.id")
    public Personaje update(Long id, PersonajeDTO personajeDTO) {
        Personaje personaje = personajeRepository.findById(id)
                .orElseThrow(() -> new PersonajeNotFoundException("Personaje no encontrado"));

        personaje.setNombre(personajeDTO.getNombre());
        personaje.setDescripcion(personajeDTO.getDescripcion());
        personaje.setRole(personajeDTO.getRole());
        personaje.setImagenUrl(personajeDTO.getImagenUrl());

        return personajeRepository.save(personaje);
    }

    @CacheEvict(value = "personaje",key = "#id")
    public Personaje delete(Long id) {
        Optional<Personaje> personaje = personajeRepository.findById(id);
        if (personaje.isPresent()) {
            personajeRepository.deleteById(id);
            return personaje.get();
        } else {
            throw new PersonajeNotFoundException(id);
        }
    }
}
