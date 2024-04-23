
// C言語では、#include に相当する
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader というのは、データ読み込みのクラス(型)
        // クラスの変数を作るには、new を使う。

        // readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
        // Java では、 try{ XXXXXXXX } catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
        try {
            while (true) {
                System.out.println("何歳ですか?");
                String line = reader.readLine();
                if (line.equals("q") || line.equals("n")) {
                    System.out.println("終了します。");
                    break;
                }
                int age = Integer.parseInt(line);
                if (age >= 120 || age < 0) {
                    System.out.println("再入力をしてください。");
                    continue;
                }
                int now = 2024;
                System.out.println("あなたは" + age + "歳ですね。");
                System.out.println("あなたは2030年、" + (age + 2030 - now) + "歳ですね。");
                System.out.print("あなたが生まれた年は");
                if (now - age >= 2019) {
                    int year = now - age - 18;
                    String wareki = Integer.valueOf(year).toString();
                    System.out.print("令和" + wareki.charAt(2) + wareki.charAt(3));
                } else if (now - age >= 1989) {
                    int year = now - age + 12;
                    String wareki = Integer.valueOf(year).toString();
                    System.out.print("平成" + wareki.charAt(2) + wareki.charAt(3));
                } else if (now - age >= 1926) {
                    int year = now - age - 25;
                    String wareki = Integer.valueOf(year).toString();
                    System.out.print("昭和" + wareki.charAt(2) + wareki.charAt(3));
                } else if (now - age >= 1912) {
                    int year = now - age - 11;
                    String wareki = Integer.valueOf(year).toString();
                    System.out.print("大正" + wareki.charAt(2) + wareki.charAt(3));
                } else if (now - age > 1868) {
                    int year = now + 33;
                    String wareki = Integer.valueOf(year).toString();
                    System.out.print("明治" + wareki.charAt(2) + wareki.charAt(3));
                }
                System.out.println("年ですね");
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}

// 課題 キーボードから数字を打ち込む
// その結果、 あなたは、???歳ですね、と画面に表示させる。
// その後、あなたは10年後、????歳ですね、と画面に表示させる。
