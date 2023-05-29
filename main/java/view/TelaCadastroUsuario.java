package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import controller.UsuarioController;
import model.vo.UsuarioVO;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroUsuario {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField txtNome;
	
	private UsuarioController usuarioControler;
	private UsuarioVO usuarioVO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario window = new TelaCadastroUsuario();
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
	public TelaCadastroUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		frame = new JFrame();
		
		frame.setUndecorated(true);
		
		frame.setBounds(100, 100, 901, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		//mover componentes no painel
	 	panel.setLayout(null);
		panel.setBackground(new Color(25, 118, 211));
		panel.setBounds(0, 0, 901, 491);
		frame.getContentPane().add(panel);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(264, 139, 386, 24);
		panel.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(264, 216, 386, 24);
		panel.add(lblSenha);
		
		textField = new JTextField();
		textField.setSelectionColor(new Color(25, 118, 211));
		textField.setSelectedTextColor(new Color(25, 118, 211));
		textField.setForeground(new Color(25, 118, 211));
		textField.setDisabledTextColor(new Color(25, 118, 211));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(264, 173, 347, 19);
		panel.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(264, 250, 347, 19);
		panel.add(passwordField);
		
		JLabel lblDisable = new JLabel("");
		lblDisable.setBounds(621, 252, 29, 24);
		panel.add(lblDisable);
		
		JLabel lblShow = new JLabel("");
		lblShow.setBounds(621, 252, 29, 24);
		panel.add(lblShow);
		
		txtNome = new JTextField();
		txtNome.setSelectionColor(new Color(25, 118, 211));
		txtNome.setSelectedTextColor(new Color(25, 118, 211));
		txtNome.setForeground(new Color(25, 118, 211));
		txtNome.setDisabledTextColor(new Color(25, 118, 211));
		txtNome.setColumns(10);
		txtNome.setBackground(Color.WHITE);
		txtNome.setBounds(264, 97, 347, 19);
		panel.add(txtNome);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(264, 63, 386, 24);
		panel.add(lblNome);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuarioControler = new UsuarioController();
				usuarioVO = new UsuarioVO();
				try {
					usuarioControler.cadastrarUsuarioController(usuarioVO);

					JOptionPane.showMessageDialog(null, "Erro ao realizar cadastro!", "Erro",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception excecao) {
					JOptionPane.showMessageDialog(null, excecao.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCadastrar.setForeground(new Color(25, 118, 211));
		btnCadastrar.setBounds(395, 323, 85, 21);
		panel.add(btnCadastrar);
		
		JLabel lblNewLabel = new JLabel(" voltar");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel.setIcon(new ImageIcon("D:\\Downloads\\.opera\\deixou.png"));
		lblNewLabel.setBounds(10, -19, 111, 88);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("X");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_6.setBounds(881, 0, 20, 21);
		panel.add(lblNewLabel_6);
		
		
	}
	
	public void tornarVisivelForaDoFrame(TelaCadastroUsuario telaVisivel) {
			frame.setVisible(true);
		}
	}


