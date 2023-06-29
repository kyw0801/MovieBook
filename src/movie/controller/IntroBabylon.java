package movie.controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IntroBabylon extends JFrame {

	// 타이틀 및 내용글
	JLabel title = new JLabel("바빌론");
	JLabel subtitle = new JLabel("바빌론 Babylon");
	JLabel cut = new JLabel("------------------------------------");
	JLabel synopsis = new JLabel("- SYSNOPSIS -");
	JLabel syn = new JLabel("<html><body style='text-align:left;'>황홀하면서도 위태로운 고대 도시, '바빌론'에 비유되던 할리우드. '꿈' 하나만을 위해 모인 사람들이 이를 쟁취하기 위해 벌이는 강렬하면서도 매혹적인 이야기</body></html>");
	JLabel outline = new JLabel("- OUTLINE -");
	JLabel ol = new JLabel("<html><body style='text-align:left;'>데미언 샤젤의 다섯번째 장편 영화.<br/>무성영화에서 유성영화로 넘어가던 1920년대 할리우드를 배경으로, 영화를 만드는 사람들의 욕망과 사랑에 대한 이야기를 그렸다.</body></html>");

	// 이미지
	Container cPane;
	// 로고
	ImageIcon Logosmallicon; JLabel Logosmall;
	// 포스터
	ImageIcon Babylonicon; JLabel Babylon;

	public IntroBabylon() {

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
		add(syn).setBounds(335, 185, 430, 75);


		add(outline).setBounds(330, 270, 440, 25);
		outline.setHorizontalAlignment(JLabel.CENTER);  // 가운데정렬
		add(ol).setBounds(335, 300, 430, 100);


		// 이미지
		cPane = getContentPane();
		cPane.setLayout(null);

		// 로고
		Logosmallicon = new ImageIcon("./images/logo/smalllogo.png");
		Logosmall = new JLabel(Logosmallicon);
		Logosmall.setBounds(-295, -260, getWidth(), getHeight());
		cPane.add(Logosmall);

		// 포스터
		Babylonicon = new ImageIcon("./images/poster/Babylon.jpg");
		Babylon = new JLabel(Babylonicon);
		Babylon.setBounds(30, 80, Babylonicon.getIconWidth(), Babylonicon.getIconHeight());
		cPane.add(Babylon);


		setVisible(true);

	}

	public static void main(String[] args) {
		new IntroBabylon();
	}

}
