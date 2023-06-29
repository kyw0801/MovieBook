package movie.controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class IntroSlamdunk extends JFrame {
	
	// 타이틀 및 내용글
	JLabel title = new JLabel("더 퍼스트 슬램덩크");
	JLabel subtitle = new JLabel("더 퍼스트 슬램덩크  The First Slam Dunk");
	JLabel cut = new JLabel("------------------------------------");
	JLabel synopsis = new JLabel("- SYSNOPSIS -");
	JLabel syn = new JLabel("<html><body style='text-align:left;'>전국 제패를 꿈꾸는 북산고 농구부 5인방의 꿈과 열정, 멈추지 않는 도전을 그린 영화</body></html>");
	JLabel outline = new JLabel("- OUTLINE -");
	JLabel ol = new JLabel("<html><body style='text-align:left;'>더 퍼스트 슬램덩크는 2022년 12월 3일에 개봉한 일본의 영화다. 슬램덩크의 신 극장판이며 슬램 덩크의 원작자 이노우에 다케히코가 감독과 각본을 맡았다.<br/>" + 
			"TV판 애니메이션에서 미처 다루지 못한, 많은 팬들이 그토록 원했던 원작 최종 보스 산왕공고(산노)와의 인터하이 32강전을 영상화한 극장판으로, 큰 틀에선 원작과 같으면서도 세부적으론 다른 연출과 스토리텔링을 사용한 게 돋보인다.</body></html>");
	
	// 이미지
	Container cPane;
	// 로고
	ImageIcon Logosmallicon; JLabel Logosmall;
	// 포스터
	ImageIcon Slamdunkicon; JLabel Slamdunk;

	public IntroSlamdunk() {
		
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
		add(ol).setBounds(335, 300, 430, 190);
	
		
		// 이미지
		cPane = getContentPane();
		cPane.setLayout(null);
		
		// 로고
		Logosmallicon = new ImageIcon("./images/logo/smalllogo.png");
		Logosmall = new JLabel(Logosmallicon);
		Logosmall.setBounds(-295, -260, getWidth(), getHeight());
		cPane.add(Logosmall);
		
		// 포스터
		Slamdunkicon = new ImageIcon("./images/poster/Slamdunk.jpg");
		Slamdunk = new JLabel(Slamdunkicon);
		Slamdunk.setBounds(30, 80, Slamdunkicon.getIconWidth(), Slamdunkicon.getIconHeight());
		cPane.add(Slamdunk);

		
		setVisible(true);

	}
	

	public static void main(String[] args) {
		
		new IntroSlamdunk();

	}

}
