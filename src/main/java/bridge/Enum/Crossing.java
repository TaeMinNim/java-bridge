package bridge.Enum;

public enum Crossing {
    UP(1, "U"),
    DOWN(0, "D");

    private int number;
    private String string;

    private Crossing(int number, String string){
        this.number = number;
        this.string = string;
    }

    public static String toString(int number){
        if(Crossing.UP.number == number){
            return Crossing.UP.string;
        }
        return Crossing.DOWN.string;
    }

    public String getString(){
        return string;
    }
}
