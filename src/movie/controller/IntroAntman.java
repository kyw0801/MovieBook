package movie.controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IntroAntman extends JFrame {
	
	// 타이틀 및 내용글
	JLabel title = new JLabel("앤트맨과 와스프");
	JLabel subtitle = new JLabel("앤트맨과 와스프 : 퀀텀매니아 Antman and the Wasp");
	JLabel cut = new JLabel("------------------------------------");
	JLabel synopsis = new JLabel("- SYSNOPSIS -");
	JLabel syn = new JLabel("<html><body style='text-align:left;'>미지의 '양자 영역' 세계 속에 빠져버린 '앤트맨 패밀리'.<br>그 곳에서 새로운 존재들과 무한한 우주를 다스리는 정복자 '캉'을 만나며, 그 누구도 예상 못 한 모든 것의 한계를 뛰어넘는 모험을 시작하게 되는데…</body></html>");
	JLabel outline = new JLabel("- OUTLINE -");
	JLabel ol = new JLabel("<html><body style='text-align:left;'>마블 시네마틱 유니버스 페이즈 5의 첫 번째 영화이자 앤트맨 실사영화 시리즈의 세 번째 작품. 전작 이후 5년 만의 후속작이다.</body></html>");
	
	// 이미지
	Container cPane;
	// 로고
	ImageIcon Logosmallicon; JLabel Logosmall;
	// 포스터
	ImageIcon Antmanicon; JLabel Antman;

	public IntroAntman() {
		
		// 타이틀 및 내용글
		Color BGColor = new Color(23, 28, 45);
		
		setTitle("영화 소개");
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(BGColor);
		
		
		Font titleFt = new Font("돋움", Font.BOLD, 30);
		Font subtitleFt = new Font("돋움", Font.BOLD, 23);
		Font subFt = new Font("돋움", Font.ITALIC, 20);
		Font mainFt = new Font("견고딕", Font.CENTER_BASELINE, 17);
		
		// 폰트 및 글씨색
		
		title.setFont(titleFt);
		title.setForeground(Color.white);
		
		subtitle.setFont(subtitleFt);
		subtitle.setForeground(Color.white);
		
		cut.setFont(subtitleFt);
		cut.setForeground(Color.white);
		
		synopsis.setFont(subFt);
		synopsis.setForeground(Color.white);
		
		syn.setFont(mainFt);
		syn.setForeground(Color.white);
		
		outline.setFont(subFt);
		outline.setForeground(Color.white);
		
		ol.setFont(mainFt);
		ol.setForeground(Color.white);

		
		// 레이아웃 위치
		setLayout(null);
		
		add(title).setBounds(30, 515, 292, 30);
		title.setHorizontalAlignment(JLabel.CENTER);  // 가운데정렬
		
		add(subtitle).setBounds(330, 90, 440, 25);
		subtitle.setHorizontalAlignment(JLabel.CENTER);  // 가운데정렬
		
		add(cut).setBounds(335, 125, 440, 20);
		
		add(synopsis).setBounds(330, 155, 440, 25);
		synopsis.setHorizontalAlignment(JLabel.CENTER);  // 가운데정렬
		add(syn).setBounds(335, 185, 430, 100);
		
		
		add(outline).setBounds(330, 295, 440, 25);
		outline.setHorizontalAlignment(JLabel.CENTER);  // 가운데정렬
		add(ol).setBounds(335, 325, 430, 75);
	
		
		// 이미지
		cPane = getContentPane();
		cPane.setLayout(null);
		
		// 로고
		Logosmallicon = new ImageIcon("./images/logo/smalllogo.png");
		Logosmall = new JLabel(Logosmallicon);
		Logosmall.setBounds(-295, -260, getWidth(), getHeight());
		cPane.add(Logosmall);
		
		// 포스터
		Antmanicon = new ImageIcon("./images/poster/Antman.jpg");
		Antman = new JLabel(Antmanicon);
		Antman.setBounds(30, 80, Antmanicon.getIconWidth(), Antmanicon.getIconHeight());
		cPane.add(Antman);

		
		setVisible(true);

	}
	

	public static void main(String[] args) {
		new IntroAntman();
	}

}
