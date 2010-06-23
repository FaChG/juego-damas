package decorator.problema;
/**
   Ok, esta soluci�n tiene algunos inconvenientes:
    * �Ensucia� la l�gica del m�todo comprar() cliente
	*  Agrega atributos que no todos los clientes necesitan: si el cliente no se adhiere a la
	promoci�n no necesita tener puntosAcumulados. 
	El problema no es guardar una referencia de m�s, 
	sino que el que lee la clase Cliente puede confundirse pensando
	que esa variable la necesita el cliente (est� o no en promoci�n).
 * @author alejandro
 *
 */
public class ClientePosta implements Cliente{

	private boolean usaSafeShop;
	private double montoMaximoSafeShop;
	private double montoMinimoPromocion;
	private boolean tienePromocion;
	private double puntosPremioPromocion;
	private double puntosAcumulados;

	public void comprar(double monto) throws BusinessException {
		if (usaSafeShop() && monto > montoMaximoSafeShop) {
			throw new BusinessException("Ha excedido el monto maximo");
		}
		if (tienePromocion && monto > montoMinimoPromocion) {
			puntosAcumulados += puntosPremioPromocion;
		}
	}

	public boolean usaSafeShop() {
		return usaSafeShop;
	}

	public void pagarVencimiento(double monto) {
		// TODO Auto-generated method stub
		
	}

	
}
