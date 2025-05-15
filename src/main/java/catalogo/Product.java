package catalogo;

public class Product {
    private Long id;
    private String name;
    private String category;
    private Double price;

    public Product(Long id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getter e Setter
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public Double getPrice() { return price; }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - $" + price;
    }
}
