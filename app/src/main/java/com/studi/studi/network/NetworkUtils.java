package com.studi.studi.network;

import com.google.gson.Gson;
import com.studi.studi.resources.User;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by kevin on 2/28/15.
 */
public class NetworkUtils {

    private static HttpClient client = new DefaultHttpClient();
    private static Gson gson = new Gson();
    private static String host = "localhost:3000/studi";

    private static String getContent(HttpResponse response) throws IOException {
        InputStream content = response.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(content));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }

    public static String getFreeId() {
        HttpGet get = new HttpGet(host + "/getfreeid");
        String content = null;

        try {
            HttpResponse response = client.execute(get);
            content = getContent(response);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return content;
    }

    public static void logOff(User user) {
        String data = gson.toJson(user);
        HttpPost post = new HttpPost(host + "/logoff");

        try {
            post.setHeader("Content-Type", "application/json");
            post.setEntity(new StringEntity(data));

            client.execute(post);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateLocation(User user) {
        String data = gson.toJson(user);
        HttpPost post = new HttpPost(host + "/updatelocation");

        try {
            post.setHeader("Content-Type", "application/json");
            post.setEntity(new StringEntity(data));

            client.execute(post);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static User[] getUsers() {
        HttpGet get = new HttpGet(host + "/getfreeid");
        String content = null;

        try {
            HttpResponse response = client.execute(get);
            content = getContent(response);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return gson.fromJson(content, User[].class);
    }

}
