import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Game extends JFrame implements MouseListener{
		JButton[] Tab;
		static int score=0,time=60;
		int a,r,g,b,x,ind;
		long start=0,end=0,diff;
		JPanel Center,North;
		MonThread T=new MonThread();
		JLabel ScoreL,TimeL,CatchL;
		JButton Skip=new JButton(">>");
		Game N;
		static Game G;
		static long speed=0;
		public Game(int a, int r ,int g ,int b,int s,int t,long d) {
			// TODO Auto-generated constructor stub
			this .setSize(1000,1050);
			Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
			this.setLayout(new BorderLayout());
			this.setResizable(false);
			North=new JPanel();
			North.setPreferredSize(new Dimension(1000,50));
			North.setLayout(null);
			North.setBackground(Color.white);
			this.score=s;
			this.time=t;
			this.diff=d;
			
			ScoreL=new JLabel("Score : "+score);
			TimeL=new JLabel("Time : "+t);
			CatchL=new JLabel("Catch Rate : "+d);
			ScoreL.setBounds(10,5,100,50);
			TimeL.setBounds(460,5,100,50);
			Skip.setBounds(500,5,100,50);
			CatchL.setBounds(840,5,120,50);
			ScoreL.setFont(new Font("Arial",10,15));
			TimeL.setFont(new Font("Arial",10,15));
			CatchL.setFont(new Font("Arial",10,15));
			Skip.setFont(new Font("Arial",10,10));
			North.add(ScoreL);
			North.add(TimeL);
			North.add(CatchL);
			North.add(Skip);
			Skip.setContentAreaFilled(false);
			Skip.setFocusable(false);
			Skip.setBorderPainted(false);
			Skip.addMouseListener(this);
			this.add(North,BorderLayout.NORTH);
			
			
			
			Center=new JPanel();
			this.add(Center,BorderLayout.CENTER);
			Center.setLayout(new GridLayout(a,a));
			Center.setBorder(BorderFactory.createLineBorder(Color.white,4));
			this.x=a*a;
			this.a=a;
			this.r=r;
			this.g=g;
			this.b=b;
			Tab=new JButton[x];
			for(int i=0;i<x;i++) {
				Tab[i]=new JButton();
				Tab[i].setBorder(BorderFactory.createLineBorder(Color.white,2));
				Center.add(Tab[i]);
				Tab[i].addMouseListener(this);
				Tab[i].setBackground(new Color(r,g,b));
			}
			T.start();
			N=this;
			G=N;
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			for(int i=0;i<x;i++) {
				
			if((arg0.getSource()==Tab[ind])&&(i==ind)) {
				int c1=(int)(Math.random()*255);
				int c2=(int)(Math.random()*255);
				int c3=(int)(Math.random()*255);
				this.r=c1;
				this.g=c2;
				this.b=c3;
				end=System.currentTimeMillis();
				this.diff=end-start;
				speed=speed+diff;
				N=new Game(++a,this.r,this.g,this.b,++this.score,this.time,diff);
				N.setVisible(true);
				T.stop();
				G=N;
				this.dispose();
				
				}
			else if((arg0.getSource()==Tab[i])&&(i!=ind)){
				
			}
			}
			if(arg0.getSource()==Skip) {
				time=0;
			}
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

class MonThread extends Thread{
	@Override
	public void run() {
				ind=(int)(Math.random()*x);
				if(r>240)r=r-15;
				else r=r+15;
				if(g>240)g=g-15;
				else g=g+15;
				if(b>240)b=b-15;
				else b=b+15;
				Tab[ind].setBackground(new Color(r,g,b));
				start=System.currentTimeMillis();
				while(time>0) {
					try {
						T.sleep(1000);
						time=time-1;

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(time<=0) {
						End E=new End();
						E.setVisible(true);
						G.remove(North);
						Center.removeAll();
						Center.setLayout(null);
						E.setBounds(0,0,1000,1050);
						Center.add(E);
						Center.revalidate();
						Center.repaint();
						G.revalidate();
						G.repaint();
						T.stop();

					}
					TimeL.setText("Time : "+time);

				}
				
				
		}

	private void add(JPanel new1, String center) {
		// TODO Auto-generated method stub
		
	}

	private void remove(JPanel p) {
		// TODO Auto-generated method stub
		
	}
	

}
}
