package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.*;

public class jpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Order order = new Order();
//            order.addOrderItem(new OrderItem());
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            em.persist(orderItem);

            tx.commit();
        }
        catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }


}