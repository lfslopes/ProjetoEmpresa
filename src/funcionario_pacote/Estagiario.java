package funcionario_pacote;

import funcionario_exceptions.IdException;

import java.util.Locale;

public non-sealed class Estagiario extends Colaborador{
    private double valeTransporte;

    public Estagiario(String nome, Integer id, double salario, double horasSemanais) throws IdException {
        super(nome, salario, horasSemanais);

        if (!id.toString().matches(ESTAGIARIO_PATTERN))
            throw new IdException("Id de estagiário inválido.");
        this.setId(id);

        this.valeTransporte = calcularBonus(() -> 10 + this.getHorasSemanais() / 4);
    }

    public double getValeTransporte() {
        return valeTransporte;
    }
    public double getSalarioTotal() {
        return this.getSalario() + this.getValeTransporte();
    }

    @Override
    public String toString() {
        return "Estagiário: " + this.getNome() + "\n" +
                "Salário: R$ " + String.format(Locale.forLanguageTag("BR"), "%.2f", this.getSalario()) + "\n" +
                "Horas Semanais: " + this.getHorasSemanais() + " horas\n" +
                "Vale transporte: R$ " + String.format(Locale.forLanguageTag("BR"), "%.2f", this.getValeTransporte()) + "\n" +
                "Salário total: R$ " + String.format(Locale.forLanguageTag("BR"), "%.2f", this.getSalarioTotal()) + "\n";
    }
}
