package design_patterns.creational_patterns;

public class LamborginiBuilder extends CarBuilder {
    Lamborgini lamborgini;
    public ICar getResult() {
        return lamborgini;
    }
    @Override
    public void buildEngine() {

    }
    @Override
    public void buildXhasis() {

    }
    @Override
    public void buildDriverCabin() {
        lamborgini = new Lamborgini();
    }

    // No build doors method has been overridden.
}
