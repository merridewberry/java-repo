public class Cat extends Animal {

    public Cat(String name, boolean random) {
        super("Cat", true);
    }

    public Cat() {
    }

    @Override
    public void swim(double distance) {
        System.out.println("Cats cannot swim.");
    }

    public void randomize() {
        if (!getRandom()) {
            setRunningDistance(200);
            setJumpingHeight(2.0);
            System.out.printf("%s parameters set to default.%n", getName());
        } else {
            setRunningDistance( (int) (Math.random() * 200) + 100);
            setJumpingHeight((Math.random() * 2.0) + 1.0);
            System.out.printf("%s parameters randomized.%n", getName());
        }
    }
}
