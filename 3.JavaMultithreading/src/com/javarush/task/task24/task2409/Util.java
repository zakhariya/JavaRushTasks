package com.javarush.task.task24.task2409;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static com.javarush.task.task24.task2409.Util.Company.Denim;
import static com.javarush.task.task24.task2409.Util.Company.Levis;

public class Util {
    protected static Collection<Object[]> jeansArray = new LinkedList<>();

    static {
        jeansArray.add(new Object[]{1, Levis, 34, 6, 150.0});
        jeansArray.add(new Object[]{2, Denim, 35, 8, 154.0});
        jeansArray.add(new Object[]{3, Company.Colins, 32, 6, 120.0});
        jeansArray.add(new Object[]{4, Company.CalvinKleinJeans, 31, 8, 125.0});
    }

    public static List<Jeans> getAllJeans() {

        abstract class AbstractJeans implements Jeans {
            private int id, length, size;
            private double price;

            public AbstractJeans(int id, int length, int size, double price) {
                this.id = id;
                this.length = length;
                this.size = size;
                this.price = price;
            }

            protected abstract String getJeansInfo();

            @Override
            public int getId() {
                return this.id;
            }

            @Override
            public double getPrice() {
                return this.price;
            }

            @Override
            public String getTM() {
                return this.getClass().getSimpleName();
            }

            @Override
            public int getLength() {
                return this.length;
            }

            @Override
            public int getSize() {
                return this.size;
            }

            @Override
            public String toString() {
                String pattern = "%s{id=%d, length=%d, size=%d, price=%s}";

                return String.format(pattern, this.getTM(), this.getId(), this.getLength(), this.getSize(),
                        new BigDecimal(this.getPrice()).setScale(2, RoundingMode.HALF_UP));
            }
        }

        class Levis extends AbstractJeans {

            public Levis(int id, int length, int size, double price) {
                super(id, length, size, price);
            }

            @Override
            protected String getJeansInfo() {
                return super.toString();
            }
        }

        class Denim extends AbstractJeans {

            public Denim(int id, int length, int size, double price) {
                super(id, length, size, price);
            }

            @Override
            protected String getJeansInfo() {
                return super.toString();
            }
        }

        List<Jeans> allJeans = new LinkedList<>();

        for (Object[] obj : getJeansArray()) {
            int id = (int) obj[0];
            final Company company = (Company) obj[1];
            int length = (int) obj[2];
            int size = (int) obj[3];
            double price = (double) obj[4];

            Jeans jeans = null;
            if (Levis == company) {
                jeans = new Levis(id, length, size, price);
            } else if (Denim == company) {
                jeans = new Denim(id, length, size, price);
            } else {
                jeans = new AbstractJeans(id, length, size, price) {
                    @Override
                    protected String getJeansInfo() {
                        return this.toString();
                    }

                    public String getTM() {
                        return company.fullName;
                    }
                };
            }
            allJeans.add(jeans);
        }
        return allJeans;
    }

    public static Collection<Object[]> getJeansArray() {
        return jeansArray;
    }

    static enum Company {
        Levis("Levi's"),
        Denim("Denim"),
        Colins("COLIN'S"),
        CalvinKleinJeans("Calvin Klein Jeans");

        final String fullName;

        Company(String name) {
            this.fullName = name;
        }
    }
}
