package genetic;

import java.util.*;

public class Main {
    public static void printTravelPrices(int[][] travelPrices, int numberOfCities){
        for(int i = 0; i<numberOfCities; i++){
            for(int j=0; j<numberOfCities; j++){
                System.out.print(travelPrices[i][j]);
                if(travelPrices[i][j]/10 == 0)
                    System.out.print("  ");
                else
                    System.out.print(' ');
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int numberOfCities = 5;
        int[][] travelPrices = new int[numberOfCities][numberOfCities];
        for(int i = 0; i<numberOfCities; i++){
            for(int j=0; j<=i; j++){
                Random rand = new Random();
                if(i==j)
                    travelPrices[i][j] = 0;
                else {
                    travelPrices[i][j] = rand.ints(1,8).limit(1).findFirst().getAsInt();
                    travelPrices[j][i] = travelPrices[i][j];
                }
            }
        }

        printTravelPrices(travelPrices,numberOfCities);

        GeneticSales geneticAlgorithm = new GeneticSales(numberOfCities, SelectionType.ROULETTE, travelPrices, 0, 0);
        SalesmanGenome result = geneticAlgorithm.optimize();
        System.out.println(result);

    }
}

