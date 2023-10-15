package bscode.edu.roadtrip.api;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PlaylistRepository extends CrudRepository<Playlist, Integer> {
}
