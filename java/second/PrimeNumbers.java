import java.util.ArrayList;
public class PrimeNumbers {

    public final static int POWER = 21;
    protected final static int[] SIEVE = new int[1<<POWER];

    public static boolean isPrime(int z) {
        if (SIEVE[z] == 1)
            return true;
        else
            return false;
    }


    protected static final void  normalSieve() {
        int i, j;
        for (int z = 2; z < 1<<POWER; z++) {
            SIEVE[z] = 1;
        }
        SIEVE[0] = 0;
        SIEVE[1] = 0;

        for (i = 2; i*i <= 1<<POWER; i++){
            for (j = i*i; j < 1<<POWER; j+=i) {
                if (SIEVE[j] == 1) {
                    SIEVE[j] = 0;
                }
            }
        }
    }


    public static final long  product(ArrayList<Long> l) {
        long product = 1;
        for (long elm : l) {
            product *= elm;
        }

        return product;
    }


    public static ArrayList<Long> factorization(long number){
        long numberCopy = number;
        ArrayList<Long> primes = new ArrayList<Long>();
        for (int z = 2; z < (1<<21); z++){
            if (isPrime(z)){
                while (number % z == 0) {
                    primes.add(Long.valueOf(z));
                    number /= z;
                }
            }
        }

        if (primes.size() == 0)
            primes.add(number);
        if (numberCopy != product(primes)){
            primes.addAll(factorization(numberCopy / product(primes)));
        }
        return primes;
    }
    
    public static ArrayList<Long> factorizationFinal(long number){
        normalSieve();
        return factorization(number);
    }
}
