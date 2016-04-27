# Pre-work - FirstToDoApp

FirstToDoApp  is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Ashok Ramaraj

Time spent: 5 hours spent in total

## User Stories

The following **required** functionality is completed:

* [ ] User can **successfully add and remove items** from the todo list
* [ ] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [ ] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are in implemetation in Progress:

* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [ ] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)



Here's a walkthrough of implemented user stories:

<img src='http://g.recordit.co/xY4XcZxNyT.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with RecordIt

## Notes

Challenges encountered while building the app.
- I had challenges in emulator starting up. I had chosen android NExus 5 phone with 6.0 and API 23. I then used the Nexus 4 with android 16 and Android4.1. My system had very less memory that was the reason for this. I also conected my Nexus 5 directly and tested the app there. Only issue was live debug was not possible .
- I had toruble in the call back methods when switching to the new acttivity and coming back to the Main activity. I had not used the REQUEST_CODE poeroperly  while starting the Edit activity.


## License

    Copyright [2016] [ashok ramaraj]











