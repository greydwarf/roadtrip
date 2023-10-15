package bscode.edu.roadtrip.api;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @Column(nullable = false, updatable = false, columnDefinition = "VARCHAR")
    private String id;

    @Column
    private String name;

    @ManyToOne
    private Playlist selectedPlaylist;

    protected User() {}

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
