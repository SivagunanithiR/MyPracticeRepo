import java.util.*;

interface ProductSearchEngine {
    void insertProduct(String name, int popularity);
    void deleteProduct(String name);
    List<Product> search(String prefix, int k);
}
