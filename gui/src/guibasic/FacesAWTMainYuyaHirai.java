package guibasic;
import java.awt.*;
import java.awt.event.*;

public class FacesAWTMainYuyaHirai {

    public static void main(String[] args) {
        new FacesAWTMainYuyaHirai();
    }

    FacesAWTMainYuyaHirai() {
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    class FaceFrame extends Frame {

        private int xStart0 = 50;
        private int yStart0 = 50;

        FaceFrame() {
        }

        public void paint(Graphics g) {
            FaceObj[] fobj = new FaceObj[9];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fobj[i * 3 + j] = new FaceObj();
                    fobj[i * 3 + j].setPosition(xStart0 + (250 * j), yStart0 + (250 * i));
                    fobj[i * 3 + j].setExpression(i * 3 + j);
                    fobj[i * 3 + j].drawFace(g);
                }
            }
        }
    }

    private class FaceObj {

        private int w = 200;
        private int h = 200;
        private int xStart;
        private int yStart;
        private int expression = 0;

        public void drawRim(Graphics g) {
            g.drawLine(xStart, yStart, xStart + w, yStart);
            g.drawLine(xStart, yStart, xStart, yStart + h);
            g.drawLine(xStart, yStart + h, xStart + w, yStart + h);
            g.drawLine(xStart + w, yStart, xStart + w, yStart + h);
        }

        public void setPosition(int i, int j) {
            this.xStart = i;
            this.yStart = j;
        }

        public void setExpression(int expression) {
            this.expression = expression;
        }

        public void drawFace(Graphics g) {
            drawRim(g);
            drawBrow(g);
            drawEye(g);
            drawNose(g);
            drawMouth(g);
        }

        public void drawBrow(Graphics g) {
            switch (expression) {
                case 0:
                    g.drawLine(xStart + 45, yStart + 20, xStart + 80, yStart + 45);
                    g.drawLine(xStart + 120, yStart + 45, xStart + 155, yStart + 20);
                    break;
                case 1:
                    g.drawLine(xStart + 45, yStart + 20, xStart + 80, yStart + 30);
                    g.drawLine(xStart + 120, yStart + 30, xStart + 155, yStart + 20);
                    break;
                case 2:
                    g.drawLine(xStart + 45, yStart + 30, xStart + 80, yStart + 20);
                    g.drawLine(xStart + 120, yStart + 20, xStart + 155, yStart + 30);
                    break;
                case 3:
                    g.drawArc(xStart + 45, yStart + 20, 35, 20, 0, -180);
                    g.drawArc(xStart + 120, yStart + 20, 35, 20, 0, -180);
                    break;
                case 4:
                    g.drawArc(xStart + 45, yStart + 20, 35, 20, 0, 180);
                    g.drawArc(xStart + 120, yStart + 20, 35, 20, 0, 180);
                    break;
                case 5:
                    g.drawLine(xStart + 45, yStart + 25, xStart + 80, yStart + 25);
                    g.drawLine(xStart + 120, yStart + 25, xStart + 155, yStart + 25);
                    break;
                case 6:
                    g.drawArc(xStart + 45, yStart + 20, 35, 15, 0, -180);
                    g.drawArc(xStart + 120, yStart + 20, 35, 15, 0, -180);
                    break;
                case 7:
                    g.drawArc(xStart + 45, yStart + 25, 35, 10, 0, 180);
                    g.drawArc(xStart + 120, yStart + 25, 35, 10, 0, 180);
                    break;
                case 8:
                    g.drawLine(xStart + 45, yStart + 20, xStart + 80, yStart + 20);
                    g.drawLine(xStart + 120, yStart + 20, xStart + 155, yStart + 20);
                    break;
                default:
                    g.drawLine(xStart + 45, yStart + 20, xStart + 80, yStart + 45);
                    g.drawLine(xStart + 120, yStart + 45, xStart + 155, yStart + 20);
                    break;
            }
        }

        public void drawNose(Graphics g) {
            switch (expression) {
                case 0:
                    g.drawLine(xStart + w / 2, yStart + h / 2, xStart + w / 2, yStart + h / 2 + 30);
                    break;
                case 1:
                    g.drawLine(xStart + w / 2, yStart + h / 2, xStart + w / 2, yStart + h / 2 + 20);
                    break;
                case 2:
                    g.drawLine(xStart + w / 2, yStart + h / 2, xStart + w / 2, yStart + h / 2 + 40);
                    break;
                case 3:
                    g.drawOval(xStart + w / 2 - 10, yStart + h / 2, 20, 20);
                    break;
                case 4:
                    g.drawOval(xStart + w / 2 - 5, yStart + h / 2, 10, 10);
                    break;
                case 5:
                    g.drawLine(xStart + w / 2 - 10, yStart + h / 2, xStart + w / 2 + 10, yStart + h / 2 + 20);
                    break;
                case 6:
                    g.drawLine(xStart + w / 2 - 10, yStart + h / 2 + 20, xStart + w / 2 + 10, yStart + h / 2);
                    break;
                case 7:
                    g.drawArc(xStart + w / 2 - 10, yStart + h / 2, 20, 20, 0, 180);
                    break;
                case 8:
                    g.drawArc(xStart + w / 2 - 10, yStart + h / 2, 20, 20, 0, -180);
                    break;
                default:
                    g.drawLine(xStart + w / 2, yStart + h / 2, xStart + w / 2, yStart + h / 2 + 30);
                    break;
            }
        }

        public void drawEye(Graphics g) {
            switch (expression) {
                case 0:
                    g.drawOval(xStart + 45, yStart + 65, 35, 35);
                    g.drawOval(xStart + 120, yStart + 65, 35, 35);
                    break;
                case 1:
                    g.drawOval(xStart + 45, yStart + 65, 30, 30);
                    g.drawOval(xStart + 120, yStart + 65, 30, 30);
                    break;
                case 2:
                    g.drawOval(xStart + 45, yStart + 65, 40, 40);
                    g.drawOval(xStart + 120, yStart + 65, 40, 40);
                    break;
                case 3:
                    g.drawOval(xStart + 45, yStart + 70, 35, 35);
                    g.drawOval(xStart + 120, yStart + 70, 35, 35);
                    break;
                case 4:
                    g.drawOval(xStart + 45, yStart + 60, 35, 35);
                    g.drawOval(xStart + 120, yStart + 60, 35, 35);
                    break;
                case 5:
                    g.drawOval(xStart + 50, yStart + 65, 30, 30);
                    g.drawOval(xStart + 125, yStart + 65, 30, 30);
                    break;
                case 6:
                    g.drawOval(xStart + 40, yStart + 65, 40, 40);
                    g.drawOval(xStart + 115, yStart + 65, 40, 40);
                    break;
                case 7:
                    g.drawOval(xStart + 45, yStart + 65, 35, 35);
                    g.drawLine(xStart + 55, yStart + 80, xStart + 70, yStart + 80);
                    g.drawLine(xStart + 130, yStart + 80, xStart + 145, yStart + 80);
                    break;
                case 8:
                    g.drawOval(xStart + 45, yStart + 65, 35, 35);
                    g.fillOval(xStart + 60, yStart + 80, 10, 10);
                    g.fillOval(xStart + 135, yStart + 80, 10, 10);
                    break;
                default:
                    g.drawOval(xStart + 45, yStart + 65, 35, 35);
                    g.drawOval(xStart + 120, yStart + 65, 35, 35);
                    break;
            }
        }

        public void drawMouth(Graphics g) {
            int xMiddle = xStart + w / 2;
            int yMiddle = yStart + h - 30;
            int width = 70;
            int height = 20;
            switch (expression) {
                case 0:
                    g.drawArc(xMiddle - width / 2, yMiddle - height / 2, width, height, 0, -180);
                    break;
                case 1:
                    g.drawArc(xMiddle - width / 2, yMiddle - height / 2, width, height, 0, 180);
                    break;
                case 2:
                    g.drawLine(xMiddle - width / 2, yMiddle, xMiddle + width / 2, yMiddle);
                    break;
                case 3:
                    g.drawArc(xMiddle - width / 2, yMiddle - height / 2, width, height / 2, 0, 180);
                    break;
                case 4:
                    g.drawArc(xMiddle - width / 2, yMiddle, width, height / 2, 0, -180);
                    break;
                case 5:
                    g.drawArc(xMiddle - width / 2, yMiddle - height / 4, width, height / 2, 0, -180);
                    break;
                case 6:
                    g.drawLine(xMiddle - width / 2, yMiddle, xMiddle + width / 2, yMiddle);
                    g.drawLine(xMiddle - width / 4, yMiddle, xMiddle - width / 4, yMiddle + height / 2);
                    g.drawLine(xMiddle + width / 4, yMiddle, xMiddle + width / 4, yMiddle + height / 2);
                    break;
                case 7:
                    g.drawArc(xMiddle - width / 2, yMiddle, width, height, 0, 180);
                    break;
                case 8:
                    g.drawArc(xMiddle - width / 2, yMiddle - height / 4, width, height, 0, -180);
                    break;
                default:
                    g.drawLine(xMiddle - width / 2, yMiddle, xMiddle + width / 2, yMiddle);
                    break;
            }
        }
    }
}
