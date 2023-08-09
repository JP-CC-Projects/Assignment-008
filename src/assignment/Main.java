package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {

        ExecutorService executorFixedThreadPool = Executors.newFixedThreadPool(32);
        ExecutorService singleThreadService = Executors.newSingleThreadExecutor();
        ExecutorService cachedThreadService = Executors.newCachedThreadPool();

        List<HashMap<Integer, Integer>> hashMapList = new ArrayList<>();
        List<HashMap<Integer, Integer>> concurrentHashMapList = Collections.synchronizedList(hashMapList);
        HashMap<Integer, Integer> mapTotals = new HashMap<>();
        Assignment8 assignment8 = new Assignment8();

            for (int i = 0; i < 1000; i++) {
                CompletableFuture.supplyAsync(() -> new NumberCounterServices(), cachedThreadService)
                        .thenApplyAsync(service -> service.populateNumberCounterPOJO(assignment8.getNumbers()), cachedThreadService)
                        .thenApplyAsync(numberCounterServices -> numberCounterServices.getNumberCounterPOJO(), singleThreadService)
                        .thenApplyAsync(numberCounterPOJO -> numberCounterPOJO.getNumberListHashMap(), singleThreadService)
                        .thenAcceptAsync(hashMap -> concurrentHashMapList.add(hashMap), singleThreadService);
            }
        while(concurrentHashMapList.size() < 1000) {}

        cachedThreadService.shutdown();
        singleThreadService.shutdown();
        mapTotals = NumberCounterServices.hashMapAdder(concurrentHashMapList);
        System.out.println("HashMap of Totals: " + mapTotals);
    }
}
