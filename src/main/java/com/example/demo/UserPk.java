package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserPk implements Serializable {
    @Column(name="id1")
    private String id1;

    @Column(name="id2")
    private String id2;

    public UserPk() {}

    public UserPk(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPk userKey = (UserPk) o;
        return Objects.equals(id1, userKey.id1) && Objects.equals(id2, userKey.id2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id1, id2);
    }
}
