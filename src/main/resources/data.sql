INSERT INTO GENRES (name) VALUES
    ('Novel'),
    ('Science Fiction'),
    ('Horror'),
    ('Tragedy');

INSERT INTO AUTHORS (name) VALUES
    ('Leo Tolstoy'),
    ('F. Scott Fitzgerald'),
    ('Herman Melville'),
    ('William Shakespeare');

INSERT INTO COMMENTS (text) VALUES
    ('Great!'),
    ('Awesome!'),
    ('Cool!');

INSERT INTO BOOKS (title, author_id, genre_id) VALUES
    ('War and Peace', 1, 1),
    ('The Great Gatsby', 2, 1),
    ('Moby Dick', 3, 1),
    ('Hamlet', 4, 3),
    ('Anna Karenina', 1, 3);