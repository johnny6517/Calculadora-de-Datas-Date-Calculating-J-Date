import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Janela extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void iniciando(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
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
	public Janela() {
		
		setBounds(100, 100, 471, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#ffcc80"));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("J-Date");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(189, 5, 120, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dias");
		lblNewLabel_1.setBounds(20, 78, 142, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblDataFinalA = new JLabel("Data de Hoje");
		lblDataFinalA.setBounds(337, 75, 113, 21);
		panel.add(lblDataFinalA);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea.setBounds(319, 92, 98, 22);
		panel.add(textArea);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		Date HJ = new Date();
		textArea.setText(formato.format(HJ));
		
		JLabel lblNewLabel_3 = new JLabel("OBS: Informe a quantidade de dias e retorne uma data a partir de hoje.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 37, 440, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("\u00C1rea Resultado");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 120, 401, 64);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(20, 96, 39, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setBackground(new Color(184, 134, 11));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
				Date dataFuturo = new Date();
				boolean b = true;
				
				String d;
				
				d = textField.getText().toString();
		
				//Analisando se o usuário digite algo sem ser número
				//==============================================
				char[] c = d.toCharArray(); //convertendo string em um arrayChar
				for (int i = 0; i < c.length; i++ ){
		            // verifica se o char não é um dígito
		            if ( !Character.isDigit(c[i])) {
		                b = false;
		                break;
		            }
		        }
				if(b == false) {
					JOptionPane.showMessageDialog(null,"Por favor digite apenas números sem caracteres ou letras");
					return;
				}
				//Fim da análise
				//=================================================
				
				if(textField.getText()==null || textField.getText().trim().equals("") || d == "") {
					JOptionPane.showMessageDialog(null,"Favor colocar algum valor");
					return;
				}
				int a = Integer.parseInt(d.replaceAll(",","").replace(".",""));
				 
				dataFuturo.setDate(dataFuturo.getDate()+a);
				
				lblNewLabel_2.setText("Com "+a+" dias, a data retornada é "+formato.format(dataFuturo));
			}
		});
		btnNewButton.setBounds(163, 176, 89, 23);
		panel.add(btnNewButton);
	}
}
