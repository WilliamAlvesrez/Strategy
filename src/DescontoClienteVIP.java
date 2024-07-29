public class DescontoClienteVIP implements CalculoDesconto {
    public double calcularDesconto(double consumo) {
        if (consumo > 1000) {
            return consumo * 0.10;
        } else {
            return consumo * 0.05;
        }
    }
}
