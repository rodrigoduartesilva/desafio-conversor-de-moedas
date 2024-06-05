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
