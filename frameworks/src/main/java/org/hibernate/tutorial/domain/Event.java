package org.hibernate.tutorial.domain;

/**
 * Created by tk3sy on 15.09.2015.
 */
import java.util.Date;

public class Event {

  private Long id;

  private String title;
  private Date date;

  public Event() {
  }

  public Long getId() {
    return id;
  }

  private void setId(Long id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}