package com.antonfifindik.discographies.models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Антон on 29.03.2018.
 */
@MappedSuperclass
public abstract class BaseEntity {
    private long id;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
