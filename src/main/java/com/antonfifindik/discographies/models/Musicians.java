package com.antonfifindik.discographies.models;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Антон on 26.03.2018.
 */
@Entity
public class Musicians extends BaseEntity {

    private static final long serialVersionUID = -5676655350464906893L;

    private String firstName;
    private String lastName;
    private String description;
    private byte[] photo;
    private Set<Authors> authors = new HashSet<Authors>();

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
    @JoinTable(name = "authors_musicians", joinColumns = @JoinColumn(name = "musician_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
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

        Musicians musicians = (Musicians) o;

        if (getId() != musicians.getId()) return false;
        if (firstName != null ? !firstName.equals(musicians.firstName) : musicians.firstName != null) return false;
        if (lastName != null ? !lastName.equals(musicians.lastName) : musicians.lastName != null) return false;
        if (description != null ? !description.equals(musicians.description) : musicians.description != null)
            return false;
        return Arrays.equals(photo, musicians.photo);
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    @Override
    public String toString() {
        return "Musicians{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                //            ", photo=" + Arrays.toString(photo) +
                '}';
    }
}
