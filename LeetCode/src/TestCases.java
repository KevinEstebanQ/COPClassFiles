import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCases {
    private static ArrayList<String[]> cases = new ArrayList<>();
    public TestCases(){
        cases.add(new String[]{"least","slate","stale","steal","tales","teals","stela","aster", "rates", "stare", "stear", "tares", "taser", "tears"});
        cases.add(new String[]{"enlist", "listen", "silent", "tinsel", "inlets", "linest","caters", "caster", "crates", "reacts", "recast", "traces"});
        cases.add(new String[]{"armets", "maters", "master", "ramets", "stream", "tamers","pastel", "petals", "plates", "pleats", "septal", "staple","rescue", "secure", "recuse", "ceruse", "cereus"});

    }
    public static boolean testAnagrams(Solution sl1){
        for(String[] s: cases){
            List<List<String>> ans = sl1.groupAnagrams(s);
            System.out.print("Current Test Case: " + Arrays.toString(s));
            System.out.print(" ");
            System.out.printf("output %s", ans);
            System.out.println();
        }
        return true;
    }

    public static void main(String[] args){
        new TestCases();
        Solution sl1 = new Solution();
        System.out.println(testAnagrams(sl1));
    }
}
