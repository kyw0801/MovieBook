package movie.controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import movie.dao.UserDAO;
import movie.dto.UserDTO;

public class Withdrawal extends JFrame implements ActionListener {

	// 이미지
	Container cPane;
	// 로고
	ImageIcon LogoRicon; JLabel LogoR;
	
	JLabel pwd = new JLabel("비밀번호 입력");
	JPasswordField pwdF = new JPasswordField();
	JLabel pwdchk = new JLabel("비밀번호 확인");
	JPasswordField pwdchkF = new JPasswordField();
	JButton chk = new JButton("확인");

	public Withdrawal() {

		// 타이틀 및 내용글
		Color BGColor = new Color(23, 28, 45);
		Color back = new Color(37, 66, 82);

		setTitle("회원탈퇴");
		setSize(344, 590);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(BGColor);

		Font mainFt = new Font("견고딕", Font.CENTER_BASELINE, 20);
		Font menuFt = new Font("견고딕", Font.BOLD, 20);
		
		pwd.setFont(mainFt);
		pwd.setForeground(Color.white);
		pwdF.setFont(menuFt);
		
		pwdchk.setFont(mainFt);
		pwdchk.setForeground(Color.white);
		pwdchkF.setFont(menuFt);
		
		chk.setFont(mainFt);
		chk.setForeground(Color.white);
		chk.setBackground(back);
		
		// 레이아웃 위치
		setLayout(null);
		
		add(pwd).setBounds(87, 180, 170, 30);
		pwd.setHorizontalAlignment(JLabel.CENTER);
		
		add(pwdF).setBounds(72, 230, 200, 30);
		
		add(pwdchk).setBounds(87, 300, 170, 30);
		pwdchk.setHorizontalAlignment(JLabel.CENTER);
		
		add(pwdchkF).setBounds(72, 350, 200, 30);
		
		add(chk).setBounds(87, 440, 170, 40);


		// 이미지
		cPane = getContentPane();
		cPane.setLayout(null);

		// 로고
		LogoRicon = new ImageIcon("./images/logo/logoR.png");
		LogoR = new JLabel(LogoRicon);
		LogoR.setBounds(0, -220, getWidth(), getHeight());
		cPane.add(LogoR);

		setVisible(true);
		
		chk.addActionListener(this);

	}


	public static void main(String[] args) {
		new Withdrawal();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		
		if(btn.equals("확인")) {
			if(pwdF.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요.");
				pwdF.requestFocus();
			}else if(pwdchkF.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "비밀번호 확인을 입력하세요.");
				pwdchkF.requestFocus();
			}else if(!pwdF.getText().trim().equals(pwdchkF.getText().trim())) {
				JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
				pwdchkF.requestFocus();
			}else {
				UserDTO withdrawaldto = new UserDTO();
				withdrawaldto.setUser_id(Login.id_field.getText());
				withdrawaldto.setUser_pwd(pwdF.getText().trim());
				
				UserDAO withdrawaldao = new UserDAO();
				int result=withdrawaldao.withdrawal(withdrawaldto);
				
				if(result==1) {
					JOptionPane.showMessageDialog(this, Login.id_field.getText()+"님 정상적으로 탈퇴 되었습니다.");
					System.exit(0);
				}else {
					JOptionPane.showMessageDialog(this, Login.id_field.getText()+"님의 비밀번호가 일치하지 않습니다.");
				}
			}
		}
	}

}
