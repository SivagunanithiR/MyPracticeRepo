import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    Set<String> words = new HashSet<>();
}
