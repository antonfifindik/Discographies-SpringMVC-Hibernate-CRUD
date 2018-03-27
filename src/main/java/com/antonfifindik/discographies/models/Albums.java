package com.antonfifindik.discographies.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Антон on 26.03.2018.
 */
@Entity
public class Albums {
    private long id;
    private String name;
    private Date releaseDate;
    private String length;
    private byte[] cover;
    private String description;
    private Authors author;
    private AlbumTypes albumType;
    private RecordTypes recordType;
    private Set<Songs> songs = new HashSet<Songs>();
    private Set<Genres> genres = new HashSet<Genres>();
    private Set<Producers> producers = new HashSet<Producers>();
    private Set<Labels> labels = new HashSet<Labels>();

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
    @Column(name = "release_date", nullable = false)
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "length", nullable = false, length = 10)
    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Basic
    @Column(name = "cover", nullable = false)
    @Lob
    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 5000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "album_type_id", referencedColumnName = "id", nullable = false)
    public AlbumTypes getAlbumType() {
        return albumType;
    }

    public void setAlbumType(AlbumTypes albumType) {
        this.albumType = albumType;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "record_type_id", referencedColumnName = "id", nullable = false)
    public RecordTypes getRecordType() {
        return recordType;
    }

    public void setRecordType(RecordTypes recordType) {
        this.recordType = recordType;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "album", cascade = CascadeType.ALL)
    public Set<Songs> getSongs() {
        return songs;
    }

    public void setSongs(Set<Songs> songs) {
        this.songs = songs;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "albums_genres", joinColumns = @JoinColumn(name = "album_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    public Set<Genres> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genres> genres) {
        this.genres = genres;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "albums_producers", joinColumns = @JoinColumn(name = "album_id"), inverseJoinColumns = @JoinColumn(name = "producer_id"))
    public Set<Producers> getProducers() {
        return producers;
    }

    public void setProducers(Set<Producers> producers) {
        this.producers = producers;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "albums_labels", joinColumns = @JoinColumn(name = "album_id"), inverseJoinColumns = @JoinColumn(name = "label_id"))
    public Set<Labels> getLabels() {
        return labels;
    }

    public void setLabels(Set<Labels> labels) {
        this.labels = labels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Albums albums = (Albums) o;

        if (id != albums.id) return false;
        if (name != null ? !name.equals(albums.name) : albums.name != null) return false;
        if (releaseDate != null ? !releaseDate.equals(albums.releaseDate) : albums.releaseDate != null) return false;
        if (length != null ? !length.equals(albums.length) : albums.length != null) return false;
        if (!Arrays.equals(cover, albums.cover)) return false;
        return description != null ? description.equals(albums.description) : albums.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(cover);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Albums{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", length='" + length + '\'' +
//                ", cover=" + Arrays.toString(cover) +
                //         ", description='" + description + '\'' +
                ", author=" + author.getName() +
                ", albumType=" + albumType.getName() +
                ", recordType=" + recordType.getName() +
                ", songs=" + songs.size() +
                ", genres=" + songs.size() +
                '}';
    }
}

