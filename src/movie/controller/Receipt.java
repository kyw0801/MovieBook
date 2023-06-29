package movie.controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import movie.dao.UserDAO;
import movie.dto.ReserveDTO;

public class Receipt extends JFrame implements ActionListener {

	// 이미지
	Container cPane;
	// 로고
	ImageIcon LogoRicon; JLabel LogoR;
	ImageIcon banerRicon; JLabel banerR;

	JPanel panel = new JPanel();
	JLabel booking = new JLabel("영화입장권");

	JLabel reservedateLabel = new JLabel("0000년 0월 0일");
	JLabel theatherLabel = new JLabel("MOVIE BOOK");
	JLabel theatherPhone = new JLabel("02-3673-3200");
	JLabel theatherPOS = new JLabel("영화관/POS: 2023-217");
	JLabel lineLabel = new JLabel("============================================");
	JLabel title = new JLabel("영화제목");
	JLabel runningtime = new JLabel("runningtime");
	JLabel movietime = new JLabel("0000년 0월 0일");
	JLabel seatnum = new JLabel("좌석번호   총 0명");
	JLabel lineLabel_1 = new JLabel("============================================");
	JLabel item = new JLabel("제품명");
	JLabel quantity = new JLabel("수량");
	JLabel lineLabel_3 = new JLabel("---------------------------------------------------");
	JLabel itemname = new JLabel("영화 티켓");
	JLabel itemnum = new JLabel("0 장");
	JLabel lineLabel_3_1 = new JLabel("---------------------------------------------------");
	JLabel total = new JLabel("합    계");
	JLabel totalre = new JLabel("0");
	JLabel lineLabel_2 = new JLabel("============================================");
	JLabel waring = new JLabel("<html><body>본 티켓의 교환, 환불 및 취소는 영화 시작 1시간 전에만 가능하며, 영수증 미지참시 불가합니다.</body></html>");

	public Receipt() {

		setTitle("영수증");
		setSize(344, 590);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 화면 가운데 출력시키기
		setResizable(false);

		getContentPane().setBackground(Color.white);

		// 이미지
		cPane = getContentPane();
		cPane.setLayout(null);

		// 로고
		LogoRicon = new ImageIcon("./images/logo/logoR.png");
		LogoR = new JLabel(LogoRicon);
		LogoR.setBounds(0, -240, getWidth(), getHeight());
		cPane.add(LogoR);

		banerRicon = new ImageIcon("./images/ex/banerR.png");
		banerR = new JLabel(banerRicon);
		banerR.setBounds(0, -280, getWidth(), getHeight());
		cPane.add(banerR);


		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 338, 583);
		getContentPane().add(panel);
		panel.setLayout(null);

		booking.setFont(new Font("돋움", Font.BOLD, 28));
		booking.setBounds(94, 125, 160, 45);
		panel.add(booking);

		reservedateLabel.setBounds(12, 197, 118, 15);
		panel.add(reservedateLabel);		

		theatherLabel.setBounds(12, 180, 160, 15);
		panel.add(theatherLabel);	

		theatherPhone.setHorizontalAlignment(JLabel.RIGHT);
		theatherPhone.setBounds(187, 180, 133, 15);
		panel.add(theatherPhone);

		theatherPOS.setHorizontalAlignment(JLabel.RIGHT);
		theatherPOS.setBounds(165, 197, 153, 15);
		panel.add(theatherPOS);

		lineLabel.setBounds(12, 215, 314, 24);
		panel.add(lineLabel);	

		item.setBounds(12, 372, 57, 15);
		panel.add(item);


		quantity.setHorizontalAlignment(SwingConstants.RIGHT);
		quantity.setBounds(258, 372, 57, 15);
		panel.add(quantity);

		lineLabel_3.setFont(new Font("굴림", Font.PLAIN, 12));
		lineLabel_3.setBounds(12, 382, 314, 24);
		panel.add(lineLabel_3);

		itemname.setBounds(12, 402, 57, 15);
		panel.add(itemname);

		itemnum.setHorizontalAlignment(SwingConstants.RIGHT);
		itemnum.setBounds(258, 402, 57, 15);
		panel.add(itemnum);

		lineLabel_1.setBounds(12, 352, 314, 24);
		panel.add(lineLabel_1);

		title.setFont(new Font("굴림", Font.BOLD, 26));
		title.setBounds(9, 237, 314, 45);
		panel.add(title);

		runningtime.setFont(new Font("굴림", Font.BOLD, 14));
		runningtime.setBounds(11, 310, 314, 14);
		panel.add(runningtime);

		movietime.setFont(new Font("굴림", Font.BOLD, 14));
		movietime.setBounds(10, 282, 314, 24);
		panel.add(movietime);

		seatnum.setFont(new Font("굴림", Font.BOLD, 14));
		seatnum.setBounds(15, 328, 303, 24);
		panel.add(seatnum);

		lineLabel_3_1.setFont(new Font("굴림", Font.PLAIN, 12));
		lineLabel_3_1.setBounds(12, 437, 314, 24);
		panel.add(lineLabel_3_1);

		total.setBounds(12, 462, 57, 15);
		panel.add(total);

		totalre.setHorizontalAlignment(SwingConstants.RIGHT);
		totalre.setBounds(258, 462, 57, 15);
		panel.add(totalre);

		lineLabel_2.setBounds(12, 475, 314, 24);
		panel.add(lineLabel_2);

		waring.setHorizontalAlignment(SwingConstants.LEFT);
		waring.setFont(new Font("굴림", Font.BOLD, 12));
		waring.setBounds(12, 495, 314, 30);
		panel.add(waring);

		setVisible(true);

		reReceipt(); // 영수증 DB값 받기
	}
	public void reReceipt() {
		UserDAO receiptre = new UserDAO();
		String id = Login.id_field.getText();
		List<ReserveDTO> setter = receiptre.getReceipt(id);
		if(setter.size() > 0) {
			for(int i=0; i<setter.size(); i++) {
				ReserveDTO vo = setter.get(i);
				reservedateLabel.setText(vo.getReserve_date());
				title.setText(vo.getMovie_name());
				runningtime.setText(vo.getSelect_time());
				movietime.setText(vo.getSelect_day());
				seatnum.setText(vo.getSetnumber()+"  총 "+vo.getPerson()+"명");
				itemnum.setText(vo.getPerson()+" 장");
				totalre.setText(vo.getPerson());
				theatherPOS.setText(vo.getMovie_local()+"관/POS: 2023-217");
			}
		}else {
			JOptionPane.showMessageDialog(this,"예매한 검색 결과가 없습니다..");
		}
	}
	public static void main(String[] args) {
		new Receipt();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
