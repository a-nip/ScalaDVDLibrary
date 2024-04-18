package com.example.dvdlibrary.model
import java.time.LocalDate
import javax.persistence._

@Entity
@Table(name = "dvd")
class DVD {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "dvdID", nullable = false)
  var id: Long = _

  @Column(name = "title", nullable = false)
  var title: String = _

  @Column(name = "releaseDate", nullable = false)
  var releaseDate: LocalDate = _


  @ManyToOne
  @JoinColumn(name = "directorID")
  var director: Director = _

  @ManyToOne
  @JoinColumn(name = "studioID")
  var studio: Studio = _

  @ManyToOne
  @JoinColumn(name = "ratingID")
  var rating: Rating = _

  @Column(name = "userRatingNote")
  var userRatingNote: String = _

  // Getters
  def getId: Long = id
  def getTitle: String = title
  def getReleaseDate: LocalDate = releaseDate
  def getDirector: Director = director
  def getStudio: Studio = studio
  def getRating: Rating = rating
  def getUserRatingNote: String = userRatingNote

  // Setters
  def setId(id: Long): Unit = this.id = id
  def setTitle(title: String): Unit = this.title = title
  def setReleaseDate(releaseDate: LocalDate): Unit = this.releaseDate = releaseDate
  def setDirector(director: Director): Unit = this.director = director
  def setStudio(studio: Studio): Unit = this.studio = studio
  def setRating(rating: Rating): Unit = this.rating = rating
  def setUserRatingNote(userRatingNote: String): Unit = this.userRatingNote = userRatingNote
}






