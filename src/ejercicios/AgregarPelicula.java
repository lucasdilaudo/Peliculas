package ejercicios;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AgregarPelicula extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JComboBox<Categorias> comboBoxGen;
	private JLabel lblValorID;
	private static int aux=1; 
	private DefaultListModel<Peliculas> DLModel;

	/**
	 * Create the panel.
	 */
	public AgregarPelicula() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{72, 74, 41, 102, 153, 0};
		gridBagLayout.rowHeights = new int[]{34, 14, 22, 0, 14, 20, 40, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("ID:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);
		
		lblValorID = new JLabel(String.valueOf(aux));
		GridBagConstraints gbc_lblValorID = new GridBagConstraints();
		gbc_lblValorID.anchor = GridBagConstraints.WEST;
		gbc_lblValorID.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorID.gridx = 3;
		gbc_lblValorID.gridy = 1;
		add(lblValorID, gbc_lblValorID);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		add(lblNombre, gbc_lblNombre);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridx = 3;
		gbc_textFieldNombre.gridy = 3;
		add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero:");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.WEST;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 1;
		gbc_lblGenero.gridy = 5;
		add(lblGenero, gbc_lblGenero);
		
		comboBoxGen = new JComboBox<Categorias>();
		GridBagConstraints gbc_comboBoxGen = new GridBagConstraints();
		gbc_comboBoxGen.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxGen.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxGen.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxGen.gridx = 3;
		gbc_comboBoxGen.gridy = 5;
		add(comboBoxGen, gbc_comboBoxGen);
		comboBoxGen.addItem(new Categorias("Seleccione un genero"));
		comboBoxGen.addItem(new Categorias("Terror"));
		comboBoxGen.addItem(new Categorias("Accion"));
		comboBoxGen.addItem(new Categorias("Suspenso"));
		comboBoxGen.addItem(new Categorias("Romantica"));
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validacionesAgregar()) {
					//setear pelicula
					
					Peliculas peli = new Peliculas();
					peli.setNombre(textFieldNombre.getText().trim());
					peli.setGenero(new Categorias(comboBoxGen.getSelectedItem().toString()));								
					//pasar a model, J list
					DLModel.addElement(peli);
					
					//
					JOptionPane.showMessageDialog(null,peli.toString(),"PELICULA AGREGADA",-1);
					
					textFieldNombre.setText("");
					comboBoxGen.setSelectedIndex(0);
					aux++;
					lblValorID.setText(String.valueOf(aux));
					
				}
				//else {
					//JOptionPane.showMessageDialog(null, "error");
				//}
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 7;
		add(btnAceptar, gbc_btnAceptar);

	}
	
	public boolean validacionesAgregar() {
		if(textFieldNombre.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error: ingrese un nombre");
			return false;
		}
		if(comboBoxGen.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(null, "Error: Seleccione un genero");
			return false;
		}
		
		return true;		
	}
	
	public void SetDefaultListModel(DefaultListModel<Peliculas> DLM) {
		DLModel = DLM;
	}


}
