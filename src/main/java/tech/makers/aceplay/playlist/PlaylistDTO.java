package tech.makers.aceplay.playlist;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonGetter;

import tech.makers.aceplay.track.Track;
import tech.makers.aceplay.user.User;

public class PlaylistDto {
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


		@ManyToMany(fetch = FetchType.EAGER)
    private Set<Track> tracks;

    public PlaylistDto() {}

    public PlaylistDto(User user, String name) {
    this(user, name, null);
  }

    public PlaylistDto(User user, String name, Set<Track> tracks) {
    this.user = user;
    this.name = name;
    this.tracks = tracks;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
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