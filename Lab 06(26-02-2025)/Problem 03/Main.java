public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("V8 Hyper Sonic");
        myCar.startCar();

        System.out.println();
        Driver driver = new Driver("Lemar");
        Bus myBus = new Bus(driver);
        myBus.showDriver();
    }
}