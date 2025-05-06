package funcionario_pacote;

import funcionario_exceptions.IdException;

import java.util.Locale;

public non-sealed class Funcionario extends Colaborador{
    private double valeAlimentacao;
    private double valeTransporte;

    public Funcionario(String nome, Integer id, double salario, double horasSemanais) throws IdException {
        super(nome, salario, horasSemanais);

        if (!id.toString().matches(FUNCIONARIO_PATTERN))
            throw new IdException("Id de funcionario inválido.");
        this.setId(id);


        this.valeAlimentacao = calcularBonus(() -> 40 + (horasSemanais * 0.1) * (horasSemanais / 8));
        this.valeTransporte = calcularBonus(() -> 15 + horasSemanais / 8);
    }

    public double getValeAlimentacao() {
        return valeAlimentacao;
    }
    public double getValeTransporte() {
        return valeTransporte;
    }
    public double getSalarioTotal() {
        return this.getSalario() + this.getValeAlimentacao() + this.getValeTransporte();
    }

    @Override
    public String toString() {
        return super.toString() +
                "Vale Alimentação: R$ " + String.format(Locale.forLanguageTag("BR"), "%.2f", this.getValeAlimentacao()) + "\n" +
                "Vale Transporte: R$ " + String.format(Locale.forLanguageTag("BR"), "%.2f", this.getValeTransporte()) + "\n" +
                "Salário total R$ " + String.format(Locale.forLanguageTag("BR"), "%.2f", this.getSalarioTotal()) + "\n";
    }
}
