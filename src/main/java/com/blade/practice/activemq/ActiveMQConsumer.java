package com.blade.practice.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/21 12:10
 */
public class ActiveMQConsumer {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.2.106:61616");
        Connection connection = null;

        try {
            connection = connectionFactory.createConnection();

            connection.start();

            // 事务性会话
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("active_test");

            MessageConsumer consumer = session.createConsumer(destination);

            TextMessage message = (TextMessage)consumer.receive();

            System.out.println(message.getText());

            session.commit();
            session.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
