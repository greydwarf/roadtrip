package bscode.edu.roadtrip.api;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Playlist {
    @Id
    @SequenceGenerator(name="playlist_seq", sequenceName = "play_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playlist_seq")
    @Column(updatable = false)
    private Integer id;

    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String name;

    @ManyToMany
    private Set<User> editors;

    @ManyToMany
    @JoinTable(
            name = "playlist_editors",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    Set<User> playlistEditors;

    @ManyToMany
    private Set<Song> songs;
    @ManyToMany
    @JoinTable(
            name = "playlist_songs",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    Set<User> playlistSongs;
}
