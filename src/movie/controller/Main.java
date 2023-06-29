package movie.controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import movie.dao.UserDAO;
import movie.dto.MovieDTO;
import movie.dto.ReserveDTO;
import movie.dto.UserDTO;

public class Main extends JFrame implements ActionListener {

	// 타이틀 및 내용글
	JButton search = new JButton("검색");
	JTextField searchF = new JTextField();
	static JLabel user = new JLabel( "-------님 환영합니다!");
	JButton mypage = new JButton("마이페이지");
	JButton logout = new JButton("로그아웃");
	JLabel rankT1 = new JLabel("1. 더 퍼스트 슬램덩크");
	JLabel rankB1 = new JLabel("예매율 25.4%");
	JLabel rankT2 = new JLabel("2. 타이타닉");
	JLabel rankB2 = new JLabel("예매율 16.4%");
	JLabel rankT3 = new JLabel("3. 아바타:물의 길");
	JLabel rankB3 = new JLabel("예매율 12.2%");
	JLabel rankT4 = new JLabel("4. 바빌론");
	JLabel rankB4 = new JLabel("예매율 5.8%");
	JLabel releT1 = new JLabel("서치");
	JLabel releB1 = new JLabel("2023.02.22");
	JLabel releT2 = new JLabel("카운트");
	JLabel releB2 = new JLabel("2023.02.22");
	JLabel releT3 = new JLabel("멍뭉이");
	JLabel releB3 = new JLabel("2023.03.01");
	JLabel releT4 = new JLabel("스즈메의 문단속");
	JLabel releB4 = new JLabel("2023.03.08");
	JLabel timeT1 = new JLabel("더 퍼스트 슬램덩크");
	JLabel timeB1 = new JLabel("2관 19:00");
	JLabel timeT2 = new JLabel("아바타:물의 길");
	JLabel timeB2 = new JLabel("1관 11:30");
	JLabel timeT3 = new JLabel("바빌론");
	JLabel timeB3 = new JLabel("5관 14:00");
	JLabel timeT4 = new JLabel("교섭");
	JLabel timeB4 = new JLabel("4관 09:00");

	// 이미지
	Container cPane;
	// 로고
	ImageIcon Logoicon; JLabel Logo;
	// 포스터
	ImageIcon Slamdunkicon; JButton Slamdunk;
	ImageIcon Avataricon; JButton Avatar;
	ImageIcon Babylonicon; JButton Babylon;
	ImageIcon ThePointMenicon; JButton ThePointMen;
	ImageIcon Titanicicon; JButton Titanic;
	// 배너
	ImageIcon baner; JLabel bn;
	// 목록
	ImageIcon rankingi; JLabel ranking;
	ImageIcon releasei; JLabel release;
	ImageIcon timelinei; JLabel timeline;
	ImageIcon booki; JLabel book;

