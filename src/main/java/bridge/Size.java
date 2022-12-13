package bridge;

public class Size {
    private int size;

    public Size(int size){
        validData(size);
        this.size = size;
    }

    private void validData(int size){
        if(!(size >= 3 && size <= 20)){
            throw new IllegalArgumentException("3부터 20 사이의 숫자만 입력 가능합니다");
        }
    }

    public int getSize(){
        return size;
    }
}
