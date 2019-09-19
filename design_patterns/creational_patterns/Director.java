package design_patterns.creational_patterns;

public class Director {
    CarBuilder carBuilder;

    public Director(CarBuilder carBuilder){
        this.carBuilder = carBuilder;
    }

    public void construct(boolean isRaceCar ){
        carBuilder.buildEngine();
        carBuilder.buildDriverCabin();
        carBuilder.buildXhasis();
        if ( isRaceCar ){
            carBuilder.buildDoors();
        }
    }
}
