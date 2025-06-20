public class EcommerceSearchDemo {
    public static void main(String[] args) {
        ProductSearchSystem searchSystem = ProductSearchSystem.getInstance("popularity");

        searchSystem.insert("laptop", 10);
        searchSystem.insert("lamp", 15);
        searchSystem.insert("laptop", 5);
        searchSystem.insert("latte", 8);
        searchSystem.insert("laptopcase", 4);
        searchSystem.insert("laptoptable", 6);
        searchSystem.insert("lampstand", 3);

        System.out.println("Top 3 results for 'lap': " + searchSystem.search("lap", 3));
        System.out.println("Top 2 results for 'lamp': " + searchSystem.search("lamp", 2));
        System.out.println("Top 5 results for 'la': " + searchSystem.search("la", 5));

        System.out.println("\nDeleting 'lamp'...");
        searchSystem.delete("lamp");
        System.out.println("After deletion, 'lamp' results: " + searchSystem.search("lamp", 3));
    }
}
