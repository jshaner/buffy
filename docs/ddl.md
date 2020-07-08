## Data Definition Language (DDL)

```sqlite
CREATE TABLE IF NOT EXISTS `Movie`
(
    `movie_id`    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `external_id` INTEGER                           NOT NULL,
    `date`        INTEGER COLLATE NOCASE,
    `title`       TEXT                              NOT NULL COLLATE NOCASE
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Movie_title` ON `Movie` (`title`);

CREATE TABLE IF NOT EXISTS `Search`
(
    `search_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `date`      INTEGER                           NOT NULL COLLATE NOCASE,
    `filter`    TEXT                              NOT NULL COLLATE NOCASE
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Search_search_id` ON `Search` (`search_id`);

CREATE TABLE IF NOT EXISTS `SearchResult`
(
    `search_result_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `search_id`        INTEGER                           NOT NULL,
    `movie_id`         INTEGER                           NOT NULL,
    `order`            INTEGER                           NOT NULL COLLATE NOCASE,
    FOREIGN KEY (`search_id`) REFERENCES `Search` (`search_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_SearchResult_search_result_id` ON `SearchResult` (`search_result_id`);

CREATE INDEX IF NOT EXISTS `index_SearchResult_search_id` ON `SearchResult` (`search_id`);

CREATE INDEX IF NOT EXISTS `index_SearchResult_movie_id` ON `SearchResult` (`movie_id`);
```

[`ddl.sql`](sql/ddl.sql)