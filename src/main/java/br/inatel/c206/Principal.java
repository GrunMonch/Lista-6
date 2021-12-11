package br.inatel.c206;

import br.inatel.c206.model.Game;
import br.inatel.c206.model.Arquivo;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        Arquivo arquivo = new Arquivo();
        List<Game> listaGames;
        List<Game> listaFiltrada;
        List<Game> listaFiltrada2;

        listaGames = arquivo.mapeamento();
        listaFiltrada = arquivo.filtraPlat(listaGames,"PS4");
        listaFiltrada2 = arquivo.filtraEmp(listaGames,"Activision");

        for(Game p : listaFiltrada){
            System.out.println(p);
        }
        System.out.println("-------------------------------------------");
        for(Game e : listaFiltrada2){
            System.out.println(e);
        }
    }
}
