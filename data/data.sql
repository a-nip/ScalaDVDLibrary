USE dvd;
INSERT INTO mpaa_rating (rating) VALUES ('PG-13'), ('PG'), ('R');


INSERT INTO director (director_name) VALUES
    ('Christopher Nolan'),
    ('Steven Spielberg'),
    ('Quentin Tarantino');


INSERT INTO studio (studio_name) VALUES
    ('Warner Bros. Pictures'),
    ('Paramount Pictures'),
    ('Miramax Films');


INSERT INTO dvd (title, release_date, director_id, studio_id, rating_id, user_rating_note) VALUES
    ('Inception', '2010-07-16', 1, 1, 1, 'Mind-bending sci-fi thriller'),
    ('Jurassic Park', '1993-06-11', 2, 2, 2, 'Classic adventure with dinosaurs'),
    ('Pulp Fiction', '1994-10-14', 3, 3, 3, 'Quirky crime masterpiece');