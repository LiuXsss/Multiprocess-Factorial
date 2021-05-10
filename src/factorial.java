import java.math.BigInteger;

public class factorial {

    //Time complexity: O(n)
    public static BigInteger factorial(long n){
        BigInteger res = new BigInteger("1");
        if(n <= 0){
            //return 0 means input is not valid
            return new BigInteger("0");
        } else if(n == 1){
            return res;
        } else {
            long point1 = n;
            long point2 = n / 3 * 2;
            long point3 = n / 3;

            res = res.multiply(factorialHelper(point1, point2 + 1));
            res = res.multiply(factorialHelper(point2, point3 + 1));
            res = res.multiply(factorialHelper(point3,1));

            return res;
        }
    }

    public static BigInteger factorialHelper(long end, long start){
        BigInteger res = new BigInteger("1");
        for (long i = start; i <= end; i++) {
            res = res.multiply(new BigInteger("" + i));
        }
        return res;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        factorial(100000);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }



}
