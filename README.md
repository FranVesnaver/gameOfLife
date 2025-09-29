# Conway's Game of Life

This project is an implementation of **Conway's Game of Life**, a cellular automaton devised by mathematician John Horton Conway in 1970.  
It simulates the evolution of a grid of cells according to simple rules, producing complex and sometimes unexpected behaviors.
It was implemented in the context of the "Software Engineering" course of the "Computer Analyst" program at the "National University of Río Cuarto"
## Features
- Configurable grid size.
- Step-by-step evolution of the automaton.
- Support for classic Game of Life rules:
    - Any live cell with 2 or 3 live neighbors survives.
    - Any dead cell with exactly 3 live neighbors becomes a live cell.
    - All other live cells die in the next generation, and all other dead cells stay dead.
- Initial state can be randomized or defined manually.

## Requirements
- [Java 17+](https://adoptium.net/)
- [Gradle](https://gradle.org/) (if you build manually, otherwise you can use the Gradle wrapper included in the repo)

## Installation & Usage

1. Clone this repository:
   ```bash
   git clone https://github.com/FranVesnaver/gameOfLife.git
   cd gameOfLife
   ```
   
2. Build the project with Gradle:
   ```bash
   ./gradlew build
   ```
   
3. Run the program:
   ```bash
   ./gradlew run
   ```
   To run the program without gradle messages:
   ```bash
   ./gradlew -q --console plain run
   ```

## Examples
At this moment, running the application shows an example of a glider and a blinker on a 10x10 grid and it can not be changed.

As development advances it will be possible to change the size of the grid, game rules, color schemes, and to define the initial state of the board

## References
- [Conway's Game of Life (Wikipedia)](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life) 
- [Original Kata by Coding Dojo](https://codingdojo.org/kata/GameOfLife/)