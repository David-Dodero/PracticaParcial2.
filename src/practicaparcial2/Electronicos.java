package practicaparcial2;

/*
 */

public class Electronicos extends Producto{
    
    private int garantiaMeses;

    public Electronicos() {
    }


    public Electronicos(String codigo, String marca, String modelo, double precio, int stock, Proveedor proveedor, int garantiaMeses) {
        super(codigo, marca, modelo, precio, stock, proveedor);
        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }
    
    
    
}
