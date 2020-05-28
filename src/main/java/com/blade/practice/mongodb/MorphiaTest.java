package com.blade.practice.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

/**
 * @author blade
 * 2019/8/29 17:31
 */
public class MorphiaTest {

    private static Datastore datastore = new Morphia().createDatastore(
            new MongoClient("127.0.0.1", 27017), "blade");

    public static void main(String[] args) {
        findOne();
//        saveOne();
    }

    private static void findOne() {
        Query<User> query = datastore.find(User.class);
        System.out.println(datastore.find(User.class));
    }

    private static void saveOne() {
        User user = new User();
        user.setName("morphia");
        user.setAge(88);
        user.setSex("男");

        datastore.save(user);
    }
}
