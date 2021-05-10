import org.junit.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class factorialTest {

    @org.junit.jupiter.api.Test
    void factorial(){
        assertEquals(new BigInteger("1"),factorial.factorial(1));
        assertEquals(new BigInteger("120"),factorial.factorial(5));
        assertEquals(new BigInteger("0"), factorial.factorial(-5));
    }
}