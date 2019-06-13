/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.javatry.colorbox;

import java.util.List;

import org.docksidestage.bizfw.colorbox.ColorBox;
import org.docksidestage.bizfw.colorbox.space.BoxSpace;
import org.docksidestage.bizfw.colorbox.yours.YourPrivateRoom;
import org.docksidestage.unit.PlainTestCase;

/**
 * The test of Number with color-box. <br>
 * Show answer by log() for question of javadoc.
 * @author jflute
 * @author yukikoma
 */
public class Step13NumberTest extends PlainTestCase {

    // ===================================================================================
    //                                                                        Small Helper
    //                                                                        ============
    private boolean withinRange(BoxSpace boxSpace) {
        int contentVal;
        if (boxSpace.getContent() instanceof Integer) {
            contentVal = (int) boxSpace.getContent();
        } else {
            try{
                contentVal = Integer.parseInt(boxSpace.getContent().toString());
            }catch (Exception e){
                return false;
            }
        }
        return 0 <= contentVal && contentVal <= 54;
    }

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    /**
     * How many integer-type values in color-boxes are between 0 and 54? <br>
     * (カラーボックの中に入っているInteger型で、0から54までの値は何個ある？)
     */
    public void test_countZeroToFiftyFour_IntegerOnly() {
        // TODO yuki.komatsu 合計じゃない… (2019-06-13)
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();

        int sum = colorBoxList.stream()
                .flatMap(colorBox -> colorBox.getSpaceList().stream())
                .filter(boxSpace -> boxSpace.getContent() instanceof Integer)
                .filter(boxSpace -> withinRange(boxSpace))
                .mapToInt(boxSpace -> (int) boxSpace.getContent())
                .sum();
        System.out.println(sum);

    }

    /**
     * How many number values in color-boxes are between 0 and 54? <br>
     * (カラーボックの中に入っている数値で、0から54までの値は何個ある？)
     */
    public void test_countZeroToFiftyFour_Number() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        // TODO yuki.komatsu 数字を合計してしまっていた、intだけじゃないのにむししてた。 (2019-06-13)
        int sum = colorBoxList.stream()
                .flatMap(colorBox -> colorBox.getSpaceList().stream())
                .peek(boxSpace -> System.out.println(boxSpace))
                .filter(boxSpace -> boxSpace.getContent() instanceof Integer || boxSpace.getContent() instanceof String)
                .filter(boxSpace -> withinRange(boxSpace))
                .mapToInt(boxSpace -> (int) boxSpace.getContent())
                .sum();
        System.out.println(sum);
    }

    /**
     * What color name is used by color-box that has integer-type content and the biggest width in them? <br>
     * (カラーボックスの中で、Integer型の Content を持っていてBoxSizeの幅が一番大きいカラーボックスの色は？)
     */
    public void test_findColorBigWidthHasInteger() {
    }

    /**
     * What is total of BigDecimal values in List in color-boxes? <br>
     * (カラーボックスの中に入ってる List の中の BigDecimal を全て足し合わせると？)
     */
    public void test_sumBigDecimalInList() {
        // TODO yuki.komatsu 次回レビュー必ずあるやつ。終わらせなければ。 (2019-06-13)
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * What key is related to value that is max number in Map that has only number in color-boxes? <br>
     * (カラーボックスに入ってる、valueが数値のみの Map の中で一番大きいvalueのkeyは？)
     */
    public void test_findMaxMapNumberValue() {
    }

    /**
     * What is total of number or number-character values in Map in purple color-box? <br> 
     * (purpleのカラーボックスに入ってる Map の中のvalueの数値・数字の合計は？)
     */
    public void test_sumMapNumberValue() {
    }
}


