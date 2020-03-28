import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;;
public class TesteJAVA {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteJAVA window = new TesteJAVA();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TesteJAVA() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 471, 254);
		frame.setLocationRelativeTo(null); // toda vez que abrir centralizar a tela
		frame.setResizable(false); //responsivo
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 465, 225);
		panel.setBackground(Color.decode("#ffcc80"));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("J-Date");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(189, 5, 120, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Informe a data incial");
		lblNewLabel_1.setBounds(20, 75, 142, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblDataFinalA = new JLabel("Data de Hoje");
		lblDataFinalA.setBounds(337, 75, 113, 21);
		panel.add(lblDataFinalA);
		
		//Retornando a data de hoje a ser calculada.
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea.setBounds(319, 92, 98, 22);
		panel.add(textArea);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date HJ = new Date();
		textArea.setText(formato.format(HJ));
		
		JLabel lblInformeAData = new JLabel("Informe a data Final");
		lblInformeAData.setBounds(167, 75, 142, 21);
		panel.add(lblInformeAData);
		
		JLabel lblNewLabel_3 = new JLabel("OBS: Caso queira utilizar a data de Hoje como final, basta informar a data Inicial");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 37, 440, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CopyRight by Jaum.");
		lblNewLabel_4.setBounds(329, 197, 126, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u00C1rea Resultado");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 120, 401, 64);
		panel.add(lblNewLabel_5);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(20, 92, 113, 20);
		dateChooser.setDateFormatString("dd/MM/yyyy"); //formato quando selecionar pelo calendário
		panel.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(167, 92, 113, 20);
		dateChooser_1.setDateFormatString("dd/MM/yyyy"); //formato quando selecionar pelo calendário
		panel.add(dateChooser_1);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setBackground(new Color(184, 134, 11));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
				Calendar myNextCalendar = Calendar.getInstance();
				Calendar myNextCalendar2 = Calendar.getInstance();
				int dia,mes,ano;
				int dia2,mes2,ano2;
				Date hoje = new Date();
				
				String input = String.valueOf(dateChooser.getDate());
				String input2 = String.valueOf(dateChooser_1.getDate());
				
				//caso o primeiro campo esteja vazio
				
				if(dateChooser.getDate() == null && dateChooser_1.getDate() == null) {
					JOptionPane.showMessageDialog(null,"Pare de sacanear e preencha algum campo!");
					//return;
				}
				//caso primeiro esteja vazio e o segundo não
				if(dateChooser.getDate() == null && dateChooser_1.getDate() != null) {
					lblNewLabel_5.setText("Favor preencher o Primeiro Campo");
					return;
				}
				
				
				//caso primeiro campo seja vazio, calcule com a data do sistema
				if(dateChooser_1.getDate() == null) {
					Date dataHJ = new Date();
						int var1 = dataHJ.compareTo(dateChooser.getDate());
					if(var1 < 0) {
						JOptionPane.showMessageDialog(null,"Data inicial não pode ser maior que a do sistema");
						return;
					}
					input = formato.format(dateChooser.getDate());
					
					dia = Integer.parseInt(input.substring(0,2));
					mes = Integer.parseInt(input.substring(3,5));
					ano = Integer.parseInt(input.substring(6,10));
					mes = mes - 1;
					myNextCalendar.set(ano,mes,dia);
					
					//Date hoje = new Date();
					Date nyd = myNextCalendar.getTime();
					
					TesteJAVA meuObjeto = new TesteJAVA();
					long dias = meuObjeto.calculoData(nyd,hoje);
			
					String dataHj = formato.format(hoje); 
					String novaData = formato.format(nyd);
					
					lblNewLabel_5.setText("A diferença entre "+novaData+" e "+dataHj+" é "+dias+" dias");
					JOptionPane.showMessageDialog(null,"Calculo realizado com Sucesso, totalizando " + dias + " dias");	
					
				}
				int var1 = dateChooser.getDate().compareTo(dateChooser_1.getDate());
				
				if(var1 > 0) {
					JOptionPane.showMessageDialog(null,"A data inicial não pode ser maior que a final");
					return;
				}
				
				if(dateChooser.getDate() != null && dateChooser_1.getDate() != null){//ele calcula as duas datas
					
					//formatando para entrar na substring
					input = formato.format(dateChooser.getDate());
					input2 = formato.format(dateChooser_1.getDate());
					//---------------------------------------------
					
					dia = Integer.parseInt(input.substring(0,2));
					mes = Integer.parseInt(input.substring(3,5));
					ano = Integer.parseInt(input.substring(6,10));
					mes = mes - 1;
					myNextCalendar.set(ano,mes,dia);
					
					dia2 = Integer.parseInt(input2.substring(0,2));
					mes2 = Integer.parseInt(input2.substring(3,5));
					ano2 = Integer.parseInt(input2.substring(6,10));
					mes2 = mes2 - 1;
					myNextCalendar2.set(ano2,mes2,dia2);
					
					Date nyd = myNextCalendar.getTime();
					Date nyd2 = myNextCalendar2.getTime();
					
					TesteJAVA meuObjeto = new TesteJAVA();
					long dias = meuObjeto.calculoData(nyd,nyd2);
			
					String dataHj = formato.format(nyd); 
					String novaData = formato.format(nyd2);
					
					lblNewLabel_5.setText("A diferença entre "+dataHj+" e "+novaData+" é "+dias+" dias");
					JOptionPane.showMessageDialog(null,"Calculo realizado com Sucesso, totalizando " + dias + " dias");
				}else{
					JOptionPane.showMessageDialog(null,"Algum erro ocorreu, favor contatar o código fonte.");
				}
				
			}
		});
		btnNewButton.setBounds(167, 191, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Acessar nova janela");
		lblNewLabel_2.setBounds(10, 175, 123, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Clique Aqui");
		btnNewButton_1.setBackground(new Color(250, 250, 210));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Janela objeto = new Janela();
				objeto.iniciando();
			}
		});
		btnNewButton_1.setBounds(10, 193, 123, 23);
		panel.add(btnNewButton_1);
		//------------------------------------------
	}
	public long calculoData (Date um, Date dois){
		long diferenca = (um.getTime()-dois.getTime())/86400000; //milissegundos
		return Math.abs(diferenca);
	}
}