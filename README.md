# Tic-Tac-Toe

This is a group project for CSC 211. Our project consists of a simple tic-tac-toe game that an individual could play whenever they feel bored.

The way it works is simple. We created a 2D array that looks like a game board. After creating the game board, we simply indicated to the computer what symbols to put in that game board.

Inside our project, we used concepts like 2D arrays, for loops, methods, Scanner, if statements, Arraylists, while statements, and switch statements.

We used a 2D array of chars to create the game board. This setup makes it look like a game board with 3 rows and 3 columns.

The while loop for the player makes it so that the computer keeps asking the player to continue placing the pieces.
This while loop for the cpu is so that the computer does not play over the player's position.

We told the computer on line 32 to generate its symbol randomly throughout the game board.

We created the printGameBoard method to print out the game board by doing two for loops. 

The placePiece method is to identify the symbols the player and the cpu will be using and where are we allowed to place them. We told the computer if the input is from a player then the symbol placed will be "X" and if the input is from the cpu then the symbol placed will be "O". The switch case in this method tells the computer that when the user inputs a number from 1-9, then it will be marked with an X.

The checkWinner method is to identify the winner by creating an arrayList
