package model;

public class Vinyl
{
  private String artist;
  private String title;
  private int year;
  private State state;

  private String reserveName;
  private String borrowName;

  public Vinyl(){

  }
  public void setReserveName(String reserveName) {
    this.reserveName = reserveName;
  }

  public void setBorrowName(String borrowName) {
    this.borrowName = borrowName;
  }

  public String getReserveName() {
    return reserveName;
  }

  public String getBorrowName() {
    return borrowName;
  }
}
