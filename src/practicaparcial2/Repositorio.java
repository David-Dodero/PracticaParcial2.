/*
Interface
*/
package practicaparcial2;

import java.util.List;

public interface Repositorio<T> {
    
    void crear(T objeto) throws CodigoDuplicadoException;
    
    T buscarPorCodigo(String codigo);
    
    void actualizar(T objeto);
    
    void eliminar(String codigo);
    
    List<T> listar();
}
