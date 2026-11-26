package practicaparcial2;

/*
excepcion propia cuando el codigo ya existe 
 */

public class CodigoDuplicadoException extends Exception{
    public CodigoDuplicadoException(String mensaje){
        super(mensaje);
    }
}
