package bscode.edu.roadtrip.api;

import jakarta.persistence.*;

@Entity
public class Song {
    @Id
    @SequenceGenerator(name="song_seq", sequenceName = "song_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "song_seq")
    @Column(updatable = false)
    private Integer id;

    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String name;
    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String artist;
    @Column(columnDefinition = "VARCHAR")
    private String album;
}
