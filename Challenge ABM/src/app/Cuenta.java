package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Cuenta
 */
public class Cuenta {

    public String moneda;
    public double saldoTotal;
    public double dineroDisponible;
    public double dineroPendiente;

    public List<MovimientoTransaccion> movimientos = new ArrayList<MovimientoTransaccion>();

    public List<MovimientoTransaccion> ultimosMovimientos = new ArrayList<MovimientoTransaccion>();

    
}