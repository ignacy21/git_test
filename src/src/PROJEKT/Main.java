package src.PROJEKT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
//    id,first_name,last_name,email,ip_address,color,car_vin,car_company,car_model,car_model_year,car_price,country,city,date

    public static void main(String[] args) {

        Path path = Paths.get("src/PROJEKT/car-spreadsheet.csv");
        // 1
        List<String> read = read(path);
        List<Purchase> purchaseList = createObjectFormList(read);
        // 2
        Path carCompanies = Paths.get("src/PROJEKT/carCompanies");
        writeCarFilesByCompany(purchaseList);
        Map<String, Long> stringLongMap = fileNameAndSize(carCompanies);
//        for (Map.Entry<String, Long> stringLongEntry : stringLongMap.entrySet()) {
//            System.out.println(stringLongEntry);
//        }
        // 3
        Path averagePriceFile = Paths.get("src/PROJEKT/averagePriceFile.txt");
        averagePrice(purchaseList, averagePriceFile);

        // 4
        Path path1 = Path.of("src/PROJEKT/purchasesDates.txt");
        purchaseDates(purchaseList, path1);

    }

    private static void purchaseDates(List<Purchase> purchaseList, Path path) {

        if (!path.toFile().exists()) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException("Creation of file went wrong");
            }
        }

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {

            purchaseList.stream()
                    .sorted((t1, t2) -> {
                        LocalDateTime dateTime1 = t1.getDateTime();
                        LocalDateTime dateTime2 = t2.getDateTime();
                        if (dateTime1.isBefore(dateTime2)) {
                            return -1;
                        } else if (dateTime1.isEqual(dateTime2)) {
                            return 0;
                        }
                        return 1;
                    })
                    .forEach(p -> {
                        try {
                            writer.write(p.getDateTime().toString());
                            writer.write("   ");
                            writer.write(p.toString());
                            writer.newLine();
                        } catch (IOException e) {
                            throw new RuntimeException("Sth went wrong in writer.write()");
                        }
                    });

        } catch (IOException e) {
            throw new RuntimeException("Sth went wrong during purchaseDates() - write()");
        }

    }

    private static void averagePrice(List<Purchase> purchaseList, Path fileToWriteData) {
        Map<String, List<Purchase>> groupingByModel = purchaseList.stream()
                .collect(Collectors.groupingBy(p -> p.getCar().getModel()));
        try (BufferedWriter writer = Files.newBufferedWriter(fileToWriteData)) {
            if (!fileToWriteData.toFile().exists()) {
                try {
                    Files.createFile(fileToWriteData);
                } catch (IOException e) {
                    throw new RuntimeException("Creation of file went wrong");
                }
            }
            int counter = 0;
            String model = "";
            String company = "";

            for (List<Purchase> value : groupingByModel.values()) {
                int counter1 = 0;
                counter++;
                BigDecimal price = BigDecimal.valueOf(0);
                for (Purchase purchase : value) {
                    model = purchase.getCar().getModel();
                    company = purchase.getCar().getCompany();
                    counter1++;
                    BigDecimal price1 = purchase.getCar().getPrice();
                    price = price.add(price1);
                }
//                System.out.println(""+counter);
//                System.out.println("marka: " + company);
//                System.out.println("model: " + model);
//                System.out.println("number of cars bought: " + counter1);
//                System.out.println("price of all cars combined: " + price);
//                System.out.println("average price: " + price.divide(BigDecimal.valueOf(counter1), RoundingMode.HALF_UP));
//                System.out.println();
                writer.write(counter + "." + "\n");
                writer.write("marka: " + company + "\n");
                writer.write("model: " + model + "\n");
                writer.write("number of cars bought: " + counter1 + "\n");
                writer.write("price of all cars combined: " + price + "\n");
                writer.write("average price: " + price.divide(BigDecimal.valueOf(counter1), RoundingMode.HALF_UP) + "\n");
                writer.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Sth went wrong during averagePrice() - write()" + e);
        }
    }

    private static TreeMap<String, Long> fileNameAndSize(Path path) {
        try (Stream<Path> walk = Files.walk(path)) {
            Map<String, Long> collect = walk
                    .skip(1)
                    .collect(Collectors.toMap(walkPath -> {
                        String pathToString = walkPath.toString();
                        String substring = pathToString.substring(25, pathToString.length() - 4);
                        return substring;
                    }, walkPath -> {
                        try {
                            return Files.size(walkPath);
                        } catch (IOException e) {
                            throw new RuntimeException("Sth went wrong during Files.size() in stream");
                        }
                    }));
            return new TreeMap<>(collect);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong during walk()");
        }
    }

    private static List<String> read(Path path) {
        List<String> resultList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();
            while (line != null) {
                resultList.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Reading went wrong");
        }
        return resultList;
    }

    private static List<Purchase> createObjectFormList(List<String> dataListString) {
        List<Purchase> result = new ArrayList<>();
        for (String line : dataListString) {
            String[] split = line.split(",");
            String id = split[0];
            BigDecimal idBigDecimal = BigDecimal.valueOf(Long.parseLong(id));
            String first_name = split[1];
            String last_name = split[2];
            String email = split[3];
            String ip_address = split[4];
            String color = split[5];
            String car_vin = split[6];
            String car_company = split[7];
            String car_model = split[8];
            String car_model_year = split[9];
            String car_price = split[10];
            String country = split[11];
            String city = split[12];
            String date = split[13];
            String[] dateSplit = date.split("-");
            int year = Integer.parseInt(dateSplit[0]);
            int month = Integer.parseInt(dateSplit[1]);
            int dayOfMonth = Integer.parseInt(dateSplit[2]);
            LocalDateTime localDateTime = LocalDateTime.of(year, month, dayOfMonth, 0, 0);

            String carPrice = car_price.substring(1, car_price.length() - 1);
            String currency = carPrice.substring(0, 1);
            String price = carPrice.substring(1);
            BigDecimal priceBigDecimal = BigDecimal.valueOf(Double.parseDouble(price));

            Localization localization = new Localization(country, city);
            Person person = new Person(first_name, last_name, email, ip_address);
            Car car = new Car(color, car_vin, car_company, car_model, car_model_year, priceBigDecimal);
            Purchase purchase = new Purchase(idBigDecimal, person, car, localization, localDateTime);
            result.add(purchase);
        }
        return result;
    }

    private static void writeCarFilesByCompany(List<Purchase> purchaseList) {
        List<String> carCompanyStringList = purchaseList.stream()
                .map(x -> x.getCar().getCompany())
                .distinct()
                .toList();

        for (String company : carCompanyStringList) {
            List<Purchase> purchaseListSpecificCompany = new ArrayList<>();
            Path specificCompanyPath = Path.of("src/PROJEKT/carCompanies/" + company + ".txt");
            if (!specificCompanyPath.toFile().exists()) {
                try {
                    Files.createFile(specificCompanyPath);
                } catch (IOException e) {
                    throw new RuntimeException("Creation of file went wrong");
                }
            }

            for (Purchase purchase : purchaseList) {
                if (purchase.getCar().getCompany().equals(company)) {
                    purchaseListSpecificCompany.add(purchase);
                }
            }
            try (BufferedWriter writer = Files.newBufferedWriter(specificCompanyPath)) {
                for (Purchase purchase : purchaseListSpecificCompany) {
                    writer.write(purchase.toString());
                    writer.newLine();
                }
            } catch (IOException e) {
                throw new RuntimeException("Writing in file went wrong");
            }
        }
    }
}
