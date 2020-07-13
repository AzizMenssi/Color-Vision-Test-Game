import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class End extends JPanel implements MouseListener{
	JLabel Score,B,C,T,M,F,D,Lb,Lc,Lt,Lm,Lf,Ld,Catch;
	Image Bi,Ci,Ti,Mi,Fi,Di;
	ImageIcon Bc,Cc,Tc,Mc,Fc,Dc; 
	long S=0;
	JButton Play,Exit;
	Game E;
	public End() {
		// TODO Auto-generated consructor stub
		this .setSize(1000,1050);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		E=(Game) this.getParent();
		Score=new JLabel("Your Score : "+Game.score);
		Score.setBounds(260,70,800,200);
		Score.setFont(new Font("Arial",10,70));
		this.add(Score);
		Bc=new ImageIcon("src/Bat.jpg");
		Bi=Bc.getImage().getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH);
		Bc=new ImageIcon(Bi);
		B=new JLabel(Bc);
		B.setBounds(200,350,200,200);
		this.add(B);
		Mc=new ImageIcon("src/Mole.png");
		Mi=Mc.getImage().getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH);
		Mc=new ImageIcon(Mi);
		M=new JLabel(Mc);
		M.setBounds(400,350,200,200);
		this.add(M);
		Cc=new ImageIcon("src/Cat.png");
		Ci=Cc.getImage().getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH);
		Cc=new ImageIcon(Ci);
		C=new JLabel(Cc);
		C.setBounds(600,350,200,200);
		this.add(C);
		Dc=new ImageIcon("src/Dog.jpg");
		Di=Dc.getImage().getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH);
		Dc=new ImageIcon(Di);
		D=new JLabel(Dc);
		D.setBounds(200,550,200,200);
		this.add(D);
		Tc=new ImageIcon("src/Tiger.png");
		Ti=Tc.getImage().getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH);
		Tc=new ImageIcon(Ti);
		T=new JLabel(Tc);
		T.setBounds(400,550,200,200);
		this.add(T);
		Fc=new ImageIcon("src/Falcon.png");
		Fi=Fc.getImage().getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH);
		Fc=new ImageIcon(Fi);
		F=new JLabel(Fc);
		F.setBounds(590,550,200,200);
		this.add(F);
		Lb=new JLabel("0 - 4");
		Lb.setBounds(270,450,200,200);
		Lb.setFont(new Font("Arial",10,40));
		this.add(Lb);
		Lm=new JLabel("5 - 9");
		Lm.setBounds(460,450,200,200);
		Lm.setFont(new Font("Arial",10,40));
		this.add(Lm);
		Lc=new JLabel("10 - 14");
		Lc.setBounds(640,450,200,200);
		Lc.setFont(new Font("Arial",10,40));
		this.add(Lc);
		Ld=new JLabel("15 - 19");
		Ld.setBounds(240,650,200,200);
		Ld.setFont(new Font("Arial",10,40));
		this.add(Ld);
		Lt=new JLabel("20 - 24");
		Lt.setBounds(440,650,200,200);
		Lt.setFont(new Font("Arial",10,40));
		this.add(Lt);
		Lf=new JLabel("25 - 29");
		Lf.setBounds(640,650,200,200);
		Lf.setFont(new Font("Arial",10,40));
		this.add(Lf);
		if(Game.score!=0)S=Game.speed/Game.score;
		else S=Game.speed;
		Catch=new JLabel("Your Catch Rate : "+S);
		Catch.setBounds(370,210,400,100);
		Catch.setFont(new Font("Arial",11,30));
		this.add(Catch);
		Play=new JButton("Play Again");
		Play.setBounds(290,290,200,80);
		Play.setBorder(BorderFactory.createLineBorder(Color.white,2));
		Play.setBackground(Color.white);
		Play.setFocusable(false);
		Play.setFocusPainted(false);
		Play.setFont(new Font("Arial",10,30));
		this.add(Play);
		Play.addMouseListener(this);
		Exit=new JButton("Exit");
		Exit.setBounds(540,290,100,80);
		Exit.setBorder(BorderFactory.createLineBorder(Color.white,2));
		Exit.setBackground(Color.white);
		Exit.setFocusable(false);
		Exit.setFocusPainted(false);
		Exit.setFont(new Font("Arial",10,30));
		this.add(Exit);
		Exit.addMouseListener(this);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Play) {
			java.awt.Window win[]=java.awt.Window.getWindows();
			for(int i=0;i<win.length;i++) {
				win[i].dispose();
				win[i]=null;
			}
			Game A=new Game(2,10,10,10,0,30,0);
			A.setVisible(true);
		}
		if(e.getSource()==Exit) {
			System.exit(0);
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
