import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // ENTRADA DE DADOS PARA SOLICITAR O CONSUMO 
        String consumoInput = JOptionPane.showInputDialog(null, "Digite o consumo:", "Entrada de Dados", JOptionPane.QUESTION_MESSAGE);
        double consumo = Double.parseDouble(consumoInput);

        // Variável para armazenar o tipo de cliente
        String tipoCliente = null;
        boolean tipoClienteValido = false;

        // Loop até que um tipo de cliente válido seja fornecido
        while (!tipoClienteValido) {
            tipoCliente = JOptionPane.showInputDialog(null, "Digite o tipo de cliente (Regular, VIP, Funcionario):", "Entrada de Dados", JOptionPane.QUESTION_MESSAGE);

            try {
                // Tenta instanciar a CalculadoraDescontos para verificar se o tipo de cliente é válido
                CalculadoraDescontos calculadora = new CalculadoraDescontos(consumo, tipoCliente);
                tipoClienteValido = true; // Se não lançar exceção, o tipo de cliente é válido
                
                // Se chegou aqui, o tipo de cliente é válido e podemos continuar
                double desconto = calculadora.calcularDesconto();
                JOptionPane.showMessageDialog(null, "Valor do desconto: " + desconto, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } catch (IllegalArgumentException e) {
                // Exibe uma mensagem de erro amigável ao usuário
                JOptionPane.showMessageDialog(null, "Tipo de cliente desconhecido: " + tipoCliente + ". Por favor, informe um tipo de cliente válido (Regular, VIP, Funcionario).", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
