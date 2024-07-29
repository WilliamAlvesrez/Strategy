public class DescontoFuncionario implements CalculoDesconto {
    public double calcularDesconto(double consumo) {
        return consumo * 0.30;
    }
}
