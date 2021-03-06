package com.antonfifindik.discographies.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Антон on 26.03.2018.
 */
@Entity
@Table(name = "record_types", schema = "db_discographies")
public class RecordTypes extends BaseEntity {

    private static final long serialVersionUID = 6178316015130314370L;

    private String name;
    private String description;
    private Set<Albums> albums = new HashSet<Albums>();

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

        if (getId() != that.getId()) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RecordTypes{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                //          ", description='" + description + '\'' +
                ", albums=" + albums.size() +
                '}';
    }
}
