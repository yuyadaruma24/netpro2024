class Renshu {

    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }

    //ここに続きを実装していく。

    public int sumUpToN(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }
        return sum;
    }

    public int sumFromPtoQ(int p, int q){
        int sum = 0;
        for(int i = p;i <= q; i++){
            sum += i;
        }
        if(p >= q){
            sum = -1;
        }
        return sum;
    }

    int sumFromArrayIndex(int[] a, int index){
        int sum = 0;
        if(index >= a.length || index < 0){
            sum = -1;
            return sum;
        }
        for(int i=index;i < a.length;i++){
            sum += a[i];
        }
        return sum;
    }

    int selectMaxValue(int[] a){
        int max = a[0];
        for(int i = 0;i<a.length;i++){
            if(a[i] >= max){
                max = a[i];
            }
        }
        return max;
    }
    int selectMinValue(int[] a){
        int min = a[0];
        for(int i = 0;i<a.length;i++){
            if(a[i] <= min){
                min = a[i];
            }
        }
        return min;
    }

    int selectMaxIndex(int[] a){
        int maxIndex = 0;
        int max = a[0];
        for(int i = 0;i<a.length;i++){
            if(a[i] > max){
                max = a[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    int selectMinIndex(int[] a){
        int minIndex = 0;
        int min = a[0];
        for(int i = 0;i<a.length;i++){
            if(a[i] < min){
                min = a[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    void swapArrayElements(int[] p, int i, int j){
        int term = p[i];
        p[i] = p[j];
        p[j] = term;
    }

    boolean swapTwoArrays(int[] a, int[] b){
        if(a.length == b.length){
            for(int i = 0;i<a.length;i++){
                int term = a[i];
                a[i] = b[i];
                b[i] = term;
            }
            return true;
        }else{
            return false;
        }
    }
}