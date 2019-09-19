package design_patterns.creational_patterns.phone;

public class Shop {
    public static void main(String[] args){
        Phone p = new Phone("Android", "QualComm", 5.5, 3100,13);
        System.out.println(p);

        Phone iPhone = new PhoneBuilder().setBattery(3000).setCamera(8).setScreenSize(4).getPhone();
        System.out.println(iPhone);
    }
}
