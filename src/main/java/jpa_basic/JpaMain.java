package jpa_basic;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homeCity", "street", "10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("족발");

            member.getAddressesHistory().add(new AddressEntity("old1", "street", "10000"));
            member.getAddressesHistory().add(new AddressEntity("old2", "street", "10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("======== start =========");
            Member findMember = em.find(Member.class, member.getId());

//            List<Address> addressesHistory = findMember.getAddressesHistory();
//            for (Address address : addressesHistory) {
//                System.out.println("address.getCity() = " + address.getCity());
//            }
//
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }
//
//            em.flush();
//            em.clear();
//
//            System.out.println("======== start =========");
//            Member findMember1 = em.find(Member.class, member.getId());
//
//            // homeCity -> newCity
//            // findMember.getHomeAddress().setCity("newCity"); 잘못된 방법
//            Address a = findMember1.getHomeAddress();
//            findMember1.setHomeAddress(new Address(a.getCity(), a.getStreet(), a.getZipcode()));
//
//            // 치킨 -> 한식
//            findMember1.getFavoriteFoods().remove("치킨");
//            findMember1.getFavoriteFoods().add("햄버거");
//
//            findMember1.getAddressesHistory().remove(new Address("old1", "street", "10000"));
//            findMember1.getAddressesHistory().add(new Address("newCity1", "street", "10000"));

            tx.commit(); // commit 을 해야 영속성 컨텍스트에 벗어나 DB 에 insert sql 을 보내 저장한다.
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }
}