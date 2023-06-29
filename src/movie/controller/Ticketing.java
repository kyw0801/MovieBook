package movie.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import movie.dao.UserDAO;
import movie.dto.ReserveDTO;

public class Ticketing extends JFrame implements ActionListener {
	
	
	List V=new ArrayList(); // 좌석저장
	
	// 로고
	ImageIcon Logoicon; JLabel Logo;
	
	Color BGColor = new Color(23, 28, 45);
	Color back = new Color(37, 66, 82);
	
	JPanel p = new JPanel();
	JPanel Seat_p = new JPanel();
	
	String[] place = {" 지점선택 ", " 강남 ", " 노량진 ", " 종로 ", " 건대 "};
	String[] movie = {" 영화선택 ", " 아바타 ", " 바빌론 ", " 교섭 ", " 슬램덩크 "};
	String[] date = {" 날짜선택 ", " 2월 18일 ", " 2월 19일 ", " 2월 20일 ", " 2월 21일 "};
	String[] time = {" 시간선택 ", " 09:00 ~ 11:00 ", " 11:30 ~ 13:30 ", " 14:00 ~ 16:00 ", " 16:30 ~ 18:30 ", " 19:00 ~ 21:00 "};
	String[] count = {" 인원선택 ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 "};
	JComboBox placeCom = new JComboBox(place);
	JComboBox movieCom = new JComboBox(movie);
	JComboBox dateCom = new JComboBox(date);
	JComboBox timeCom = new JComboBox(time);
	JComboBox countCom = new JComboBox(count);
	
	JCheckBox cb1_1,cb1_2,cb1_3,cb1_4,cb1_5,cb1_6,cb1_7,cb1_8,cb1_9,cb1_10;
	JCheckBox cb2_1,cb2_2,cb2_3,cb2_4,cb2_5,cb2_6,cb2_7,cb2_8,cb2_9,cb2_10;
	JCheckBox cb3_1,cb3_2,cb3_3,cb3_4,cb3_5,cb3_6,cb3_7,cb3_8,cb3_9,cb3_10;
	JCheckBox cb4_1,cb4_2,cb4_3,cb4_4,cb4_5,cb4_6,cb4_7,cb4_8,cb4_9,cb4_10;
	JCheckBox cb5_1,cb5_2,cb5_3,cb5_4,cb5_5,cb5_6,cb5_7,cb5_8,cb5_9,cb5_10;
	JCheckBox cb6_1,cb6_2,cb6_3,cb6_4,cb6_5,cb6_6,cb6_7,cb6_8,cb6_9,cb6_10;
	JCheckBox cb7_1,cb7_2,cb7_3,cb7_4,cb7_5,cb7_6,cb7_7,cb7_8,cb7_9,cb7_10;
	JCheckBox cb8_1,cb8_2,cb8_3,cb8_4,cb8_5,cb8_6,cb8_7,cb8_8,cb8_9,cb8_10;
	JCheckBox cb9_1,cb9_2,cb9_3,cb9_4,cb9_5,cb9_6,cb9_7,cb9_8,cb9_9,cb9_10;
	JCheckBox cb10_1,cb10_2,cb10_3,cb10_4,cb10_5,cb10_6,cb10_7,cb10_8,cb10_9,cb10_10;
	JLabel scrlbl = new JLabel("스크린");
	JButton commit = new JButton("예약!"); //
	
	// JButton[] seat = new JButton[10];
	
