/*
 */
package practicaparcial2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepositorioProductos implements Repositorio<Producto>{

    private List<Producto> productos;
    private ArchivoProductos archivo;

    public RepositorioProductos() {
        this.archivo = new ArchivoProductos();
        this.productos = archivo.cargar();
    }
    
    
    @Override
    public void crear(Producto objeto) throws CodigoDuplicadoException {
        
        for(Producto p : productos){
            if(p.getCodigo().equals(objeto.getCodigo())){
                throw new CodigoDuplicadoException("Ya existe un producto con el codigo "+ objeto.getCodigo());
            }
        }
        productos.add(objeto);
        archivo.guardar(productos);
    }

    @Override
    public Producto buscarPorCodigo(String codigo) {
        
        for(Producto p: productos){
            if(p.getCodigo().equals(codigo)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void actualizar(Producto objeto) {

        for(int i = 0; i < productos.size(); i++ ){
            if(productos.get(i).getCodigo().equals(objeto.getCodigo())){
                productos.set(i, objeto);
                archivo.guardar(productos);
                break;
            }
            
        }
    }

    @Override
    public void eliminar(String codigo) {

        Iterator<Producto>it = productos.iterator();
        
        while (it.hasNext()) {
            Producto p = it.next();
            
            if(p.getCodigo().equals(codigo)){
                it.remove();
                archivo.guardar(productos);
                break;
            }
        }
    }
    
    // OPCIÓN 2: usando Lambda
    // Productos.removeIf(p -> p.getCodigo().equals(codigo));

    @Override
    public List<Producto> listar() {
        return productos;
    }

    //private ArchivoProductos archivo;
    
    
}
