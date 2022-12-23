import models.Town;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class FileWorking {

    private static String FILE_PATH = "./src/data_town.txt";

    private static BufferedReader initReader(){
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(FILE_PATH));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
        return br;
    }

    public static ArrayList<Town> getArrayFromFile(){
        BufferedReader br = initReader();
        ArrayList<Town> towns = new ArrayList<>();
        String s;
        while (true) {
            try {
                if (!((s = br.readLine()) !=null)) break;

                String[] line = parse(s);
                if(line.length !=3) {
                    System.out.println("Error: One or more parameters not found in line");
                    continue;
                }
                towns.add(new Town(
                        line[0],
                        Float.parseFloat(line[1].replace(",",".")),
                        line[2]
                ));

            } catch (IOException e) {
                System.out.println("Error while reading line from file");
                return null;
            }
        }
        return towns;
    }

    private static String[] parse(String s) {
        return s.split("\t");
    }
}
