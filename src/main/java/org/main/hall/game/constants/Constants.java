package org.main.hall.game.constants;

/**
 * This class contains all constants of the project
 */
public interface Constants {

    // Box numbers
    int NUMBER_OF_BOXES = 3;
    int MINIMUM_NUMBER_FOR_BOX = 1;
    int MAXIMUM_NUMBER_FOR_BOX = 3;

    // Game Messages
    String WELCOME_MESSAGE = "Welcome to the Monty Hall game!!! \nThere are " + NUMBER_OF_BOXES + " boxes (With Box Number 1, 2 and 3), one of them has money." +
            " You need to choose one box number and press ENTER.";
    String CHANGE_MIND_TO_SELECT_BOX = "Do you want to change your mind and pick box %s instead? (y/n)";
    String PICKED_BOX = "You have picked %s";
    String PREVIOUS_SELECTED_BOX = "Previously you picked box %s, but you changed your decision to pick the other box %s";
    String BOX_PICKED_BY_HOST = "Let me make this interesting for you. \n I will open one empty box. \n (Opened box %s)";
    String WRONG_COMMAND_FOR_BOX_SELECTION = "Wrong command. Please enter between "
            + MINIMUM_NUMBER_FOR_BOX + " and " + MAXIMUM_NUMBER_FOR_BOX;
    String YES = "y";
    String NO = "n";
    String WRONG_COMMAND_FOR_YES_AND_NO = "Wrong command. Please enter '" + YES + "' or '" + NO + "'";
    String CONGRATULATION_MESSAGE = "Congratulations. You have won!!!";
    String WRONG_BOX_SELECTED = "Oops!!! You chose the wrong box. NO MONEY FOR YOU!!!";
    String WANT_TO_PLAY_AGAIN = "Want to play again? (y/n)";
    String THANKS_MESSAGE = "Thanks for playing!!!";
}
