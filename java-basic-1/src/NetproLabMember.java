import java.util.Random;
public class NetproLabMember {
    final int years = 15;

    public static void main(String[] args){
        Random random = new Random();
        int[][] newMenber = new int[15][3];
        float rate = 1;
        for(int i = 0; i < 15; i ++){
            newMenber[i][0] = 110 + random.nextInt(20) - 10; //入学生数
            newMenber[i][1] = newMenber[i][0] * (20+i)/100;        //女子の割合
            newMenber[i][2] = 10 + random.nextInt(6) - 3;    //岩井研の新メンバー
            float manRate = newMenber[i][1] / newMenber[i][1];     //男の割合
            rate = rate* newMenber[i][2] / manRate;
        }
        System.out.println(rate + "%");
    }
}
