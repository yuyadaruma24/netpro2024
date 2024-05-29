public class CharAtExample {
    public static void main(String[] args) {
    
        String message = "Hello, Java!";

				// 引数にint, 返り値がcharであることはわかっている！
        char fifthCharacter = message.charAt(4); 

        System.out.println("文字列 '" + message + "' の5番目の文字は '" + fifthCharacter + "' です。");
    }
}
