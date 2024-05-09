import java.util.ArrayList;
import java.util.Random;

public class HeikinCKadai {
    public static final int N = 100;
    Kamoku[] result = new Kamoku[N];
    public static void main(String[] args){
        HeikinCKadai heikinCKadai = new HeikinCKadai();
        heikinCKadai.resultScores();
        heikinCKadai.average();
        heikinCKadai.passStudents();
    }

    void HeikinCKadai(){
    }

    void resultScores(){
        Random r = new Random();
        for(int i = 0; i< N;i++){
            int score = r.nextInt(N+1);
            result[i] = new Kamoku(score);
        }
    }

    void average(){
        int sum = 0;
        for(int i = 0; i < result.length;i++){
            sum += result[i].getScore();
        }
        System.out.println("*平均点は" + (sum / N) + "*");
    }
    void passStudents(){
        System.out.println("*以下合格者の点数です。*");
        ArrayList<Kamoku> highScore = new ArrayList<Kamoku>();
        for(int i = 0;i < result.length;i++){
            if (result[i].getScore() >= 80) {
                System.out.println("*" + result[i].getScore() + "*");
                highScore.add(new Kamoku(result[i].getScore()));
            }
        }

        sort(highScore);
        

        System.out.println("ソートを行うと…");
        for(Kamoku score : highScore){
            System.out.println(score.getScore());
        }

    }

    void sort(ArrayList<Kamoku> highScore){
        for(int i = 0;i < highScore.size();i++){
            Kamoku min = highScore.get(i);
            int location = i;
            for(int j = i+1;j < highScore.size();j++){
                if(highScore.get(j).getScore() < highScore.get(location).getScore()){
                    location = j;
                }
            }
            min = highScore.get(location);
            highScore.set(location, highScore.get(i));
            highScore.set(i, min);
        }
    }
}
