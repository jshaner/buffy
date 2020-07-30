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
a TMDB (The Movie Database) page for logline browsing and trailer viewing, as well as 
links for online streaming.  With _Buffy_'s help, 
searching for a movie to watch is easier than ever.


## Intended Users

* Consumers who want to watch a movie with certain specific elements, and would like some title suggestions.

    > As a parent of five, who works 40 hours per week, I need an app that can quickly filter through a set of specific preferences, to return a small, targeted list of movie titles from which to choose, and save my searches for when I have time to watch something.
	
* Consumers who want immediate assistance finding a specific film title.
	
	> As a movie buff, I need an app that can quickly return the name of a specific film title I'm looking for, and save it so I won't forget.

## Current State

In _Buffy_'s current state, users are able to perform simple title queries for movies.  Keyword searches are 
limited to whether or not the keyword happens to appear in a movie's title.  Users are able to add or delete any title
in their watchlist, and they may retrieve the watchlist at any time.  Right now users
cannot enter any additional search criteria, nor can previous searches be perused on a unique screen, however, if 
a duplicate search is performed, _Buffy_ will alert the user to that fact by populating the similar text under the search field.

The following are aesthetic/cosmetic updates that would improve the app:

* Displaying the userid of the user in the app's Navigation Drawer

* Adding a list of search histories to a separate screen accessible from the navigation drawer

The following are functional stretch goals to be added in the near future:

* Full implementation for extended search criteria, including, actor name, genre, release date, running time, 
studio, director name, and distributor

* User ability to recall previous search results in their entirety

* User ability to sort returned search results by popularity, user rating, and chronology

## Design documentation

* [Wireframe diagram](wireframe.md)

* [Entity-Relationship Diagram](erd.md)

## [DDL](https://github.com/jshaner/buffy/blob/master/docs/ddl.md)

## Technical requirements/dependencies

* _Buffy_ was tested on the Pixel 3a API 28 emulator, and works in both portrait and landscape modes.

* _Buffy_ uses several 3rd party libraries, including Google Sign In, Gson, Retrofit, ReactiveX, Room, and Stetho.

* _Buffy_ uses the following permissions: android:permission.INTERNET

## How do I use it?

See [Instructions](instructions.md).

## Build instructions

* Navigate to the [Git Hub](https://github.com/jshaner/buffy) repository.
    * Using the Clone or download button, copy the SSH URL of the repository into the clipboard.
* With IntelliJ (or from a command shell), clone the repository (into a subdirectory of your bootcamp/projects directory).
    * From IntelliJ, open the repository contents as an IntelliJ project.
    * Under the Build menu at the top of the screen, select Build Project (CTRL+F9 on Windows)
* Procure API key from [The Movie Database API](https://developers.themoviedb.org/3/getting-started/introduction)
    * Add base_url, api_key, and website_url to a .properties file, and save in a services subdirectory of your bootcamp directory.
    
######  [Java Docs](api/) 


