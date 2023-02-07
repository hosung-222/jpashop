package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

import javax.persistence.*;

public class jpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Order order = em.find(Order.class,1L);
            Long memberId = order.getMemberId();

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