public class NoHolidayException extends Exception {
    
    public void printStackTrace() {
        System.err.println("エラー：平日です。");
    }
}