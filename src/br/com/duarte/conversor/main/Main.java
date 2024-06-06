package br.com.duarte.conversor.main;

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