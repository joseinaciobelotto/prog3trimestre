package aual32;

import java.util.ArrayList;

public class ExemploArrayList {
    public static void main(String[] args) {
        //ArrayList<tipo -> Integer | Float | Double | Pessoa> nome = new ArrayList<>(capacidade -> opcional)
        ArrayList<String> l1 = new ArrayList<>();
        //Método para adicionar elementos.
        l1.add(("A"));
        l1.add(("C"));
        l1.add(("D"));
        l1.add(("E"));
        l1.add(("F"));
        l1.add(("G"));
        System.out.println(l1);
        l1.add(1, "B");
        System.out.println(l1);
        System.out.println("Obter o elemento da posição 2 "+l1.get(2));
        //Descpbromdp a posição do elemento.
        System.out.println("O elemento 'E' está na posição "+l1.indexOf("E"));
        System.out.println("O elemento 'e' está na posição "+l1.indexOf("e"));
        l1.add("C");
        System.out.println("O último 'C da lista está na posição "+l1.lastIndexOf("C"));
        //Verificando se um elemento existe nalista (não tem)
        System.out.println("O elemento 'A' existe na lista "+l1.contains("A"));
        //Descobrindo o tamanho da lista
        System.out.println("");

    }
}
