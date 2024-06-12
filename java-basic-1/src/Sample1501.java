import java.io.*;

class Sample1501 {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("なんか入力してください。");
        String s = new String(in.readLine());
        System.out.println("入力値は「" + s + "」です。");
    }
}