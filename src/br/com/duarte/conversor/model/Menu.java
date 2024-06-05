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
