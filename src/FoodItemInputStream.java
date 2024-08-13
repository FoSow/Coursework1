
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FoodItemInputStream extends InputStream {
    private BufferedReader reader;

    public FoodItemInputStream(InputStream input) {
        this.reader = new BufferedReader(new InputStreamReader(input));
    }

    @Override
    public int read() throws IOException {
        // This method must be implemented when extending InputStream, but we don't use it directly.
        throw new UnsupportedOperationException("Use readItem() instead.");
    }

    @Override
    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    public FoodItem readItem() throws IOException {
        String line = reader.readLine();
        if (line == null) {
            return null; // End of file
        }

        // Assuming the line format is "type,name,calories,price"
        String[] parts = line.split(",");
        if (parts.length != 4) {
            throw new IOException("Invalid line format");
        }

        try {
            String type = parts[0].trim();
            String name = parts[1].trim();
            int calories = Integer.parseInt(parts[2].trim());
            double price = Double.parseDouble(parts[3].trim());

            // Assuming FoodItem has a constructor with the signature:
            // public FoodItem(String type, String name, int calories, double price)
            return new FoodItem(type, FoodType.FRUIT, FoodType.CHEESE, FoodType.DRINK);
        } catch (NumberFormatException e) {
            throw new IOException("Invalid number format in line: " + line, e);
        }
    }
}
