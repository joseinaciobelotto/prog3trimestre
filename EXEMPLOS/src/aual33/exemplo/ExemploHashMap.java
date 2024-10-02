package aual33.exemplo;

import java.util.HashMap;

public class ExemploHashMap
{
    public static void main(String[] arg){

        HashMap<String, String> capitais = new HashMap<>();

        capitais.put("GO","Goiânia");
        capitais.put("RS","Rio Grande Do Sul");
        capitais.put("SP","São Paulo");

        System.out.println("Estados:");
        for(String cidades:capitais.values())
            System.out.println(cidades);
        System.out.println(capitais.values());



    }


}
