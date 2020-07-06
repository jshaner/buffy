# Buffy

## Introduction

_Buffy_ is a convenient motion picture title finder 
for audiences looking for viewing suggestions that 
match specific preferences, or for those who need help 
to remember the title of a film.  Users are able to
include as much or as little information as they want for their search,
and _Buffy_ will return a list of results that fit those parameters.  With _Buffy_, users have their very own personal film buff at their disposal
around the clock.

When _Buffy_ is started, users are greeted with a prompt to enter text
for their search.  The more text entered, the narrower
and more specific will be Buffy's returned list, which will
be displayed on a subsequent screen that allows for watchlisting titles, 
and archiving previous searches in the history, for later
perusing.  As a stretch goal, each title will be accompanied by a link to 
a TMD page for logline browsing and trailer viewing, as well as 
a link for online streaming.  With _Buffy_'s help, 
searching for a movie to watch is easier than ever.

## Intended Users

* Consumers who want to watch a movie with certain specific elements, and would like some title suggestions.

    > As a parent of five, who works 40 hours per week, I don't have the time to keep up with what new movies have been released, and I know I've missed many titles that would interest me.  I don't have the time to scroll endlessly through websites, and read descriptions of random movies hoping to find something to watch in the few free hours I have each week.  I need a way to filter through a set of specific preferences to return a small, targeted list of titles from which to choose.
	
* Consumers who want immediate assistance finding a specific film title.
	
	> As a movie buff it is very important to me to not forget the name of a film.  The other night I was out with friends and an old film came up in conversation, one that we all remembered obscure details about, but couldn't quite place the title.  If I had an app that could find the title based on a few details it would have come in handy that night.



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



