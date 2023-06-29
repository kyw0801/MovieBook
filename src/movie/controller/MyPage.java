package movie.controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import movie.dao.UserDAO;
import movie.dto.ReserveDTO;
import movie.dto.UserDTO;

public class MyPage extends JFrame implements ActionListener {

	static JLabel user = new JLabel( "-------님 환영합니다!");
	JButton bookchk = new JButton("예매확인");
	JButton bookcan = new JButton("예매취소");
	JButton withdrawal = new JButton("회원탈퇴");

	// 이미지
	Container cPane;
	// 로고
	ImageIcon LogoRicon; JLabel LogoR;

	public MyPage() {
		// 타이틀 및 내용글
		Color BGColor = new Color(23, 28, 45);
		Color back = new Color(37, 66, 82);

		setTitle("마이페이지");
		setSize(344, 590);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(BGColor);

		Font mainFt = new Font("견고딕", Font.CENTER_BASELINE, 20);
		Font menuFt = new Font("견고딕", Font.BOLD, 20);

		user.setFont(mainFt);
		user.setForeground(Color.white);

		bookchk.setFont(menuFt);
		bookchk.setForeground(Color.white);                                                              
		bookchk.setBackground(back);
		bookcan.setFont(menuFt);
		bookcan.setForeground(Color.white);
		bookcan.setBackground(back);
		withdrawal.setFont(menuFt);
		withdrawal.setForeground(Color.white);
		withdrawal.setBackground(back);

		// 이미지
		cPane = getContentPane();
		cPane.setLayout(null);

		// 로고
		LogoRicon = new ImageIcon("./images/logo/logoR.png");
		LogoR = new JLabel(LogoRicon);
		LogoR.setBounds(0, -220, getWidth(), getHeight());
		cPane.add(LogoR);

		// 레이아웃 위치
		setLayout(null);

		add(user).setBounds(87, 160, 345, 30);
		user.setHorizontalAlignment(JLabel.LEFT);  // LEFT정렬

		add(bookchk).setBounds(87, 230, 170, 60);
		add(bookcan).setBounds(87, 330, 170, 60);
		add(withdrawal).setBounds(87, 430, 170, 60);

		setVisible(true);

		bookcan.addActionListener(this);
		bookchk.addActionListener(this);
		withdrawal.addActionListener(this);
		renameChange(); // 우측____이름 세팅하는 메소드

	}
	//메인 우측 ____안녕하세요.
	public void renameChange() {
		UserDAO rename = new UserDAO();
		String id = Login.id_field.getText();
		List<UserDTO> name = rename.getName(id);
		for(int i=0; i<name.size(); i++) {
			UserDTO vo = name.get(i);
			user.setText(vo.getUser_name()+"님 환영합니다!");
		}
	}


	public static void main(String[] args) {
		new MyPage();
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void actionPerformed(ActionEvent e) {

		String btn = e.getActionCommand();

		if(btn.equals("예매확인")) {
			UserDAO reserveChk = new UserDAO();
			String ChkId = Login.id_field.getText();
			List<ReserveDTO> check = reserveChk.Chkreserve(ChkId);

			if(check.size() > 0) {
				Receipt newRceipt = new Receipt();
			}else {
				JOptionPane.showMessageDialog(this, "예매내역을 확인할수 없습니다.");
			}
		}
		if(btn.equals("예매취소")) {
			ReserveDTO deletedto = new ReserveDTO();
			deletedto.setUser_id(Login.id_field.getText());
			UserDAO delete = new UserDAO();
			int result=delete.delReserve(deletedto);

			if(result==1) {
				JOptionPane.showMessageDialog(this, "예매를 취소하였습니다.");
			}else {
				JOptionPane.showMessageDialog(this, "취소할 예매내역이 없습니다.");
			}
		}
		if(btn.equals("회원탈퇴")) {
			new Withdrawal();
		}
	}

}