	public Ticketing() {
		
		p.setPreferredSize(new Dimension(650, 100));
		p.setBackground(back);
		p.add(movieCom); p.add(placeCom); p.add(dateCom); p.add(timeCom); p.add(countCom);
		commit.setPreferredSize(new Dimension(70, 25 ));
		commit.setBackground(Color.white);
		p.add(commit, "North");
		add(p, "North");
		
		scrlbl.setForeground(Color.white);
		scrlbl.setFont(new Font("고딕", Font.BOLD, 50));
		p.add(scrlbl, "South"); 
		
		Seat_p.setBackground(BGColor);
		Seat_p.setBounds(0, 0, 650, 720);
		getContentPane().add(Seat_p);
		Seat_p.setLayout(null);
		
		// 버튼 노가다
		cb1_1 = new JCheckBox("A1");
		cb1_1.setBounds(20, 30, 50, 25);
		Seat_p.add(cb1_1);
		cb1_2 = new JCheckBox("A2");
		cb1_2.setBounds(80, 30, 50, 25);
		Seat_p.add(cb1_2);
		cb1_3 = new JCheckBox("A3");
		cb1_3.setBounds(140, 30, 50, 25);
		Seat_p.add(cb1_3);
		cb1_4 = new JCheckBox("A4");
		cb1_4.setBounds(200, 30, 50, 25);
		Seat_p.add(cb1_4);
		cb1_5 = new JCheckBox("A5");
		cb1_5.setBounds(260, 30, 50, 25);
		Seat_p.add(cb1_5);
		cb1_6 = new JCheckBox("A6");
		cb1_6.setBounds(320, 30, 50, 25);
		Seat_p.add(cb1_6);
		cb1_7 = new JCheckBox("A7");
		cb1_7.setBounds(380, 30, 50, 25);
		Seat_p.add(cb1_7);
		cb1_8 = new JCheckBox("A8");
		cb1_8.setBounds(440, 30, 50, 25);
		Seat_p.add(cb1_8);
		cb1_9 = new JCheckBox("A9");
		cb1_9.setBounds(500, 30, 50, 25);
		Seat_p.add(cb1_9);
		cb1_10 = new JCheckBox("A10");
		cb1_10.setBounds(560, 30, 50, 25);
		Seat_p.add(cb1_10);
		
		cb2_1 = new JCheckBox("B1");
		cb2_1.setBounds(20, 70, 50, 25);
		Seat_p.add(cb2_1);
		cb2_2 = new JCheckBox("B2");
		cb2_2.setBounds(80, 70, 50, 25);
		Seat_p.add(cb2_2);
		cb2_3 = new JCheckBox("B3");
		cb2_3.setBounds(140, 70, 50, 25);
		Seat_p.add(cb2_3);
		cb2_4 = new JCheckBox("B4");
		cb2_4.setBounds(200, 70, 50, 25);
		Seat_p.add(cb2_4);
		cb2_5 = new JCheckBox("B5");
		cb2_5.setBounds(260, 70, 50, 25);
		Seat_p.add(cb2_5);
		cb2_6 = new JCheckBox("B6");
		cb2_6.setBounds(320, 70, 50, 25);
		Seat_p.add(cb2_6);
		cb2_7 = new JCheckBox("B7");
		cb2_7.setBounds(380, 70, 50, 25);
		Seat_p.add(cb2_7);
		cb2_8 = new JCheckBox("B8");
		cb2_8.setBounds(440, 70, 50, 25);
		Seat_p.add(cb2_8);
		cb2_9 = new JCheckBox("B9");
		cb2_9.setBounds(500, 70, 50, 25);
		Seat_p.add(cb2_9);
		cb2_10 = new JCheckBox("B10");
		cb2_10.setBounds(560, 70, 50, 25);
		Seat_p.add(cb2_10);
		
		cb3_1 = new JCheckBox("C1");
		cb3_1.setBounds(20, 110, 50, 25);
		Seat_p.add(cb3_1);
		cb3_2 = new JCheckBox("C2");
		cb3_2.setBounds(80, 110, 50, 25);
		Seat_p.add(cb3_2);
		cb3_3 = new JCheckBox("C3");
		cb3_3.setBounds(140, 110, 50, 25);
		Seat_p.add(cb3_3);
		cb3_4 = new JCheckBox("C4");
		cb3_4.setBounds(200, 110, 50, 25);
		Seat_p.add(cb3_4);
		cb3_5 = new JCheckBox("C5");
		cb3_5.setBounds(260, 110, 50, 25);
		Seat_p.add(cb3_5);
		cb3_6 = new JCheckBox("C6");
		cb3_6.setBounds(320, 110, 50, 25);
		Seat_p.add(cb3_6);
		cb3_7 = new JCheckBox("C7");
		cb3_7.setBounds(380, 110, 50, 25);
		Seat_p.add(cb3_7);
		cb3_8 = new JCheckBox("C8");
		cb3_8.setBounds(440, 110, 50, 25);
		Seat_p.add(cb3_8);
		cb3_9 = new JCheckBox("C9");
		cb3_9.setBounds(500, 110, 50, 25);
		Seat_p.add(cb3_9);
		cb3_10 = new JCheckBox("C10");
		cb3_10.setBounds(560, 110, 50, 25);
		Seat_p.add(cb3_10);
		
		cb4_1 = new JCheckBox("D1");
		cb4_1.setBounds(20, 150, 50, 25);
		Seat_p.add(cb4_1);
		cb4_2 = new JCheckBox("D2");
		cb4_2.setBounds(80, 150, 50, 25);
		Seat_p.add(cb4_2);
		cb4_3 = new JCheckBox("D3");
		cb4_3.setBounds(140, 150, 50, 25);
		Seat_p.add(cb4_3);
		cb4_4 = new JCheckBox("D4");
		cb4_4.setBounds(200, 150, 50, 25);
		Seat_p.add(cb4_4);
		cb4_5 = new JCheckBox("D5");
		cb4_5.setBounds(260, 150, 50, 25);
		Seat_p.add(cb4_5);
		cb4_6 = new JCheckBox("D6");
		cb4_6.setBounds(320, 150, 50, 25);
		Seat_p.add(cb4_6);
		cb4_7 = new JCheckBox("D7");
		cb4_7.setBounds(380, 150, 50, 25);
		Seat_p.add(cb4_7);
		cb4_8 = new JCheckBox("D8");
		cb4_8.setBounds(440, 150, 50, 25);
		Seat_p.add(cb4_8);
		cb4_9 = new JCheckBox("D9");
		cb4_9.setBounds(500, 150, 50, 25);
		Seat_p.add(cb4_9);
		cb4_10 = new JCheckBox("D10");
		cb4_10.setBounds(560, 150, 50, 25);
		Seat_p.add(cb4_10);
		
		cb5_1 = new JCheckBox("E1");
		cb5_1.setBounds(20, 190, 50, 25);
		Seat_p.add(cb5_1);
		cb5_2 = new JCheckBox("E2");
		cb5_2.setBounds(80, 190, 50, 25);
		Seat_p.add(cb5_2);
		cb5_3 = new JCheckBox("E3");
		cb5_3.setBounds(140, 190, 50, 25);
		Seat_p.add(cb5_3);
		cb5_4 = new JCheckBox("E4");
		cb5_4.setBounds(200, 190, 50, 25);
		Seat_p.add(cb5_4);
		cb5_5 = new JCheckBox("E5");
		cb5_5.setBounds(260, 190, 50, 25);
		Seat_p.add(cb5_5);
		cb5_6 = new JCheckBox("E6");
		cb5_6.setBounds(320, 190, 50, 25);
		Seat_p.add(cb5_6);
		cb5_7 = new JCheckBox("E7");
		cb5_7.setBounds(380, 190, 50, 25);
		Seat_p.add(cb5_7);
		cb5_8 = new JCheckBox("E8");
		cb5_8.setBounds(440, 190, 50, 25);
		Seat_p.add(cb5_8);
		cb5_9 = new JCheckBox("E9");
		cb5_9.setBounds(500, 190, 50, 25);
		Seat_p.add(cb5_9);
		cb5_10 = new JCheckBox("E10");
		cb5_10.setBounds(560, 190, 50, 25);
		Seat_p.add(cb5_10);
		
		cb6_1 = new JCheckBox("F1");
		cb6_1.setBounds(20, 230, 50, 25);
		Seat_p.add(cb6_1);
		cb6_2 = new JCheckBox("F2");
		cb6_2.setBounds(80, 230, 50, 25);
		Seat_p.add(cb6_2);
		cb6_3 = new JCheckBox("F3");
		cb6_3.setBounds(140, 230, 50, 25);
		Seat_p.add(cb6_3);
		cb6_4 = new JCheckBox("F4");
		cb6_4.setBounds(200, 230, 50, 25);
		Seat_p.add(cb6_4);
		cb6_5 = new JCheckBox("F5");
		cb6_5.setBounds(260, 230, 50, 25);
		Seat_p.add(cb6_5);
		cb6_6 = new JCheckBox("F6");
		cb6_6.setBounds(320, 230, 50, 25);
		Seat_p.add(cb6_6);
		cb6_7 = new JCheckBox("F7");
		cb6_7.setBounds(380, 230, 50, 25);
		Seat_p.add(cb6_7);
		cb6_8 = new JCheckBox("F8");
		cb6_8.setBounds(440, 230, 50, 25);
		Seat_p.add(cb6_8);
		cb6_9 = new JCheckBox("F9");
		cb6_9.setBounds(500, 230, 50, 25);
		Seat_p.add(cb6_9);
		cb6_10 = new JCheckBox("F10");
		cb6_10.setBounds(560, 230, 50, 25);
		Seat_p.add(cb6_10);
		
		cb7_1 = new JCheckBox("G1");
		cb7_1.setBounds(20, 270, 50, 25);
		Seat_p.add(cb7_1);
		cb7_2 = new JCheckBox("G2");
		cb7_2.setBounds(80, 270, 50, 25);
		Seat_p.add(cb7_2);
		cb7_3 = new JCheckBox("G3");
		cb7_3.setBounds(140, 270, 50, 25);
		Seat_p.add(cb7_3);
		cb7_4 = new JCheckBox("G4");
		cb7_4.setBounds(200, 270, 50, 25);
		Seat_p.add(cb7_4);
		cb7_5 = new JCheckBox("G5");
		cb7_5.setBounds(260, 270, 50, 25);
		Seat_p.add(cb7_5);
		cb7_6 = new JCheckBox("G6");
		cb7_6.setBounds(320, 270, 50, 25);
		Seat_p.add(cb7_6);
		cb7_7 = new JCheckBox("G7");
		cb7_7.setBounds(380, 270, 50, 25);
		Seat_p.add(cb7_7);
		cb7_8 = new JCheckBox("G8");
		cb7_8.setBounds(440, 270, 50, 25);
		Seat_p.add(cb7_8);
		cb7_9 = new JCheckBox("G9");
		cb7_9.setBounds(500, 270, 50, 25);
		Seat_p.add(cb7_9);
		cb7_10 = new JCheckBox("G10");
		cb7_10.setBounds(560, 270, 50, 25);
		Seat_p.add(cb7_10);
		
		cb8_1 = new JCheckBox("H1");
		cb8_1.setBounds(20, 310, 50, 25);
		Seat_p.add(cb8_1);
		cb8_2 = new JCheckBox("H2");
		cb8_2.setBounds(80, 310, 50, 25);
		Seat_p.add(cb8_2);
		cb8_3 = new JCheckBox("H3");
		cb8_3.setBounds(140, 310, 50, 25);
		Seat_p.add(cb8_3);
		cb8_4 = new JCheckBox("H4");
		cb8_4.setBounds(200, 310, 50, 25);
		Seat_p.add(cb8_4);
		cb8_5 = new JCheckBox("H5");
		cb8_5.setBounds(260, 310, 50, 25);
		Seat_p.add(cb8_5);
		cb8_6 = new JCheckBox("H6");
		cb8_6.setBounds(320, 310, 50, 25);
		Seat_p.add(cb8_6);
		cb8_7 = new JCheckBox("H7");
		cb8_7.setBounds(380, 310, 50, 25);
		Seat_p.add(cb8_7);
		cb8_8 = new JCheckBox("H8");
		cb8_8.setBounds(440, 310, 50, 25);
		Seat_p.add(cb8_8);
		cb8_9 = new JCheckBox("H9");
		cb8_9.setBounds(500, 310, 50, 25);
		Seat_p.add(cb8_9);
		cb8_10 = new JCheckBox("H10");
		cb8_10.setBounds(560, 310, 50, 25);
		Seat_p.add(cb8_10);
		
		cb9_1 = new JCheckBox("I1");
		cb9_1.setBounds(20, 350, 50, 25);
		Seat_p.add(cb9_1);
		cb9_2 = new JCheckBox("I2");
		cb9_2.setBounds(80, 350, 50, 25);
		Seat_p.add(cb9_2);
		cb9_3 = new JCheckBox("I3");
		cb9_3.setBounds(140, 350, 50, 25);
		Seat_p.add(cb9_3);
		cb9_4 = new JCheckBox("I4");
		cb9_4.setBounds(200, 350, 50, 25);
		Seat_p.add(cb9_4);
		cb9_5 = new JCheckBox("I5");
		cb9_5.setBounds(260, 350, 50, 25);
		Seat_p.add(cb9_5);
		cb9_6 = new JCheckBox("I6");
		cb9_6.setBounds(320, 350, 50, 25);
		Seat_p.add(cb9_6);
		cb9_7 = new JCheckBox("I7");
		cb9_7.setBounds(380, 350, 50, 25);
		Seat_p.add(cb9_7);
		cb9_8 = new JCheckBox("I8");
		cb9_8.setBounds(440, 350, 50, 25);
		Seat_p.add(cb9_8);
		cb9_9 = new JCheckBox("I9");
		cb9_9.setBounds(500, 350, 50, 25);
		Seat_p.add(cb9_9);
		cb9_10 = new JCheckBox("I10");
		cb9_10.setBounds(560, 350, 50, 25);
		Seat_p.add(cb9_10);
		
		cb10_1 = new JCheckBox("J1");
		cb10_1.setBounds(20, 390, 50, 25);
		Seat_p.add(cb10_1);
		cb10_2 = new JCheckBox("J2");
		cb10_2.setBounds(80, 390, 50, 25);
		Seat_p.add(cb10_2);
		cb10_3 = new JCheckBox("J3");
		cb10_3.setBounds(140, 390, 50, 25);
		Seat_p.add(cb10_3);
		cb10_4 = new JCheckBox("J4");
		cb10_4.setBounds(200, 390, 50, 25);
		Seat_p.add(cb10_4);
		cb10_5 = new JCheckBox("J5");
		cb10_5.setBounds(260, 390, 50, 25);
		Seat_p.add(cb10_5);
		cb10_6 = new JCheckBox("J6");
		cb10_6.setBounds(320, 390, 50, 25);
		Seat_p.add(cb10_6);
		cb10_7 = new JCheckBox("J7");
		cb10_7.setBounds(380, 390, 50, 25);
		Seat_p.add(cb10_7);
		cb10_8 = new JCheckBox("J8");
		cb10_8.setBounds(440, 390, 50, 25);
		Seat_p.add(cb10_8);
		cb10_9 = new JCheckBox("J9");
		cb10_9.setBounds(500, 390, 50, 25);
		Seat_p.add(cb10_9);
		cb10_10 = new JCheckBox("J10");
		cb10_10.setBounds(560, 390, 50, 25);
		Seat_p.add(cb10_10);
		
		//
		
		
		setTitle("영화 예매");
		setSize(650, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(BGColor);
		
		

		// 로고
		Logoicon = new ImageIcon("./images/logo/logo.png");
		Logo = new JLabel(Logoicon);
		Logo.setBounds(0 , 145, getWidth(), getHeight());
		Seat_p.add(Logo);
		
		add(Seat_p);
		
		setVisible(true);
		
		commit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Ticketing();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// 버튼 값 추가
		if(cb1_1.isSelected()){
			V.add("A1");
		}
		if(cb1_2.isSelected()) {
			V.add("A2");
		}
		if(cb1_3.isSelected()){
			V.add("A3");
		}
		if(cb1_4.isSelected()) {
			V.add("A4");
		}
		if(cb1_5.isSelected()){
			V.add("A5");
		}
		if(cb1_6.isSelected()) {
			V.add("A6");
		}
		if(cb1_7.isSelected()){
			V.add("A7");
		}
		if(cb1_8.isSelected()) {
			V.add("A8");
		}
		if(cb1_9.isSelected()){
			V.add("A9");
		}
		if(cb1_10.isSelected()) {
			V.add("A10");
		}
		
		if(cb2_1.isSelected()){
			V.add("B1");
		}
		if(cb2_2.isSelected()) {
			V.add("B2");
		}
		if(cb2_3.isSelected()){
			V.add("B3");
		}
		if(cb2_4.isSelected()) {
			V.add("B4");
		}
		if(cb2_5.isSelected()){
			V.add("B5");
		}
		if(cb2_6.isSelected()) {
			V.add("B6");
		}
		if(cb2_7.isSelected()){
			V.add("B7");
		}
		if(cb2_8.isSelected()) {
			V.add("B8");
		}
		if(cb2_9.isSelected()){
			V.add("B9");
		}
		if(cb2_10.isSelected()) {
			V.add("B10");
		}
		
		if(cb3_1.isSelected()){
			V.add("C1");
		}
		if(cb3_2.isSelected()) {
			V.add("C2");
		}
		if(cb3_3.isSelected()){
			V.add("C3");
		}
		if(cb3_4.isSelected()) {
			V.add("C4");
		}
		if(cb3_5.isSelected()){
			V.add("C5");
		}
		if(cb3_6.isSelected()) {
			V.add("C6");
		}
		if(cb3_7.isSelected()){
			V.add("C7");
		}
		if(cb3_8.isSelected()) {
			V.add("C8");
		}
		if(cb3_9.isSelected()){
			V.add("C9");
		}
		if(cb3_10.isSelected()) {
			V.add("C10");
		}
		
		if(cb4_1.isSelected()){
			V.add("D1");
		}
		if(cb4_2.isSelected()) {
			V.add("D2");
		}
		if(cb4_3.isSelected()){
			V.add("D3");
		}
		if(cb4_4.isSelected()) {
			V.add("D4");
		}
		if(cb4_5.isSelected()){
			V.add("D5");
		}
		if(cb4_6.isSelected()) {
			V.add("D6");
		}
		if(cb4_7.isSelected()){
			V.add("D7");
		}
		if(cb4_8.isSelected()) {
			V.add("D8");
		}
		if(cb4_9.isSelected()){
			V.add("D9");
		}
		if(cb4_10.isSelected()) {
			V.add("D10");
		}
		
		if(cb5_1.isSelected()){
			V.add("E1");
		}
		if(cb5_2.isSelected()) {
			V.add("E2");
		}
		if(cb5_3.isSelected()){
			V.add("E3");
		}
		if(cb5_4.isSelected()) {
			V.add("E4");
		}
		if(cb5_5.isSelected()){
			V.add("E5");
		}
		if(cb5_6.isSelected()) {
			V.add("E6");
		}
		if(cb5_7.isSelected()){
			V.add("E7");
		}
		if(cb5_8.isSelected()) {
			V.add("E8");
		}
		if(cb5_9.isSelected()){
			V.add("E9");
		}
		if(cb5_10.isSelected()) {
			V.add("E10");
		}
		
		if(cb6_1.isSelected()){
			V.add("F1");
		}
		if(cb6_2.isSelected()) {
			V.add("F2");
		}
		if(cb6_3.isSelected()){
			V.add("F3");
		}
		if(cb6_4.isSelected()) {
			V.add("F4");
		}
		if(cb6_5.isSelected()){
			V.add("F5");
		}
		if(cb6_6.isSelected()) {
			V.add("F6");
		}
		if(cb6_7.isSelected()){
			V.add("F7");
		}
		if(cb6_8.isSelected()) {
			V.add("F8");
		}
		if(cb6_9.isSelected()){
			V.add("F9");
		}
		if(cb6_10.isSelected()) {
			V.add("F10");
		}
		
		if(cb7_1.isSelected()){
			V.add("G1");
		}
		if(cb7_2.isSelected()) {
			V.add("G2");
		}
		if(cb7_3.isSelected()){
			V.add("G3");
		}
		if(cb7_4.isSelected()) {
			V.add("G4");
		}
		if(cb7_5.isSelected()){
			V.add("G5");
		}
		if(cb7_6.isSelected()) {
			V.add("G6");
		}
		if(cb7_7.isSelected()){
			V.add("G7");
		}
		if(cb7_8.isSelected()) {
			V.add("G8");
		}
		if(cb7_9.isSelected()){
			V.add("G9");
		}
		if(cb7_10.isSelected()) {
			V.add("G10");
		}
		
		if(cb8_1.isSelected()){
			V.add("H1");
		}
		if(cb8_2.isSelected()) {
			V.add("H2");
		}
		if(cb8_3.isSelected()){
			V.add("H3");
		}
		if(cb8_4.isSelected()) {
			V.add("H4");
		}
		if(cb8_5.isSelected()){
			V.add("H5");
		}
		if(cb8_6.isSelected()) {
			V.add("H6");
		}
		if(cb8_7.isSelected()){
			V.add("H7");
		}
		if(cb8_8.isSelected()) {
			V.add("H8");
		}
		if(cb8_9.isSelected()){
			V.add("H9");
		}
		if(cb8_10.isSelected()) {
			V.add("H10");
		}
		
		if(cb9_1.isSelected()){
			V.add("I1");
		}
		if(cb9_2.isSelected()) {
			V.add("I2");
		}
		if(cb9_3.isSelected()){
			V.add("I3");
		}
		if(cb9_4.isSelected()) {
			V.add("I4");
		}
		if(cb9_5.isSelected()){
			V.add("I5");
		}
		if(cb9_6.isSelected()) {
			V.add("I6");
		}
		if(cb9_7.isSelected()){
			V.add("I7");
		}
		if(cb9_8.isSelected()) {
			V.add("I8");
		}
		if(cb9_9.isSelected()){
			V.add("I9");
		}
		if(cb9_10.isSelected()) {
			V.add("I10");
		}
		
		if(cb10_1.isSelected()){
			V.add("J1");
		}
		if(cb10_2.isSelected()) {
			V.add("J2");
		}
		if(cb10_3.isSelected()){
			V.add("J3");
		}
		if(cb10_4.isSelected()) {
			V.add("J4");
		}
		if(cb10_5.isSelected()){
			V.add("J5");
		}
		if(cb10_6.isSelected()) {
			V.add("J6");
		}
		if(cb10_7.isSelected()){
			V.add("J7");
		}
		if(cb10_8.isSelected()) {
			V.add("J8");
		}
		if(cb10_9.isSelected()){
			V.add("J9");
		}
		if(cb10_10.isSelected()) {
			V.add("J10");
		}
		//
		//
		String btn = e.getActionCommand();
		
		String saveSeat = String.join(",", V);
		
		if(btn.equals("예약!")) {
			ReserveDTO reserve = new ReserveDTO();
			reserve.setUser_id(Login.id_field.getText());
			reserve.setMovie_name((String)movieCom.getSelectedItem());
			reserve.setMovie_local((String)placeCom.getSelectedItem());
			reserve.setSelect_day((String)dateCom.getSelectedItem());
			reserve.setSelect_time((String)timeCom.getSelectedItem());
			reserve.setPerson((String)countCom.getSelectedItem());
			reserve.setSetnumber(saveSeat);
			
			UserDAO userdao = new UserDAO();
			int result=userdao.booking(reserve);
			
			if(result > 0) {
				JOptionPane.showMessageDialog(this, "예약 완료 :)");
				dispose();
			}else {
				JOptionPane.showMessageDialog(this, "예약 실패 :(");
			}
		}
	}

}
