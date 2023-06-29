package movie.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import movie.dao.UserDAO;
import movie.dto.UserDTO;

public class PwdFind extends JFrame implements ActionListener{
	
	JFrame f=new JFrame();
	JLabel title=new JLabel("비밀번호 찾기");
	JLabel id=new JLabel("아이디");
	static JTextField idField = new JTextField(20);
	JLabel name=new JLabel("이름");
	JTextField nameField = new JTextField(20);
	JLabel email=new JLabel("이메일");
	JTextField emailField = new JTextField(20);
	//JLabel phone=new JLabel("핸드폰 번호");
	//JTextField phoneField = new JTextField(20);
	//JLabel CertificationNumber=new JLabel("인증 번호");
	//JTextField CertificationNumberField = new JTextField(20);
	
	JButton Btn01 = new JButton("비밀번호 찾기");
	//JButton Btn02 = new JButton("인증 요청");
	//JButton Btn03 = new JButton("인증 확인");

	
	public PwdFind() {
		Color BGColor = new Color(23, 28, 45);
		Color btnColor = new Color(37, 66, 82);
		
		setTitle("비밀번호 찾기");
		setSize(800,600);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(BGColor);
		setLocationRelativeTo(null);
		
		//비밀번호 찾기
		setLayout(null);
		title.setFont(new Font("돋음",Font.BOLD,40));
		add(title).setBounds(290, 50, 300, 50);
		title.setForeground(Color.white);
		
		//이름
		name.setFont(new Font("견고딕",Font.BOLD,20));
		add(name).setBounds(150,170,300,50);
		add(nameField).setBounds(300,180,250,30);
		name.setForeground(Color.white);
		nameField.setFont(new Font("견고딕",Font.BOLD,20));
		
		//아이디
		id.setFont(new Font("견고딕",Font.BOLD,20));
		add(id).setBounds(150,250,300,50);
		add(idField).setBounds(300,260,250,30);
		id.setForeground(Color.white);
		idField.setFont(new Font("견고딕",Font.BOLD,20));
		
		//전화번호
		email.setFont(new Font("견고딕",Font.BOLD,20));
		add(email).setBounds(150,330,300,50);
		add(emailField).setBounds(300,340,250,30);
		email.setForeground(Color.white);
		emailField.setFont(new Font("견고딕",Font.BOLD,20));
		/*
		//전화번호 인증 요청
		Btn03.setFont(new Font("견고딕",Font.BOLD,15));
		add(Btn03).setBounds(570,320,100,30);
		Btn03.setForeground(Color.white);
		Btn03.setBackground(btnColor);
		
		//인증번호
		CertificationNumber.setFont(new Font("견고딕",Font.BOLD,20));
		add(CertificationNumber).setBounds(150,390,300,50);
		add(CertificationNumberField).setBounds(300,400,250,30);
		CertificationNumber.setForeground(Color.white);
		CertificationNumberField.setFont(new Font("견고딕",Font.BOLD,20));
		
		//인증번호 인증 요청
		Btn02.setFont(new Font("돋음",Font.BOLD,15));
		add(Btn02).setBounds(570,400,100,30);
		Btn02.setForeground(Color.white);
		Btn02.setBackground(btnColor);
		*/
		//비밀번호 찾기 버튼
		Btn01.setFont(new Font("돋음",Font.BOLD,20));
		add(Btn01).setBounds(300,440,170,35);
		Btn01.setForeground(Color.white);
		Btn01.setBackground(btnColor);		
		
		
		Btn01.addActionListener(this);
	}//생성자
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		
		if(btn.equals("비밀번호 찾기")) {
			if(nameField.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "이름을 입력하세요.");
				nameField.requestFocus();
			}else if(idField.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
				idField.requestFocus();
			}else if(emailField.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "이메일을 입력하세요.");
				emailField.requestFocus();
			}
			else {
					String name = nameField.getText().trim();
					String email = emailField.getText().trim(); 
					String id = idField.getText().trim();
					
				UserDAO searchPwd = new UserDAO();
				List<UserDTO> result = searchPwd.userPwFind(name,email,id);
				
				if(result.size() > 0) {
				//	UserDTO pwdFind = result.get(0);
				//	String pwd = pwdFind.getUser_pwd();					
					UserDAO searchEmail = new UserDAO();
			        String emailFind = PwdFind.idField.getText();
			        List<UserDTO> result1 = searchEmail.mailSend(emailFind);
			        if(result1.size() <= 0) {
			        	JOptionPane.showMessageDialog(null, "메일발송을 실패");
			         }else{
			        	 UserDTO vo = result1.get(0);
							String FindEmail = vo.getUser_email();
							String FindPwd = vo.getUser_pwd();
							String FindId = vo.getUser_id();
			         
			     //   String code = "abc";
			         
			        // 1. 발신자의 메일 계정과 비밀번호 설정
			        final String user = "moviebook5555@gmail.com";
			        final String password = "dqjbbbrrtrwcbagt";
			     //하람   oqkeyolhoihvijpl
			        //  dqjbbbrrtrwcbagt
			        // 2. Property에 SMTP 서버 정보 설정
			        Properties prop = new Properties();
			        prop.put("mail.smtp.host", "smtp.gmail.com");
			        prop.put("mail.smtp.port", 465);
			        prop.put("mail.smtp.auth", "true");
			        prop.put("mail.smtp.ssl.enable", "true");
			        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			 
			        // 3. SMTP 서버정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스 생성
			        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			            protected PasswordAuthentication getPasswordAuthentication() {
			                return new PasswordAuthentication(user, password);
			            }
			        });
			 
			        // 4. Message 클래스의 객체를 사용하여 수신자와 내용, 제목의 메시지를 작성한다.
			        // 5. Transport 클래스를 사용하여 작성한 메세지를 전달한다.
			 
			        MimeMessage message = new MimeMessage(session);
			        try {
			            message.setFrom(new InternetAddress(user));
			 
			            // 수신자 메일 주소
			            message.addRecipient(Message.RecipientType.TO, new InternetAddress(FindEmail));
			 
			            // Subject
			            message.setSubject("안녕하세요"+FindId+"의 비밀번호 입니다.");
			 
			            // Text
			            message.setText("안녕하세요"+FindId+"의 비밀번호는 :"+FindPwd+" 입니다.");
			 
			            Transport.send(message);    // send message
			 
			 
			        } catch (AddressException e1) {
			            e1.printStackTrace();
			        } catch (MessagingException e1) {
			            e1.printStackTrace();
			        }
			        JOptionPane.showMessageDialog(this, "비밀번호를 이메일로 전송했습니다!");
			    }
				}else {
					JOptionPane.showMessageDialog(this, "다시 확인후 입력해주세요.");
				}
			}
		}
	}
	
	public static void main(String[] args) {		
		new PwdFind();
	}
}
