package models;

import org.sql2o.Connection;

import java.util.List;

public class Animal extends Wildlife {
    private static final String DATABASE_TYPE = "animals";

    public Animal(String name) {
        this.name = name;
        this.type = DATABASE_TYPE;
    }

    public static List<Animal> all() {
        try (Connection con = DB.sql2o.open()) {
            String queryAnimals = "SELECT * FROM animals WHERE type='animals'";
            return con.createQuery(queryAnimals)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);
        }
    }
}
