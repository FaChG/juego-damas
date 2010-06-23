package decorator.solucion.a.subclasificar;

import decorator.problema.BusinessException;
import decorator.problema.Cliente;

/**
 * @author alejandro
 *
 * Esta alternativa separa claramente las responsabilidades de cada condici�n comercial. Ya no
se ensucia al ClientePosta, sino que cada subclase delega en la superclase el comportamiento
default del comprar y adem�s hace su propio agregado. Parece una trivialidad pero no lo es, el
atributo montoMaximoSafeShop pasa a llamarse montoMaximo a secas.

No obstante esta opci�n presenta una clara desventaja: no s�lo es complicado hacer que un
cliente posta habilite/deshabilite el servicio de Safe Shop: esta soluci�n no permite que
coexistan un cliente en promoci�n que tambi�n tenga safe shop, y es el motivo que lo
convierte en la soluci�n menos deseable de todas.

 */
public abstract class ClientePosta implements Cliente{

	private boolean usaSafeShop;
	private double puntosPremioPromocion;
	private double puntosAcumulados;
	public void comprar(double monto) throws BusinessException {
		puntosAcumulados += puntosPremioPromocion;
	}

	public boolean usaSafeShop() {
		return usaSafeShop;
	}

	public void pagarVencimiento(double monto) {
		// TODO Auto-generated method stub
		
	}

	
}
