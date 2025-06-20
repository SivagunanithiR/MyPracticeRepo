import java.util.*;

class TrieSearchEngine implements ProductSearchEngine {
    private TrieNode root = new TrieNode();
    private Map<String, Integer> popularityMap = new HashMap<>();
    private RankingStrategy rankingStrategy;

    public TrieSearchEngine(RankingStrategy strategy) {
        this.rankingStrategy = strategy;
    }

    public void insertProduct(String name, int popularity) {
        popularityMap.put(name, popularityMap.getOrDefault(name, 0) + popularity);
        TrieNode node = root;
        for (char c : name.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.words.add(name);
        }
    }

    public void deleteProduct(String name) {
        if (!popularityMap.containsKey(name)) return;
        popularityMap.remove(name);
        TrieNode node = root;
        for (char c : name.toCharArray()) {
            if (!node.children.containsKey(c)) return;
            node = node.children.get(c);
            node.words.remove(name);
        }
    }

    public List<Product> search(String prefix, int k) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) return new ArrayList<>();
            node = node.children.get(c);
        }
        return rankingStrategy.rank(node.words, popularityMap, k);
    }
}
