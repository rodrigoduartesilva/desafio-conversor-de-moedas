import br.com.duarte.conversor.model.Conversor;
import br.com.duarte.conversor.service.ExchangerateApi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExchangerateApi conversor = new ExchangerateApi();
        String base_code;
        String target_code;

        System.out.print("Informe a moeda base para a conversão: ");
        base_code = scanner.nextLine();

        System.out.print("Informe a moeda para a qual você deseja converter: ");
        target_code = scanner.nextLine();


        Conversor consulta = conversor.conversorMoeda(base_code, target_code);

        System.out.print("Moeda base: " + consulta.base_code());
        System.out.println("");
        System.out.print("Moeda a ser convertida: " + consulta.target_code());
        System.out.println("");
        System.out.print("Valor convertido: " + consulta.conversion_rate());
    }
}