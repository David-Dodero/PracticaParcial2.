/*
 */

package practicaparcial2;

import com.google.gson.Gson;
import java.awt.Font;

import java.time.LocalDate;
import java.util.List;

public class PracticaParcial2 {

    public static void main(String[] args) {
    
        RepositorioProductos repo = new RepositorioProductos();
        
        Proveedor prove = new Proveedor(1, "TecnoSur S.A.", "011-4555-1001",
                "Ventas@tecnoSur.com.ar", "Buenos Aires");
                
        Electronicos notebook = new Electronicos("E001", "Samsung", "Galaxy Book", 800000, 3, prove, 12);
        
        Alimenticios yerba = new Alimenticios("A001", "Taragui", "yerba 1kg", 5000, 10, prove, LocalDate.of(2026,12,31));
        
        try{
            repo.crear(notebook);
            repo.crear(yerba);
        }catch(CodigoDuplicadoException e){
            
            System.out.println(e.getMessage());
        }
        System.out.println("Lista de productos ");
        for(Producto p: repo.listar()){
            System.out.println(p.getCodigo() + " " + p.getMarca());
        }
        
        //2. intento agregar uno con codigo repetido
        Electronicos repetido = new Electronicos("E001", "LG", "Gram", 900000, 2, prove, 6);
        
        try{
            repo.crear(repetido);
        }catch(CodigoDuplicadoException e){
           System.out.println("Error: " + e.getMessage()); 
        }
        
        //3.busco uno q existe y uno q no 
        
        Producto encontrado = repo.buscarPorCodigo("A001");
        if(encontrado != null){
            System.out.println("Producto encontrado: " + encontrado.getMarca());
        }else{
            System.out.println("El codigo no existe" );
        }
        
        Producto noExiste = repo.buscarPorCodigo("xxx");
            if(noExiste == null){
            System.out.println("El codigo no existe" );
            }
        
        // 4. actualizo la nootbok con otro precio(mismo codigo)
        Electronicos nootbookNueva = new Electronicos("E001", "Samsung", "Galaxy Book", 750000, 3, prove, 12);
        repo.actualizar(nootbookNueva);
        System.out.println("Precio nuevo: " + repo.buscarPorCodigo("E001").getPrecio());
    
        
        
    ArchivoProductos archivo = new ArchivoProductos();
    archivo.guardar(repo.listar());
    
    List<Producto> recuperados = archivo.cargar();
    for(Producto p : recuperados){
        System.out.println( p.getCodigo() + " - " + p.getMarca());
    }
        
        //5. Elimino la yerba y listo de nuevo 
        repo.eliminar("A001");
        System.out.println("Lista final");
        for(Producto p: repo.listar()){
            System.out.println(p.getCodigo() + " " + p.getMarca() );
        }
    
        //mostrar provedores 
        CargadorProveedores cargador = new CargadorProveedores();
    List<Proveedor>proveedores = cargador.cargar();
    for( Proveedor p : proveedores){
    System.out.println(p);
    }
    
    System.out.println("Cantidad de proveedores: " + proveedores.size());
    for(Proveedor p : proveedores){
        System.out.println( p.getId() + " - " + p.getRazonSocial());
    }
    
    //ArchivoProductos archivo = new ArchivoProductos();
    //archivo.guardar(repo.listar());
    
    
    }
    
    }
    
    

    
    

