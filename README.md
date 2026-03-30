# Tic Tac Toe (Java)

## Overview
This is a command-line Tic Tac Toe game developed in Java.  
It supports both two-player mode and a single-player mode against an intelligent AI.

## Features
- 3x3 Tic Tac Toe board
- Two modes:
    - Player vs Player
    - Player vs AI Mode
- Intelligent AI using the Minimax algorithm
- Player name input
- Symbol selection (X or O)
- Automatic turn handling (X always starts)
- Input validation (prevents invalid and out-of-range moves)
- Win and draw detection

## Technologies Used
- Java
- Object-Oriented Programming
- Minimax Algorithm

## How to Run
1. Compile the program
2. Run `TicTacToeMain`
3. Select game mode:
    - 1 for Player vs Player
    - 2 for Player vs AI
4. Follow the prompts in the console

## AI Logic
The AI uses the Minimax algorithm to evaluate all possible moves and choose the optimal one.  
This ensures the AI plays perfectly and cannot be easily defeated.

## Project Structure
- `TicTacToe.java` – Game logic
- `TicTacToeMain.java` – Main program and user interaction
- `AIPlayer.java` – Minimax AI implementation

## Author
Jenifa Joseph