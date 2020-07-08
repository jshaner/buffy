CREATE TABLE IF NOT EXISTS `Movie`
(
    `movie_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`      TEXT                              NOT NULL COLLATE NOCASE
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Movie_name` ON `Movie` (`name`);

CREATE TABLE IF NOT EXISTS `Search`
(
    `search_id`  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `movie_id` INTEGER,
    `text`      TEXT                              NOT NULL COLLATE NOCASE,
    FOREIGN KEY (`search_id`) REFERENCES `Movie` (`movie_id`) ON UPDATE NO ACTION ON DELETE SET NULL
);

CREATE INDEX IF NOT EXISTS `index_Quote_source_id` ON `Search` (`search_id`);

CREATE TABLE IF NOT EXISTS `SearchResult`
(
    `search_result_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`      TEXT                              NOT NULL COLLATE NOCASE
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Search_Result_name` ON `Movie` (`name`);
