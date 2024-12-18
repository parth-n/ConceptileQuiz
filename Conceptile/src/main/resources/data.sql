-- Insert into the question table
INSERT INTO question (id, question_text, correct_answer) VALUES
(1, 'What is the capital of France?', 'Paris'),
(2, 'Which planet is known as the Red Planet?', 'Mars'),
(3, 'Who wrote "Hamlet"?', 'William Shakespeare'),
(4, 'What is the chemical symbol for water?', 'H2O'),
(5, 'What is the largest mammal?', 'Blue Whale'),
(6, 'Which country hosted the 2020 Summer Olympics?', 'Japan'),
(7, 'What is the square root of 64?', '8'),
(8, 'What is the speed of light in vacuum (m/s)?', '299792'),
(9, 'Who painted the Mona Lisa?', 'Leonardo da Vinci'),
(10, 'Which programming language is used for Android development?', 'Java');

-- Insert into the question_choices table for each question
INSERT INTO question_choices (question_id, choice) VALUES
(1, 'Paris'),
(1, 'London'),
(1, 'Berlin'),
(1, 'Madrid'),
(2, 'Earth'),
(2, 'Venus'),
(2, 'Mars'),
(2, 'Jupiter'),
(3, 'Charles Dickens'),
(3, 'William Shakespeare'),
(3, 'Leo Tolstoy'),
(3, 'Mark Twain'),
(4, 'H2'),
(4, 'O2'),
(4, 'H2O'),
(4, 'CO2'),
(5, 'Elephant'),
(5, 'Blue Whale'),
(5, 'Giraffe'),
(5, 'Great White Shark'),
(6, 'Japan'),
(6, 'China'),
(6, 'USA'),
(6, 'Brazil'),
(7, '6'),
(7, '7'),
(7, '8'),
(7, '9'),
(8, '300000'),
(8, '150000'),
(8, '299792'),
(8, '100000'),
(9, 'Vincent van Gogh'),
(9, 'Leonardo da Vinci'),
(9, 'Pablo Picasso'),
(9, 'Claude Monet'),
(10, 'Python'),
(10, 'Swift'),
(10, 'Java'),
(10, 'Ruby');
