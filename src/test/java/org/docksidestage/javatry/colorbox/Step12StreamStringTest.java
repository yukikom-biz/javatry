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

import java.io.File;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.docksidestage.bizfw.colorbox.ColorBox;
import org.docksidestage.bizfw.colorbox.space.BoxSpace;
import org.docksidestage.bizfw.colorbox.yours.YourPrivateRoom;
import org.docksidestage.unit.PlainTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The test of String with color-box, using Stream API you can. <br>
 * Show answer by log() for question of javadoc.
 * @author jflute
 * @author yukikoma
 */
public class Step12StreamStringTest extends PlainTestCase {

    // ===================================================================================
    //                                                                            length()
    //                                                                            ========
    /**
     * What is color name length of first color-box? <br>
     * (最初のカラーボックスの色の名前の文字数は？)
     */
    public void test_length_basic() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String answer = colorBoxList.stream().findFirst().map(colorBox -> colorBox.getColor()) // consciously split as example
                .map(boxColor -> boxColor.getColorName()).map(colorName -> {
                    log(colorName); // for visual check
                    return String.valueOf(colorName.length());
                }).orElse("not found"); // basically no way because of not-empty list and not-null returns
        log(answer);
    }

    /**
     * Which string has max length in color-boxes? <br>
     * (カラーボックスに入ってる文字列の中で、一番長い文字列は？)
     */
    public void test_length_findMax() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String answer = colorBoxList.stream()
                .map(colorBox -> colorBox.getSpaceList())
                .map(cont -> cont.toString())
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
        System.out.println("+++++++++Answer+++++++++");
        System.out.println(answer);
    }

    /**
     * How many characters are difference between max and min length of string in color-boxes? <br>
     * (カラーボックスに入ってる文字列の中で、一番長いものと短いものの差は何文字？)
     */
    public void test_length_findMaxMinDiff() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String maxStr = colorBoxList.stream()
                .map(colorBox -> colorBox.getSpaceList())
                .map(cont -> cont.toString())
                .max(Comparator.comparingInt(String::length))
                .orElse(null);

        String minStr = colorBoxList.stream()
                .map(colorBox -> colorBox.getSpaceList())
                .map(cont -> cont.toString())
                .min(Comparator.comparingInt(String::length))
                .orElse(null);

        int ans = maxStr.length() - minStr.length();

        System.out.println("+++++++++Answer+++++++++");
        System.out.println(ans);

    }

    // has small #adjustmemts from ClassicStringTest
    //  o sort allowed in Stream
    /**
     * Which value (toString() if non-string) has second-max legnth in color-boxes? (sort allowed in Stream)<br>
     * (カラーボックスに入ってる値 (文字列以外はtoString()) の中で、二番目に長い文字列は？ (Streamでのソートありで))
     */
    public void test_length_findSecondMax() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();

        String maxStr = colorBoxList.stream()
                .flatMap(colorBox -> colorBox.getSpaceList().stream())
                .map(boxSpace -> boxSpace.getContent())
                .filter(c -> c != null)
                .map(c -> c.toString())
                .max(Comparator.comparingInt(String::length))
                .orElse(null);

        String answer = colorBoxList.stream()
                .flatMap(colorBox -> colorBox.getSpaceList().stream())
                .map(boxSpace -> boxSpace.getContent())
                .filter(c -> c != null)
                .map(c -> c.toString())
                .filter(str -> !str.equals(maxStr))
                .max(Comparator.comparingInt(String::length))
                .orElse(null);

        System.out.println("+++++++++Answer+++++++++");
        System.out.println("Max is " + maxStr);
        System.out.println("Second is " + answer);

    }

    /**
     * How many total lengths of strings in color-boxes? <br>
     * (カラーボックスに入ってる文字列の長さの合計は？)
     */
    public void test_length_calculateLengthSum() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();

        Integer answer = colorBoxList.stream()
                .map(colorBox -> colorBox.getSpaceList())
                .map(cont -> cont.toString().length())
                .reduce(0, Integer::sum);

        System.out.println("+++++++++Answer+++++++++");
        System.out.println("Sum is " + answer);

    }

    /**
     * Which color name has max length in color-boxes? <br>
     * (カラーボックスの中で、色の名前が一番長いものは？)
     */
    public void test_length_findMaxColorSize() {
        //        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        //        String answer = colorBoxList.stream()
        //                .map(colorBox -> colorBox.getColor().getColorName().toString())
        //                .max(Comparator.comparingInt(String::length))
        //                .orElse(null);
        //
        //        System.out.println("+++++++++Answer+++++++++");
        //        System.out.println(answer);

        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        Optional<String> optMax = colorBoxList.stream()
                .map(colorBox -> colorBox.getColor().getColorName().toString())
                .max(Comparator.comparingInt(String::length));

        if (optMax.isPresent()) {
            String answer = optMax.get();
            System.out.println("+++++++++Answer+++++++++");
            System.out.println(answer);
        } else {
            System.out.println("nothing");
        }

    }

    // ===================================================================================
    //                                                            startsWith(), endsWith()
    //                                                            ========================
    /**
     * What is color in the color-box that has string starting with "Water"? <br>
     * ("Water" で始まる文字列をしまっているカラーボックスの色は？)
     */
    public void test_startsWith_findFirstWord() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String answer = colorBoxList.stream()
                .filter(colorBox -> isStartWithWater(colorBox))
                .map(colorBox -> colorBox.getColor().getColorName())
                .collect(Collectors.joining());

        System.out.println("+++++++++Answer+++++++++");
        System.out.println(answer);

    }
    private boolean isStartWithWater(ColorBox colorBox) {
        for (BoxSpace boxSpace : colorBox.getSpaceList()) {
            if (boxSpace.getContent() instanceof String) {
                if (boxSpace.getContent().toString().startsWith("Water")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * What is color in the color-box that has string ending with "front"? <br>
     * ("front" で終わる文字列をしまっているカラーボックスの色は？)
     */
    public void test_endsWith_findLastWord() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String answer = colorBoxList.stream()
                .filter(colorBox -> isEndsWithfromt(colorBox))
                .map(colorBox -> colorBox.getColor().getColorName())
                .collect(Collectors.joining());

        System.out.println("+++++++++Answer+++++++++");
        System.out.println(answer);

    }
    private boolean isEndsWithfromt(ColorBox colorBox) {
        for (BoxSpace boxSpace : colorBox.getSpaceList()) {
            if (boxSpace.getContent() instanceof String) {
                if (boxSpace.getContent().toString().endsWith("front")) {
                    return true;
                }
            }
        }
        return false;
    }

    // ===================================================================================
    //                                                            indexOf(), lastIndexOf()
    //                                                            ========================
    /**
     * What number character is starting with first "front" of string ending with "front" in color-boxes? <br>
     * (カラーボックスに入ってる "front" で終わる文字列で、最初の "front" は何文字目から始まる？)
     */
    public void test_indexOf_findIndex() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        Optional<BoxSpace> optAnswer = colorBoxList.stream()
                .filter(colorBox -> isEndsWithfromt(colorBox))
                .flatMap(colorBox -> colorBox.getSpaceList().stream())
                .filter(cont -> cont.getContent().toString().endsWith("front"))
                .findAny();

        if (optAnswer.isPresent()) {
            String answer = optAnswer.get().getContent().toString();
            int indexOfFront = answer.indexOf("f");
            System.out.println("+++++++++Answer+++++++++");
            System.out.println(answer + " : " + indexOfFront);
        } else {
            System.out.println("Error");
        }

//        optAnswer.ifPresent(ans -> {
//            log(ans);
//        });


    }



    /**
     * What number character is starting with the late "ど" of string containing plural "ど"s in color-boxes? (e.g. "どんどん" => 3) <br>
     * (カラーボックスに入ってる「ど」を二つ以上含む文字列で、最後の「ど」は何文字目から始まる？ (e.g. "どんどん" => 3))
     */
    public void test_lastIndexOf_findIndex() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        char tar = 'ど';
        Optional<Integer> optAnswer = colorBoxList.stream()
                .filter(colorBox -> isContainCharTwice(colorBox, tar))
                .flatMap(colorBox -> colorBox.getSpaceList().stream())
                .map(boxSpace -> boxSpace.getContent().toString().lastIndexOf(tar))
                .findAny();

        optAnswer.ifPresent(answer -> System.out.println("The answer is ... " + answer));
        optAnswer.orElseThrow();
//        optAnswer.orElseGet();

    }
    private boolean isContainCharTwice(ColorBox colorBox, char target) {
            int firstTarget;
            int secondTarget;
        List<BoxSpace> spaceList = colorBox.getSpaceList();
        for (BoxSpace boxSpace : spaceList) {
            if (boxSpace.getContent() instanceof String) {
                firstTarget = boxSpace.getContent().toString().indexOf(target);
                secondTarget = boxSpace.getContent().toString().lastIndexOf(target);
                if (secondTarget - firstTarget > 0){
                    return true;
                }
            }
        }
        return false;
    }



    // ===================================================================================
    //                                                                         substring()
    //                                                                         ===========
    /**
     * What character is first of string ending with "front" in color-boxes? <br>
     * (カラーボックスに入ってる "front" で終わる文字列の最初の一文字は？)
     */
    public void test_substring_findFirstChar() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        Optional<BoxSpace> optAnswer = colorBoxList.stream()
                .filter(colorBox -> isEndsWithfromt(colorBox))
                .flatMap(colorBox -> colorBox.getSpaceList().stream())
                .filter(cont -> cont.getContent().toString().endsWith("front"))
                .findAny();

        if (optAnswer.isPresent()) {
            String answer = optAnswer.get().getContent().toString();
            char substringFirstChar = answer.charAt(0);
            System.out.println("+++++++++Answer+++++++++");
            System.out.println(answer + " : " + substringFirstChar);
        } else {
            System.out.println("Error");
        }
    }

    /**
     * What character is last of string starting with "Water" in color-boxes? <br>
     * (カラーボックスに入ってる "Water" で始まる文字列の最後の一文字は？)
     */
    public void test_substring_findLastChar() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        Optional<BoxSpace> optAnswer = colorBoxList.stream()
                .filter(colorBox -> isStartWithWater(colorBox))
                .flatMap(colorBox -> colorBox.getSpaceList().stream())
                .filter(cont -> cont.getContent().toString().startsWith("Water"))
                .findAny();

        if (optAnswer.isPresent()) {
            String answer = optAnswer.get().getContent().toString();
            String substringFirstChar = answer.substring(answer.length() - 1);
            System.out.println("+++++++++Answer+++++++++");
            System.out.println(answer + " : " + substringFirstChar);
        } else {
            System.out.println("Error");
        }

    }

    // ===================================================================================
    //                                                                           replace()
    //                                                                           =========
    /**
     * How many characters does string that contains "o" in color-boxes and removing "o" have? <br>
     * (カラーボックスに入ってる "o" (おー) を含んだ文字列から "o" を全て除去したら何文字？)
     */
    public void test_replace_remove_o() {

        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String target = "o";
        Optional<Integer> optAnswer = colorBoxList.stream()
                .flatMap(colorBox -> colorBox.getSpaceList().stream())
                .filter(boxSpace -> boxSpace.getContent() instanceof String)
                .filter(boxSpace -> boxSpace.getContent().toString().contains(target))
                .map(boxSpace -> boxSpace.getContent().toString().replace(target, ""))
                .map(str -> str.length())
                .findAny();

        if (optAnswer.isPresent()) {
            Integer answer = optAnswer.get();
            System.out.println("+++++++++Answer+++++++++");
            System.out.println("Answer is : " + answer);
        } else {
            System.out.println("Error");
        }

    }
