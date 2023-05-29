package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

import controller.UsuarioController;
import model.vo.UsuarioVO;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin {

	private JFrame frame;
	private final JLabel lblNewLabel_1 = new JLabel("New label");
	private final JLabel lblNewLabel_2 = new JLabel("New label");
	private JTextField txtEmail;
	private JPasswordField txtSenha;

	private JLabel lblDisable;
	private JLabel lblShow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
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
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 901, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(-26, -29, 466, 483);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Downloads\\.opera\\LoginForm\\src\\icon\\bg-login.png"));
		lblNewLabel.setBounds(26, 134, 414, 253);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(25, 118, 211));
		panel_1.setBounds(441, -29, 446, 483);
		frame.getContentPane().add(panel_1);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("New label");
		panel_1.add(lblNewLabel_3);
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("Login");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		lblNewLabel_4.setBounds(183, 78, 91, 56);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Olá! seja bem vindo");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(158, 132, 148, 13);
		panel_1.add(lblNewLabel_5);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(42, 174, 386, 24);
		panel_1.add(lblEmail);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Downloads\\.opera\\LoginForm\\src\\icon\\icons8_user_20px_1.png"));
		lblNewLabel_8.setBounds(399, 194, 47, 48);
		panel_1.add(lblNewLabel_8);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(42, 252, 386, 24);
		panel_1.add(lblSenha);

		JCheckBox cbxLembrarSenha = new JCheckBox("Lembrar senha");
		cbxLembrarSenha.setHorizontalAlignment(SwingConstants.LEFT);
		cbxLembrarSenha.setBackground(new Color(25, 118, 211));
		cbxLembrarSenha.setForeground(new Color(255, 255, 255));
		cbxLembrarSenha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cbxLembrarSenha.setBounds(42, 317, 124, 24);
		panel_1.add(cbxLembrarSenha);

		JLabel lblEsqueciSenha = new JLabel("Esqueci minha senha");
		lblEsqueciSenha.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEsqueciSenha.setForeground(new Color(255, 255, 255));
		lblEsqueciSenha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEsqueciSenha.setBounds(284, 321, 144, 17);
		panel_1.add(lblEsqueciSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioController usuarioController = new UsuarioController();
				UsuarioVO novoUsuario = new UsuarioVO();
				try {
					usuarioController.realizarLoginController(novoUsuario);

					JOptionPane.showMessageDialog(null, "Erro ao realizar login!", "Erro",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception excecao) {
					JOptionPane.showMessageDialog(null, excecao.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEntrar.setBackground(new Color(255, 255, 255));
		btnEntrar.setForeground(new Color(25, 118, 211));
		btnEntrar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnEntrar.setBounds(138, 365, 165, 29);
		panel_1.add(btnEntrar);

		JLabel lblNewLabel_11 = new JLabel("Não possui conta?");
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel_11.setBounds(148, 404, 91, 13);
		panel_1.add(lblNewLabel_11);

		JLabel lblCadastrar = new JLabel("Cadastrar-se");
		lblCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UsuarioController usuarioController = new UsuarioController();
				UsuarioVO novoUsuario = new UsuarioVO();
				try {
					usuarioController.cadastrarUsuarioController(novoUsuario);

					JOptionPane.showMessageDialog(null, "Erro ao realizar cadastro!", "Erro",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception excecao) {
					JOptionPane.showMessageDialog(null, excecao.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		lblCadastrar.setForeground(new Color(255, 255, 255));
		lblCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblCadastrar.setBounds(237, 398, 69, 24);
		panel_1.add(lblCadastrar);

		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(25, 118, 211));
		txtEmail.setSelectedTextColor(new Color(25, 118, 211));
		txtEmail.setSelectionColor(new Color(25, 118, 211));
		txtEmail.setDisabledTextColor(new Color(25, 118, 211));
		txtEmail.setBackground(new Color(255, 255, 255));
		txtEmail.setBounds(42, 208, 347, 19);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(42, 292, 347, 19);
		panel_1.add(txtSenha);

		lblDisable = new JLabel("");
		lblDisable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSenha.setEchoChar((char) 0);

				lblDisable.setVisible(false);
				lblDisable.setEnabled(false);
				lblShow.setEnabled(true);
				lblShow.setEnabled(true);
			}
		});
		lblDisable.setIcon(new ImageIcon("D:\\Downloads\\.opera\\LoginForm\\src\\icon\\icons8_eye_20px_1.png"));
		lblDisable.setBounds(399, 287, 29, 24);
		panel_1.add(lblDisable);

		lblShow = new JLabel("");
		lblShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSenha.setEchoChar((char) 8226);

				lblDisable.setVisible(true);
				lblDisable.setEnabled(true);
				lblShow.setEnabled(false);
				lblShow.setEnabled(false);
			}
		});
		lblShow.setIcon(new ImageIcon("D:\\Downloads\\.opera\\LoginForm\\src\\icon\\icons8_invisible_20px_1.png"));
		lblShow.setBounds(399, 287, 29, 24);
		panel_1.add(lblShow);

	}
}
