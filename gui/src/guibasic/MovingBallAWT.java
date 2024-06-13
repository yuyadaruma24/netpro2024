package guibasic;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MovingBallAWT {
	
	static int xSize = 500;
	static int ySize = 500;
	public static void main(String[] args) {
		FFrame f = new FFrame();
		f.setSize(xSize, ySize);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setVisible(true);
	}


	static class FFrame extends Frame implements Runnable {

		Thread th;
		Ball[] balls;
		Random r = new Random();

		private boolean enable = true;

		FFrame() {
			th = new Thread(this);
			th.start();
		}

		public void run() {
			balls = new Ball[5];
			for (int i = 0; i < balls.length; i++) {
				balls[i] = new Ball();
				balls[i].setPosition(r.nextInt(xSize), r.nextInt(ySize));
				balls[i].setR(r.nextInt(20) + 10);
				balls[i].setColor(r.nextInt(256), r.nextInt(256), r.nextInt(256));
			}

			while (enable) {
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				for (Ball ball : balls) {
					ball.move();
				}

				repaint();  // paint()メソッドが呼び出される
			}
		}

		public void paint(Graphics g) {
			for (Ball ball : balls) {
				ball.draw(g);
			}
		}

		// Ball というインナークラスを作る
		class Ball {
			int x;
			int y;
			int r; // 半径
			Color c = new Color(0, 0, 0);

			Random rand = new Random();

			int xDir = 1;  // 1:+方向  -1: -方向
			int yDir = 1;

			void setColor(int r, int g, int b) {
				this.c = new Color(r, g, b);
			}

			void move() {
				boolean hitWall = false;

				if ((xDir == 1) && (x >= xSize - r * 2)) {
					xDir = -1;
					hitWall = true;
				}
				if ((xDir == -1) && (x <= 0)) {
					xDir = 1;
					hitWall = true;
				}

				if (xDir == 1) {
					x = x + 10;
				} else {
					x = x - 10;
				}

				if ((yDir == 1) && (y >= ySize - r * 2)) {
					yDir = -1;
					hitWall = true;
				}
				if ((yDir == -1) && (y <= 0 + r)) {
					yDir = 1;
					hitWall = true;
				}

				if (yDir == 1) {
					y = y + 10;
				} else {
					y = y - 10;
				}

				if (hitWall) {
					setColor(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
				}
			}

			void setPosition(int x, int y) {
				this.x = x;
				this.y = y;
			}

			void setR(int r) {
				this.r = r;
			}

			void draw(Graphics g) {
				g.setColor(c);
				g.fillOval(x, y, 2 * r, 2 * r);  // rは半径なので2倍にする
			}
		} // inner class Ball end
	}
}