//    private boolean isContain(ColorBox colorBox, char target) {
//        int firstTarget;
//        List<BoxSpace> spaceList = colorBox.getSpaceList();
//        for (BoxSpace boxSpace : spaceList) {
//            if (boxSpace.getContent() instanceof String) {
//                firstTarget = boxSpace.getContent().toString().indexOf(target);
//                if (firstTarget >= 0){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    /**
     * What string is path string of java.io.File in color-boxes, which is replaced with "/" to Windows file separator? <br>
     * カラーボックスに入ってる java.io.File のパス文字列のファイルセパレーターの "/" を、Windowsのファイルセパレーターに置き換えた文字列は？
     */
    public void test_replace_fileseparator() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String macSeparater = "/";
        String windowsSeparater = "\\";
        Optional<String> optFileSrting = colorBoxList.stream()
                .flatMap(colorBox -> colorBox.getSpaceList().stream())
//                .peek(boxSpace -> log(boxSpace))
                .filter(boxSpace -> boxSpace.getContent() instanceof File)
                .map(boxSpace -> ((File) boxSpace.getContent()).getPath().replace(macSeparater, windowsSeparater))
                .findAny();

        optFileSrting.ifPresent(str -> {
            System.out.println(str);
        });
    }

    // ===================================================================================
    //                                                                    Welcome to Devil
    //                                                                    ================
    /**
     * What is total length of text of DevilBox class in color-boxes? <br>
     * (カラーボックスの中に入っているDevilBoxクラスのtextの長さの合計は？)
     */
    public void test_welcomeToDevil() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        int sumTextLength = colorBoxList.stream()
                .flatMap(colorBox -> colorBox.getSpaceList().stream())
                .filter(boxSpace -> boxSpace.getContent() instanceof YourPrivateRoom.DevilBox)
                .peek(boxSpace -> {
                    YourPrivateRoom.DevilBox contentDevilBox = (YourPrivateRoom.DevilBox) boxSpace.getContent();
                    contentDevilBox.wakeUp();
                    contentDevilBox.allowMe();
                    contentDevilBox.open();
                })
                .filter(boxSpace -> boxSpace.getContent() != null)
                .filter(boxSpace -> hasText(boxSpace))
                .mapToInt(boxSpace -> boxSpace.getContent().toString().length())
                .sum();
        log("sum is : " + sumTextLength);
    }
    private boolean hasText(BoxSpace boxSpace) {
        try {
            ((YourPrivateRoom.DevilBox) boxSpace.getContent()).getText();
            return true;
        }catch (YourPrivateRoom.DevilBoxTextNotFoundException e){
            System.out.println(e);
            return false;
        }
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * What string is converted to style "map:{ key = value ; key = value ; ... }" from java.util.Map in color-boxes? <br>
     * (カラーボックスの中に入っている java.util.Map を "map:{ key = value ; key = value ; ... }" という形式で表示すると？)
     */
    public void test_showMap_flat() {
        // TODO yuki.komatsu 次回ここから (2019-06-13)
    }

    /**
     * What string is converted to style "map:{ key = value ; key = map:{ key = value ; ... } ; ... }" from java.util.Map in color-boxes? <br>
     * (カラーボックスの中に入っている java.util.Map を "map:{ key = value ; key = map:{ key = value ; ... } ; ... }" という形式で表示すると？)
     */
    public void test_showMap_nested() {
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    // has small #adjustmemts from ClassicStringTest
    //  o comment out because of too difficult to be stream?
    ///**
    // * What string of toString() is converted from text of SecretBox class in upper space on the "white" color-box to java.util.Map? <br>
    // * (whiteのカラーボックスのupperスペースに入っているSecretBoxクラスのtextをMapに変換してtoString()すると？)
    // */
    //public void test_parseMap_flat() {
    //}
    //
    ///**
    // * What string of toString() is converted from text of SecretBox class in both middle and lower spaces on the "white" color-box to java.util.Map? <br>
    // * (whiteのカラーボックスのmiddleおよびlowerスペースに入っているSecretBoxクラスのtextをMapに変換してtoString()すると？)
    // */
    //public void test_parseMap_nested() {
    //}
}
