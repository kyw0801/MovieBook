package movie.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import movie.dao.UserDAO;
import movie.dto.UserDTO;

public class IdFind extends JFrame implements ActionListener{

	JLabel title=new JLabel("아이디 찾기");
	JLabel name=new JLabel("이름");
	JTextField nameField = new JTextField(20);
	JLabel email=new JLabel("이메일");
	JTextField emailField = new JTextField(20);

	JButton idBtn = new JButton("아이디 찾기");
	JButton pwdBtn = new JButton("비밀번호 찾기");

	public IdFind() {
		Color BGColor = new Color(23, 28, 45);
		Color btnColor = new Color(37, 66, 82);
		
		setTitle("아이디 찾기");
		setSize(800,600);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(BGColor);
		setLocationRelativeTo(null);


		setLayout(null);
		title.setFont(new Font("돋음",Font.BOLD,40));
		add(title).setBounds(305, 50, 300, 50);
		title.setForeground(Color.white);

		//이름
		name.setFont(new Font("견고딕",Font.BOLD,20));
		add(name).setBounds(190,170,300,50);
		add(nameField).setBounds(320,180,300,30);
		name.setForeground(Color.white);
		nameField.setFont(new Font("견고딕",Font.BOLD,20));

		//생년월일
		email.setFont(new Font("견고딕",Font.BOLD,20));
		add(email).setBounds(190,270,300,50);
		add(emailField).setBounds(320,280,300,30);
		email.setForeground(Color.white);
		emailField.setFont(new Font("견고딕",Font.BOLD,20));

		//아이디 찾기 버튼
		idBtn.setFont(new Font("견고딕",Font.BOLD,20));
		add(idBtn).setBounds(190,440,170,30);//중앙  (350,400,170,30)
		idBtn.setForeground(Color.white);
		idBtn.setBackground(btnColor);

		//비밀번호 찾기 버튼
		pwdBtn.setFont(new Font("견고딕",Font.BOLD,20));
		add(pwdBtn).setBounds(450,440,170,30);
		pwdBtn.setForeground(Color.white);
		pwdBtn.setBackground(btnColor);

		pwdBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new PwdFind();	
			}			
		});
		
		// 비번찾기 버튼 이벤트
		pwdBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PwdFind();
				dispose();
			}
		});
				
		idBtn.addActionListener(this);
	}//생성자

	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		
		if(btn.equals("아이디 찾기")) {
			if(nameField.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "이름을 입력하세요.");
				nameField.requestFocus();
			}else if(emailField.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "이메일을 입력하세요.");
				emailField.requestFocus();
			}else {
					String name = nameField.getText().trim();
					String email = emailField.getText().trim(); 
			
				UserDAO searchId = new UserDAO();
				List<UserDTO> result = searchId.userIdFind(name,email);
				
				if(result.size() > 0) {
					UserDTO idFind = result.get(0);
					String id = idFind.getUser_id();
					JOptionPane.showMessageDialog(this, "회원님의 아이디는"+id+" 입니다.");
				}else {
					JOptionPane.showMessageDialog(this, "회원님의 이름과 이메일을 다시 확인후 입력해주세요.");
				}
			}
		}
	}

	public static void main(String[] args) {		
		new IdFind();
	}
}