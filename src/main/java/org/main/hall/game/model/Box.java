package org.main.hall.game.model;

/**
 * Box model which contains box number and its status of having money or not
 */
public class Box {

    private int boxNumber;
    private boolean hasMoney;

    public Box(int boxNumber, boolean hasMoney) {
        this.boxNumber = boxNumber;
        this.hasMoney = hasMoney;
    }

    public int getBoxNumber() {
        return boxNumber;
    }

    public boolean isHasMoney() {
        return hasMoney;
    }

    @Override
    public String toString() {
        return "Box{" +
                "boxNumber=" + boxNumber +
                ", hasMoney=" + hasMoney +
                '}';
    }
}
