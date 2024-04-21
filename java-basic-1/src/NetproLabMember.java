import java.util.Random;
public class NetproLabMember {
    final int years = 15;

    public static void main(String[] args){
        Random random = new Random();
        int[][] newMen = new int[15][3];
        float rate = 1;
        for(int i = 0; i < 15; i ++){
            newMen[i][0] = 110 + random.nextInt(20) - 10;
            newMen[i][1] = newMen[i][0] * (20+i)/100;
            newMen[i][2] = 10 + random.nextInt(6) - 3;
            float manrate = newMen[i][1] / newMen[i][1];
            rate = rate* newMen[i][2] / manrate;
        }
        System.out.println(rate + "%");
    }
}
