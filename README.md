# Java-Project-2---Find-The-Item
Project was last updated on: 25 May 2022

**This was a university project for a basic java object oriented programming unit/module.**

There were more classes to this project but they were not written by me. So only what I have uploaded are my edits of the given skeletons (author name in Java files), and although compiling these Java files will work, them alone will not run as a functioning game. The code itself passed all tests and overall received a project grade of over 85%.

## Project Overview

The goal of this project was to develop a game called Find my Things. "Things" are randomly placed on the board at random locations and orientations by the AIPlayer. All placed "things" are hidden to the player at the beginning of the game. It is the player's job to locate all the "things" before they run out of turns (number of clicks allowed). More on the game in the Game Specification section of this read me.

We had to edit four java classes: GameViewer, AIPlayer, Board, and Item. What were edited were the TO DO'S of the already provided skeletons.

**Clarification:** 

⭒■━━━━━━ˁᱸᲲᱸˀ━━━━━━■⭒ 

This was originally a partner project, but for the sake of me uploading this project on github I will upload all of my own work for the four java classes. The GameViewer and AIPlayer classes my project partner did had additional features such as an auto solver and difficulty levels, but what I have uploaded are just enough to get the game running without any errors. Perhaps in the future when I have time I'll come back to this and add those features along with many more to enhance the gameplay.

Again there were more classes to this project but they were not written by me, so only what I have edited are what are uploaded.

⭒■━━━━━━━━━━━━━━━■⭒

> GameViewer: Represents one interface for playing the game Find my Things.

> AIPlayer: Represents the computer, who will hide "things" on the board at the start of every game of Find My Things (i.e when the game is loaded or when the game is restarted).

> Board: Represents the current state of the game board in one game of Find my Things (i.e. for each piece on the board, does this space contain a lost item, a found item, a searched space, or an unsearched space).
> Item: Represents a "thing" that is hidden by the AIPlayer and must by found by the player during the game.


## Game Specifications

Upon starting the game there will be blue square grids with the number of turns, closest lost item (with x and y coordinates), a list of things to find with their shapes outlined as legends, and lastly a restart button. 

□・・・・・・■・・・・・・□・・・・・・■

**Since items are hidden, players will have to guess which of these blue squares have items behind them.**
> A blue square represents an unclicked square.

> A right click would result in the blue square clicked turning green, red otherwise. Correct clicks do not cost the player turns. One green square only means part the item has been found.

> Only will the item legend turn green (be found) once all of the squares hiding it are searched. For example, if an item were to be four squares long, clicking one square correctly would only indicate that you are on the right track; once all 4 squares are searched (are green), only then it will record the item as found.

> The player loses once all turns are used up. They can also click on the restart button to start a new game.

□・・・・・・■・・・・・・□・・・・・・■


> There are 5 "things" available to the AIPlayer when hiding items on the board. Their shapes are shown in the image below:
<img width="500" alt="image" src="https://user-images.githubusercontent.com/115472181/198891920-2fbf8f1e-9d9f-46c4-883f-7d50f000cf02.png">



