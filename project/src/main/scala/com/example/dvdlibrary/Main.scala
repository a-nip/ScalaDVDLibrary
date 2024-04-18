package com.example.dvdlibrary

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class DVDLibraryApplication

object DVDLibraryApplication {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[DVDLibraryApplication], args: _*)
  }
}
