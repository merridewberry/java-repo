public class Dog extends Animal{

    protected double swimmingDistance;

    public Dog(String name, boolean random, int runningDistance, double jumpingHeight, double swimmingDistance) {
        super(name, random, runningDistance, jumpingHeight);
        this.swimmingDistance = swimmingDistance;
    }

    public Dog() {
    }

    public double getSwimmingDistance() {
        return swimmingDistance;
    }

    public void setSwimmingDistance(double swimmingDistance) {
        this.swimmingDistance = swimmingDistance;
    }

    @Override
    public void swim(double distance) {
        if (swimmingDistance >= distance) {
            System.out.printf("%s can swim %.2f meters.%nTheir maximum swimming distance is %.2f.%n%n",
                    getName(), distance, swimmingDistance);
        } else {
            System.out.printf("%s cannot swim %.2f meters.%nTheir maximum swimming distance is %.2f.%n%n",
                    getName(), distance, swimmingDistance);
        }
    }

    @Override
    public void randomize() {
        if (!getRandom()) {
            setRunningDistance(500);
            setJumpingHeight(0.5);
            setSwimmingDistance(10.0);
            System.out.printf("%s parameters set to default.%n", getName());
        } else {
            setRunningDistance( (int) (Math.random() * 500) + 200);
            setJumpingHeight((Math.random() * 0.5) + 0.3);
            setSwimmingDistance((Math.random() * 10.0) + 5.0);
            System.out.printf("%s parameters randomized.%n", getName());
        }

    }
}
