package movie.controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IntroAvatar extends JFrame {
	
	// 타이틀 및 내용글
	JLabel title = new JLabel("아바타: 물의 길");
	JLabel subtitle = new JLabel("아바타: 물의 길  Avatar: The Way of Water");
	JLabel cut = new JLabel("------------------------------------");
	JLabel synopsis = new JLabel("- SYSNOPSIS -");
	JLabel syn = new JLabel("<html><body style='text-align:left;'>'제이크 설리'와 '네이티리'가 이룬 가족이 겪게 되는 무자비한 위협과 살아남기 위해 떠나야 하는 긴 여정과 전투, 그리고 견뎌내야 할 상처에 대한 이야기를 그렸다.</body></html>");
	JLabel outline = new JLabel("- OUTLINE -");
	JLabel ol = new JLabel("<html><body style='text-align:left;'>아바타 시리즈의 두 번째 영화. 전작 이후 무려 13년 만의 후속작이다.</br>코로나19 팬데믹 발발 이후 첫 번째 천만 외화이자 두 번째 천만 영화이다.</body></html>");
	
	// 이미지
	Container cPane;
	// 로고
	ImageIcon Logosmallicon; JLabel Logosmall;
	// 포스터
	ImageIcon Avataricon; JLabel Avatar;

	public IntroAvatar() {
		
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
		Avataricon = new ImageIcon("./images/poster/Avatar.jpg");
		Avatar = new JLabel(Avataricon);
		Avatar.setBounds(30, 80, Avataricon.getIconWidth(), Avataricon.getIconHeight());
		cPane.add(Avatar);

		
		setVisible(true);

	}
	

	public static void main(String[] args) {
		new IntroAvatar();
	}

}
