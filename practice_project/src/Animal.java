public abstract class Animal {
	private String name;
    private String food;

	public Animal(String name) {
		this.name = name;
	}

	public String sound() {
		return null;
	}

    public void setFood(String food) {
        this.food = food;
    }

    public String getFood(){
        return this.food;
    }

    public String toString() {
        return name.concat(" says ").concat(sound().concat(" and eats ").concat(food));
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
	public String sound() {
		return "Woof";
	}
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
	public String sound() {
		return "Meow";
	}
}

class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }
	public String sound() {
		return "Moo";
	}
}

class Tree {
    public node[] nodeList;

    public class node {
        int valor;
        node left;
        node right;

        node(int valor) {
            this.valor = valor;
            this.left = null;
            this.right = null;
        }

    }
    Tree() {
        nodeList = new node[10];
    }
    public void addNode(int valor){
        if (nodeList[0] == null) {
            nodeList[0] = new node(valor);
        } else {
            addNodeHelper(nodeList[0], valor);
        }
    }

    private void addNodeHelper(node currentNode, int valor){
        if(valor < currentNode.valor){
            if (currentNode.left == null) {
                currentNode.left = new node(valor);
            } else {
                addNodeHelper(currentNode.left, valor);
            }
        } else {
            if (currentNode.right == null) {
                currentNode.right = new node(valor);
            } else {
                addNodeHelper(currentNode.right, valor);
            }
        }
    }
    public void printInOrder(){
        printInOrderHelper(nodeList[0]);
    }
    private void printInOrderHelper(node currentNode){
        if (currentNode != null) {
            printInOrderHelper(currentNode.left);
            System.out.println(currentNode.valor);
            printInOrderHelper(currentNode.right);
        }
    }
    public void dfs(){
        dfsHelper(nodeList[0]);
    }
    private void dfsHelper(node currentNode){
        if (currentNode == null) {
            return;
        }
        System.out.println(currentNode.valor);
        dfsHelper(currentNode.left);
        dfsHelper(currentNode.right);
    }   

}