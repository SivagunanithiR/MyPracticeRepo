public class ProductSearchSystem {
    private static ProductSearchSystem instance;
    private ProductSearchEngine engine;

    private ProductSearchSystem(String strategyType) {
        engine = SearchFactory.createSearchEngine(strategyType);
    }

    public static ProductSearchSystem getInstance(String strategyType) {
        if (instance == null) {
            instance = new ProductSearchSystem(strategyType);
        }
        return instance;
    }

    public void insert(String name, int popularity) {
        engine.insertProduct(name, popularity);
    }

    public void delete(String name) {
        engine.deleteProduct(name);
    }

    public List<Product> search(String prefix, int k) {
        return engine.search(prefix, k);
    }
}
