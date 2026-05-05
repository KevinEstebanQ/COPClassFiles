import java.util.ArrayList;

public class SwapCommand extends UndoCommand {
    // TODO: Add field declarations here
        ArrayList<String> list;
        int i;
        int j;
    // TODO: Add constructor code here

    public SwapCommand(ArrayList<String> list, int i, int j) {
        this.list = list;
        this.i = i;
        this.j = j;
    }

    @Override
    public void execute() {
        // TODO: Type your code here
        String tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

}
