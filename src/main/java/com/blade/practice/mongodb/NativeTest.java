package com.blade.practice.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.QueryOperators;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

/**
 * mongodb 驱动的原生API操作
 *
 * @author blade
 * 2019/8/29 16:23
 */
public class NativeTest {

    private static MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
    private static MongoDatabase mongoDatabase = mongoClient.getDatabase("blade");
    private static MongoCollection<Document> collection = mongoDatabase.getCollection("user");

    public static void main(String[] args) {
//        insertOne();
//        insertBatch();
        updateOne();
//        findAll();
//        findOne();
//        deleteOne();
//        sum();

    }

    private static void insertOne() {
        // 增加
        Document document = new Document();
        document.put("name", "xiaoming");
        document.put("age", 18);
        document.put("sex", "男");
        document.put("mobilePhone", "13222222222");

        collection.insertOne(document);
    }

    private static void insertBatch() {

        List<Document> documents = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Document document = new Document();
            document.put("name", "for" + i);
            document.put("age", 18);
            document.put("sex", "男");
            document.put("mobilePhone", "13222222222");
            documents.add(document);
        }

        collection.insertMany(documents);
    }

    private static void updateOne() {
        // 改
//        collection.updateOne(Filters.eq("name", "blade"), new Document("$set", new Document("age", 18)));
        UpdateResult updateResult = collection.updateOne(Filters.eq("name", "blade"), Updates.set("age", 20));
        System.out.println("更新条数为:" + updateResult.getModifiedCount());
    }

    private static void findAll() {
        // 查
        FindIterable<Document> iterable = collection.find();
        MongoCursor<Document> cursor = iterable.iterator();

        while (cursor.hasNext()) {
            System.out.println(cursor.next().toJson());
        }
    }

    private static void findOne() {
        Document document = collection.find(Filters.eq("name", "blade")).first();
        System.out.println(document.toJson());
    }

    private static void deleteOne() {
        collection.deleteOne(Filters.eq("name", "for0"));
    }

    private static void sum() {
        List<Bson> list = new ArrayList<>();
        list.add(Aggregates.count("age"));
        AggregateIterable<Document> aggregate = collection.aggregate(list);
        MongoCursor<Document> cursor = aggregate.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next().toJson());
        }
    }
}
