package mmf.piskunou.EnumMap;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class EnumMapMain {
    public static void main(String[] args){
        Plant[] garden = {
                new Plant("Tomato", Plant.LifeCycle.ANNUAL),
                new Plant("Apple", Plant.LifeCycle.PERENNIAL),
                new Plant("Beet", Plant.LifeCycle.BIENNIAL)
        };

        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        for(Plant.LifeCycle lc: Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());
        for(Plant p: garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        System.out.println(plantsByLifeCycle);

        // Использование потока и EnumMap для связи данных с перечислениями
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(Plant.LifeCycle.class), toSet())));
    }
}
