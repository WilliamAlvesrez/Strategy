import java.util.HashMap;
import java.util.Map;

public class CalculadoraDescontos {
    private double consumo;
    private CalculoDesconto calculoDesconto;

    private static final Map<String, CalculoDesconto> strategyDesconto = new HashMap<>();

    static {
        strategyDesconto.put("Regular", new DescontoClienteRegular());
        strategyDesconto.put("VIP", new DescontoClienteVIP());
        strategyDesconto.put("Funcionario", new DescontoFuncionario());
    }

   public CalculadoraDescontos(double consumo, String tipoCliente) {
    this.consumo = consumo;
    this.calculoDesconto = strategyDesconto.get(tipoCliente.trim());

    if (this.calculoDesconto == null) {
        throw new IllegalArgumentException("Tipo de cliente desconhecido: " + tipoCliente );
    }
}

    public double calcularDesconto() {
        return calculoDesconto.calcularDesconto(consumo);
    }
}