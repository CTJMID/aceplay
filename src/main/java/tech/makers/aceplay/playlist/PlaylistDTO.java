package tech.makers.aceplay.playlist;
import tech.makers.aceplay.track.Track;
import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.Set;

public class PlaylistDto {
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Track> tracks;

    public PlaylistDto() {}

    public PlaylistDto(String name) {
    this(name, null);
  }

    public PlaylistDto(String name, Set<Track> tracks) {
    this.name = name;
    this.tracks = tracks;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  @JsonGetter("tracks")
  public Set<Track> getTracks() {
    if (null == tracks) {
      return Set.of();
    }
    return tracks;
  }

}