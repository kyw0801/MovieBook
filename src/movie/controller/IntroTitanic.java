package movie.controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IntroTitanic extends JFrame {

	// 타이틀 및 내용글
	JLabel title = new JLabel("타이타닉");
	JLabel subtitle = new JLabel("타이타닉 Titanic");
	JLabel cut = new JLabel("------------------------------------");
	JLabel synopsis = new JLabel("- SYSNOPSIS -");
	JLabel syn = new JLabel("<html><body style='text-align:left;'>우연한 기회로 티켓을 구해 타이타닉호에 올라탄 자유로운 영혼을 가진 화가 ‘잭’(레오나르도 디카프리오)은 막강한 재력의 약혼자와 함께 1등실에 승선한 ‘로즈’(케이트 윈슬렛)에게 한눈에 반한다.<br/>진실한 사랑을 꿈꾸던 ‘로즈’ 또한 생애 처음 황홀한 감정에 휩싸이고, 둘은 운명 같은 사랑에 빠지는데…</body></html>");
	JLabel outline = new JLabel("- OUTLINE -");
	JLabel ol = new JLabel("<html><body style='text-align:left;'>제임스 카메론의 1997년 영화. 제목 그대로 가장 유명한 침몰선 타이타닉호의 침몰 사고를 바탕으로, 두 남녀의 슬픈 사랑 이야기를 그렸다.</body></html>");

	// 이미지
	Container cPane;
	// 로고
	ImageIcon Logosmallicon; JLabel Logosmall;
	// 포스터
	ImageIcon Titanicicon; JLabel Titanic;

	public IntroTitanic() {

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
		add(syn).setBounds(335, 185, 430, 150);


		add(outline).setBounds(330, 345, 440, 25);
		outline.setHorizontalAlignment(JLabel.CENTER);  // 가운데정렬
		add(ol).setBounds(335, 375, 430, 75);


		// 이미지
		cPane = getContentPane();
		cPane.setLayout(null);

		// 로고
		Logosmallicon = new ImageIcon("./images/logo/smalllogo.png");
		Logosmall = new JLabel(Logosmallicon);
		Logosmall.setBounds(-295, -260, getWidth(), getHeight());
		cPane.add(Logosmall);

		// 포스터
		Titanicicon = new ImageIcon("./images/poster/Titanic.jpg");
		Titanic = new JLabel(Titanicicon);
		Titanic.setBounds(30, 80, Titanicicon.getIconWidth(), Titanicicon.getIconHeight());
		cPane.add(Titanic);


		setVisible(true);

	}

	public static void main(String[] args) {
		new IntroTitanic();
	}

}
