package com.antonfifindik.discographies.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Антон on 26.03.2018.
 */
@Entity
@Table(name = "author_types", schema = "db_discographies", catalog = "")
public class AuthorTypes {
    private long id;
    private String name;
    private Collection<Authors> authorsById;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorTypes that = (AuthorTypes) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "authorTypesByAuthorTypeId")
//    public Collection<Authors> getAuthorsById() {
//        return authorsById;
//    }

    public void setAuthorsById(Collection<Authors> authorsById) {
        this.authorsById = authorsById;
    }

    @Override
    public String toString() {
        return "AuthorTypes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorsById=" + authorsById +
                '}';
    }
}
