package io.shadowmc.discobot.utils;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class GetWeather {
    public InputStream retrieve(String zipcode) throws Exception {

        String url = "http://weather.yahooapis.com/forecastrss?p="
          + zipcode;
        URLConnection conn = new URL(url).openConnection();
        return conn.getInputStream();
    }
}
