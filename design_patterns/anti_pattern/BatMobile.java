package design_patterns.anti_pattern;

public class BatMobile {
    private String type;
    private String color;
    private int seats;
    public BatMobile( String type){
        this.type = type;
    }
    public BatMobile (String type, String color){
        this.type = type;
        this.color = color;
    }
    public BatMobile ( String type, String color, int seats){
        this.type = type;
        this.color = color;
        this.seats = seats;
    }
}
