package jpa_basic;

import javax.persistence.*;

// 아 jpa 사용하는구나 인식 시켜주기 ㅋ.ㅋ
// Entity 는 기본적으로 클래스명을 따라간다.
@Entity
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME") // db 에는 name 으로 써야한다면 이런식으로 바꿔서 사용하면 된다.
    private String username;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
