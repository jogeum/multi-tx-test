package net.jogeum.multitxtest.db1.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "test_code")
public class TestCode1 {

    @Id
    private String code;
    private String name;

    @Column(name = "create_date")
    private Date createDate;

    public TestCode1(String code, String name) {
        this.code = code;
        this.name = name;
        this.createDate = new Date();
    }
}
