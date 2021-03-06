<div class="container-fluid">
  <div class="jumbotron">
    <h2>Day 7 - Rock, Paper, Scissors, Lizard, Conclusion...</h2>
      <p>
        You made it to the final day! Congratulations on becoming a programmer!<br>
        Today we will be putting everything you have learnt together into a Rock, Paper, Scissors game
        that you can play with your friends.
      </p>
  </div>

  <div class="well well-sm">
    <h4>Let's Begin...</h4>
    <p>
      Firstly, this part of the course assumes you know how to play Rock-Paper-Scissors.
      If not, take a look on Wikipedia <a href="https://en.wikipedia.org/wiki/Rock-paper-scissors">here</a>
      because otherwise you'll be hopelessly confused for the rest of today!
    </p>
    <p>
      Assuming you have a better idea of how Rock-Paper-Scissors works, the plan is to build this game using
      a mixture of all the skills you have learnt over the last week. This will need all the following skills:
      <ul>
        <li>
            Writing things on the screen
        </li>
        <li>
          User input with Scanners
        </li>
        <li>
          Functions
        </li>
        <li>
          If (and else) statements
        </li>
        <li>
          For loops
        </li>
        <li>
          Random Numbers
        </li>
        <li>
          do...while loops
        </li>
        <li>
          switch...case statements
        </li>
      </ul>
      Lots of stuff there! But don't worry if you have forgotten anything, because we'll walk you right through it.
    </p>
    <p>
      Now, before we do anything you need to create a new project in IntelliJ like on the first day. Make sure you
      click the option to <em>Use a template</em>, and tick <em>Command Line App</em>. You'll be presented with an empty
      code window.
    </p>
  </div>
  <div class="well well-sm">
    <h4>What's on the Menu?</h4>
    <p>
      This is probably your first Java project, and therefore you'll be undoubtedly nervous about diving head-first into this one.
      Therefore, each section will tell you exactly what you need to achieve. If you get stuck, the answer will be hidden
      in a spoiler. The complete solution is also at the bottom of this page in case you want to see how it all fits together.
    </p>
    <p>
      The first function we will build is the code that outputs a menu asking the player whether they would like to play with
      a friend or against the computer. It should do the following:
      <ul>
        <li>Show the game title</li>
        <li>A request for the user to choose an option</li>
        <li>Option to play alone against the computer</li>
        <li>Option to play against a friend</li>
        <li>Option to exit the game</li>
      </ul>
    </p>
    <p>
      Aim for something that looks a bit like this:<br>
      <img src="img/Day7_01.jpg" style="width:577px; height: 167px;">
    </p>
    <p>
      Call your funtion showMenu, to make it easier to follow any sample code given in this tutorial.
    </p>
    <p>
      <div class="panel-group" id="Accordion_Day7_01" role="tablist">
        <div class="panel panel-default">
          <div class="panel-heading" role="tab" id="Accordion_Day7_01_1">
            <h4 class="panel-title">
              <a role="button" data-toggle="collapse" data-parent="#Accordion_Day7_01" href="#Accordion_Day7_01_Collapse1" aria-expanded="true" aria-controls="Accordion_Day7_01_1">
                *** SPOILER ALERT *** Code Answer is Inside *** SPOILER ALERT ***
              </a>
            </h4>
          </div>
          <div id="Accordion_Day7_01_Collapse1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="Accordion_Day7_01_1">
            <div class="panel-body">
              <pre>
                <code class="language-java">
                  private static void showMenu()
                  {
                      System.out.println("Rock Paper Scissors");
                      System.out.println("Please select an option from the list:");
                      System.out.println("1) Play alone against the computer");
                      System.out.println("2) Play against a friend");
                      System.out.println("x) Exit the game");
                  }
                </code>
              </pre>
            </div>
          </div>
        </div>
      </div>
    </p>
  </div>

  <div class="well well-sm">
    <h4>Weapon of Choice?</h4>
    <p>
      That wasn't too painful, eh? Now let's do the same thing again, but this time offer the user three options:
      <ul>
        <li>Rock</li>
        <li>Paper</li>
        <li>Scissors</li>
      </ul>
    </p>
    <p>
      Again, here's a lovely example of what output you should be aiming for:<br>
      <img src="img/Day7_02.jpg" style="width: 368.5px; height: 126px;">
    </p>
    <p>
      Call your function showOptions, so that you can follow along with any sample code throughout this tutorial.
    </p>
    <p>
      <div class="panel-group" id="Accordion_Day7_02" role="tablist">
        <div class="panel panel-default">
          <div class="panel-heading" role="tab" id="Accordion_Day7_02_1">
            <h4 class="panel-title">
              <a role="button" data-toggle="collapse" data-parent="#Accordion_Day7_02" href="#Accordion_Day7_02_Collapse1" aria-expanded="true" aria-controls="Accordion_Day7_02_1">
                *** SPOILER ALERT *** Code Answer is Inside *** SPOILER ALERT ***
              </a>
            </h4>
          </div>
          <div id="Accordion_Day7_02_Collapse1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="Accordion_Day7_02_1">
            <div class="panel-body">
              <pre>
                <code class="language-java">
                  private static void showOptions()
                  {
                      System.out.println("Please select a weapon");
                      System.out.println("R) Rock");
                      System.out.println("P) Paper");
                      System.out.println("S) Scissors");
                  }
                </code>
              </pre>
            </div>
          </div>
        </div>
      </div>
    </p>
  </div>
  <div class="well well-sm">
    <h4>Scissors cuts Paper, Paper covers Rock and, as it always has, Rock crushes Scissors</h4>
    <p>
      If you don't get the reference, watch this so that I might have a tougher time judging you...<br>
      <iframe width="420" height="315" src="https://www.youtube.com/embed/Kov2G0GouBw" frameborder="0" allowfullscreen></iframe>
    </p>
    <p>
      Now let's program some rules into this system! We're not going into a Sheldon level of detail here, so the three rules you need
      to implement are the ones in the title:
      <ul>
        <li>If scissors are against paper, scissors wins.</li>
        <li>If paper is against rock, paper wins.</li>
        <li>If rock is against scissors, rock wins.</li>
      </ul>
    </p>
    <p>
      Here are some hints:
      <ul>
        <li>
          Your function should return an integer (1 if player one won, 2 if player two won or 3 if the result was a tie).
        </li>
        <li>
          Your function should take in two characters (each of which will be R (rock), P (paper) or S (scissors)). Each of those
          will have been entered by a player
        </li>
        <li>
          Try focussing only on one player's perspective. If the result wasn't a tie, and player one did not win then player two
          must have won. This will save you on coding.
        </li>
        <li>
          Call your function whichPlayerWins.
        </li>
      </ul>
    </p>
    <p>
      <div class="panel-group" id="Accordion_Day7_03" role="tablist">
        <div class="panel panel-default">
          <div class="panel-heading" role="tab" id="Accordion_Day7_03_1">
            <h4 class="panel-title">
              <a role="button" data-toggle="collapse" data-parent="#Accordion_Day7_03" href="#Accordion_Day7_03_Collapse1" aria-expanded="true" aria-controls="Accordion_Day7_03_1">
                *** SPOILER ALERT *** Code Answer is Inside *** SPOILER ALERT ***
              </a>
            </h4>
          </div>
          <div id="Accordion_Day7_03_Collapse1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="Accordion_Day7_03_1">
            <div class="panel-body">
              <pre>
                <code class="language-java">
                  private static int whichPlayerWins(char playerOneWeapon, char playerTwoWeapon)
                   {
                       if (playerOneWeapon == playerTwoWeapon)
                           return 3;
                       else if (playerOneWeapon == 'R' && playerTwoWeapon == 'S')
                           return 1;
                       else if (playerOneWeapon == 'P' && playerTwoWeapon == 'R')
                           return 1;
                       else if (playerOneWeapon == 'S' && playerTwoWeapon == 'P')
                           return 1;

                       return 2;
                   }
                </code>
              </pre>
            </div>
          </div>
        </div>
      </div>
    </p>
  </div>
  <div class="well well-sm">
    <h2>No cheating!</h2>
    <p>
      in order to make sure that the opponent is not looking at the screen while you are playing, we need to build a clearScreen function! so that it clears the other opponent's
      choice! HINT: you can do it by simply printing out empty lines...
      <div id="Accordion_Day7_03_Collapse1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="Accordion_Day7_03_1">
        <div class="panel-body">
          <pre>
            <code class="language-java">
              private static void clearScreen()
              {
                  for (int i = 0; i < 50; i++)
                  {
                      System.out.println();
                  }
              }
            </code>
          </pre>
        </div>
      </div>
    </p>
  </div>
  <div class="well well-sm">
    <h2>Computer Chooses...!</h2>
    <p>
      The times that you want to play against the computer you need to get it to make a choice, just like a person! but you need to tell it how to randomly choose a move, this is done
      by one of the java library classes named Random, which holds a method named "nextInt" that returns an Int value from 0 to the value that you give to the function! It's pretty interesting,
      you can search for more uses of Random class on google!
      <div id="Accordion_Day7_03_Collapse1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="Accordion_Day7_03_1">
        <div class="panel-body">
          <pre>
            <code class="language-java">
              private static Character getRandomWeapon()
              {
                  Random random = new Random();
                  int r = random.nextInt(3);
                  if (r == 0)
                      return 'R';
                  else if (r == 1)
                      return 'P';
                  else
                      return 'S';
              }
            </code>
          </pre>
        </div>
      </div>
    </p>
  </div>
  <div class="well well-sm">
    <h4>Full Answers</h4>
    <p>
      Well here they are! Just in case you've become confused at any point throughout this tutorial,
      the full source code to the whole program is here.
    </p>
    <p>
      <div class="panel-group" id="Accordion_Day7_99" role="tablist">
        <div class="panel panel-default">
          <div class="panel-heading" role="tab" id="Accordion_Day7_99_1">
            <h4 class="panel-title">
              <a role="button" data-toggle="collapse" data-parent="#Accordion_Day7_99" href="#Accordion_Day7_99_Collapse1" aria-expanded="true" aria-controls="Accordion_Day7_99_1">
                *** SPOILER ALERT *** Code Answer is Inside *** SPOILER ALERT ***
              </a>
            </h4>
          </div>
          <div id="Accordion_Day7_99_Collapse1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="Accordion_Day7_99_1">
            <div class="panel-body">
              <pre>
                <code class="language-java">
<?=file_get_contents('../Rock-Paper-Scissors/src/com/thebabies/rockpaperscissors/Main.java');?>
                </code>
              </pre>
            </div>
          </div>
        </div>
      </div>
    </p>
  </div>
</div>
