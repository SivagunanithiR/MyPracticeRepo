class SearchFactory {
    public static ProductSearchEngine createSearchEngine(String type) {
        if (type.equalsIgnoreCase("popularity")) {
            return new TrieSearchEngine(new PopularityRanking());
        } else if (type.equalsIgnoreCase("alphabetical")) {
            return new TrieSearchEngine(new AlphabeticalRanking());
        } else {
            throw new IllegalArgumentException("Invalid strategy type");
        }
    }
}
