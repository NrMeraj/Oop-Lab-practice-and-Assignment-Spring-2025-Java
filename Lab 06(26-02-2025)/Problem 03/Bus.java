class Bus {
    private Driver driver;

    Bus(Driver driver) {
        this.driver = driver;
    }

    void showDriver() {
        System.out.println("Bus driver is " + driver.name);
    }
}