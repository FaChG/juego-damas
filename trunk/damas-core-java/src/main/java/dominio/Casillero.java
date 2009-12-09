package dominio;

import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;

import excepciones.NoExisteCasilleroDisponibleException;

public abstract class Casillero extends Entidad{
	
	private static final long serialVersionUID = -786502683990149694L;
	protected int x;
	protected int y;
	public abstract Ficha obtenerFicha();
	public abstract boolean isOcupada();
	protected abstract String getType();
	protected abstract void ocupado();
	protected abstract void desOcupado();
	public abstract List<CasilleroNegro> obtenerCasillerosDesocupadosDerecha(String color,boolean adelante);
	public abstract List<CasilleroNegro> obtenerCasillerosDesocupadosIzquierda(String color,boolean adelante);
	public abstract List<CasilleroNegro> getCasillerosDisponibles();
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(!this.getClass().equals(obj.getClass())){
			return false;
		}
		Casillero casillero = (Casillero) obj;
		if(this.getId()== null || !this.getId().equals(casillero.getId()) ){
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int returnint = HashCodeBuilder.reflectionHashCode(this.getId());
		return returnint;
	}

	@Override
	public String toString() {
		return "x" + this.x + "y" + this.y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean tenesFichaContrario(Jugador jugador) {
		if(!this.isOcupada()){
			return false;
		}
		if(!obtenerFicha().sosDelContrario(jugador)){
			return false;
		}
		return true;
	}
	public void eliminaFicha() {
		obtenerFicha().eliminate();
	}
	public Casillero dameCasilleroAnterior(boolean soyContrincante,
			List<CasilleroNegro> casillasNegras, boolean casilleroDerecha, Class class1) throws NoExisteCasilleroDisponibleException {
		Casillero casillero = null;
		Ficha ficha = obtenerFicha();
		List<CasilleroNegro> casilleros;
		if(casilleroDerecha){
//			casilleros = vecinoDiagonalIzquierdaAtras(ficha);
//			if(casilleros != null && !casilleros.isEmpty()){
//				casillero = casilleros.get(0);
//			}
		}else{
//			casilleros = vecinoDiagonalDerechaAtras(ficha);
//			if(casilleros != null && !casilleros.isEmpty()){
//				casillero = casilleros.get(0);
//			}
		}
		return casillero;
	}
	public void generateId() {
		this.setIdEntity(this.toString());
	}
	
}