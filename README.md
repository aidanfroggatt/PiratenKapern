# A1 - Piraten Karpen

  * Author: < Aidan Froggatt >
  * Email: < froggata@mcmaster.ca >

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn exec:java -Dexec.args="player1strategy player2strategy"`
    * `Strategies: card, random, combo`
    * old//`mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Logging
Level | Description
ALL | All levels including custom levels.
DEBUG | Designates fine-grained informational events that are most useful to debug an
application.
INFO | Designates informational messages that highlight the progress of the application at
coarse-grained level.
WARN | Designates potentially harmful situations.
ERROR | Designates error events that might still allow the application to continue running.
FATAL | Designates very severe error events that will presumably lead the application to
abort.
OFF | The highest possible rank and is intended to turn off logging.
TRACE | Designates finer-grained informational events than the DEBUG.

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * < Create a game that allows for dice rolling, scoring, user input, game ending function, and number of games. Complete F01-F06. Each feature is complete when it can be implemented without impacting any other function and provides it's desired business value to the final game.>

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| 1   | F01 | Roll a dice |  D | 2023-01-11 | 2023-01-11 |
| 1   | F02 | Roll eight dices  |  D |  2023-01-11 | 2023-01-11 |
| 1   | F03 | Select how many games as command-line arg.  | D | 2023-01-25 | 2023-01-25 |
| 1   | F04 | End of game with three skulls | D | 2023-01-16 | 2023-01-16 |
| 1   | F05 | Player keeping random dice at their turn | D | 2023-01-16 | 2023-01-16 | 
| 1   | F06 | Score points: 3-of-a-kind | D | 2023-01-16 | 2023-01-16 | 
| 0   | F07 | Score points: diamonds and gold | D | 2023-01-16 | 2023-01-16 |
| 0   | F08 | Two Players with random strategy| D | 2023-01-16 | 2023-02-16 |
| 0   | F09 | 42 game simulation | D | 2023-01-16 | 2023-01-18 |
| 0   | F10 | Win percentage for each player | D | 2023-01-16 | 2023-01-18 |
| 0   | F11 | Trace player decisions | D | 2023-01-16 | 2023-01-25 |
| 0   | F12 | Sets-of-a-kind (1->8) | D | 2023-01-18 | 2023-01-23 |
| 0   | F13 | Max combo strategy | D | 2023-01-19 | 2023-01-23 |
| 0   | F14 | Command line entry to select each players strategy | D | 2023-01-23 | 2023-01-23 |
| 0   | F15 | Introduce card deck (only "sea battle" card and functionality) and apply effect to turn | D | 2023-01-23 | 2023-01-23 |
| 0   | F16 | Card based strategy | D | 2023-01-24 | 2023-01-24 |
| 0   | F17 | "Monkey-business" card and functionality | D | 2023-01-24 | 2023-01-25 |




| ... | ... | ... |

