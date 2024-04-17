DROP TABLE IF EXISTS director;
CREATE TABLE director (
	directorID INT AUTO_INCREMENT PRIMARY KEY,
	directorName VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS studio;
CREATE TABLE studio (
	studioID INT AUTO_INCREMENT PRIMARY KEY,
	studioName VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS mpaa-rating;
CREATE TABLE mpaa-rating (
	ratingID INT AUTO_INCREMENT PRIMARY KEY,
	rating VARCHAR(2) NOT NULL
);

DROP TABLE IF EXISTS dvd;
CREATE TABLE dvd (
    dvdID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    releaseDate DATE NOT NULL,
    directorID INT,
    studioID INT,
    ratingID INT,
    userRatingNote TEXT,
    FOREIGN KEY (directorID) REFERENCES director(directorID),
    FOREIGN KEY (studioID) REFERENCES studio(studioID),
    FOREIGN KEY (ratingID) REFERENCES mpaa-rating(ratingID)
);