package org.main.hall.game.service;

import org.main.hall.game.constants.Constants;
import org.main.hall.game.model.Box;
import org.main.hall.game.utility.RandomNumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains functions related to box generation for the game show
 */
public class BoxService {

    /**
     * This will generate box list and one of the box will have the money
     *
     * @return Will return box list
     */
    public List<Box> getBoxListForTheShow() {
        List<Box> boxList = new ArrayList<>(Constants.NUMBER_OF_BOXES);
        int boxNumberToContainMoney = RandomNumberUtils.generateRandomNumberWithInRange(
                Constants.MINIMUM_NUMBER_FOR_BOX, Constants.MAXIMUM_NUMBER_FOR_BOX);
        for (int i = 1; i <= Constants.NUMBER_OF_BOXES; i++) {
            boxList.add(new Box(i, i == boxNumberToContainMoney));
        }
        return boxList;
    }

    /**
     * This will find box in box list which does contain money inside that
     *
     * @param boxList           Box list to search
     * @param selectedBoxNumber This is the selected box that user has selected.
     *                          And it does not need to consider in search.
     * @return
     */
    public Box getBoxFromBoxListWhichDoesNotContainMoney(List<Box> boxList, int selectedBoxNumber) {
        Box selectedBox = getBoxByBoxNumber(boxList, selectedBoxNumber);
        return boxList
                .stream()
                .filter(box -> box.getBoxNumber() != selectedBox.getBoxNumber() && !box.isHasMoney())
                .findFirst()
                .get();
    }

    /**
     * This will find box based on the box number
     *
     * @param boxList   Box list to find box
     * @param boxNumber Box number is required to find box in box list
     * @return Will return selected box after search by box number
     */
    public Box getBoxByBoxNumber(List<Box> boxList, int boxNumber) {
        return boxList
                .stream()
                .filter(b -> b.getBoxNumber() == boxNumber)
                .findFirst()
                .get();
    }

    /**
     * This will return the other box which is not equal to the give box number
     *
     * @param boxList   Box list to find box
     * @param boxNumber Box number is required to find the other box in box list
     * @return Will return selected box after search by box number
     */
    public Box getBoxWhichDoesNotContainMoney(List<Box> boxList, int boxNumber) {
        return boxList
                .stream()
                .filter(b -> b.getBoxNumber() != boxNumber)
                .findFirst()
                .get();
    }

    /**
     * This will check the selected box whether it has prize money or not
     *
     * @param selectedBox Selected box by the user
     */
    public void checkSelectedBoxToShowMessage(Box selectedBox) {
        if (selectedBox.isHasMoney()) {
            System.out.println(Constants.CONGRATULATION_MESSAGE);
        } else {
            System.out.println(Constants.WRONG_BOX_SELECTED);
        }
    }
}
