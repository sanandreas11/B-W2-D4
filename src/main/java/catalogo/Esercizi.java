package catalogo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Esercizi {

    // Esercizio 1
    public static Map<Customer, List<Order>> raggruppaOrdiniPerCliente(List<Order> ordini) {
        return ordini.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
    }

    // Esercizio 2
    public static Map<Customer, Double> calcolaTotalePerCliente(List<Order> ordini) {
        return ordini.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomer,
                        Collectors.summingDouble(o -> o.getProducts().stream().mapToDouble(Product::getPrice).sum())
                ));
    }

    // Esercizio 3
    public static Optional<Product> prodottoPiuCostoso(List<Product> prodotti) {
        return prodotti.stream()
                .max(Comparator.comparing(Product::getPrice));
    }

    // Esercizio 4
    public static double mediaOrdini(List<Order> ordini) {
        return ordini.stream()
                .mapToDouble(o -> o.getProducts().stream().mapToDouble(Product::getPrice).sum())
                .average()
                .orElse(0.0);
    }

    // Esercizio 5
    public static Map<String, Double> sommaPerCategoria(List<Product> prodotti) {
        return prodotti.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.summingDouble(Product::getPrice)
                ));
    }

    // Esercizio 6
    public static void salvaProdottiSuDisco(List<Product> prodotti, File file) throws IOException {
        String contenuto = prodotti.stream()
                .map(p -> p.getName() + "@" + p.getCategory() + "@" + p.getPrice())
                .collect(Collectors.joining("#"));
        FileUtils.writeStringToFile(file, contenuto, StandardCharsets.UTF_8);
    }

    // Esercizio 7
    public static List<Product> leggiProdottiDaDisco(File file) throws IOException {
        String contenuto = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        String[] record = contenuto.split("#");
        List<Product> prodotti = new ArrayList<>();
        long idCounter = 1;
        for (String r : record) {
            String[] parts = r.split("@");
            if (parts.length == 3) {
                prodotti.add(new Product(idCounter++, parts[0], parts[1], Double.parseDouble(parts[2])));
            }
        }
        return prodotti;
    }
}
