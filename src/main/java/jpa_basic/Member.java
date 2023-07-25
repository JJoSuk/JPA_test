package jpa_basic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // 아 jpa 사용하는구나 인식 시켜주기 ㅋ.ㅋ
public class Member {
    @Id
    private Long id;
    private String name;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
