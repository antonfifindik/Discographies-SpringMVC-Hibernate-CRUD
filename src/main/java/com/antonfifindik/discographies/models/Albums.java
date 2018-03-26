package com.antonfifindik.discographies.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

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
    private Authors authorsByAuthorId;
    private AlbumTypes albumTypesByAlbumTypeId;
    private RecordTypes recordTypesByRecordTypeId;
    private Collection<Songs> songsById;

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
        if (description != null ? !description.equals(albums.description) : albums.description != null) return false;

        return true;
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

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    public Authors getAuthorsByAuthorId() {
        return authorsByAuthorId;
    }

    public void setAuthorsByAuthorId(Authors authorsByAuthorId) {
        this.authorsByAuthorId = authorsByAuthorId;
    }

    @ManyToOne
    @JoinColumn(name = "album_type_id", referencedColumnName = "id", nullable = false)
    public AlbumTypes getAlbumTypesByAlbumTypeId() {
        return albumTypesByAlbumTypeId;
    }

    public void setAlbumTypesByAlbumTypeId(AlbumTypes albumTypesByAlbumTypeId) {
        this.albumTypesByAlbumTypeId = albumTypesByAlbumTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "record_type_id", referencedColumnName = "id", nullable = false)
    public RecordTypes getRecordTypesByRecordTypeId() {
        return recordTypesByRecordTypeId;
    }

    public void setRecordTypesByRecordTypeId(RecordTypes recordTypesByRecordTypeId) {
        this.recordTypesByRecordTypeId = recordTypesByRecordTypeId;
    }

    @OneToMany(mappedBy = "albumsByAlbumId")
    public Collection<Songs> getSongsById() {
        return songsById;
    }

    public void setSongsById(Collection<Songs> songsById) {
        this.songsById = songsById;
    }
}
