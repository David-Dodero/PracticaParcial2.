/*
 */
package practicaparcial2;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ArchivoProductos {

    public void guardar(List<Producto>productos){
        
        DatosProductos datos = new DatosProductos();
        
        for(Producto p : productos){
            if(p instanceof Electronicos){
                datos.getElectronicos().add((Electronicos)p);
            }else if (p instanceof Alimenticios){
                datos.getAlimenticios().add((Alimenticios)p);
            }
        }
        try(Writer writer = new FileWriter("productos.json")){
            Gson gson = new Gson();
            gson.toJson(datos, writer);
        }catch (IOException e){
            System.out.println("Error al guardar producto: " + e.getMessage());
        }
    }
    
    public List<Producto> cargar(){
        
        List<Producto> lista= new ArrayList<>();
        
        try (Reader reader =  new FileReader("productos.json")){
            Gson gson = new Gson();
            
            DatosProductos datos = gson.fromJson(reader, DatosProductos.class);
            
        if(datos != null){    
            lista.addAll(datos.getElectronicos());
            lista.addAll(datos.getAlimenticios());
        }
        } catch (IOException e){
            System.out.println("Error al cargar productos: "+ e.getMessage());
        }
        return lista;
    }
    
    
    
}
