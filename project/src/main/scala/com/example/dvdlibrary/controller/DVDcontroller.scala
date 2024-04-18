package com.example.dvdlibrary.controller
import com.example.dvdlibrary.dao.DVDRepo
import com.example.dvdlibrary.model.DVD
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation._


@RestController
@RequestMapping(Array("/dvd"))
@CrossOrigin
class DVDController {

  @Autowired
  private var dvdRepo: DVDRepo = _
  @GetMapping(Array("/dvds"))
  def allDVDs(): ResponseEntity[java.util.List[DVD]] = {
    val dvds = dvdRepo.findAll()
    ResponseEntity.status(HttpStatus.OK).body(dvds)
  }
  @GetMapping(Array("/{id}"))
  def getDVDById(@PathVariable("id") id: Long): ResponseEntity[DVD] = {
    val dvd = dvdRepo.findById(id).orElse(null)
    new ResponseEntity[DVD](dvd, HttpStatus.OK)
  }
  @PostMapping(Array("/add"))
  def addNewDVD(@RequestBody dvd: DVD): ResponseEntity[Unit] = {
    dvdRepo.save(dvd)
    new ResponseEntity[Unit](HttpStatus.CREATED)
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
