package catalogo;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Customer c1 = new Customer(1L, "Alice", 2);
        Customer c2 = new Customer(2L, "Bob", 1);

        Product p1 = new Product(1L, "Book 1", "Books", 120.0);
        Product p2 = new Product(2L, "Toy", "Baby", 40.0);
        Product p3 = new Product(3L, "Game", "Toys", 80.0);

        Order o1 = new Order(1L, "Shipped", LocalDate.now(), LocalDate.now().plusDays(2), List.of(p1, p2), c1);
        Order o2 = new Order(2L, "Delivered", LocalDate.now(), LocalDate.now().plusDays(3), List.of(p3), c1);
        Order o3 = new Order(3L, "Processing", LocalDate.now(), LocalDate.now().plusDays(4), List.of(p2), c2);

        List<Order> orders = List.of(o1, o2, o3);
        List<Product> products = List.of(p1, p2, p3);

        // Esercizi
        System.out.println("Esercizio 1: " + Esercizi.raggruppaOrdiniPerCliente(orders));
        System.out.println("Esercizio 2: " + Esercizi.calcolaTotalePerCliente(orders));
        System.out.println("Esercizio 3: " + Esercizi.prodottoPiuCostoso(products));
        System.out.println("Esercizio 4: " + Esercizi.mediaOrdini(orders));
        System.out.println("Esercizio 5: " + Esercizi.sommaPerCategoria(products));

        // EXTRA: Salvataggio e Lettura
        File file = new File("prodotti.txt");
        Esercizi.salvaProdottiSuDisco(products, file);
        List<Product> caricati = Esercizi.leggiProdottiDaDisco(file);
        System.out.println("Esercizio 7: Prodotti caricati da file -> " + caricati);
    }
}