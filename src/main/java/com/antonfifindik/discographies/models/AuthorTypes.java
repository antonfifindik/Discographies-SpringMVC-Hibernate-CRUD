package com.antonfifindik.discographies.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Антон on 26.03.2018.
 */
@Entity
@Table(name = "author_types", schema = "db_discographies")
public class AuthorTypes extends BaseEntity {
    private String name;
    private Set<Authors> authors = new HashSet<Authors>();

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "authorType", cascade = CascadeType.ALL)
    public Set<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Authors> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorTypes that = (AuthorTypes) o;

        if (getId() != that.getId()) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AuthorTypes{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", authors=" + authors.size() +
                '}';
    }
}
