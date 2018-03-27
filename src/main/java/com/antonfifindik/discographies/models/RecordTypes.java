package com.antonfifindik.discographies.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Антон on 26.03.2018.
 */
@Entity
@Table(name = "record_types", schema = "db_discographies")
public class RecordTypes {
    private long id;
    private String name;
    private String description;
    private Set<Albums> albums = new HashSet<Albums>();

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

    @Basic
    @Column(name = "description", nullable = false, length = 5000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recordType", cascade = CascadeType.ALL)
    public Set<Albums> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Albums> albums) {
        this.albums = albums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecordTypes that = (RecordTypes) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }



    @Override
    public String toString() {
        return "RecordTypes{" +
                "id=" + id +
                ", name='" + name + '\'' +
      //          ", description='" + description + '\'' +
                ", albums=" + albums.size() +
                '}';
    }
}
