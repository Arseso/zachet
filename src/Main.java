import models.Town;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Town> towns = FileWorking.getArrayFromFile();
        if(towns == null) return;

        TownWithMinPeoples(towns);

        String NameOfCountry = "Египет"; //input country name here
        String NameOfTown = "Кортрейк"; //input town name here

        searchTownByCountryName(towns, NameOfCountry);
        searchPeoplesByTownName(towns, NameOfTown);
    }

    private static void searchPeoplesByTownName(ArrayList<Town> towns, String nameOfTown) {
        System.out.println("[searchPeoplesByTownName]");
        Town t = null;
        for(Town s: towns) if(s.getTitle().equals(nameOfTown)) t = s;
        if (t == null){
            System.out.println("Town not found in file");
            return;
        }
        System.out.println("In town "+t.getTitle() +" there are " + t.getNumberOfGuys() + " thousands people.");
    }

    private static void searchTownByCountryName(ArrayList<Town> towns, String nameOfCountry) {
        System.out.println("[TownsWithRequestedCountry]");
        ArrayList<Town> townsForCurrentCountry = new ArrayList<>();
        for(Town t: towns) if(t.getCountry().equals(nameOfCountry)) townsForCurrentCountry.add(t);
        if(townsForCurrentCountry.size() == 0) {
            System.out.println("No one town has not inputed country");
            return;
        }
        townsForCurrentCountry.sort(Comparator.comparing(Town::getNumberOfGuys));
        for(Town t: townsForCurrentCountry) printTown(t);
    }

    private static void TownWithMinPeoples(ArrayList<Town> towns) {
        System.out.println("[TownWithMinPeoples]");
        towns.sort(Comparator.comparing(Town::getNumberOfGuys));
        printTown(towns.get(0));
    }


    private static void printTown(Town t){
        System.out.println("Town Title: " + t.getTitle());
        System.out.println("Town Peoples: " + t.getNumberOfGuys());
        System.out.println("Country: " + t.getCountry());
        System.out.println("-------------------------------");
    }
}


