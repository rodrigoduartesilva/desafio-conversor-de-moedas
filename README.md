# Desafio - Conversor de Moedas (Oracle & Alura)

<div align="center">
    <img src="./Badge-Conversor.png" alt="Badge Conversor" width="250" />
</div>

### Enunciado:

#### Desenvolva um conversor de moedas em Java, usando a API Exchangerate.

#### Abaixo segue um passo a passo com a implementação de uma sugestão de resolução:

1. Crie uma record chamada Conversor com a passagem dos seguintes parametros: base_code, target_code e conversion_rate.

```Java
package br.com.duarte.conversor.model;

public record Conversor(String base_code, String target_code, String conversion_rate) {

}
```

2. Crie uma classe chamada Menu, essa classe tem o intuito apenas de exibir o menu de opções da aplicação.

```Java
package br.com.duarte.conversor.model;

public class Menu {
    public String textoMenu() {
        return """
                ****************************************************************
                Bem-vindo/a ao Conversor de Moeda!
                
                1 - Real            --> Dolar
                2 - Dolar           --> Real
                3 - Real            --> Peso Argentino
                4 - Peso Argentino  --> Real
                5 - Real            --> Peso Colombiano
                6 - Peso Colombiano --> Real
                7 - Sair
               
                ****************************************************************
                
                """;
    }
}
```
3. Crie uma classe chamada ExchangerateApi, esta classe tem como função, realizar todo o processo de comunicação com a API.

```Java
package br.com.duarte.conversor.service;

import br.com.duarte.conversor.model.Conversor;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangerateApi {

    public Conversor conversorMoeda(String base_code, String target_code) {
        String key = "Your Key";
        String url = "https://v6.exchangerate-api.com/v6/" + key + "/pair/" + base_code + "/" + target_code;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {

            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Conversor.class);

        } catch (IOException | InterruptedException error) {

            throw new RuntimeException("Moeda incorreta!");

        }
    }
}
```

4. Crie uma classe chamada Opcao, esta classe deverá gerir o menu de opções com suas respectivas conversões de moedas.

```Java
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
                System.out.print("Operação finalizada!");
                break;

            default:
                System.out.println("Selecione uma opção de acordo como menu acima!");
                break;

        }
    }
}
```

5. Crie uma classe chamada HistoricoConversoes, essa classe gera um arquivo a cada consulta que servirá como um histórico para cada consulta realizada.

```Java
package br.com.duarte.conversor.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class HistoricoConversoes {
    public void historico(Conversor conversor) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter historico = new FileWriter(conversor + ".json");
        historico.write(gson.toJson(conversor));
        historico.close();
    }
}
```

6. Por fim, a classe Main, realizando a chamada das classes para rodar a aplicação.

```Java
import br.com.duarte.conversor.model.Menu;
import br.com.duarte.conversor.model.Opcao;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Opcao opcao = new Opcao();

        System.out.println(menu.textoMenu());

        try {

            do {
                System.out.println("");
                System.out.print("Selecione uma das opções acima: ");
                opcao.setOpcaoSelecionada(scanner.nextInt());

                opcao.valorSelecionado(opcao.getOpcaoSelecionada());
            } while (opcao.getOpcaoSelecionada() != 7);

        } catch (InputMismatchException | IOException error) {

            System.err.println("A opção deve ser informada como um número inteiro! ");
            System.err.println("Erro: " + error);

        } catch (IllegalArgumentException error) {

            System.out.println("");
            System.err.println("Informe sua key na respectiva classe!");
            System.err.println("Erro: " + error);
                    }
    }
}
```

### Autor: Rodrigo Duarte

| [Linkedin](https://www.linkedin.com/in/rodrigoduar-te/) | [GitHub](https://github.com/rodrigoduartesilva/) | [Link do Repositório](https://github.com/rodrigoduartesilva/desafio-conversor-de-moedas) |