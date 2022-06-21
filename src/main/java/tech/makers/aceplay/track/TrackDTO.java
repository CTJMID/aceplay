package tech.makers.aceplay.track;

import javax.persistence.*;

import tech.makers.aceplay.user.User;

import java.net.MalformedURLException;
import java.net.URL;

public class TrackDto {

  private Long id;

  private String title;

  private String artist;

  private URL publicUrl;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private User user;


  public TrackDto(User user) {
    this.user = user;
  }

  public TrackDto() { }

  public TrackDto(User user, String title, String artist, URL publicUrl) {
    this.user = user;
    this.title = title;
    this.artist = artist;
    this.publicUrl = publicUrl;
  }

  public TrackDto(User user, String title, String artist, String publicUrl) throws MalformedURLException {
    this(user, title, artist, new URL(publicUrl));
  }

  public String toString() {
    return String.format(
        "Track[id=%d title='%s' artist='%s' publicUrl='%s']", id, title, artist, publicUrl);
  }

  public Long getId() {
    return id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
  
  public String getTitle() {
    return title;
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
