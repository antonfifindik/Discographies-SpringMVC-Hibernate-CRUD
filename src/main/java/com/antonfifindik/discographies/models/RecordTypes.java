package com.antonfifindik.discographies.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Антон on 26.03.2018.
 */
@Entity
@Table(name = "record_types", schema = "db_discographies", catalog = "")
public class RecordTypes {
    private long id;
    private String name;
    private String description;
    private Collection<Albums> albumsById;

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

    @OneToMany(mappedBy = "recordTypesByRecordTypeId")
    public Collection<Albums> getAlbumsById() {
        return albumsById;
    }

    public void setAlbumsById(Collection<Albums> albumsById) {
        this.albumsById = albumsById;
    }
}
