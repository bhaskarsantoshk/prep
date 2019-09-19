package design_patterns.creational_patterns;

public class Client {
    public void main(){
        FerrariBuilder ferrariBuilder = new FerrariBuilder();
        Director director = new Director(ferrariBuilder);
        director.construct(false);
        ICar ferrari = ferrariBuilder.getResult();
    }
}
