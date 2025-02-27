class Car{
    private Engine engine;
    Car(String engineType) {
        this.engine = new Engine(engineType);
    }

    void startCar() {
        engine.start();
        System.out.println("Car is ready");
    }
}

