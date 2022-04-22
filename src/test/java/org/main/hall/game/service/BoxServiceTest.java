package org.main.hall.game.service;


import org.junit.Assert;
import org.junit.Test;
import org.main.hall.game.model.Box;

import java.util.List;

public class BoxServiceTest {

    private final BoxService boxService = new BoxService();

    @Test
    public void testBoxListIsGeneratedCorrectly() {
        List<Box> boxList = boxService.getBoxListForTheShow();
        Assert.assertEquals(3, boxList.size());
        Assert.assertEquals(1, boxList.stream().filter(Box::isHasMoney).toList().size());
    }
}
