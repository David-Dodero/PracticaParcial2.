/*
 */
package practicaparcial2;

import java.util.ArrayList;
import java.util.List;

public class DatosProductos {
    
    private List<Electronicos> electronicos = new ArrayList<>();
    private List<Alimenticios> alimenticios = new ArrayList<>();
    
    public DatosProductos(){}
    
    public List<Electronicos> getElectronicos(){return electronicos;}
    public List<Alimenticios> getAlimenticios(){return alimenticios;}
}
