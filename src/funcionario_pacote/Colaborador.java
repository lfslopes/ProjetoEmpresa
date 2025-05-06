package funcionario_pacote;

import beneficios.Beneficio;

import java.util.Locale;

public sealed abstract class Colaborador implements Comparable<Colaborador> permits Estagiario, Funcionario, Gerente, Terceirizado {
    private String nome;
    private Integer id;
    private double salario;
    private double horasSemanais;

    protected static final String GERENTE_PATTERN = "1[0-9]{7}0";
    protected static final String FUNCIONARIO_PATTERN = "2[0-9]{7}0";
    protected static final String TERCEIRIZADO_PATTERN = "2[0-9]{7}1";
    protected static final String ESTAGIARIO_PATTERN = "3[0-9]{7}0";

    public Colaborador(String nome, double salario, double horasSemanais) {
        this.nome = nome;
        this.salario = salario;
        this.horasSemanais = horasSemanais;
    }
    protected Double calcularBonus (Beneficio beneficio) {
        return beneficio.beneficio();
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public double getSalario() {
        return salario;
    }

    public double getHorasSemanais() {
        return horasSemanais;
    }
    protected void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Funcionário: " + this.getNome() + "\n" +
               "Salário: R$ " + String.format(Locale.forLanguageTag("BR"), "%.2f", this.getSalario()) + "\n" +
               "Horas Semanais: " + this.getHorasSemanais() + " horas\n";
    }
    @Override
    public int compareTo(Colaborador c) {
        return Integer.compare(this.getId(), c.getId());
    }
}
