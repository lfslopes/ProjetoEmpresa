package funcionario_pacote;

import beneficios.Beneficio;
import funcionario_exceptions.IdException;

import java.util.Locale;

public non-sealed class Gerente extends Colaborador{

    private double bonus;
    private double valeAlimentacao;
    private double valeTransporte;

    public Gerente(String nome, Integer id, double salario, double horasSemanais) throws IdException {
        super(nome, salario, horasSemanais);

        if (!id.toString().matches(GERENTE_PATTERN))
            throw new IdException("Id de gerente inválido.");
        this.setId(id);

        this.bonus = calcularBonus(() -> 0.15 * horasSemanais * this.getSalario() * 0.01);
        this.valeAlimentacao = calcularBonus(() -> 50 + (horasSemanais * 0.1) * (horasSemanais / 8));
        this.valeTransporte = calcularBonus(() -> 20 + horasSemanais / 8);
    }

    public double getBonus() {
        return this.bonus;
    }
    public double getValeAlimentacao() {
        return valeAlimentacao;
    }
    public double getValeTransporte() {
        return valeTransporte;
    }
    public double getSalarioTotal() {
        return this.getSalario() + this.getBonus() + this.getValeAlimentacao() + this.getValeTransporte();
    }

    @Override
    public String toString() {
        return "Gerente: " + this.getNome() + "\n" +
                "Salário normal: R$ " + String.format(Locale.forLanguageTag("BR"), "%.2f", this.getSalario()) + "\n" +
                "Horas Semanais: " + this.getHorasSemanais() + " horas\n" +
                "Bonunificação por horas semanais: R$ " + String.format(Locale.forLanguageTag("BR"), "%.2f", this.getBonus()) + "\n" +
                "Vale Alimentação: R$ " + String.format(Locale.forLanguageTag("BR"), "%.2f", this.getValeAlimentacao()) + "\n" +
                "Vale Transporte: R$ " + String.format(Locale.forLanguageTag("BR"), "%.2f", this.getValeTransporte()) + "\n" +
                "Salário total R$ " + String.format(Locale.forLanguageTag("BR"), "%.2f", this.getSalarioTotal()) + "\n";
    }


}
