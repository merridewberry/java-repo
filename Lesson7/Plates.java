package Lesson7;

public class Plates {

    protected int number;
    protected int capacity;
    protected int fullness;

    public Plates(int number, int capacity, int fullness) {
        this.number = number;
        this.capacity = capacity;
        this.fullness = fullness;
    }

    public Plates() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFullness() {
        return fullness;
    }

    public void setFullness(int fullness) {
        this.fullness = fullness;
    }

    public void decreaseFullness (int amount) {
        this.fullness = this.fullness - amount;
        System.out.println("Plate #" + this.getNumber() + " fullness is " + this.getFullness() + "/" +
                "" + this.getCapacity());
    }

}
