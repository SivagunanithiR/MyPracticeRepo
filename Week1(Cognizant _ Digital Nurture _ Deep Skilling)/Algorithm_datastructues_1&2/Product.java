public class Product {
    String name;
    int popularity;

    public Product(String name, int popularity) {
        this.name = name;
        this.popularity = popularity;
    }

    public String getName() { return name; }

    public int getPopularity() { return popularity; }

    @Override
    public String toString() {
        return name + " (popularity: " + popularity + ")";
    }
}
