package ejercicios;

import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.JList;

import java.util.TreeSet;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;

public class ListarPelicula extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<Peliculas> listPeliculas;
	private DefaultListModel<Peliculas> DLModel;

	/**
	 * Create the panel.
	 */
	public ListarPelicula() {
		setLayout(null);
		
		listPeliculas = new JList<Peliculas>();
		listPeliculas.setBounds(103, 33, 309, 217);
		add(listPeliculas);
		
		JLabel lblPeliculas = new JLabel("Peliculas");
		lblPeliculas.setBounds(26, 133, 67, 14);
		add(lblPeliculas);
		
	}
	
	public void SetDefaultListModel(DefaultListModel<Peliculas> lista) {
		
		
		
		DLModel = lista;
		
		listPeliculas.setModel(DLModel);
		
		
	}
}
