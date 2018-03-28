package com.antonfifindik.discographies.models;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Антон on 26.03.2018.
 */
@Entity
public class Producers {
    private long id;
    private String firstName;
    private String lastName;
    private String description;
    private byte[] photo;
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
    @Column(name = "first_name", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @ManyToMany
    @JoinTable(name = "albums_producers", joinColumns = @JoinColumn(name = "producer_id"), inverseJoinColumns = @JoinColumn(name = "album_id"))
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

        Producers producers = (Producers) o;

        if (id != producers.id) return false;
        if (firstName != null ? !firstName.equals(producers.firstName) : producers.firstName != null) return false;
        if (lastName != null ? !lastName.equals(producers.lastName) : producers.lastName != null) return false;
        if (description != null ? !description.equals(producers.description) : producers.description != null)
            return false;
        return Arrays.equals(photo, producers.photo);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    @Override
    public String toString() {
        return "Producers{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                //           ", photo=" + Arrays.toString(photo) +
                '}';
    }
}
