package com.antonfifindik.discographies.models;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Антон on 26.03.2018.
 */
@Entity
public class Authors {
    private long id;
    private String name;
    private String description;
    private byte[] photo;
    private Collection<Albums> albumsById;
    private AuthorTypes authorTypesByAuthorTypeId;

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
    @Column(name = "description", nullable = true, length = 5000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "photo", nullable = true)
    @Lob
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authors authors = (Authors) o;

        if (id != authors.id) return false;
        if (name != null ? !name.equals(authors.name) : authors.name != null) return false;
        if (description != null ? !description.equals(authors.description) : authors.description != null) return false;
        if (!Arrays.equals(photo, authors.photo)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    @OneToMany(mappedBy = "authorsByAuthorId")
    public Collection<Albums> getAlbumsById() {
        return albumsById;
    }

    public void setAlbumsById(Collection<Albums> albumsById) {
        this.albumsById = albumsById;
    }

    @ManyToOne
    @JoinColumn(name = "author_type_id", referencedColumnName = "id", nullable = false)
    public AuthorTypes getAuthorTypesByAuthorTypeId() {
        return authorTypesByAuthorTypeId;
    }

    public void setAuthorTypesByAuthorTypeId(AuthorTypes authorTypesByAuthorTypeId) {
        this.authorTypesByAuthorTypeId = authorTypesByAuthorTypeId;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", albumsById=" + albumsById +
                ", authorTypesByAuthorTypeId=" + authorTypesByAuthorTypeId +
                '}';
    }
}
