package dominio;

import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;

import excepciones.NoExisteCasilleroDisponibleException;

public abstract class Casillero extends Entidad{
	
	private static final long serialVersionUID = -786502683990149694L;
	protected static final String BLANCO = "BLANCO";
	protected int x;
	protected int y;
	protected List<Casillero> vecinos;
	
	
	protected Ficha ficha;
	public void cambiarFicha(Ficha ficha){
		this.ficha = ficha;
	}
	public Ficha getFicha() {
		return ficha;
	}
	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}
	public boolean isOcupada(){
		if(ficha == null) return false;
		return true;
	}
	protected abstract String getType();
	public abstract List<Casillero> vecinoDiagonalDerecha(List<Casillero> casillerosNegros, boolean soyContrincante);
	public abstract List<Casillero> vecinoDiagonalIzquierda(List<Casillero> casillerosNegros, boolean soyContrincante);
	public abstract List<Casillero> vecinoDiagonalDerechaAtras(List<Casillero> casillerosNegros, boolean soyContrincante);
	public abstract List<Casillero> vecinoDiagonalIzquierdaAtras(List<Casillero> casillerosNegros, boolean soyContrincante);
	public abstract List<Casillero> getCasillerosDisponibles();
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
	public abstract List<Casillero> getVecinos(Ficha ficha,List<Casillero> casillerosNegros);
	public void setVecinos(List<Casillero> vecinos) {
		this.vecinos = vecinos;
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
		if(!this.ficha.sosDelContrario(jugador)){
			return false;
		}
		return true;
	}
	public void eliminaFicha() {
		this.ficha.eliminate();
		this.ficha = null;
	}
	public Casillero dameCasilleroAnterior(boolean soyContrincante,
			List<Casillero> casillasNegras, boolean casilleroDerecha) throws NoExisteCasilleroDisponibleException {
		Casillero casillero = null;
		List<Casillero> casilleros;
		if(casilleroDerecha){
			casilleros = vecinoDiagonalIzquierdaAtras(casillasNegras,this.ficha.esDeContrincante());
			if(casilleros != null && !casilleros.isEmpty()){
				casillero = casilleros.get(0);
			}
		}else{
			casilleros = vecinoDiagonalDerechaAtras(casillasNegras,this.ficha.esDeContrincante());
			if(casilleros != null && !casilleros.isEmpty()){
				casillero = casilleros.get(0);
			}
		}
		return casillero;
	}
	public void generateId() {
		this.setIdEntity(this.toString());
	}
	
}