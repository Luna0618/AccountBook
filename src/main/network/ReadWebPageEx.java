package network;


import org.jsoup.Jsoup;

import java.io.IOException;

public class ReadWebPageEx {

    public static void main(String[] args) throws IOException {

        String webPage = "https://api.openweathermap.org/data/2.5/weather?q=London,uk&mode=html&APPID=a57d7f6cd0938b9397c84bccc21e05d9";

        String html = Jsoup.connect(webPage).get().html();

        System.out.println(html);
    }
}

