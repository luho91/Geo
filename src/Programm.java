public class Programm {
    public static void main(String[] args) {

        Kreis k = new Kreis("\u001B[35m", 4.0);

        Dreieck d1 = new Dreieck("\u001B[32m", 2.0, 2.0, 3.0);
        Dreieck d2 = new Dreieck("\u001B[34m", 1.0, 1.0, 3.0);

        System.out.println(k);
        System.out.println(d1);
        System.out.println(d2);
    }
}