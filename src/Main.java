import br.com.duarte.conversor.model.Menu;
import br.com.duarte.conversor.model.Opcao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Opcao opcao = new Opcao();


        System.out.println(menu.textoMenu());

        do {
            System.out.print("Selecione uma das opções acima: ");
            opcao.setOpcaoSelecionada(scanner.nextInt());

            opcao.valorSelecionado(opcao.getOpcaoSelecionada());
        } while (opcao.getOpcaoSelecionada() != 7);
    }
}