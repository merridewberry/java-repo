package Lesson7;

public class Cats {

    protected int number;
    protected int fullness;
    protected int appetite;

    public Cats(int number, int appetite, int fullness) {
        this.number = number;
        this.appetite = appetite;
        this.fullness = fullness;
    }

    public Cats() {
    }

    public int getNumber() {
        return number;
    }

    public int getFullness() {
        return fullness;
    }

    public void setFullness(int fullness) {
        this.fullness = fullness;
    }

    public int getAppetite() {
        return appetite;
    }

    public int getHowHungry() {
        return appetite - fullness;
    }

    public void isSated() {
        this.fullness = this.appetite;
        System.out.println("Cat #" + this.number + " is sated. ");
    }

    public void eatFrom(Plates plate) {
        System.out.println("Cat #" + this.getNumber() + " has eaten from the plate #" + plate.getNumber() + ".");
        if (plate.getFullness() >= this.getHowHungry()) {
            plate.decreaseFullness(this.getHowHungry());
            this.isSated();
        } else {
            this.setFullness(this.getFullness() + plate.getFullness());
            plate.decreaseFullness(plate.getFullness());
        }

    }




}
