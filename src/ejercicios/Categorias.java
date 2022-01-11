package ejercicios;

public class Categorias {
	
	private String categoria;
	
	public Categorias() {
		
	}
	
	public Categorias(String cat) {
		this.categoria=cat;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return  categoria;
	}
	

}
