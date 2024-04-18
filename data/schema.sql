DROP DATABASE IF EXISTS dvd;
CREATE DATABASE dvd;
USE dvd;

DROP TABLE IF EXISTS director;
CREATE TABLE director (
	director_id INT AUTO_INCREMENT PRIMARY KEY,
	director_name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS studio;
CREATE TABLE studio (
	studio_id INT AUTO_INCREMENT PRIMARY KEY,
	studio_name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS mpaa_rating;
CREATE TABLE mpaa_rating (
	rating_id INT AUTO_INCREMENT PRIMARY KEY,
	rating VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS dvd;
CREATE TABLE dvd (
    dvd_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    release_date DATE NOT NULL,
    director_id INT,
    studio_id INT,
    rating_id INT,
    user_rating_note TEXT,
    FOREIGN KEY (director_id) REFERENCES director(director_id),
    FOREIGN KEY (studio_id) REFERENCES studio(studio_id),
    FOREIGN KEY (rating_id) REFERENCES mpaa_rating(rating_id)
);