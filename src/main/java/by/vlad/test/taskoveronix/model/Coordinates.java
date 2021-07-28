package by.vlad.test.taskoveronix.model;

import javax.persistence.*;

@Entity
@Table(name = "coordinates")
public class Coordinates {

    @EmbeddedId
    private LatAndLon latAndLon;

    public Coordinates() {
    }

    public LatAndLon getLatAndLon() {
        return latAndLon;
    }

    public void setLatAndLon(LatAndLon latAndLon) {
        this.latAndLon = latAndLon;
    }
}
