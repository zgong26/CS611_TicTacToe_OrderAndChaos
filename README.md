# CS611-Assignment 1
## Tic-Tac-Toe, Order and Chaos
---------------------------------------------------------------------------
Ziqi Gong
zgong@bu.edu

## Files
---------------------------------------------------------------------------
1. Board.java
A class that can be initiated to create a game board. It supports rectangle
and square shape. It has basic methods such as getLength, getWidth, clear(to 
empty the board) as well as a toString, which prints out the current board.

2. Player.java
A basic class that defines a generic player.

3. Team.java
An interface that describes what a Team should look like; it takes a generic 
type T which refers to the player object varied by the actual implementation of 
the player object.

4. BoardGame.java
An abstract class that has a Board object in it, an abstract class called start 
and an abstract class called end.

5. TicTacToeBoard.java
A child class that extends Board class. It creates a tic-tac-toe board for 
that specific game. In this class, the rule is defined; the class will keep 
track of the game status.

6. TicTacToeGame.java
A class that extends BoardGame abstract class that has implementation for the 
abstract method. It also has a gameLoop method to allow repeating plays. This 
class is the one that unites all parts of the tic-tac-toe game.

7. TicTacToePlayer.java
A child class that extends Player class. It has full implementation for a tic-
tac-toe player. It also has a Chess object which is either a type "O" or "X".

8. TicTacToeTeam.java
A class that implements Team interface. It defines what a team in tic-tac-toe 
game should look like. It has an independent scoring system as well as the 
ability to randomly choose a player.

9. Chess.java
A class that defines a piece. It can be used in both tic-tac-toe game and Order 
and Chaos game.

10. OrderAndChaosBoard.java
A child class that extends Board class. It creates an Order and Chaos board for 
that specific game. In this class, the rule is defined; the class will keep 
track of the game status.

11. OrderAndChaosGame.java
A class that extends BoardGame abstract class that has implementation for the 
abstract method. It also has a gameLoop method to allow repeating plays. This 
class is the one that unites all parts of the Order and Chaos game.

12. OrderAndChaosPlayer.java
A child class that extends Player class. It has full implementation for an Order 
and Chaos player. It also has a Chess object which is either a type "O" or "X". 
It has a setChess method to allow changing the chess piece as a player can use 
either "O" or "X".

13. OrderAndChaosTeam.java
A class that implements Team interface. It defines what a team in Order and Chaos  
game should look like. It has an independent scoring system as well as the 
ability to randomly choose a player.

14. Main.java
Entry class that contains the main method.

15. ErrorControl.java
A class that contains static methods that are used to prevent mistakes that might 
occur in a game such as invalid input, string-integer issue, etc.

## Notes
---------------------------------------------------------------------------
1. Bonus part is done. It allows two teams to compete. After each round, one player 
is randomly selected from each team to compete. Each team has an individual score 
system.

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "Game" after unzipping the files
2. Run the following instructions:
javac Main.java
java Main

## Input/Output Example
---------------------------------------------------------------------------
Output:
Which game would you like to play? 
1. Tic-Tac-Toe
2. Order and Chaos
Input: 1
Output:
Please enter the board size(side length): 
Input: 3
Output:
Welcome to Tic-Tac-Toe!
Team 1, enter your name:
Input: A
Output:
Team 2, enter your name:
Input: B
Output:
Round 1


Team 1, player P1 is selected.
Team 2, player P1 is selected
+--+--+--+
|1 |2 |3 |
+--+--+--+
|4 |5 |6 |
+--+--+--+
|7 |8 |9 |
+--+--+--+

Team A, Player P1 Enter your move:
Input: 5
Output: 
+--+--+--+
|1 |2 |3 |
+--+--+--+
|4 |O |6 |
+--+--+--+
|7 |8 |9 |
+--+--+--+

Team B, Player P1 Enter your move: 
Input: 6
Output: 
+--+--+--+
|1 |2 |3 |
+--+--+--+
|4 |O |X |
+--+--+--+
|7 |8 |9 |
+--+--+--+

Team A, Player P1 Enter your move: 

.
.
.
.
.

Output:
+--+--+--+
|O |X |O |
+--+--+--+
|X |O |X |
+--+--+--+
|O |8 |9 |
+--+--+--+
Player P1 from team A wins!
Current status: round 1 
Score: 
Team A: 1 
Team B: 0

Would you like to continue? (y/N)
Input: N
Output:
Game Over!
Team A has score of 1, Team B has score of 0.
Team A wins!

Would you like to play another game?(y/N)
Input: y
Output:
Which game would you like to play? 
1. Tic-Tac-Toe
2. Order and Chaos

Input: 2
Output:
Would you like to play it with the additional rule?(y/N) 
Additional rule implies that the only winning condition for Order is to have exact 5 consecutive pieces, 6 doesn't count

Input: N
Output:
Welcome to Order and Chaos!
Team 1, enter your name:

.
.
.
.
.

Output:
Round 1


Team 1, player P2 is selected.
Team 2, player P1 is selected
+--+--+--+--+--+--+
|1 |2 |3 |4 |5 |6 |
+--+--+--+--+--+--+
|7 |8 |9 |10|11|12|
+--+--+--+--+--+--+
|13|14|15|16|17|18|
+--+--+--+--+--+--+
|19|20|21|22|23|24|
+--+--+--+--+--+--+
|25|26|27|28|29|30|
+--+--+--+--+--+--+
|31|32|33|34|35|36|
+--+--+--+--+--+--+

Team A, Player P2(Order) Enter your move and chess(O/X) separated by comma: 

Input: 1,O
Output:
+--+--+--+--+--+--+
|O |2 |3 |4 |5 |6 |
+--+--+--+--+--+--+
|7 |8 |9 |10|11|12|
+--+--+--+--+--+--+
|13|14|15|16|17|18|
+--+--+--+--+--+--+
|19|20|21|22|23|24|
+--+--+--+--+--+--+
|25|26|27|28|29|30|
+--+--+--+--+--+--+
|31|32|33|34|35|36|
+--+--+--+--+--+--+

Team B, Player P1(Chaos) Enter your move and chess(O/X) separated by comma:

Input: 7,X
Output:
+--+--+--+--+--+--+
|O |2 |3 |4 |5 |6 |
+--+--+--+--+--+--+
|X |8 |9 |10|11|12|
+--+--+--+--+--+--+
|13|14|15|16|17|18|
+--+--+--+--+--+--+
|19|20|21|22|23|24|
+--+--+--+--+--+--+
|25|26|27|28|29|30|
+--+--+--+--+--+--+
|31|32|33|34|35|36|
+--+--+--+--+--+--+

Team A, Player P2(Order) Enter your move and chess(O/X) separated by comma: 

.
.
.
.
.

Team B, Player P1(Chaos) Enter your move and chess(O/X) separated by comma: 
Input: 5,O
Output: 
+--+--+--+--+--+--+
|O |O |O |O |O |6 |
+--+--+--+--+--+--+
|X |8 |9 |10|11|12|
+--+--+--+--+--+--+
|13|14|15|16|17|18|
+--+--+--+--+--+--+
|19|20|21|22|23|24|
+--+--+--+--+--+--+
|25|26|27|28|29|30|
+--+--+--+--+--+--+
|31|32|33|34|35|36|
+--+--+--+--+--+--+
Team A(Order) wins!
Current status: round 1 
Score: 
Team A: 1 
Team B: 0

Would you like to continue? (y/N)

Input: N
Output:
Game Over!
Team A has score of 1, Team B has score of 0.
Team A wins!

Would you like to play another game?(y/N)

Input: N
Output:
Game Over
