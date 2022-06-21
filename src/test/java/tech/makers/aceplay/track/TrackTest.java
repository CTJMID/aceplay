package tech.makers.aceplay.track;

import org.junit.jupiter.api.Test;
import tech.makers.aceplay.track.Track;

import java.net.MalformedURLException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import static org.junit.jupiter.api.Assertions.*;



// https://www.youtube.com/watch?v=L4vkcgRnw2g&t=798s
class TrackTest {

  @Test
  void testConstructs() throws MalformedURLException {
    Track subject = new Track("Hello, world!", "Sarah", "https://example.org/track.mp3");
    assertEquals("Hello, world!", subject.getTitle());
    assertEquals("Sarah", subject.getArtist());
    assertEquals("https://example.org/track.mp3", subject.getPublicUrl().toString());
    assertEquals(null, subject.getId());
  }

  @Test
  void testToString() throws MalformedURLException {
    Track subject = new Track("Hello, world!", "Sarah", "https://example.org/track.mp3");
    assertEquals(
        "Track[id=null title='Hello, world!' artist='Sarah' publicUrl='https://example.org/track.mp3']",
        subject.toString());
  }

  @Test
  void testSetPublicUrl() throws MalformedURLException {
    Track subject = new Track();
    subject.setPublicUrl("https://example.org/track.mp3");
    assertEquals("https://example.org/track.mp3", subject.getPublicUrl().toString());
  }

  @Test
    public void whenNotEmptyTitleorArtist_thenNoConstraintViolations() throws MalformedURLException {
    Track track = new Track("Title1", "Artist1", "https://example.com");
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<Track>> violations = validator.validate(track);
 
    assertEquals(0, violations.size());
}
@Test
    public void whenEmptyTitle_thenOneConstraintViolations() throws MalformedURLException {
    Track track = new Track("", "Artist", "https://example.com");
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<Track>> violations = validator.validate(track);
 
    assertEquals(1, violations.size());
}

@Test
    public void whenEmptyArtist_thenOneConstraintViolations() throws MalformedURLException {
    Track track = new Track("Title", "", "https://example.com");
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<Track>> violations = validator.validate(track);
 
    assertEquals(1, violations.size());
}

@Test
    public void whenEmptyTitleandArtist_thenTwoConstraintViolations() throws MalformedURLException {
    Track track = new Track("", "", "https://example.com");
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<Track>> violations = validator.validate(track);
 
    assertEquals(2, violations.size());
}
}
