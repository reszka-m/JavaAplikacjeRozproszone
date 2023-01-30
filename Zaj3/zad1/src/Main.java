import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public synchronized static void main(String[] args) throws IOException {
        Map<String, String> waluty = new HashMap<>();
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try{
            Connection connect = Jsoup.connect("https://www.nbp.pl/home.aspx?f=/kursy/kursya.html");
                    Document document = connect.get();
            Elements allH1 = document.select("td");

            for (Element elem : allH1) {
                if (elem.text().contains("euro")) {
                    waluty.put("Euro", elem.nextElementSibling().nextElementSibling().text());
//                    printElements(elem);
                } else if (elem.text().contains("dolar amerykański")) {
                    waluty.put("Dolar amerykański", elem.nextElementSibling().nextElementSibling().text());
//                    printElements(elem);
                } else if (elem.text().contains("frank szwajcarski")) {
                    waluty.put("Frank szwajcarski", elem.nextElementSibling().nextElementSibling().text());
//                    printElements(elem);
                }
            }
            System.out.println(waluty);
            System.out.println(waluty.get("Euro"));
            System.out.println(waluty.get("Dolar amerykański"));
            System.out.println(waluty.get("Frank szwajcarski"));
        } finally {
            reentrantLock.unlock();
        }
    }
    public static void printElements(Element elem) {
//        System.out.println(elem.nextElementSibling().text());
        System.out.println(elem.nextElementSibling().nextElementSibling().text());
    }
}