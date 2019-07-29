/*
    Database initialization script that runs on every web-application redeployment.
*/
DROP TABLE IF EXISTS poem;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
	CONSTRAINT email_not_empty CHECK (email <> ''),
	CONSTRAINT password_not_empty CHECK (password <> '')
);

CREATE TABLE poem (
    poem_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    title VARCHAR(50) NOT NULL,
    content TEXT NOT NULL,
    date TEXT NOT NULL,
	FOREIGN KEY(user_id) REFERENCES users(user_id)
);

INSERT INTO users (name, email, password) VALUES
	('Theodore Roethke','user1@user1', 'user1'), -- 1
	('Dorianne Laux', 'user2@user2', 'user2'), -- 2
	('Susan Mitchell', 'user3@user3', 'user3'); -- 3

INSERT INTO poem (user_id, title, content, date) VALUES
	(1, 'The Bat','By day the bat is cousin to the mouse.<br>
        He likes the attic of an aging house.<br><br>

        His fingers make a hat about his head.<br>
        His pulse beat is so slow we think him dead.<br><br>

        He loops in crazy figures half the night<br>
        Among the trees that face the corner light.<br><br>

        But when he brushes up against a screen,<br>
        We are afraid of what our eyes have seen:<br><br>

        For something is amiss or out of place<br>
        When mice with wings can wear a human face.','1948-06-24'),           -- 1
	(2, 'Break','We put the puzzle together piece<br>
        by piece, loving how one curved<br>
        notch fits so sweetly with another.<br>
        A yellow smudge becomes\n
        the brush of a broom, and two blue arms<br>
        fill in the last of the sky.<br>
        We patch together porch swings and autumn<br>
        trees, matching gold to gold. We hold<br>
        the eyes of deer in our palms, a pair<br>
        of brown shoes. We do this as the child<br>
        circles her room, impatient<br>
        with her blossoming, tired<br>
        of the neat house, the made bed,<br>
        the good food. We let her brood<br>
        as we shuffle through the pieces,<br>
        setting each one into place with a satisfied<br>
        tap, our backs turned for a few hours<br>
        to a world that is crumbling, a sky<br>
        that is falling, the pieces<br>
        we are required to return to.','1755-01-08'),           -- 2
	(3, 'The Dead','At night the dead come down to the river to drink.
        They unburden themselves of their fears,
        their worries for us. They take out the old photographs.
        They pat the lines in our hands and tell our futures,
        which are cracked and yellow.
        Some dead find their way to our houses.
        They go up to the attics.
        They read the letters they sent us, insatiable
        for signs of their love.
        They tell each other stories.
        They make so much noise
        they wake us
        as they did when we were children and they stayed up
        drinking all night in the kitchen.','2004-10-07');           -- 3

