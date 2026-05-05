import java.util.*;
import java.io.PrintWriter;

public class GroceryList {
    protected ArrayList<String> listItems = new ArrayList<String>();
    protected Stack<UndoCommand> undoStack = new Stack<UndoCommand>();

    public void addWithUndo(String newItemName) {
        // Add the new list item
        listItems.add(newItemName);

        // Make an undo command that removes the last item and push onto stack
        undoStack.push(new RemoveLastCommand(listItems));
    }

    public void removeAtWithUndo(int removalIndex) {
        // TODO: Type your code here
            String removed = listItems.remove(removalIndex);
            undoStack.push(new InsertAtCommand(listItems, removalIndex, removed));
    }

    public void swapWithUndo(int index1, int index2) {
        // TODO: Type your code here
        String tmp = listItems.get(index1);
        listItems.set(index1, listItems.get(index2));
        listItems.set(index2, tmp);

        undoStack.push(new SwapCommand(listItems, index1, index2));

    }

    // Pop and execute the command at the top of the stack
    public void executeUndo() {
        // TODO: Type Your code here
        if(!undoStack.isEmpty()){
            undoStack.pop().execute();
        }
    }

    public int getListSize() {
        return listItems.size();
    }

    public int getUndoStackSize() {
        return undoStack.size();
    }

    public String[] getItemList() {
        String[] itemArray = new String[listItems.size()];
        itemArray = listItems.toArray(itemArray);
        return itemArray;
    }

    public void print(PrintWriter out) {
        for (int i = 0; i < listItems.size(); i++) {
            out.println(i + ". " + listItems.get(i));
        }
    }
}
