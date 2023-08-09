package assignment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberCounterServices {
    private NumberCounterPOJO numberCounterPOJO;
    public NumberCounterServices populateNumberCounterPOJO(List<Integer> numArr) {
        this.numberCounterPOJO = new NumberCounterPOJO();
        this.numberCounterPOJO.setNumberList(numArr);
        HashMap<Integer, Integer> map = numberListToHashMap(numArr);
        this.numberCounterPOJO.setNumberListHashMap(map);
        return this;
    }

    public NumberCounterPOJO markComplete() {
        numberCounterPOJO.setCountDone(true);
        return numberCounterPOJO;
    }

    public HashMap<Integer, Integer> numberListToHashMap(List<Integer> numberList) {
        HashMap<Integer, Integer> numberListHashMap = new HashMap<>();
        for (Integer num : numberList) {
            if (numberListHashMap.get(num) == null) {
                numberListHashMap.put(num, 1);
            } else if (numberListHashMap.containsKey(num)) {
                numberListHashMap.put(num, numberListHashMap.get(num) + 1);
            }
        }
        this.numberCounterPOJO.setNumberListHashMap(numberListHashMap);
        return numberListHashMap;
    }

    public static HashMap<Integer, Integer> hashMapAdder(List<HashMap<Integer, Integer>> mapList){
        HashMap<Integer, Integer> mapTotals = new HashMap<>();
        for(HashMap<Integer, Integer> map : mapList){
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(mapTotals.containsKey(entry.getKey())){
                    mapTotals.put(entry.getKey(), mapTotals.get(entry.getKey()) + entry.getValue());
                }
                else if(!mapTotals.containsKey(entry.getKey())){
                    mapTotals.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return mapTotals;
    }

    public NumberCounterPOJO getNumberCounterPOJO() {
        return numberCounterPOJO;
    }
    public void setNumberCounterPOJO(NumberCounterPOJO numberCounterPOJO) {
        this.numberCounterPOJO = numberCounterPOJO;
    }
}
