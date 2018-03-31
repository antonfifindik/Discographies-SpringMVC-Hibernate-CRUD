package com.antonfifindik.discographies.models;

import javax.persistence.*;

/**
 * Created by Антон on 26.03.2018.
 */
@Entity
public class Songs extends BaseEntity {
    private String name;
    private int trackNum;
    private Albums album;

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
    @JoinColumn(name = "album_id", referencedColumnName = "id")
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

        if (getId() != songs.getId()) return false;
        if (trackNum != songs.trackNum) return false;
        return name != null ? name.equals(songs.name) : songs.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + trackNum;
        return result;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", trackNum=" + trackNum +
                ", album=" + album.getName() +
                '}';
    }
}
