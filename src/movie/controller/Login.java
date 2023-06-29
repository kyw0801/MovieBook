package movie.controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import movie.dao.UserDAO;
import movie.dto.UserDTO;

public class Login extends JFrame implements ActionListener{
	JLabel id_label=new JLabel("아이디");  	static JTextField id_field = new JTextField();
	JLabel pwd_label=new JLabel("비밀번호"); JPasswordField pwd_field = new JPasswordField();
	JButton login_button = new JButton("로그인");
	JLabel find_idpwd = new JLabel("ID/PW찾기");
	JLabel signup = new JLabel("회원가입");
	
	// 이미지
	Container cPane;
	// 로고
	ImageIcon Logoicon; JLabel Logo;
	
	public Login() {
		Color BGColor = new Color(23, 28, 45);
		Color btnColor = new Color(37, 66, 82);

		Font titleFnt = new Font("돋움",Font.BOLD,30);
		Font basicFnt = new Font("견고딕",Font.BOLD,20);
      
		id_label.setBounds(40, 170, 150,30);
		id_label.setFont(basicFnt);
		id_label.setForeground(Color.white);
		
		  
		id_field.setBounds(160, 170, 185,30);
		id_field.setFont(basicFnt);
		
		    
		pwd_label.setBounds(40, 240, 140,30);
		pwd_label.setFont(basicFnt);
		pwd_label.setForeground(Color.white);
		
		   //pwd입력 시, 입력 내용 가려져서 나옴
		pwd_field.setBounds(160, 240,185,30);
		pwd_field.setFont(basicFnt);
		
		    
		login_button.setBounds(40, 320, 305,50);    
		login_button.setFont(basicFnt);
		login_button.setForeground(Color.white);
		login_button.setBackground(btnColor);
		
		    
		find_idpwd.setBounds(250, 410, 140,30);    
		find_idpwd.setFont(basicFnt);
		find_idpwd.setForeground(Color.white);
		find_idpwd.setBackground(btnColor);
		
		
		signup.setBounds(40, 410, 140,30);    
		signup.setFont(basicFnt);
		signup.setForeground(Color.white);
		signup.setBackground(btnColor);
		

		add(id_label);
		add(id_field);	
		add(pwd_label);
		add(pwd_field);	
		add(find_idpwd);
		add(login_button);	
		add(signup);
		
		
		setTitle("로그인 창");
		setSize(400, 500);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false); //화면 창 고정
		getContentPane().setBackground(BGColor);
		
		// 이미지
		cPane = getContentPane();
		cPane.setLayout(null);

		// 로고
		Logoicon = new ImageIcon("./images/logo/logo.png");
		Logo = new JLabel(Logoicon);
		Logo.setBounds(0, -165, getWidth(), getHeight());
		cPane.add(Logo);
				
		setVisible(true);
	
		//버튼 클릭시
		login_button.addActionListener(this);
		
		
		//회원가입 TextField 마우스 어뎁터사용하여 이벤트 등록
		signup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Signup sign = new Signup(); // 회원가입 페이지로 이동
			}
		});
		
		// 비번찾기 버튼 이벤트
		find_idpwd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new IdFind();
			}
		});
		
	}// 생성자
	
	//이벤트 등록
	@Override
	public void actionPerformed(ActionEvent e) {
	
		String btn = e.getActionCommand();
		
		if(btn.equals("회원가입")) {
			Signup sign = new Signup();
		}
		if(btn.equals("ID/Pw찾기")) {
			IdFind find = new IdFind();
		}
		if(btn.equals("로그인")) {
			if(id_field.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "아이디를입력하세요.");
				id_field.requestFocus();
			}else if(pwd_field.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요.");
				pwd_field.requestFocus();
			}else {
					String id = id_field.getText().trim();
					String pwd = pwd_field.getText().trim();
				
					UserDAO search = new UserDAO();
					List<UserDTO> result = search.userLogin(id,pwd);
					
				if(result.size() > 0) {
					JOptionPane.showMessageDialog(this, id_field.getText()+"로그인성공 했습니다.");
					Main main = new Main();
					dispose();
				}else {
					JOptionPane.showMessageDialog(this, id_field.getText()+"로그인 실패하였습니다.");
				}
			}
		}
	}
	public static void main(String[] args) {
		new Login();
	}
}
