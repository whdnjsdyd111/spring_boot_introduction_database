package chapter06;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "mydata9")
public class MyData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @NotNull
    private long id;

    @Column(length = 50, nullable = false)
    @NotEmpty(message = "공백 불가")   // o
    private String name;

    @Column(length = 200, nullable = true)
    @Email(message = "메일 주소만")  // o
    private String mail;

    @Column(nullable = true)
    @Min(value = 0, message = "0 이상") // o
    @Max(value = 200, message = "200 이하")   // o
    private Integer age;

    @Column(nullable = true)
    @Phone(onlyNumber = true)
    private String memo;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public Integer getAge() {
        return age;
    }

    public String getMemo() {
        return memo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
