import java.util.Scanner;

public class XmasTreeKadai {
    public static void main(String[] args) {
        int numberOfhalfleaf;
        int widthOfStem;
        int heightOfStem;
        String mark;

        Scanner scan = new Scanner(System.in);
            
			String str = scan.next();
            String[] word = str.split(",");//splitメソッドの引数に、どこの文字で分割するか指定します。この場合は空白文字。

            numberOfhalfleaf = Integer.parseInt(word[0]);
            widthOfStem = Integer.parseInt(word[1]);
            heightOfStem = Integer.parseInt(word[2]);
            mark = word[3];
            
            System.out.println("最大の葉の半分の横幅の数"+word[0]);
            System.out.println("幹の幅列"+word[1]);
            System.out.println("幹の長さ"+word[2]);
            System.out.println("十字架もようの雪など"+word[3]);
        scan.close();

        for(int i = 0; i < numberOfhalfleaf;i++){
            for(int j = 0; j < numberOfhalfleaf-1-i + (i+1) *2; j++){
                if(j >= numberOfhalfleaf+1 -i){
                    System.out.print("*");
                }else{
                    if(i % 3 == 0){
                        if(j %3 ==1 || j %3 == 2){
                            System.out.print(" ");
                        }else{
                            System.out.print(mark);
                        }
                    }else if(i % 3 == 1){
                        if(j %3 ==0 || j %3 == 1){
                            System.out.print(" ");
                        }else{
                            System.out.print(mark);
                        }
                    }else{
                        if(j %3 ==0 || j %3 == 2){
                            System.out.print(" ");
                        }else{
                            System.out.print(mark);
                        }
                    }
                }
            }
            System.out.println();
        }
        for(int i = 0; i < heightOfStem; i++){
            for(int j = 0;j <= numberOfhalfleaf + widthOfStem/2; j++){
                if(j < numberOfhalfleaf - widthOfStem/2){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }    
            System.out.println();
        }
	}
}
