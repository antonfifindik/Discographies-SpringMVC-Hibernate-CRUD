package com.antonfifindik.discographies.models;

import javax.persistence.*;

/**
 * Created by Антон on 26.03.2018.
 */
@Entity
public class Songs {
    private long id;
    private String name;
    private int trackNum;
    private Albums albumsByAlbumId;

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
    @Column(name = "track_num", nullable = false)
    public int getTrackNum() {
        return trackNum;
    }

    public void setTrackNum(int trackNum) {
        this.trackNum = trackNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Songs songs = (Songs) o;

        if (id != songs.id) return false;
        if (trackNum != songs.trackNum) return false;
        if (name != null ? !name.equals(songs.name) : songs.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + trackNum;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "id", nullable = false)
    public Albums getAlbumsByAlbumId() {
        return albumsByAlbumId;
    }

    public void setAlbumsByAlbumId(Albums albumsByAlbumId) {
        this.albumsByAlbumId = albumsByAlbumId;
    }
}
