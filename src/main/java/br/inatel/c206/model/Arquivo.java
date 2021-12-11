package br.inatel.c206.model;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Arquivo {

    public List<Game> mapeamento(){
        Path arquivo = Paths.get("vendas-games.csv");
        List<Game> listaGames = new ArrayList<>();

        try{
            Reader reader = Files.newBufferedReader(arquivo);
            CsvToBean<Game> csvToBean = new CsvToBeanBuilder(reader).withType(Game.class).withIgnoreLeadingWhiteSpace(true).build();
            listaGames = csvToBean.parse();
        }catch(IOException e){
            e.printStackTrace();
        }
        return listaGames;
    }

    public List<Game> filtraPlat(List<Game> listaGames, String plataforma){
        List<Game> listaFiltrada = new ArrayList<>();
        listaGames.stream().filter(str -> plataforma.equals(str.getPlatform())).forEach(str -> listaFiltrada.add(str));
        return listaFiltrada;
    }

    public List<Game> filtraEmp(List<Game> listaGames, String empresa){
        List<Game> listaFiltrada2 = new ArrayList<>();
        listaGames.stream().filter(str -> empresa.equals(str.getPublisher())).forEach(str -> listaFiltrada2.add(str));
        return listaFiltrada2;
    }
}
