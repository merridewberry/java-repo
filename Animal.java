public abstract class Animal {

    protected int runningDistance;
    protected double jumpingHeight;
    protected String name;
    protected boolean random;

    public Animal() {
    }

    public Animal(String name, boolean random, int runningDistance, double jumpingHeight) {
        this.runningDistance = runningDistance;
        this.jumpingHeight = jumpingHeight;
        this.name = name;
        this.random = random;
    }

    public Animal(String name, boolean random) {
        this.name = name;
        this.random = random;
    }

    public int getRunningDistance() {
        return runningDistance;
    }

    public void setRunningDistance(int runningDistance) {
        this.runningDistance = runningDistance;
    }

    public double getJumpingHeight() {
        return jumpingHeight;
    }

    public void setJumpingHeight(double jumpingHeight) {
        this.jumpingHeight = jumpingHeight;
    }

    public boolean getRandom() {
        return random;
    }

    public void setRandom(boolean random) {
        this.random = random;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void swim(double distance);

    public void jump(double distance) {
        if (getJumpingHeight() >= distance) {
            System.out.printf("%s can jump %.2f meters.%nTheir maximum jumping height is %.2f.%n%n",
                    name, distance, jumpingHeight);
        } else {
            System.out.printf("%s cannot jump %.2f meters.%nTheir maximum jumping height is %.2f.%n%n",
                    name, distance, jumpingHeight);
        }
    }

    public void run(int distance) {
        if (getRunningDistance() >= distance) {
            System.out.printf("%s can run %d meters.%nTheir maximum running distance is %d.%n%n",
                    name, distance, runningDistance);
        } else {
            System.out.printf("%s cannot run %d meters.%nTheir maximum running distance is %d.%n%n",
                    name, distance, runningDistance);
        }
    }

    public abstract void randomize();

}
