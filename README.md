# Grand Theft Auto
## Zygmund edition

### Code quality
See this beauty -> [![Codacy Badge](https://api.codacy.com/project/badge/Grade/5f5aa30ac9cd460f9be0ede89ce138a3)](https://www.codacy.com/app/mikolajwichrowski/swingding?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mikolajwichrowski/swingding&amp;utm_campaign=Badge_Grade)

### What is the game about?
This is our school project. We have made a cool game in approx. 5 hours and decided to make this into a A+ or grade 10 project. (Lets hope we get a good grade)
See the code and be amazed :D

### How to run
- Open the project in intellij
- Set java version to JDK12
- Select the option File > Project structure
- Under project settings select libraries
- Click the + icon and choose the option "Java"
- Navigate to the resource folder and add the json-20180813.jar file


### How to play
- Use arrow keys to move
- Walk into bottles of vodka to pick them up
- Walk into hookers to make them go away
- Walk into the portal/star to go to the next level
- Press save to save the game (It will load on the next start)
- Press replay level to only replay the current level
- Press restart game to clear save and start from the beginning

### Should have but had no time..(ve)
- FileUtil handle all the file traffic
- Image class instead of interface
   - We wanted to implement
   - getImage() and getImage(int direction)
   - but ended up doing
   - getImage(int direction)
   - And just using it with getImage(0) if there was no direction in the specific implementation
- Sounds and stuff :(
- Cleaner code on some parts of the application

### Lessons learned
#### Miko
- Document at least something before starting
- Java turns lambda's into some crazy stuff ...
- Stick to one naming convention
- Use proper naming
- Don't test unnecessary stuff
- Don't make stuff complex
- Don't drunk code (unless you are eastern european)
- Don't overdo and be on time with what you have to do
- Be satisfied with what you made. If it works, it works
