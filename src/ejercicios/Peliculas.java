package ejercicios;

public class Peliculas implements Comparable<Peliculas>{
	private int id;
	private String Nombre;
	private Categorias genero;
	private static int cont=0;
	
	public Peliculas(String nombre, Categorias genero) {
		super();
		cont++;
		this.id = cont;
		Nombre = nombre;
		this.genero = genero;
	}
	
	public Peliculas() {
		cont++;
		this.id = cont;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public Categorias getGenero() {
		return genero;
	}
	
	public void setGenero(Categorias genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return  "Pelicula: "+id +" - " + Nombre + " - " + genero;
	}

	@Override
	public int compareTo(Peliculas o) {
		if(Nombre.equals(o.Nombre)) {
			if(this.id>o.id) {
				return 1;
			}
			else return -1;
		}
		return this.Nombre.compareTo(o.Nombre);
		
		
		
	}
	
	

}
