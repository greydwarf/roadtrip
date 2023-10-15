package bscode.edu.roadtrip.api;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @ManyToMany
    @JoinTable(
        name="users_playlists",
        joinColumns = {@JoinColumn(name="user_id")},
        inverseJoinColumns= {@JoinColumn(name="playlist_id")})
    private List<Playlist> allPlaylists;

    protected User() {}

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
