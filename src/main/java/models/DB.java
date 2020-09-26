package models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Sql2o;

import java.net.URI;
import java.net.URISyntaxException;


public class DB {
    public static URI dbUri;
    public static Sql2o sql2o;
    static Logger logger = LoggerFactory.getLogger(DB.class);

    static {
//       postgresql-cubed-69578
        try {
            URI dbUri;
            if (System.getenv("DATABASE_URL") == null) {
                dbUri = new URI("postgresql://ec2-52-200-82-50.compute-1.amazonaws.com:5432/d4bmmm5f286tqn");
            } else {
                dbUri = new URI(System.getenv("DATABASE_URL"));
            }
            int port = dbUri.getPort();
            String host = dbUri.getHost();
            String path = dbUri.getPath();
            String username = (dbUri.getUserInfo() == null) ? "wiplifetuwgjtw" : dbUri.getUserInfo().split(":")[0];
            String password = (dbUri.getUserInfo() == null) ? "77c8423851f1e2a790924744b77c782f7747f32b07811aa481e023fe0d614edd" : dbUri.getUserInfo().split(":")[1];
            sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
        } catch (URISyntaxException e) {
            logger.error("Unable to connect.");
        }
    }
}
