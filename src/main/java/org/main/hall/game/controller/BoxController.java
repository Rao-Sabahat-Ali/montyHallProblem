package org.main.hall.game.controller;

import org.main.hall.game.constants.Constants;
import org.main.hall.game.model.Box;
import org.main.hall.game.service.BoxService;

import java.util.List;
import java.util.Scanner;

/**
 * Box controller which contains all execution of game
 */
public class BoxController {
    private final static Scanner scanner = new Scanner(System.in);
    private final static BoxService boxService = new BoxService();

    /**
     * This is an actual game function. That will ask user input and based on that will determine the further steps
     */
    public static void startGame() {
        System.out.println(Constants.WELCOME_MESSAGE);
        List<Box> boxList = boxService.getBoxListForTheShow();
        int selectedBoxNumber = scanner.nextInt();
        if (selectedBoxNumber >= Constants.MINIMUM_NUMBER_FOR_BOX && selectedBoxNumber <= Constants.MAXIMUM_NUMBER_FOR_BOX) {
            System.out.println(String.format(Constants.PICKED_BOX, selectedBoxNumber));
            // find the box which does not contain the money inside
            Box boxNotIncludeMoney = boxService.getBoxFromBoxListWhichDoesNotContainMoney(boxList, selectedBoxNumber);
            System.out.println(String.format(Constants.BOX_PICKED_BY_HOST, boxNotIncludeMoney.getBoxNumber()));
            // remove this box. Because now it is revealed.
            boxList.remove(boxNotIncludeMoney);
            askUserIfNeedsToChangeMind(boxList, selectedBoxNumber);
        } else {
            System.out.println(Constants.WRONG_COMMAND_FOR_BOX_SELECTION);
            startGame();
        }
    }

    /**
     * This will ask user if he needs to change mind. If not then the selected box will check in the box list.
     *
     * @param boxList           Box list to check
     * @param selectedBoxNumber Box number selected by the user
     */
    private static void askUserIfNeedsToChangeMind(List<Box> boxList, int selectedBoxNumber) {
        Box remainingBoxWithoutMoney = boxService.getBoxWhichDoesNotContainMoney(boxList, selectedBoxNumber);
        System.out.println(String.format(Constants.CHANGE_MIND_TO_SELECT_BOX, remainingBoxWithoutMoney.getBoxNumber()));
        String userInputForMindChange = scanner.next();
        if (userInputForMindChange.equalsIgnoreCase(Constants.YES) || userInputForMindChange.equalsIgnoreCase(Constants.NO)) {
            Box selectedBox;
            if (userInputForMindChange.equalsIgnoreCase(Constants.YES)) {
                // now change his selected box number and check in box list
                System.out.println(String.format(Constants.PREVIOUS_SELECTED_BOX, selectedBoxNumber, remainingBoxWithoutMoney.getBoxNumber()));
                selectedBox = remainingBoxWithoutMoney;
            } else {
                // check selected box in box list
                selectedBox = boxService.getBoxByBoxNumber(boxList, selectedBoxNumber);
            }
            boxService.checkSelectedBoxToShowMessage(selectedBox);
            System.out.println(Constants.WANT_TO_PLAY_AGAIN);
            String userInputForPlayAgain = scanner.next();
            if (userInputForPlayAgain.equalsIgnoreCase(Constants.YES) || userInputForPlayAgain.equalsIgnoreCase(Constants.NO)) {
                if (userInputForPlayAgain.equalsIgnoreCase(Constants.YES)) {
                    startGame();
                } else {
                    System.out.println(Constants.THANKS_MESSAGE);
                }
            } else {
                System.out.println(Constants.WRONG_COMMAND_FOR_YES_AND_NO);
            }
        } else {
            System.out.println(Constants.WRONG_COMMAND_FOR_YES_AND_NO);
            askUserIfNeedsToChangeMind(boxList, selectedBoxNumber);
        }
    }
}
