import funcionario_pacote.*;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Colaborador gerente = new Gerente("Paulo Teixeira", 120200710, 5000.0D, 32);

        Colaborador funcionario1 = new Funcionario("Marta Mendes", 220211210, 2000.0D, 40);
        Colaborador funcionario2 = new Funcionario("João Pedro Miranda", 220221010, 1500.0D, 40);
        Colaborador funcionario3 = new Funcionario("Ana Almeida", 220151110, 2000.0D, 40);

        Colaborador terceirizado1 = new Terceirizado("Marcos Manuel Mendonça", 220161011, 2000.0D, 28);
        Colaborador terceirizado2 = new Terceirizado("Bárbara Borges", 220161021, 2000.0D, 28);

        Colaborador estagiario1 = new Estagiario("Enzo Morrison", 320250410, 1518.0D, 20);
        Colaborador estagiario2 = new Estagiario("Eduardo Éric", 320250420, 1518.0D, 20);
        Colaborador estagiario3 = new Estagiario("Luiza Lopes", 320250430, 1518.0D, 20);
        Colaborador estagiario4 = new Estagiario("Valentina Vieira", 320250440, 1518.0D, 20);

        Set<Colaborador> colaboradores = new TreeSet<Colaborador>();

        colaboradores.add(gerente);
        colaboradores.add(funcionario1);
        colaboradores.add(funcionario2);
        colaboradores.add(funcionario3);
        colaboradores.add(terceirizado1);
        colaboradores.add(terceirizado2);
        colaboradores.add(estagiario1);
        colaboradores.add(estagiario2);
        colaboradores.add(estagiario3);
        colaboradores.add(estagiario4);

        System.out.println("############################### - Gerentes - ###############################\n");
        colaboradores.
                stream().
                filter(colaborador -> colaborador.getId() < 200000000).
                sorted((c1, c2) -> c1.getNome().compareTo(c2.getNome())).
                forEach(System.out::println);

        System.out.println("############################### - Funcionários Terceirizados - ###############################\n");
        colaboradores.
                stream().
                filter(colaborador -> colaborador.getId() > 200000000 && colaborador.getId() < 300000000).
                filter(colaborador -> colaborador.getId() % 2 == 1).
                sorted((c1, c2) -> c1.getNome().compareTo(c2.getNome())).
                forEach(System.out::println);

        System.out.println("############################### - Funcionários comuns - ###############################\n");
        colaboradores.
                stream().
                filter(colaborador -> colaborador.getId() > 200000000 && colaborador.getId() < 300000000).
                filter(colaborador -> colaborador.getId() % 2 == 0).
                sorted((c1, c2) -> c1.getNome().compareTo(c2.getNome())).
                forEach(System.out::println);

        System.out.println("############################### - Estagiários - ###############################\n");
        colaboradores.
                stream().
                filter(colaborador -> colaborador.getId() > 300000000).
                sorted((c1, c2) -> c1.getNome().compareTo(c2.getNome())).
                forEach(System.out::println);
    }
}
