# Buffy

## Introduction

_Buffy_ is a convenient motion picture title finder 
for audiences looking for viewing suggestions that 
match specific preferences, or for those who need help 
to remember the title of a film.  Users are able to
enter as much or as little information as they want for their search, including, but not limited to, genre, keywords, and actor preferences,
and _Buffy_ will return a list of results that fit those parameters.  With _Buffy_, users have their very own personal film buff at their disposal
around the clock.

Most film apps have only limited search options, or reference databases that aren't accurately or continuously updated,
forcing consumers to search the web for information on movies that might be of interest to them.  Even IMDB's (Internet Movie Database)
app lacks the advanced search feature for cross-referencing multiple search parameters that is available on their website.
With Buffy, consumers have that unrestricted search ability in the palm of their hands, and on-the-go, without needing to 
use cumbersome websites.

When _Buffy_ is started, users are greeted with a prompt to enter text
for their search.  The more text entered, the narrower
and more specific will be Buffy's returned list of titles, which will
be displayed on a subsequent screen that allows for watchlisting titles, 
and archiving previous searches in the history, for later
perusing.  Each title will be accompanied by a link to 
a TMD (The Movie Database) page for logline browsing and trailer viewing, as well as 
links for online streaming.  With _Buffy_'s help, 
searching for a movie to watch is easier than ever.


## Intended Users

* Consumers who want to watch a movie with certain specific elements, and would like some title suggestions.

    > As a parent of five, who works 40 hours per week, I need an app that can quickly filter through a set of specific preferences, to return a small, targeted list of movie titles from which to choose, and save my searches for when I have time to watch something.
	
* Consumers who want immediate assistance finding a specific film title.
	
	> As a movie buff, I need an app that can quickly return the name of a specific film title I'm looking for, and save it so I won't forget.

## Current State

In Buffy's current state, users are able to perform simple title queries for movies.  Keyword searches are 
limited to whether or not the keyword happens to appear in a movie's title.  At this time users
cannot enter any other search criteria, nor can they add a title to their watchlist, or save previous
searches in a search history field.

The following are aesthetic/cosmetic updates that would improve the app:

* Displaying the userid of the user in the app's Navigation Drawer

The following are functional stretch goals to be added in the near future:

* Full implementation for extended search criteria, including, actor name, genre, release date, running time, 
studio, director name, and distributor.

* User ability to save titles to a watchlist, and refer to it whenever the app is closed and reopened.

* User ability to recall previous search results.

* Notification to user of a title already included in their watchlist, if it should happen to be included in
a new search result.

* User ability to sort returned search lists by popularity, user rating, and chronology.

## Design documentation

* [Wireframe diagram](wireframe.md)

* [Entity-Relationship Diagram](erd.md)


## Cloud/Device-based services or data

* [The Movie Database API](https://developers.themoviedb.org/3/getting-started/introduction)

* The above data source will be used to retrieve a list of movie titles based on user-inputted-text.

* Users will have the ability to save queried titles into a Watchlist.

* The device will store previous search parameters and results.

* The app will have limited functionality without full-time access to the data source, restricted to browsing previous searches and watchlisted titles.

## [Entity Classes](https://github.com/jshaner/buffy/tree/master/app/src/main/java/edu/cnm/deepdive/buffy/model/entity)

## [DAO Interfaces](https://github.com/jshaner/buffy/tree/master/app/src/main/java/edu/cnm/deepdive/buffy/model/dao)

## [Database/Repository Classes](https://github.com/jshaner/buffy/tree/master/app/src/main/java/edu/cnm/deepdive/buffy/service)

## [DDL](https://github.com/jshaner/buffy/blob/master/docs/ddl.md)



