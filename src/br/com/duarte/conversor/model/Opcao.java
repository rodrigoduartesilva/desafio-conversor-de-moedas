package br.com.duarte.conversor.model;

import br.com.duarte.conversor.service.ExchangerateApi;

import java.io.IOException;
import java.util.Scanner;

public class Opcao {
    Scanner scanner = new Scanner(System.in);
    ExchangerateApi exchangerateApi = new ExchangerateApi();

    private int opcaoSelecionada;
    private double valorParaConverter;

    public int getOpcaoSelecionada() {
        return opcaoSelecionada;
    }

    public void setOpcaoSelecionada(int opcaoSelecionada) {
        this.opcaoSelecionada = opcaoSelecionada;
    }

    public void valorSelecionado(int opcaoSelecionada) throws IOException {
        switch (opcaoSelecionada) {
            case 1:
                System.out.println("Real --> Dolar");
                System.out.print("Digite o valor que deseja converter: R$ ");
                var valorDolar = exchangerateApi.conversorMoeda("BRL", "USD");
                double valorConvertido = Double.parseDouble(valorDolar.conversion_rate());
                valorParaConverter = scanner.nextDouble();


                System.out.println("Valor R$ " + valorParaConverter + " [BRL] corresponde ao valor de $ "
                        + (valorParaConverter * valorConvertido) + " [USD]");

                HistoricoConversoes historico = new HistoricoConversoes();
                historico.historico(valorDolar);
                break;

            case 2:
                System.out.println("Dolar --> Real");
                System.out.print("Digite o valor que deseja converter: $ ");
                valorDolar = exchangerateApi.conversorMoeda("USD", "BRL");
                valorConvertido = Double.parseDouble(valorDolar.conversion_rate());
                valorParaConverter = scanner.nextDouble();


                System.out.println("Valor $ " + valorParaConverter + " [USD] corresponde ao valor de R$ "
                        + (valorParaConverter * valorConvertido) + " [BRL]");

                historico = new HistoricoConversoes();
                historico.historico(valorDolar);
                break;

            case 3:
                System.out.println("Real --> Peso Argentino");
                System.out.print("Digite o valor que deseja converter: R$ ");
                valorDolar = exchangerateApi.conversorMoeda("BRL", "ARS");
                valorConvertido = Double.parseDouble(valorDolar.conversion_rate());
                valorParaConverter = scanner.nextDouble();


                System.out.println("Valor R$ " + valorParaConverter + " [BRL] corresponde ao valor de $ "
                        + (valorParaConverter * valorConvertido) + " [ARS]");

                historico = new HistoricoConversoes();
                historico.historico(valorDolar);
                break;

            case 4:
                System.out.println("Peso Argentino --> Real");
                System.out.print("Digite o valor que deseja converter: $ ");
                valorDolar = exchangerateApi.conversorMoeda("ARS", "BRL");
                valorConvertido = Double.parseDouble(valorDolar.conversion_rate());
                valorParaConverter = scanner.nextDouble();


                System.out.println("Valor $ " + valorParaConverter + " [ARS] corresponde ao valor de R$ "
                        + (valorParaConverter * valorConvertido) + " [BRL]");

                historico = new HistoricoConversoes();
                historico.historico(valorDolar);
                break;

            case 5:
                System.out.println("Real --> Peso Colombiano");
                System.out.print("Digite o valor que deseja converter: R$ ");
                valorDolar = exchangerateApi.conversorMoeda("BRL", "COP");
                valorConvertido = Double.parseDouble(valorDolar.conversion_rate());
                valorParaConverter = scanner.nextDouble();


                System.out.println("Valor R$ " + valorParaConverter + " [BRL] corresponde ao valor de $ "
                        + (valorParaConverter * valorConvertido) + " [COP]");

                historico = new HistoricoConversoes();
                historico.historico(valorDolar);
                break;

            case 6:
                System.out.println("Peso Colombiano --> Real");
                System.out.print("Digite o valor que deseja converter: $ ");
                valorDolar = exchangerateApi.conversorMoeda("COP", "BRL");
                valorConvertido = Double.parseDouble(valorDolar.conversion_rate());
                valorParaConverter = scanner.nextDouble();


                System.out.println("Valor $ " + valorParaConverter + " [COP] corresponde ao valor de R$ "
                        + (valorParaConverter * valorConvertido) + " [BRL]");

                historico = new HistoricoConversoes();
                historico.historico(valorDolar);
                break;

            case 7:
                System.out.print("Operalção finalizada!");
                break;

            default:
                System.out.println("Selecione uma opção de acordo como menu acima!");
                break;

        }
    }
}
