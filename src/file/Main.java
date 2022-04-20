package file;

public class Main {
    public static void main(String[] args) {
        Arquivo arq = new Arquivo();
        arq.SetPath();
        arq.CreateFile("Felipao");
    }
}
