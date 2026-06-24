package com.motwg.shared;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LineReader {

    public static List<String> readFile(String filepath) {
        try (
            BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filepath))
            )
        ) {
            return br.lines().toList();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return new ArrayList<String>();
    }
}
