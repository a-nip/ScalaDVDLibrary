package com.example.dvdlibrary.controller
import com.example.dvdlibrary.dao.DVDRepo
import com.example.dvdlibrary.model.DVD
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation._
import java.util.{List => JavaList}
import scala.jdk.CollectionConverters._


@RestController
@RequestMapping(Array("/dvd"))
@CrossOrigin
class DVDController @Autowired()(private val dvdRepo: DVDRepo) {

  @GetMapping(Array("/dvds"))
  def allDVDs(): ResponseEntity[JavaList[DVD]] = {
    try {
      val dvds = dvdRepo.findAllDVDs().asJava
      ResponseEntity.status(HttpStatus.OK).body(dvds)
    } catch {
      case ex: Exception =>
        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
    }
  }
  @GetMapping(Array("/{id}"))
  def getDVDById(@PathVariable("id") id: Long): ResponseEntity[DVD] = {
    try {
      val dvd = dvdRepo.findDVDById(id)
      if (dvd != null) {
        new ResponseEntity[DVD](dvd, HttpStatus.OK)
      } else {
        new ResponseEntity[DVD](HttpStatus.NOT_FOUND)
      }
    } catch {
      case ex: Exception =>
        new ResponseEntity[DVD](HttpStatus.INTERNAL_SERVER_ERROR)
    }
  }

  @PostMapping(Array("/add"))
  def addNewDVD(@RequestBody dvd: DVD): ResponseEntity[Void] = {
    try {
      //  JPA handles the foreign key associations
      val savedDVD = dvdRepo.save(dvd)
      new ResponseEntity[Void](HttpStatus.CREATED)
    } catch {
      case ex: Exception =>
        new ResponseEntity[Void](HttpStatus.INTERNAL_SERVER_ERROR)
    }
  }



  @DeleteMapping(Array("/{id}"))
  def deleteDVD(@PathVariable("id") id: Long): ResponseEntity[Unit] = {
    dvdRepo.deleteById(id)
    new ResponseEntity[Unit](HttpStatus.NO_CONTENT)
  }

  @PutMapping(Array("/{id}"))
  def updateDVD(@PathVariable("id") id: Long, @RequestBody dvd: DVD): ResponseEntity[DVD] = {
    dvd.setId(id) // Set the ID of the DVD object
    dvdRepo.save(dvd)
    new ResponseEntity[DVD](dvd, HttpStatus.OK)
  }
}
