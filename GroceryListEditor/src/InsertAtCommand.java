import java.lang.reflect.Array;
import java.util.ArrayList;

public class InsertAtCommand extends UndoCommand {
    // TODO: Add field declarations here
        ArrayList<String> list;
        int index;
        String value;
    // TODO: Add constructor code here
        public InsertAtCommand(ArrayList<String> list, int index, String value){
            this.list = list;
            this.index = index;
            this.value = value;
        }
    @Override
    public void execute() {
        // TODO: Type your code here
        list.add(index, value);
    }
}
