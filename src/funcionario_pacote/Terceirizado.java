package funcionario_pacote;

import funcionario_exceptions.IdException;

public non-sealed class Terceirizado extends Colaborador{
    public Terceirizado(String nome, Integer id, double salario, double horasSemanais) throws IdException {
        super(nome, salario, horasSemanais);

        if (!id.toString().matches(TERCEIRIZADO_PATTERN))
            throw new IdException("Id de funcionário terceirizado inválido.");
        this.setId(id);
    }
}
