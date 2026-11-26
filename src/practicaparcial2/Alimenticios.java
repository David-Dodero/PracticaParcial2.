package practicaparcial2;


import java.time.LocalDate;

/*
 */

public class Alimenticios extends Producto{
    
    private String fechaVencimiento;

    public Alimenticios() {
    }

    public Alimenticios(String codigo, String marca, String modelo, double precio, int stock, Proveedor proveedor,LocalDate fechaVencimiento) {
        super(codigo, marca, modelo, precio, stock, proveedor);
        this.fechaVencimiento = fechaVencimiento.toString();
    }

    public LocalDate getFechaVencimiento() {
        return LocalDate.parse(fechaVencimiento);
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento.toString();
    }
    
}
