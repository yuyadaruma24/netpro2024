import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MayExceptionTest {

	public static void main(String[] args) {

		MayExceptionTest myE=new MayExceptionTest();

	}

	MayExceptionTest(){
		while (true) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				System.out.println("何日ですか?");
				String line = reader.readLine();
				int theday = Integer.parseInt(line);
				System.out.println("日付：" + theday + "日。");

				test(theday);
			}catch(IOException e) {
				System.out.println(e);
			}catch (NoHolidayException e) {
				e.printStackTrace();
			}	
		}
	}

	void test(int theday) throws NoHolidayException{
		if (theday <= 31) {
			if(theday !=3 || theday != 4|| theday != 5 || theday != 6 || theday != 11 || theday != 12 || theday != 18 || theday != 19 || theday != 25 || theday != 26){
				throw new NoHolidayException();
			}
		}
	}
}
