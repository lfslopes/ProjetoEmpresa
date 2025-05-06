package beneficios;

@FunctionalInterface
public interface Beneficio {
    Double beneficio();

    default Double semBeneficio() {
        if (beneficio() == null)
            return 0.0;
        return beneficio();
    }
}
