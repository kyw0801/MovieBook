package movie.controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import movie.dao.UserDAO;
import movie.dto.UserDTO;

public class Signup extends JFrame implements ActionListener{
	JLabel title = new JLabel("회원가입 창");
	JLabel id = new JLabel("아이디"); JTextField idField = new JTextField(20);
	JLabel name = new JLabel("이름"); JTextField nameField = new JTextField(20);
	JButton idcheckBtn = new JButton("중복확인");
	JLabel pwd = new JLabel("비밀번호"); JPasswordField pwdField = new JPasswordField(20);
	JLabel pwdcheck = new JLabel("비밀번호 확인"); JPasswordField pwdcheckField = new JPasswordField(20);
	JLabel phone = new JLabel("연락처"); JTextField phoneField = new JTextField(20);
	JLabel email = new JLabel("이메일"); JTextField emailField = new JTextField(30);
	JLabel gender = new JLabel("성별"); String gendercombo[] = {"남","여"};
	DefaultComboBoxModel<String> box = new DefaultComboBoxModel<String>(gendercombo);
	JComboBox<String> genderComboBox = new JComboBox<String>(box);
	JButton signupBtn = new JButton("회원가입");
	JButton cancelBtn = new JButton("취소");

	public Signup() {
		Color BGColor = new Color(23, 28, 45);
		Color btnColor = new Color(37, 66, 82);
		
		setTitle("회원가입"); 
		setSize(800,600); // 화면 크기
		setVisible(true); //항상 보이게
		setResizable(false); //화면 크기 고정
		setLocationRelativeTo(null); // 화면열람시 중앙 위치
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫을시 JFrame 종료
		getContentPane().setBackground(BGColor); 
		
		//버튼 이벤트
		idcheckBtn.addActionListener(this);
		signupBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		//폰트
		Font titleFnt = new Font("돋움",Font.BOLD,30);
		Font basicFnt = new Font("견고딕",Font.BOLD,20);


		title.setFont(titleFnt);
		title.setForeground(Color.white);

		id.setFont(basicFnt);
		id.setForeground(Color.white);
		idField.setFont(basicFnt);
		idcheckBtn.setFont(basicFnt);
		idcheckBtn.setBackground(btnColor);
		idcheckBtn.setForeground(Color.white);
		
		name.setFont(basicFnt);
		name.setForeground(Color.white);
		nameField.setFont(basicFnt);
		
		pwd.setFont(basicFnt);
		pwd.setForeground(Color.white);
		pwdField.setFont(basicFnt);
		pwdcheck.setFont(basicFnt);
		pwdcheck.setForeground(Color.white);
		pwdcheckField.setFont(basicFnt);

		phone.setFont(basicFnt);
		phone.setForeground(Color.white);
		phoneField.setFont(basicFnt);

		email.setFont(basicFnt);
		email.setForeground(Color.white);
		emailField.setFont(basicFnt);

		gender.setFont(basicFnt);
		gender.setForeground(Color.white);
		genderComboBox.setFont(basicFnt);
		genderComboBox.setBackground(Color.white);

		signupBtn.setFont(basicFnt);
		signupBtn.setForeground(Color.white);
		signupBtn.setBackground(btnColor);
		cancelBtn.setFont(basicFnt);
		cancelBtn.setForeground(Color.white);
		cancelBtn.setBackground(btnColor);

		//레이아웃
		setLayout(null);
		add(title).setBounds(305, 50, 180, 30);

		add(id).setBounds(180, 120, 100, 30);
		add(idField).setBounds(320, 120, 200, 30);
		add(idcheckBtn).setBounds(550, 120, 120, 30);

		add(name).setBounds(180, 170, 100, 30);
		add(nameField).setBounds(320,170,200,30);
		
		add(pwd).setBounds(180, 220, 100, 30);
		add(pwdField).setBounds(320, 220, 200, 30);

		add(pwdcheck).setBounds(180, 270, 150, 30);
		add(pwdcheckField).setBounds(320, 270, 200, 30);

		add(phone).setBounds(180, 320, 100, 30);
		add(phoneField).setBounds(320, 320, 200, 30);

		add(email).setBounds(180, 370, 100, 30);
		add(emailField).setBounds(320, 370, 200, 30);

		add(gender).setBounds(180, 420, 100, 30);
		add(genderComboBox).setBounds(320, 420, 50, 30);

		add(signupBtn).setBounds(285, 490, 120, 30);
		add(cancelBtn).setBounds(405, 490, 100, 30);
	} //생성자
	//이벤트 등록
	@Override
	public void actionPerformed(ActionEvent ae) {
			String btn = ae.getActionCommand();
			// String idSearch = idField.getText();
			
			if(btn.equals("중복확인")){
				if(idField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
					idField.requestFocus();
				}else{
					UserDAO search = new UserDAO();
					List<UserDTO> result =search.getidCheck(idField.getText());
				
					if(result.size() > 0) {
						JOptionPane.showMessageDialog(this, idField.getText()+"는 사용할수 없는 ID 입니다.");
						idField.setText(""); // 아이디 입력박스를 초기화
						idField.requestFocus(); // idField 포커스 
					}else {
						JOptionPane.showMessageDialog(this, idField.getText()+"는 사용가능한 ID 입니다.");
						pwdField.requestFocus(); // 패스워드 포커스 
					}
				}
			}	
			
			if(btn.equals("회원가입")) {
				if(idField.getText().trim().equals("")) { 
					JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
					idField.requestFocus();
				}else if(nameField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "이름을 입력하세요.");
					nameField.requestFocus();
				}else if(pwdField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요.");
					pwdField.requestFocus();
				}else if(pwdcheckField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "비밀번호 확인을 입력하세요");
					pwdcheckField.requestFocus();
				}else if(!pwdField.getText().trim().equals(pwdcheckField.getText())) {
					JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
					pwdcheckField.requestFocus();
				}else if(phoneField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "연락처를 입력하세요.");
					phoneField.requestFocus();
				}else if(emailField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "이메일을 입력하세요.");
					emailField.requestFocus();
				}else {
					UserDTO userdto = new UserDTO();
					userdto.setUser_id(idField.getText().trim());
					userdto.setUser_name(nameField.getText().trim());
					userdto.setUser_pwd(pwdField.getText().trim());
					userdto.setUser_phone(phoneField.getText().trim());
					userdto.setUser_email(emailField.getText().trim());;
					userdto.setUser_gender((String)genderComboBox.getSelectedItem());

					UserDAO userdao = new UserDAO();
					int result=userdao.userSign(userdto);

					if(result > 0) {
						JOptionPane.showMessageDialog(this, "회원가입을 축하드립니다.");
					}else {
						JOptionPane.showMessageDialog(this, "회원가입에 실패하였습니다.");
					}
				}
			}// 회원가입
			if(btn.equals("취소")) {
				dispose();
			}
	}// ActionEvent
	public static void main(String[] args) {
		Signup sg = new Signup();
	}
}
