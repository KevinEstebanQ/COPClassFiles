import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static class MyhashTable{
        public enum Probing {LINEAR, QUADRATIC, DOUBLE_HASH};
        private final int NIL = Integer.MIN_VALUE;

        private final int m;            // table size
        private final int[] T;          // table storing integer keys
        private final Probing probing;


        public MyhashTable(int m, Probing probing){
            if(m<=0)throw new IllegalArgumentException("m Must be greater than 0");

            this.m = m;
            this.T = new int[m];
            Arrays.fill(T, NIL);
            this.probing = probing;
        }

        public int getLinearProbIndex(int key, int i){
            int h1 = key % m;
            return (h1 + i) % m;

        }

        public int getQuadraticProbing(int key, int i){
            int h1 = key % m;
            return (( h1 + i * i ) % m);

        }

        public int getDoubleHash(int key, int i){
            int h1 = key % m;
            int h2 = 1 + (key % (m - 1));
            return (h1 + (i*h2)) % m;

        }

        public int h(int key, int i){
            switch(probing){
                case QUADRATIC:
                    return getQuadraticProbing(key,  i);
                case DOUBLE_HASH:
                    return getDoubleHash(key,  i);
                case LINEAR:
                    return getLinearProbIndex(key,  i);
                default:
                    throw new AssertionError();
            }
        }
        public int hashInsert(int k){
            for (int i = 0; i < m ; i++) {
                int j = h(k, i);
                if (T[j] == NIL){
                    T[j] = k;
                    return j;
                }
            }
            throw new IllegalStateException("hash Table overflow");
        }

        public int hashSearch(int k){
            for (int i = 0; i < m ; i++) {
                int j = h(k, i);
                if(T[j] == k) return j;
                if(T[j] == NIL) return -1;
            }
            return -1;
        }

        @Override public String toString(){
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < m; i++) {
                if(i>0) sb.append(", ");
                sb.append(T[i] == NIL ? ".":T[i]);
            }
            return sb.append("]").toString();
        }
    }
    public static void main(String[] args) {
        MyhashTable Linear = new MyhashTable(21, MyhashTable.Probing.LINEAR);
        MyhashTable Quadratic = new MyhashTable(20, MyhashTable.Probing.QUADRATIC);
        MyhashTable Double = new MyhashTable(17, MyhashTable.Probing.DOUBLE_HASH);

        int[] keys = {21, 32, 43, 54, 65, 76, 87};

        for(int key : keys){
            Linear.hashInsert(key);
            Quadratic.hashInsert(key);
            Double.hashInsert(key);
        }
        System.out.println("Linear probing Hashtable: " + Linear.toString());
        System.out.println("Quadratic probing Hashtable: " + Quadratic.toString());
        System.out.println("Double Hashing probing Hashtable:" + Double.toString());
        System.out.println();

        int [] searchKeys = {32, 76, 1, 34, 10};
        for (int key : searchKeys){
            System.out.println("Linear: searching for: " + key);
            System.out.println("Result of search: "+ Linear.hashSearch(key));
            System.out.println("Quadratic: searching for: " + key);
            System.out.println("Result of search: "+ Quadratic.hashSearch(key));
            System.out.println("DoubleHash: searching for: " + key);
            System.out.println("Result of search: "+ Double.hashSearch(key));
            System.out.println();

        }
    }

}



