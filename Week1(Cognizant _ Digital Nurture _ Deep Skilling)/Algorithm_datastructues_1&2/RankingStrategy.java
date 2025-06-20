import java.util.*;

interface RankingStrategy {
    List<Product> rank(Set<String> productNames, Map<String, Integer> popularityMap, int k);
}

// Popularity First
class PopularityRanking implements RankingStrategy {
    public List<Product> rank(Set<String> productNames, Map<String, Integer> popMap, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int cmp = Integer.compare(popMap.get(b), popMap.get(a));
            return (cmp != 0) ? cmp : a.compareTo(b);
        });

        pq.addAll(productNames);
        List<Product> result = new ArrayList<>();
        while (!pq.isEmpty() && k-- > 0) {
            String name = pq.poll();
            result.add(new Product(name, popMap.get(name)));
        }
        return result;
    }
}

// Alphabetical
class AlphabeticalRanking implements RankingStrategy {
    public List<Product> rank(Set<String> productNames, Map<String, Integer> popMap, int k) {
        List<String> sorted = new ArrayList<>(productNames);
        Collections.sort(sorted);
        List<Product> result = new ArrayList<>();
        for (int i = 0; i < Math.min(k, sorted.size()); i++) {
            result.add(new Product(sorted.get(i), popMap.get(sorted.get(i))));
        }
        return result;
    }
}
