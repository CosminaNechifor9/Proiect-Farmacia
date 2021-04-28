import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Farmacia extends JFrame {

	private JPanel contentPane;
	private JLabel lblEnunt_farmacii;
	private JButton btnAfisare_farmacii;
	private JLabel lblAfisare_farmacii;
	/**
	 * Launch the application.
	 */

	private JTextField txtMedicament;
	private JTextField txtMed;
	private JTextField txtOras;
	private JButton btnAfisareFarmacii;
	private JButton btnAfisareMedicament;
	private JButton btnAfisareMedOras;
	private DefaultListModel<String> myModel1;
	private DefaultListModel<String> myModel2;

	private DefaultListModel<String> myModel3;

	private DefaultListModel<String> myModel4;

	private DefaultListModel<String> myModel5;

	private DefaultListModel<String> myModel6;

	JList<String> myList1;
	JList<String> myList2;
	JList<String> myList3;
	JList<String> myList4;
	JList<String> myList5;
	JList<String> myList6;


	private JComboBox combOras;
	private JComboBox combOras6;

	public static void main(String[] args) throws SQLException, InstantiationException,IllegalAccessException, ClassNotFoundException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Farmacia frame = new Farmacia();
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

	public Farmacia()throws SQLException, InstantiationException,IllegalAccessException, ClassNotFoundException{ 



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100,100);
		setSize(800, 800);
		getContentPane().setLayout(null);

		JLabel enunt1=new JLabel("Enuntul 1");		
		JLabel lblOras=new JLabel("Alegeti orasul:");
		String []items = { "Bucuresti ", "Cluj ", "Timisoara ", "Iasi "};
		combOras= new JComboBox(items);
		btnAfisareFarmacii=new JButton("Afisare farmacii");
		myList1= new JList<String>();


		JLabel enunt2=new JLabel("Enuntul 2");	
		myList2=new JList<String>();


		JLabel enunt3=new JLabel("Enuntul 3");	
		myList3=new JList<String>();

		JLabel enunt4=new JLabel("Enuntul 4");	
		myList4=new JList<String>();

		JLabel enunt5=new JLabel("Enuntul 5");	
		JLabel lblMedicament=new JLabel("Introduceti medicamentul:");
		txtMedicament=new JTextField();
		btnAfisareMedicament=new JButton("Afisare medicament");
		myList5=new JList<String>();


		JLabel enunt6=new JLabel("Enuntul 6");	
		JLabel lblMed=new JLabel("Introduceti medicamentul:");
		txtMed=new JTextField();
		JLabel lblOras6=new JLabel("Alegeti orasul:");
		combOras6= new JComboBox(items);
		btnAfisareMedOras=new JButton("Afisare");
		myList6=new JList<String>();


		myModel1=new DefaultListModel<String>();
		myModel2=new DefaultListModel<String>();
		myModel3=new DefaultListModel<String>();
		myModel4=new DefaultListModel<String>();
		myModel5=new DefaultListModel<String>();
		myModel6=new DefaultListModel<String>();

		enunt1.setBounds(20,10,120,20);

		lblOras.setBounds(20,40,120,20);
		combOras.setBounds(120, 40, 150, 20);
		btnAfisareFarmacii.setBounds(290,40,150,20);
		myList1.setBounds(20,80,350,20);

		enunt2.setBounds(20,120,120,20);
		myList2.setBounds(20,140,550,20);

		enunt3.setBounds(20,180,120,20);
		myList3.setBounds(20,200,550,20);

		enunt4.setBounds(20,240,120,20);
		myList4.setBounds(20,260,550,20);

		enunt5.setBounds(20,300,120,20);
		lblMedicament.setBounds(20,320,150,20);
		txtMedicament.setBounds(180, 320, 150, 20);
		btnAfisareMedicament.setBounds(350, 320, 150, 20);
		myList5.setBounds(20,350,550,20);

		enunt6.setBounds(20,380,120,20);
		lblMed.setBounds(20,400,150,20);
		txtMed.setBounds(180, 400, 150, 20);
		lblOras6.setBounds(20,420,120,20);
		combOras6.setBounds(180, 420, 150, 20);
		btnAfisareMedOras.setBounds(120, 450, 150, 20);
		myList6.setBounds(20,480,550,20);


		getContentPane().add(enunt1);
		getContentPane().add(lblOras);
		getContentPane().add(combOras);
		getContentPane().add(myList1);
		getContentPane().add(btnAfisareFarmacii);

		getContentPane().add(enunt2);
		getContentPane().add(myList2);

		getContentPane().add(enunt3);
		getContentPane().add(myList3);

		getContentPane().add(enunt4);
		getContentPane().add(myList4);

		getContentPane().add(enunt5);
		getContentPane().add(lblMedicament);
		getContentPane().add(txtMedicament);
		getContentPane().add(btnAfisareMedicament);
		getContentPane().add(myList5);

		getContentPane().add(enunt6);
		getContentPane().add(lblMed);
		getContentPane().add(txtMed);
		getContentPane().add(lblOras6);
		getContentPane().add(combOras6);
		getContentPane().add(btnAfisareMedOras);
		getContentPane().add(myList6);

		btnAfisareFarmacii.addActionListener(new ButonApasat());
		btnAfisareMedicament.addActionListener(new ButonApasat());
		btnAfisareMedOras.addActionListener(new ButonApasat());
		
		setVisible(true);


		String url = "jdbc:mysql://localhost:3306/farmacie";
		Class.forName ("com.mysql.cj.jdbc.Driver").newInstance ();
		Connection con = DriverManager.getConnection (url, "root", "root");
		Statement sql;
		ResultSet rs;
		sql = con.createStatement();
		int nr=0;
		
		// Cerinta 2
		rs = sql.executeQuery("select Count(*) as total from comanda, farmacie where comanda.cod_farmacie=farmacie.cod_farmacie and farmacie.nume='Farmacia Dona' and month(comanda.data_livrare)=8");
		while (rs.next())
		{
			nr= rs.getInt("total");
			//System.out.println( rs.getInt("total"));

		}


		int total=0;
		rs = sql.executeQuery("select cantitate from medicamente_comandate,comanda, farmacie where comanda.cod_farmacie=farmacie.cod_farmacie and farmacie.nume='Farmacia Dona' and month(comanda.data_livrare)=8 and comanda.cod_comanda=medicamente_comandate.cod_comanda");;
		while (rs.next())
		{
			total=total+rs.getInt("cantitate");
			//System.out.println( rs.getInt("cantitate"));

		}
		//System.out.println( total);
		//System.out.println("-");
		//System.out.println( total/nr);
		
		String cerinta2="numar comenzi: "+nr+",total medicamente comandate: "+total+",valoarea medie: "+total/nr;
		myModel2.addElement(cerinta2.toString());
		myList2.setModel(myModel2);
		
		
		//Cerinta 3
		String cerinta3="";
		int antibiotic=0;
		rs = sql.executeQuery("select count(*) as antibiotice from comanda,medicamente_comandate, farmacie, categorii_medicamente where comanda.cod_farmacie=farmacie.cod_farmacie and farmacie.nume='Farmacia Vlad' and year(comanda.data_livrare)=2020 and comanda.cod_comanda=medicamente_comandate.cod_comanda and medicamente_comandate.cod_medicament =categorii_medicamente.cod_medicament and categorii_medicamente.nume_categorie='antibiotic'");
		while (rs.next())
		{
			antibiotic=rs.getInt("antibiotice");
			//System.out.println( rs.getInt("antibiotice"));
		}
		cerinta3= "total comenzi antibiotice: "+antibiotic;
		myModel3.addElement(cerinta3.toString());
		myList3.setModel(myModel3);
		
		
		//cerinta 4
		String cerinta4="";
		String nume4="";
		int maxim=0;
		rs = sql.executeQuery("select farmacie.nume, max(y.val_absoluta) as maxim from(select count(*) as val_absoluta  from comanda,farmacie where comanda.cod_farmacie=farmacie.cod_farmacie  and year(comanda.data_livrare)=2020 group by farmacie.nume)y, farmacie");
		while (rs.next())
		{
			nume4=rs.getString("farmacie.nume");
			maxim=rs.getInt("maxim");
			//System.out.println( rs.getString("farmacie.nume"));
			//System.out.println( rs.getInt("maxim"));
		}
		cerinta4=nume4+","+maxim+" comenzi";
		myModel4.addElement(cerinta4.toString());
		myList4.setModel(myModel4);
		
		
	}

	class ButonApasat  implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();

			String url = "jdbc:mysql://localhost:3306/farmacie";
			try {
				Class.forName ("com.mysql.cj.jdbc.Driver").newInstance ();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Connection con = null;
			try {
				con = DriverManager.getConnection (url, "root", "root");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Statement sql;
			//ResultSet rs;
			try {
				sql = con.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (source == btnAfisareFarmacii)
			{
				myModel1.clear();
				PreparedStatement pr = null;
				try {
					pr = con.prepareStatement("select * from farmacie where oras=?");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					pr.setString(1, (String) combOras.getSelectedItem());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet rs = null;
				try {
					rs = pr.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String farmacii = "";
				try {
					while (rs.next())
					{
						farmacii= farmacii+"  "+ rs.getString("nume");
						//System.out.println( rs.getString("nume"));

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				myModel1.addElement(farmacii.toString());
				myList1.setModel(myModel1);
			}
			
			
			if (source == btnAfisareMedicament)
			{
				myModel5.clear();
				PreparedStatement pr = null;
				try {
					pr=con.prepareStatement("select farmacie.nume, farmacie.oras  from stoc,medicament, farmacie  where stoc.cod_farmacie=farmacie.cod_farmacie  and stoc.cod_medicament=medicament.cod_edicament and medicament.nume_medicament=? and stoc.cantitate>0");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					pr.setString(1,  txtMedicament.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet rs = null;
				try {
					rs = pr.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String cerinta5="";
				try {
					while (rs.next())
					{
						cerinta5=cerinta5+"   "+rs.getString("farmacie.nume")+" "+rs.getString("farmacie.oras");
						//System.out.println( rs.getString("farmacie.nume")+" "+rs.getString("farmacie.oras")+",");

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				myModel5.addElement(cerinta5.toString());
				myList5.setModel(myModel5);
			}
			if (source == btnAfisareMedOras)
			{
				myModel6.clear();
				PreparedStatement pr = null;
				try {
					pr=con.prepareStatement("select  sum(stoc.cantitate) as suma_stoc  from stoc,medicament, farmacie  where stoc.cod_farmacie=farmacie.cod_farmacie  and stoc.cod_medicament=medicament.cod_edicament and medicament.nume_medicament=? and farmacie.oras=?");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					pr.setString(1,  txtMed.getText());
					pr.setString(2,  (String) combOras6.getSelectedItem());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet rs = null;
				try {
					rs = pr.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				int stoc=0;
				String cerinta6="";
				try {
					while (rs.next())
					{
						stoc=rs.getInt("suma_stoc");
						//System.out.println( rs.getInt("suma_stoc"));

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cerinta6=txtMed.getText()+" "+ (String) combOras6.getSelectedItem()+": "+stoc;
				myModel6.addElement(cerinta6.toString());
				myList6.setModel(myModel6);
			}
		}
	}
}