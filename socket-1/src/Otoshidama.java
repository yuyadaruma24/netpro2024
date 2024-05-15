import java.io.Serializable;
import java.util.Random;

public class Otoshidama implements Serializable{
    String age;
    String otoshidama;

    Random random = new Random();

    public String getAge(){
        return age;
    }

    public void setAge(String age){
        this.age = age;
    }

    public String getOtoshidama(){
        return otoshidama;
    }

    public void setOtoshidama(String otoshidama){
        this.otoshidama = otoshidama;
    }

    public String caliculateOtoshidama(int age, String kibou){
        int amountOfOtoshidama = 1000;
        if(age <= 5){
            amountOfOtoshidama = amountOfOtoshidama*random.nextInt(5);
        }else if(age <= 10){
            amountOfOtoshidama = amountOfOtoshidama*(random.nextInt(5)+5);
        }else if(age <= 15){
            amountOfOtoshidama = amountOfOtoshidama*(random.nextInt(5)+10);
        }else if(age <= 20){
            amountOfOtoshidama = amountOfOtoshidama*(random.nextInt(5)+15);
        }else{
            return "自分で稼ごう!!";
        }
        int diffrence = amountOfOtoshidama - Integer.parseInt(kibou);
        return amountOfOtoshidama + "円です!! \n 差額は" + diffrence + "円です。";
    }
}
