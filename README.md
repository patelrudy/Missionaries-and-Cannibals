# Missionaries and Cannibals Game

This is a Java implementation of the "Missionaries and Cannibals" puzzle game. The objective of the game is to safely transport all the missionaries and cannibals from one side of a river to the other side, following certain rules.

## Game Rules

- There are three missionaries and three cannibals.
- The game starts with all six characters on one side of the river.
- The characters can only cross the river in a boat that can carry a maximum of two people.
- At no point in the game can the cannibals on either side of the river outnumber the missionaries. Otherwise, the cannibals would eat the missionaries.
- The goal is to find a series of moves that safely transports all the characters to the other side of the river.

## How to Play

1. Run the `MissionariesAndCannibals` class to start the game.
2. The game will output the solutions for safely transporting the characters from one side to the other.
3. The solutions will be displayed in a visual format, showing the movements of the characters.
4. Each move is represented by a description and a diagram.
5. The game will continue until all possible solutions are found.

## Implementation Details

The game uses a recursive approach to find all possible solutions. The `MissionariesAndCannibals` method takes six parameters to represent the number of missionaries and cannibals on each side of the river, the number of missionaries and cannibals in the boat, and the set of states to avoid duplicate moves. It checks for the validity of each move and recursively explores all possible combinations.

The game includes two helper methods: `drawLeave` and `drawArrive`. These methods are responsible for generating the visual representation of the game state when the boat leaves or arrives at the riverbank.

## Usage

To play the Missionaries and Cannibals game, follow these steps:

1. Copy the code into a Java IDE or text editor.
2. Compile the code and run the `MissionariesAndCannibals` class.
3. The game will display the solutions for safely transporting the characters.
4. Each solution will include a description and a diagram.
5. The game will continue until all possible solutions are found.
