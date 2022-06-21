package tech.makers.aceplay.track;

import javax.persistence.*;

import tech.makers.aceplay.user.User;

import java.net.MalformedURLException;
import java.net.URL;

// https://www.youtube.com/watch?v=5r3QU09v7ig&t=2999s
@Entity
public class Track {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String title;

  private String artist;

  private URL publicUrl;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private User user;

  

  public Track(User user) {
    this.user = user;
  }

  public Track() { }

  public Track(User user, String title, String artist, URL publicUrl) {
    this.user = user;
    this.title = title;
    this.artist = artist;
    this.publicUrl = publicUrl;
  }

  public Track(User user, String title, String artist, String publicUrl) throws MalformedURLException {
    this(user, title, artist, new URL(publicUrl));
  }

  public String toString() {
    return String.format(
        "Track[id=%d title='%s' artist='%s' publicUrl='%s']", id, title, artist, publicUrl);
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }
  
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public URL getPublicUrl() {
    return publicUrl;
  }

  public void setPublicUrl(String publicUrl) throws MalformedURLException {
    this.publicUrl = new URL(publicUrl);
  }

  public void setPublicUrl(URL publicUrl) {
    this.publicUrl = publicUrl;
  }
}
