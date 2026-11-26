/*
 */
package practicaparcial2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
//import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CargadorProveedores {
    
    public List<Proveedor> cargar(){
        try (Reader reader = new FileReader("proveedores.json")){
            Gson gson = new Gson();
            java.lang.reflect.Type tipoLista = new TypeToken<List<Proveedor>>(){}.getType();
            return gson.fromJson(reader, tipoLista);
        }catch (IOException e){
            System.out.println("Error al leer proveedores: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
}
