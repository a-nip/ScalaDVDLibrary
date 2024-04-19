package src.main.com.example.dvdlibrary.model

import java.sql.Date

class DVD private () {
  private var _dvdID: Int = _
  private var _title: String = _
  private var _releaseDate: Date = _
  private var _directorID: Int = _
  private var _studioID: Int = _
  private var _ratingID: Int = _
  private var _userRatingNote: Option[String] = _

  def getDvdID(): Int = _dvdID
  def getTitle(): String = _title
  def getReleaseDate(): Date = _releaseDate
  def getDirectorID(): Int = _directorID
  def getStudioID(): Int = _studioID
  def getRatingID(): Int = _ratingID
  def getUserRatingNote(): Option[String] = _userRatingNote

  def setDvdID(dvdID: Int): Unit = _dvdID = dvdID
  def setTitle(title: String): Unit = _title = title
  def setReleaseDate(releaseDate: Date): Unit = _releaseDate = releaseDate
  def setDirectorID(directorID: Int): Unit = _directorID = directorID
  def setStudioID(studioID: Int): Unit = _studioID = studioID
  def setRatingID(ratingID: Int): Unit = _ratingID = ratingID
  def setUserRatingNote(userRatingNote: Option[String]): Unit = _userRatingNote = userRatingNote
}





