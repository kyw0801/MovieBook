package movie.controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IntroTPM extends JFrame {

	// 타이틀 및 내용글
	JLabel title = new JLabel("교섭");
	JLabel subtitle = new JLabel("교섭 The Point Men");
	JLabel cut = new JLabel("------------------------------------");
	JLabel synopsis = new JLabel("- SYSNOPSIS -");
	JLabel syn = new JLabel("<html><body style='text-align:left;'>분쟁지역 아프가니스탄에서 한국인들이 탈레반에게 납치되는 최악의 피랍사건이 발생한다.</body></html>");
	JLabel outline = new JLabel("- OUTLINE -");
	JLabel ol = new JLabel("<html><body style='text-align:left;'>2023년 1월 18일에 개봉한 한국 영화.<br/>샘물교회 선교단 아프가니스탄 피랍 사건을 배경으로 한 실화 바탕 영화이다.</body></html>");

	// 이미지
	Container cPane;
	// 로고
	ImageIcon Logosmallicon; JLabel Logosmall;
	// 포스터
	ImageIcon ThePointMenicon; JLabel ThePointMen;

	public IntroTPM() {
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
		add(syn).setBounds(335, 185, 430, 50);


		add(outline).setBounds(330, 270, 440, 25);
		outline.setHorizontalAlignment(JLabel.CENTER);  // 가운데정렬
		add(ol).setBounds(335, 300, 430, 75);


		// 이미지
		cPane = getContentPane();
		cPane.setLayout(null);

		// 로고
		Logosmallicon = new ImageIcon("./images/logo/smalllogo.png");
		Logosmall = new JLabel(Logosmallicon);
		Logosmall.setBounds(-295, -260, getWidth(), getHeight());
		cPane.add(Logosmall);

		// 포스터
		ThePointMenicon = new ImageIcon("./images/poster/ThePointMen.jpg");
		ThePointMen = new JLabel(ThePointMenicon);
		ThePointMen.setBounds(30, 80, ThePointMenicon.getIconWidth(), ThePointMenicon.getIconHeight());
		cPane.add(ThePointMen);


		setVisible(true);
	}

	public static void main(String[] args) {
		new IntroTPM();
	}

}
