package aual33.trabalho;

import aual32.Lista;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ExemploUsoFormatoLocalDate {

    public static Scanner ler = new Scanner(System.in);
    public static List<Paciente> listaPacientes = new ArrayList<Paciente>();

    public static void main(String[] args) {



        LocalDate hoje = LocalDate.now();

        /* Paciente a1 = new Paciente();
        a1.setDataNascimento(LocalDate.of(1995, 6, 5));
        Period periodo = Period.between(a1.getDataNascimento(), hoje);


        System.out.println(periodo.getYears());

            String periodso = a1.getDataNascimento().format(formatoBr);
            */

        DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        formatoBr = DateTimeFormatter.ofPattern("dd 'de' MMMM " +
                "'de' yyyy", new Locale("pt", "BR"));
           /* O programa deve permitir

           (pesquisar pelo nome)
          (pesquisar pelo nome e incluir uma consulta relacionada a este paciente)
            (dados básicos) não mostrar pacientes desativados
            Mostrar paciente(Pesquisa pelo nome e mostra os dados do paciente e seus atendimentos, listar de 5 em 5 até o final)
            Apagar um paciente permitir que ele seja removido da lista
            Interessante criar os métodos equals na classe Paciente para fins de comparação.*/

        int auxAcao = 0;

        do {
            System.out.println("1 - Incluir paciente ");
            System.out.println("2 - Alterar paciente ");
            System.out.println("3 - Realizar um atendimento ");
            System.out.println("4 - Listar os pacientes ");
            System.out.println("5 - Mostrar paciente ");
            System.out.println("6 - Apagar um paciente ");
            int a = ler.nextInt();

            switch (a) {
                case 1: incluirPaciente();
                case 2: alterarPaciente();
                case 3: realizarAtendimento();
                case 4:
                case 5:
                case 6:
                default:
                    System.out.println("Digite outro número");
            }


        } while (auxAcao == 0);


    }


    public static void listarPacientes()
    {

        for(Paciente p1:listaPacientes )
        {
            System.out.println(p1.getNome() + p1.getSobrenome());
            System.out.println(p1.getDataNascimento());
            System.out.println(p1);

        }

    }

    public static void realizarAtendimento()
    {
        System.out.println("Digite o nome do paciente a ser consultado: ");
        String nome = ler.next();

        for(Paciente p1:listaPacientes )
        {
            if (p1.getNome().equals(nome))
            {
                Atendimento a1 = new Atendimento();
                System.out.println("Digite a descrição do atendimento: ");
                a1.setDescricao(ler.next());
                a1.setData();

                /*p1.getAtendimentos(a1);*/

            }
        }

    }


        public static void incluirPaciente() {

        Paciente p1 = new Paciente();
        System.out.println("Digite o nome do paciente: ");
        p1.setNome(ler.next());
        System.out.println("Digite o sobrenome do paciente: ");
        p1.setNome(ler.next());
        System.out.println("Digite a data de nascimento do paciente (dd/mm/aaaa): ");
        p1.setNome(ler.next());

        listaPacientes.add(p1);


    }

    public static void alterarPaciente() {

        System.out.println("Digite o nome do paciente a ser alterado: ");
        String nome = ler.next();

        for(Paciente p1:listaPacientes )
        {
            if(p1.getNome().equals(nome))
            {
                System.out.println("Digite o novo nome do paciente: ");
                p1.setNome(ler.next());
                System.out.println("Digite o novo sobrenome do paciente: ");
                p1.setNome(ler.next());
                System.out.println("Digite a novo data de nascimento do paciente (dd/mm/aaaa): ");
                p1.setNome(ler.next());
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
            String dataStr = ler.next();
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
}
