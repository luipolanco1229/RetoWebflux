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

    public List<String> elementtitle(){
        Elements elements = html.select("div > div > div > div.titlebar_02.margin_10b > h2");
        List<String > titles = new ArrayList<>();

        System.out.println("Titulos de pelis");
        for(Element title : elements){
            System.out.println("- "+title.text());
            titles.add(title.text());
        }
        return titles;
    }


}
