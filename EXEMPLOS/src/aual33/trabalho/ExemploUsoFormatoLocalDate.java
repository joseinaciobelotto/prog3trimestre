package aual33.trabalho;

import aual32.Lista;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ExemploUsoFormatoLocalDate {

    public static Scanner ler = new Scanner(System.in);
    public static List<Paciente> listaPacientes = new ArrayList<Paciente>();

    public static void main(String[] args) {


        LocalDate hoje = LocalDate.now();

        DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        formatoBr = DateTimeFormatter.ofPattern("dd 'de' MMMM " +
                "'de' yyyy", new Locale("pt", "BR"));


        int auxAcao = 0;
        int num=0;
        do {

            boolean houveErro=true;
            System.out.println();
            System.out.println("O que deseja fazer? ");
            System.out.println();
            System.out.println("1 - Incluir paciente ");
            System.out.println("2 - Alterar paciente ");
            System.out.println("3 - Realizar um atendimento ");
            System.out.println("4 - Listar os pacientes ");
            System.out.println("5 - Mostrar paciente ");
            System.out.println("6 - Apagar um paciente ");


            while (houveErro==true)
            {
                try{
                num = ler.nextInt();
                    houveErro=false;
                }catch (InputMismatchException e)
                {
                System.out.println("Digite um número entre 1-7");
            }finally {
                ler.nextLine();
            };
            }

            if(num>=1 && num<=6)
            {


                switch (num) {
                    case 1:
                        incluirPaciente();
                        break;
                    case 2:
                        alterarPaciente();
                        break;
                    case 3:
                        realizarAtendimento();
                        break;
                    case 4:
                        listarPacientes();
                        break;
                    case 5:
                        mostrarPacientes();
                        break;
                    case 6:
                        apagarPaciente();
                        break;



                };

            }else
            {
                System.out.println("Digite outro número");
            }

        } while (auxAcao == 0);


    }


    public static void listarPacientes()
    {

        for(Paciente p1:listaPacientes )
        {
            System.out.println("Lista de Pacientes:");
            System.out.println(p1.getNome() +" "+ p1.getSobrenome());
            System.out.println(p1.getDataNascimento());

        ler.nextLine();
        }

    }

    public static void mostrarPacientes()
    {
        System.out.println("Digite o nome do paciente: ");
        String nome = ler.next();

        for(Paciente p1:listaPacientes )
        {
            int auxPaciente=0;
            boolean houveErro=true;
            if (p1.getNome().equals(nome))
            {
                System.out.println();
                System.out.println("Paciente: ");
                System.out.println(p1.getNome() +" "+ p1.getSobrenome());
                System.out.println(p1.getDataNascimento());
                int auxLmt=0;
                System.out.println();
                System.out.println("Descrição: ");
                System.out.println();
                ler.nextLine();


                for(Atendimento a1:p1.getAtendimentos() )
                {
                   auxLmt++;

                    System.out.println(a1.getDescricao());
                    System.out.println(a1.getData());
                    System.out.println();

                   if(auxLmt==5)
                   {
                       System.out.println();
                       System.out.println("Enter para os próximos atendimentos.");
                       ler.nextLine();
                       auxLmt=0;
                   }

                }
                ler.nextLine();
            }
            if(auxPaciente == listaPacientes.size())
            {
                System.out.println("Esse paciente não está cadastrado!");
            }
        }

    }

    public static void realizarAtendimento()
    {
        System.out.println("Digite o nome do paciente a ser consultado: ");
        String nome = ler.next();

        for(Paciente p1:listaPacientes )
        {
            int auxPaciente=0;
            boolean houveErro=true;
            if (p1.getNome().equals(nome))
            {
                ler.nextLine();
                Atendimento a1 = new Atendimento();
                System.out.println("Digite a descrição do atendimento: ");
                a1.setDescricao(ler.nextLine());
                 a1.setData();
                /*
                while (houveErro==true)
                {
                    try {

                        houveErro = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Digite a data no formato (dd/mm/aaaa)");
                    } finally {
                        ler.nextLine();
                    } ;
                }*/

                p1.adicionarConsulta(a1);

            }
            if(auxPaciente == listaPacientes.size())
            {
                System.out.println("Esse paciente não está cadastrado!");
            }
        }

    }

    public static void apagarPaciente()
    {
        System.out.println("Digite o nome do paciente a ser apagado: ");
        String nome = ler.next();
        int auxPaciente=0;
        Paciente pAux = new Paciente();
        for(Paciente p1:listaPacientes )
        {

            boolean houveErro=true;
            if (p1.getNome().equals(nome))
            {
              auxPaciente++;
              ler.nextLine();
                pAux = p1;


            }
            if(auxPaciente == listaPacientes.size())
            {
                System.out.println("Esse paciente não está cadastrado!");
            }
        }
        try {
            listaPacientes.remove(pAux);
        }catch (NullPointerException e)
        {

        }finally {

        }

    }


    public static void incluirPaciente()
    {
    boolean houveErro=true;

        LocalDate dataA = LocalDate.now();

        DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        formatoBr = DateTimeFormatter.ofPattern("dd 'de' MMMM " +
                "'de' yyyy", new Locale("pt", "BR"));

        Paciente p1 = new Paciente();
        System.out.println("Digite o nome do paciente: ");
        p1.setNome(ler.nextLine());
        System.out.println("Digite o sobrenome do paciente: ");
        p1.setSobrenome(ler.nextLine());
        System.out.println("Digite a data de nascimento do paciente (formato: 08 de abril de 2000):");

        while (houveErro==true)
        {
            try {

                String data = ler.nextLine();
                dataA =LocalDate.parse(data,formatoBr);
                houveErro = false;
            } catch (DateTimeParseException e) {
                System.out.println("Digite a data no formato (08 de abril de 2000)");
            } finally {
                ler.nextLine();
            } ;
        }

        p1.setDataNascimento(dataA);

        listaPacientes.add(p1);


    }

    public static void alterarPaciente() {

        boolean houveErro=true;
        int auxPaciente=0;
        LocalDate hoje = LocalDate.now();

        DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        formatoBr = DateTimeFormatter.ofPattern("dd 'de' MMMM " +
                "'de' yyyy", new Locale("pt", "BR"));


        System.out.println("Digite o nome do paciente a ser alterado: ");
        String nome = ler.nextLine();

        for(Paciente p1:listaPacientes )
        {
            if(p1.getNome().equals(nome))
            {
                LocalDate dataFor  = LocalDate.now();
                System.out.println("Digite o novo nome do paciente: ");
                p1.setNome(ler.nextLine());
                System.out.println("Digite o novo sobrenome do paciente: ");
                p1.setSobrenome(ler.nextLine());
                System.out.println("Digite a novo data de nascimento do paciente (formato: 08 de abril de 2000):");

                while (houveErro==true)
                {
                    try {

                        String data = ler.nextLine();
                        dataFor =  LocalDate.parse(data,formatoBr);
                        houveErro = false;
                    } catch (DateTimeParseException
                            e) {
                        System.out.println("Digite a data no formato (08 de abril de 2000)");
                    } finally {
                        ler.nextLine();
                    } ;
                }

                p1.setDataNascimento(dataFor);
            }
            if(auxPaciente == listaPacientes.size())
            {
                System.out.println("Esse paciente não está cadastrado!");
            }
        }


    }


    public void validaData() {
        Scanner ler = new Scanner(System.in);
        LocalDate hoje = LocalDate.now();

        DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        formatoBr = DateTimeFormatter.ofPattern("dd 'de' MMMM " +
                "'de' yyyy", new Locale("pt", "BR"));
        boolean valida = true;
        LocalDate data = LocalDate.now();
        do {
            System.out.print("Digite um data no formato (dd/MM/aaaa): ");
            String dataStr = ler.nextLine();
            try {
                data = LocalDate.parse(dataStr, formatoBr);
                valida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido!" + e);
                valida = false;
            }
        }
        while (!valida);

    }

      /* Paciente a1 = new Paciente();
        a1.setDataNascimento(LocalDate.of(1995, 6, 5));
        Period periodo = Period.between(a1.getDataNascimento(), hoje);


        System.out.println(periodo.getYears());

            String periodso = a1.getDataNascimento().format(formatoBr);
            */

}
