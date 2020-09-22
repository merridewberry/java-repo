package Lesson7;

public class Lesson7 {

    public static Cats[] catsArray;
    public static Plates[] platesArray;

    public static void main(String[] args) throws InterruptedException {

        createPlates(3);
        createCats(3);
        int refillFoodFrequency = 5;
        int hungerFrequency = 4;


        hungerGames(refillFoodFrequency, hungerFrequency);

    }

    public static void hungerGames(int refillFoodFrequency, int hungerFrequency) throws InterruptedException {
        int timeCount = 0;
        while (true) {
            int hungerTimeRandomizer = ((int) (Math.random() * 3) + hungerFrequency - 1);
            Thread.sleep(1000);
            timeCount++;
            if (timeCount % refillFoodFrequency == 0) {
                fillPlates();
            }
            if (timeCount % hungerTimeRandomizer == 0) {
                becomeHungry();
                eat();
            }
        }
    }

    public static void createPlates(int quantity) {
        platesArray = new Plates[quantity];
        for (int i = 0; i < quantity; i++) {
            int number = i + 1;
            int capacity = ((int) (Math.random() * 10) + 6);
            Plates plate = new Plates(number, capacity, 0);
            platesArray[i] = plate;
            System.out.println("Created plate #" + platesArray[i].getNumber() + ", capacity: " + platesArray[i].getCapacity());
        }
        System.out.println();
    }

    public static void fillPlates() {
        for (int i = 0; i < platesArray.length; i++) {
            platesArray[i].fullness = platesArray[i].capacity;
        }
        System.out.println("All plates have been filled.");
        System.out.println();
    }

    public static void createCats(int quantity) {
        catsArray = new Cats[quantity];
        for (int i = 0; i < quantity; i++) {
            int number = (i + 1);
            int appetite = (int) (Math.random() * 10) + 6;
            Cats cat = new Cats(number, appetite, 0);
            catsArray[i] = cat;
            System.out.println("Created cat #" + catsArray[i].getNumber() + ", appetite: " + catsArray[i].getAppetite());
        }
        System.out.println();
    }

    public static void eat() {
        for (int i = 0; i < catsArray.length; i++) {
            Cats cat = catsArray[i];
            for (int j = 0; j < platesArray.length; j++) {
                Plates plate = platesArray[j];
                if (cat.getHowHungry() == 0) {
                    System.out.println("Cat #" + cat.getNumber() + " wasn't hungry.");
                    break;
                }
                if (plate.getFullness() != 0) {
                    cat.eatFrom(plate);
                }
                if (cat.getHowHungry() == 0) {
                    break;
                }
                if (cat.getFullness() == 0 && plate.getNumber() == platesArray.length) {
                    System.out.println("Cat #" + cat.getNumber() + " had nothing to eat.");
                } else if (cat.getHowHungry() != 0 && plate.getNumber() == platesArray.length) {
                    System.out.println("Cat #" +  + cat.getNumber() + " fullness is " + cat.getFullness() + "/" +
                            "" + cat.getAppetite());
                }
            }
            System.out.println();
        }
    }

    public static void becomeHungry() {
        for (int i = 0; i < catsArray.length; i++) {
            catsArray[i].setFullness(0);
        }
        System.out.println("Cats are hungry.");
        System.out.println();
    }

}
