package ejercicios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.util.ListIterator;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Principal extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static DefaultListModel<Peliculas> DLModel = new DefaultListModel<Peliculas>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPeliculas = new JMenu("Peliculas");
		menuBar.add(mnPeliculas);
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				AgregarPelicula ap = new AgregarPelicula();
				ap.SetDefaultListModel(DLModel);
				contentPane.add(ap);
				contentPane.repaint();
				contentPane.revalidate();
				
				
			}
		});
		mnPeliculas.add(mntmAgregar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrdenarLista();
				
				
				
				
				contentPane.removeAll();
				ListarPelicula lp = new ListarPelicula();
				lp.SetDefaultListModel(DLModel);
				contentPane.add(lp);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnPeliculas.add(mntmListar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public void OrdenarLista() {
		TreeSet<Peliculas> tp = new TreeSet<>();
		
		
		for(int i=0;i<DLModel.getSize();i++) {
			tp.add(DLModel.getElementAt(i));
		}
		
		DLModel.clear();
		
		
		for (Peliculas pel : tp) {
			DLModel.addElement(pel);
		}
		
		
	}
	
	
	
}
