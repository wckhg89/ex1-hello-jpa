package hellojpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            // Member member = new Member(1L, "guppy");
            // em.persist(member);
            // em.flush(); // 쓰기지연 SQL 저장소 비우기

            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            em.detach(member); // 준영속화

            System.out.println("=======================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}
