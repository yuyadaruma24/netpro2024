import java.io.Serializable;

public class TaskObject implements Serializable,ITask {

    int number;
    int result;

    @Override
    public void setExecNumber(int x){
        this.number = x;
    }

    @Override
    public void exec(){
        
        outLoop:for(int n = number;n >= 2;n--){
            if (n <= 1) {
                result = 0;
                break;
            }
            if (n <= 3) {
                result = n;
                break;
            }
            
            // 2と3の倍数以外の奇数を確認
            if (n % 2 == 0 || n % 3 == 0) {
                continue;
            }
            
            // 6k ± 1の形の数のみを確認
            for (int i = 5; i * i <= n; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    continue outLoop;
                }
            }
            result = n;
            break;
        }
    }

    @Override
    public int getResult(){
        return result;
    }

    public boolean numJudge(){
        if(number <= 1){
            return false;
        }
        return true;
    }
}
