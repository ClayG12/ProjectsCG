import java.io.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        String inputFile = "pay.csv";
        String outputFile = "output.csv";

        DecimalFormat df = new DecimalFormat("$0.00");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;

            // Skip header row
            reader.readLine();

            // Optional: write headers
            writer.write("Name,Pay Rate,Hours Worked,Weekly Pay");
            writer.newLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                String name = data[0];

                // Convert Strings to doubles
                double payRate = Double.parseDouble(data[1]);
                double hours = Double.parseDouble(data[2]);

                double weeklyPay;

                // Overtime calculation
                if (hours > 40) {
                    double overtimeHours = hours - 40;
                    weeklyPay = (40 * payRate) + (overtimeHours * payRate * 1.5);
                } else {
                    weeklyPay = hours * payRate;
                }

                // Format as money (String now)
                String formattedPay = df.format(weeklyPay);

                // Build output line
                String outputLine = name + "," + payRate + "," + hours + "," + formattedPay;

                writer.write(outputLine);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("File processed successfully!");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Data format error: " + e.getMessage());
        }
    }
}