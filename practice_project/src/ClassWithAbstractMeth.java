public abstract class ClassWithAbstractMeth {
    public abstract  String absMeth1(int num);
    public abstract boolean absMeth2(String str);
    abstract float absMeth3(int num, String str);
    protected abstract boolean absMeth4(String str);
	abstract float absMeth5(int num, String str);
    public static void main(String[] args){
        System.out.println("this is a class with abstract methods");
    }
}