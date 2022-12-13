package bridge;

public enum Status {
    Running("실행중"),
    GameOver("실패"),
    Success("성공");

    private String name;
    Status(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
