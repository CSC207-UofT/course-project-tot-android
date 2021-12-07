package com.example.course_project_tot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import com.jjoe64.graphview.series.DataPoint;

public class FromJSon {
    public static DataPoint[] returnFromJson() {

        Gson gson = new GsonBuilder().create();

        String fileName = "data/user/0/com.example.course_project_tot/files/users.json";
        Path path = new File(fileName).toPath();

        try (Reader reader = Files.newBufferedReader(path,
                StandardCharsets.UTF_8)) {

            return gson.fromJson(reader, DataPoint[].class);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
