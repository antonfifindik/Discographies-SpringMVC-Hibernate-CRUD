package com.antonfifindik.discographies.models;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Антон on 26.03.2018.
 */
@Entity
public class Authors extends BaseEntity {

    private static final long serialVersionUID = 4467355893352825731L;

    private String name;
    private String description;
    private byte[] photo;
    private Set<Albums> albums = new HashSet<Albums>();
    private AuthorTypes authorType;
    private Set<Musicians> musicians = new HashSet<Musicians>();

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

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "photo", nullable = true)
    @Lob
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.ALL)
    public Set<Albums> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Albums> albums) {
        this.albums = albums;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_type_id", referencedColumnName = "id", nullable = false)
    public AuthorTypes getAuthorType() {
        return authorType;
    }

    public void setAuthorType(AuthorTypes authorType) {
        this.authorType = authorType;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "authors_musicians", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "musician_id"))
    public Set<Musicians> getMusicians() {
        return musicians;
    }

    public void setMusicians(Set<Musicians> musicians) {
        this.musicians = musicians;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authors authors = (Authors) o;

        if (getId() != authors.getId()) return false;
        if (name != null ? !name.equals(authors.name) : authors.name != null) return false;
        if (description != null ? !description.equals(authors.description) : authors.description != null) return false;
        return Arrays.equals(photo, authors.photo);
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                //           ", description='" + description + '\'' +
//                ", photo=" + Arrays.toString(photo) +
        //       ", albums=" + albums.size() +
                ", authorType=" + authorType.getName() +
                '}';
    }
}
