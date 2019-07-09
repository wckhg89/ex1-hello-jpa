package hellojpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {



        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
//            insert
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("guppyB");
//            em.persist(member);

//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("guppy.kang");

            List<Member> members = em.createQuery("select m from Member as m", Member.class).getResultList();

            members.forEach(it -> System.out.println(it.getName()));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}
