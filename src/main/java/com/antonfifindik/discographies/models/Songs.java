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
    private Albums album;

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

    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "id", nullable = false)
    public Albums getAlbum() {
        return album;
    }

    public void setAlbum(Albums albumsByAlbumId) {
        this.album = albumsByAlbumId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Songs songs = (Songs) o;

        if (id != songs.id) return false;
        if (trackNum != songs.trackNum) return false;
        return name != null ? name.equals(songs.name) : songs.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + trackNum;
        return result;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trackNum=" + trackNum +
                ", album=" + album.getName() +
                '}';
    }
}