	public Main() {

		// 타이틀 및 내용글
		Color BGColor = new Color(23, 28, 45);

		setTitle("영화 예매 메인");
		setSize(1920, 1080);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(BGColor);


		Font titleFt = new Font("돋움", Font.BOLD, 70);
		Font subtitleFt = new Font("돋움", Font.BOLD, 40);
		Font mainFt = new Font("견고딕", Font.CENTER_BASELINE, 20);
		Font menuFt = new Font("견고딕", Font.BOLD, 20);

		// 폰트 및 글씨색

		search.setFont(menuFt);
		search.setForeground(Color.white);
		search.setBackground(BGColor);
		searchF.setFont(mainFt);

		user.setFont(mainFt);
		user.setForeground(Color.white);

		mypage.setFont(menuFt);
		mypage.setForeground(Color.white);                                                              
		mypage.setBackground(BGColor);

		logout.setFont(menuFt);
		logout.setForeground(Color.white);
		logout.setBackground(BGColor);

		rankT1.setFont(mainFt);
		rankT1.setForeground(Color.white);
		rankB1.setFont(mainFt);
		rankB1.setForeground(Color.white);
		rankT2.setFont(mainFt);
		rankT2.setForeground(Color.white);
		rankB2.setFont(mainFt);
		rankB2.setForeground(Color.white);
		rankT3.setFont(mainFt);
		rankT3.setForeground(Color.white);
		rankB3.setFont(mainFt);
		rankB3.setForeground(Color.white);
		rankT4.setFont(mainFt);
		rankT4.setForeground(Color.white);
		rankB4.setFont(mainFt);
		rankB4.setForeground(Color.white);

		releT1.setFont(mainFt);
		releT1.setForeground(Color.white);
		releB1.setFont(mainFt);
		releB1.setForeground(Color.white);
		releT2.setFont(mainFt);
		releT2.setForeground(Color.white);
		releB2.setFont(mainFt);
		releB2.setForeground(Color.white);
		releT3.setFont(mainFt);
		releT3.setForeground(Color.white);
		releB3.setFont(mainFt);
		releB3.setForeground(Color.white);
		releT4.setFont(mainFt);
		releT4.setForeground(Color.white);
		releB4.setFont(mainFt);
		releB4.setForeground(Color.white);

		timeT1.setFont(mainFt);
		timeT1.setForeground(Color.white);
		timeB1.setFont(mainFt);
		timeB1.setForeground(Color.white);
		timeT2.setFont(mainFt);
		timeT2.setForeground(Color.white);
		timeB2.setFont(mainFt);
		timeB2.setForeground(Color.white);
		timeT3.setFont(mainFt);
		timeT3.setForeground(Color.white);
		timeB3.setFont(mainFt);
		timeB3.setForeground(Color.white);
		timeT4.setFont(mainFt);
		timeT4.setForeground(Color.white);
		timeB4.setFont(mainFt);
		timeB4.setForeground(Color.white);


		// 레이아웃 위치
		setLayout(null);
		add(search).setBounds(170, 140, 80, 30);
		add(searchF).setBounds(250, 140, 265, 30);

		add(user).setBounds(1405, 100, 345, 30);
		user.setHorizontalAlignment(JLabel.RIGHT);  // 우측정렬

		add(mypage).setBounds(1470, 140, 160, 30);
		add(logout).setBounds(1630, 140, 120, 30);

		add(rankT1).setBounds(135, 845, 250, 30);
		add(rankB1).setBounds(415, 845, 150, 30);
		add(rankT2).setBounds(135, 895, 250, 30);
		add(rankB2).setBounds(415, 895, 150, 30);
		add(rankT3).setBounds(135, 945, 250, 30);
		add(rankB3).setBounds(415, 945, 150, 30);
		add(rankT4).setBounds(135, 995, 250, 30);
		add(rankB4).setBounds(415, 995, 150, 30);

		add(releT1).setBounds(775, 845, 250, 30);
		add(releB1).setBounds(1055, 845, 150, 30);
		add(releT2).setBounds(775, 895, 250, 30);
		add(releB2).setBounds(1055, 895, 150, 30);
		add(releT3).setBounds(775, 945, 250, 30);
		add(releB3).setBounds(1055, 945, 150, 30);
		add(releT4).setBounds(775, 995, 250, 30);
		add(releB4).setBounds(1055, 995, 150, 30);

		add(timeT1).setBounds(1415, 845, 250, 30);
		add(timeB1).setBounds(1695, 845, 150, 30);
		add(timeT2).setBounds(1415, 895, 250, 30);
		add(timeB2).setBounds(1695, 895, 150, 30);
		add(timeT3).setBounds(1415, 945, 250, 30);
		add(timeB3).setBounds(1695, 945, 150, 30);
		add(timeT4).setBounds(1415, 995, 250, 30);
		add(timeB4).setBounds(1695, 995, 150, 30);


		// 이미지
		cPane = getContentPane();
		cPane.setLayout(null);

		// 로고
		Logoicon = new ImageIcon("./images/logo/logo.png");
		Logo = new JLabel(Logoicon);
		Logo.setBounds(0, -440, getWidth(), getHeight());
		cPane.add(Logo);

		// 포스터
		// 슬램덩크
		Slamdunkicon = new ImageIcon("./images/poster/Slamdunk.jpg");
		Slamdunk = new JButton(Slamdunkicon);
		Slamdunk.setBounds(170, 210, Slamdunkicon.getIconWidth(), Slamdunkicon.getIconHeight());
		cPane.add(Slamdunk);

		// 아바타
		Avataricon = new ImageIcon("./images/poster/Avatar.jpg");
		Avatar = new JButton(Avataricon);
		Avatar.setBounds(599, 210, Avataricon.getIconWidth(), Avataricon.getIconHeight());
		cPane.add(Avatar);

		// 바빌론
		Babylonicon = new ImageIcon("./images/poster/Babylon.jpg");
		Babylon = new JButton(Babylonicon);
		Babylon.setBounds(1029, 210, Babylonicon.getIconWidth(), Babylonicon.getIconHeight());
		cPane.add(Babylon);

		// 교섭
		ThePointMenicon = new ImageIcon("./images/poster/ThePointMen.jpg");
		ThePointMen = new JButton(ThePointMenicon);
		ThePointMen.setBounds(1458, 210, ThePointMenicon.getIconWidth(), ThePointMenicon.getIconHeight());
		cPane.add(ThePointMen);

		// 목록
		rankingi = new ImageIcon("./images/word/ranking.png");
		ranking = new JLabel(rankingi);
		ranking.setBounds(153, 635, rankingi.getIconWidth(), rankingi.getIconHeight());
		cPane.add(ranking);

		releasei = new ImageIcon("./images/word/release.png");
		release = new JLabel(releasei);
		release.setBounds(793, 635, releasei.getIconWidth(), releasei.getIconHeight());
		cPane.add(release);

		timelinei = new ImageIcon("./images/word/timeline.png");
		timeline = new JLabel(timelinei);
		timeline.setBounds(1433, 635, timelinei.getIconWidth(), timelinei.getIconHeight());
		cPane.add(timeline);

		booki = new ImageIcon("./images/word/book.png");
		book = new JLabel(booki);
		book.setBounds(863, 645, booki.getIconWidth(), booki.getIconHeight());
		cPane.add(book);

		// 구분배너
		baner = new ImageIcon("./images/ex/baner.png");
		bn = new JLabel(baner);
		bn.setBounds(0, 750, baner.getIconWidth(), baner.getIconHeight());
		cPane.add(bn);

		setVisible(true);
		
		// 포스터 클릭 이벤트
		Slamdunk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IntroSlamdunk introSd = new IntroSlamdunk();
			}
		});
		Avatar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IntroAvatar introAv = new IntroAvatar();
			}
		});
		Babylon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IntroBabylon introBab = new IntroBabylon();
			}
		});
		ThePointMen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IntroTPM introtpm = new IntroTPM();
			}
		});
		
		// BOOK! 버튼 이벤트
		book.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Ticketing();
			}
		});
		
		logout.addActionListener(this);
		search.addActionListener(this);
		mypage.addActionListener(this);
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
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();

		if(btn.equals("마이페이지")) {
			new MyPage();
		}
		
		if(btn.equals("로그아웃")) {
			new Login();
			dispose();
		}
		
		if(btn.equals("검색")) {
			if(searchF.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "검색창을 입력해주세요.");
				searchF.requestFocus();
			}else {
				UserDAO movieFindDAO = new UserDAO();
				String Fmovie = searchF.getText().trim();
				List<MovieDTO> search = movieFindDAO.movieFind(Fmovie);
				
				if(search.size() > 0) {
					MovieDTO findmov = search.get(0);
					String mov_name = findmov.getMovie_name();
					
					if(mov_name.equals("아바타")) {
						IntroAvatar introAv = new IntroAvatar();
					}else if(mov_name.equals("슬램덩크")) {
						IntroSlamdunk introSd = new IntroSlamdunk();
					}else if(mov_name.equals("바빌론")) {
						IntroBabylon introBab = new IntroBabylon();
					}else if(mov_name.equals("앤트맨")) {
						IntroAntman introAnt = new IntroAntman();
					}else if(mov_name.equals("타이타닉")) {
						IntroTitanic introTita = new IntroTitanic();
					}else if(mov_name.equals("교섭")) {
						IntroTPM introtpm = new IntroTPM();
					}
				}else {
					JOptionPane.showMessageDialog(this, searchF.getText() + "의 검색 결과가 없습니다..");
				}
			}
		}
	}

	public static void main(String[] args) {

		new Main();

	}

}
