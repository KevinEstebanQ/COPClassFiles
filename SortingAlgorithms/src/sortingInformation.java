public class sortingInformation{
    int swaps;
    int comparisons;
    int loops;

    public sortingInformation(){
        this.swaps =0;
        this.comparisons =0;
        this.loops =0;
    }

    @Override
    public String toString() {
        return "swaps: "+ swaps + ", comparisons: " + comparisons + " " + ",  loops: " + loops;
    }
}
