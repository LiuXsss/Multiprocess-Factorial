import java.math.BigInteger;
public class MultiprocessFactorialTest{

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        MultiprocessCalculate(100000);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public static BigInteger MultiprocessCalculate(long n){
        BigInteger res = new BigInteger("1");
        try {
            long point1 = n;
            long point2 = n / 3 * 2;
            long point3 = n / 3;

            MultiprocessFactorial p1 = new MultiprocessFactorial(point1, point2 + 1);
            MultiprocessFactorial p2 = new MultiprocessFactorial(point2, point3 + 1);
            MultiprocessFactorial p3 = new MultiprocessFactorial(point3,1);

            p1.start();
            p2.start();
            p3.start();

            p1.join();
            p2.join();;
            p3.join();


            res = res.multiply(p1.getResult());
            res = res.multiply(p2.getResult());
            res = res.multiply(p3.getResult());

        } catch (Exception e){

        }
        return res;
    }
}

class MultiprocessFactorial extends Thread{
    private long start;
    private long end;
    private BigInteger result;

    public MultiprocessFactorial(long x, long y){
        this.start = y;
        this.end = x;
        this.result = new BigInteger("1");
    }
    public BigInteger getResult(){
        return this.result;
    }

    public void run(){
            for(long i = this.start; i<= end; i++ ) {
                result = result.multiply(new BigInteger("" + i));
            }
    }
}
