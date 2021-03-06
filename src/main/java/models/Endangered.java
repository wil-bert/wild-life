package models;

import org.sql2o.Connection;

import java.util.List;


public class Endangered extends Wildlife {

    public static final String HEALTHY = "healthy";
    public static final String OKAY = "okay";
    public static final String ILL = "ill";
    public static final String NEWBORN = "newborn";
    public static final String YOUNG = "young";
    public static final String ADULT = "adult";
    //discriminator
    public static final String DATABASE_TYPE = "endangered";

    private String age;
    private String health;

    public Endangered(String name) {
        this.name = name;
        this.type = DATABASE_TYPE;
    }

    public static List<Endangered> all() {
        try (Connection con = DB.sql2o.open()) {
            String queryEndangered = "SELECT * FROM animals WHERE type='endangered'";
            return con.createQuery(queryEndangered)
                    .executeAndFetch(Endangered.class);
        }
    }

    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }

    public void saveAge(String age) {
        String sql = "UPDATE animals SET age=:age WHERE id=:id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("age", age)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }

    public void saveHealth(String health) {
        String sql = "UPDATE animals SET health=:health WHERE id=:id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("health", health)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }

}
