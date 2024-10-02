package aual32;

public class Main {

    public static void main(String[] args) {
        Lista<String> l1 = new Lista(5);
        l1.adiciona("A");
        l1.adiciona("B");
        l1.adiciona("C");
        l1.adiciona("D");
        l1.adiciona("E");
        l1.adiciona("F");
        l1.adiciona("G");
        l1.adiciona("H");
        System.out.println(l1);
        System.out.println("Elemento da posição 1 "+l1.obeter(1));
        try{
            System.out.println("Elemento na posição 11 "+l1.obeter(11));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        l1.adiciona("V",4);
        System.out.println(l1);
        l1.remove(4);
        System.out.println(l1);
        System.out.println("Posição de C: "+l1.posicaoDe("V"));
    }
}
