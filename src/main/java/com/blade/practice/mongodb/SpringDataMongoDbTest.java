package com.blade.practice.mongodb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @author blade
 * 2019/8/29 17:33
 */
public class SpringDataMongoDbTest {

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-mongo.xml");
    private static MongoTemplate mongoTemplate = (MongoTemplate)applicationContext.getBean("mongoTemplate");
    public static void main(String[] args) {
//        insertOne();
        findOne();
    }

    private static void insertOne() {
        SpringUser user = new SpringUser();
        user.setName("spring");
        user.setAge(10);
        user.setSex("男");

        mongoTemplate.insert(user);
    }

    private static void findOne() {
        Criteria criteria = Criteria.where("age").is(10);
        SpringUser user = mongoTemplate.findOne(new Query(criteria), SpringUser.class);
        System.out.println(user.toString());
    }
}
