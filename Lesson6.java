public class Lesson6 {

    public static void main(String[] args) {

        int catsQuantity = 5;
        int dogsQuantity = 5;
        Cat[] catsArray = new Cat[catsQuantity];
        Dog[] dogsArray = new Dog[dogsQuantity];

        prepareCats(catsQuantity, catsArray);
        prepareDogs(dogsQuantity, dogsArray);

        int runningCheck = 220;
        double jumpingCheck = 2.1;
        double swimmingCheck = 10.2;

        runningCheck(runningCheck, catsArray);
        jumpingCheck(jumpingCheck, catsArray);
        swimmingCheck(swimmingCheck, catsArray);

        runningCheck(runningCheck, dogsArray);
        jumpingCheck(jumpingCheck, dogsArray);
        swimmingCheck(swimmingCheck, dogsArray);

    }

    private static void prepareCats(int catsQuantity, Cat[] catsArray) {
        fillCats(catsQuantity, catsArray);
        randomize(catsQuantity, catsArray);
    }

    private static void prepareDogs(int dogsQuantity, Dog[] dogsArray) {
        fillDogs(dogsQuantity, dogsArray);
        randomize(dogsQuantity, dogsArray);
    }

    private static void randomize(int quantity, Animal[] array) {
        for (int i = 0; i < quantity; i++) {
            array[i].randomize();
        }
        System.out.println();
    }

    private static void fillCats(int catsQuantity, Cat[] catsArray) {
        for (int i = 0; i < catsQuantity; i++) {
            int x = (int) (Math.random() * 2);
            Cat cat = new Cat();
            catsArray[i] = cat;
            if (x > 0) {
                catsArray[i].setRandom(true);
                catsArray[i].setName("RandomCat" + (i + 1));
            } else {
                catsArray[i].setRandom(false);
                catsArray[i].setName("DefaultCat" + (i + 1));
            }
        }
    }

    private static void fillDogs(int dogsQuantity, Dog[] dogsArray) {
        for (int i = 0; i < dogsQuantity; i++) {
            int x = (int) (Math.random() * 2);
            Dog dog = new Dog();
            dogsArray[i] = dog;
            if (x > 0) {
                dogsArray[i].setRandom(true);
                dogsArray[i].setName("RandomDog" + (i + 1));
            } else {
                dogsArray[i].setRandom(false);
                dogsArray[i].setName("DefaultDog" + (i + 1));
            }
        }
    }

    private static void runningCheck(int distance, Animal[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i].run(distance);
        }
        System.out.println();
    }

    private static void jumpingCheck(double distance, Animal[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i].jump(distance);
        }
        System.out.println();
    }

    private static void swimmingCheck(double distance, Animal[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i].swim(distance);
        }
        System.out.println();
    }

}
