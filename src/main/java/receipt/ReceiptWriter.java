package receipt;

import model.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void saveReceipt(Order order) {
        try {
            File folder = new File("receipts");
            folder.mkdirs();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String filename = "receipts/" + LocalDateTime.now().format(formatter) + ".txt";

            FileWriter writer = new FileWriter(filename);
            writer.write(order.getSummary());
            writer.close();

            System.out.println("Receipt saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving receipt.");
        }
    }
}
