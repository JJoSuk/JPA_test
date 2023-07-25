package jpa_basic;

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
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("HelloJPA"); // 여기까지는 비영속 상태
//
//            em.persist(member); // 여기서부터는 영속 상태, 그렇다고 db에 저장된 상태는 아니고 영속성 컨텍스트 안에서 관리만 되는 상태
//
//            Member findMember = em.find(Member.class, 100L);
//
//            tx.commit(); // 여기서 커밋을 해야 영속성 컨텍스트 안에서 관리되고 있는 데이터를 db 에 들어간다.

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B"); // 비영속

//            em.persist(member1);
//            em.persist(member2); // 영속 상태이며, sql 에 데이터를 보내지 않는다.

//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZ");

//            em.persist(member);

//            Member member = new Member(200L, "member200");
//            em.persist(member); // 영속 상태
//
//            em.flush();

            Member member = em.find(Member.class, 100L);
            member.setName("AAAA"); // 영속 상태지만,

            em.close(); // 영속성 컨텍스트를 아예 닫아버려서 이것도 역시 준영속 상태가 된다.
            em.clear(); // 내부에 있는 영속 상태 값을 전부 초기화 한다.
            em.detach(member); // 내부에서 외부로 전환해서 준영속 상태가 된다.

            // ================
            tx.commit(); // commit 을 해야 영속성 컨텍스트에 벗어나 DB 에 insert sql 을 보내 저장한다.
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}