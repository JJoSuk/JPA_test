package jpa_basic;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

// 아 jpa 사용하는구나 인식 시켜주기 ㅋ.ㅋ
// Entity 는 기본적으로 클래스명을 따라간다.
@Entity
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    // 기본값으로 AUTO, IDENTITY 는 순서배열, SEQUENCE 는
    private Long id;
    @Column(name = "name", nullable = false) // db 에는 name 으로 써야한다면 이런식으로 바꿔서 사용하면 된다.
    private String username;
//    private Integer age;
//    @Enumerated(EnumType.STRING) // enum 타입으로 테이블에 쓰고 싶을 때 사용
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP) // 날짜, 시간 생성
//    private Date createdDate;
//    @Temporal(TemporalType.TIMESTAMP) // 날짜, 시간 수정
//    private Date lastModifiedDate;
//    요즘은 시간 설정할 때 저 방식이 아닌 localdate 를 사용
//    private LocalDate testLocalDate;
//    private LocalDateTime testLocalDateTime;
//
//    @Lob // 문자타입이면 기본적으로 clob 으로 생성된다.
//    private String description;

    public Member() {
    }

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
}
