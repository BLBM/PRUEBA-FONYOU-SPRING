package fonyou.pruebafonyou.excepciones;

public class PersonajeNotFoundException  extends  RuntimeException{

    public PersonajeNotFoundException(Long id){
        super("Personaje no encontrado con id: "+id);
    }

    public PersonajeNotFoundException(String nombre){
        super("Personaje no encontrado nombre: "+nombre);
    }
}
