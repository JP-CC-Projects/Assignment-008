package assignment;
import java.util.HashMap;
import java.util.List;

public class NumberCounterPOJO {
    private Boolean countDone = false;
    private HashMap<Integer, Integer> numberListHashMap;
    private List<Integer> numberList;

    public Boolean getCountDone() {
        return countDone;
    }
    public void setCountDone(Boolean countDone) {
        this.countDone = countDone;
    }

    public HashMap<Integer, Integer> getNumberListHashMap() {
        return numberListHashMap;
    }
    public void setNumberListHashMap(HashMap<Integer, Integer> numberListHashMap) {
        this.numberListHashMap = numberListHashMap;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }

}
