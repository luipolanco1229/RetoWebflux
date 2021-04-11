package com.example;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSoupWeb {
    Document getHTMLByURL (String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e){
            return null;
        }
    }


    Document doc = getHTMLByURL(
            "https://www.sensacine.com/peliculas/mejores/nota-espectadores/"
    );
    Element html = doc.select(
            "#col_content"
    ).first();

    //FromIterable
    public List<String> titleList(){
        Elements elements = html.select("div > div > div > div.titlebar_02.margin_10b > h2");
        List<String > titles = new ArrayList<>();


        for(Element title : elements){

            titles.add(title.text());
        }
        return titles;
    }

    public List<String> genreList(){
        Elements elements = html.select("div > div > div > ul > li:nth-child(4) > div");
        List<String > genres = new ArrayList<>();


        for(Element genre : elements){

            genres.add(genre.text());
        }
        return genres;
    }
    public List<String> noteList(){

        Elements elementsNote = html.select("div > div > div > div.margin_10v > span:nth-child(3) > span.note");
        List<String > notes = new ArrayList<>();

        for(Element note : elementsNote){

            notes.add(note.text());
        }
        return notes;
    }




}
