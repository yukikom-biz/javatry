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

import static org.docksidestage.bizfw.colorbox.yours.YourPrivateRoom.*;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.lang.model.type.NullType;

import org.docksidestage.bizfw.colorbox.ColorBox;
import org.docksidestage.bizfw.colorbox.color.BoxColor;
import org.docksidestage.bizfw.colorbox.space.BoxSpace;
import org.docksidestage.bizfw.colorbox.yours.YourPrivateRoom;
import org.docksidestage.unit.PlainTestCase;

/**
 * The test of String with color-box, not using Stream API. <br>
 * Show answer by log() for question of javadoc. <br>
 * <pre>
 * addition:
 * o e.g. "string in color-boxes" means String-type content in space of color-box
 * o don't fix the YourPrivateRoom class and color-box classes
 * </pre>
 * @author jflute
 * @author yukikoma
 */
public class Step11ClassicStringTest extends PlainTestCase {

    // ===================================================================================
    //                                                                            length()
    //                                                                            ========
    /**
     * How many lengths does color name of first color-boxes have? <br>
     * (最初のカラーボックスの色の名前の文字数は？)
     */

    public void test_length_basic() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        ColorBox colorBox = colorBoxList.get(0);
        BoxColor boxColor = colorBox.getColor();
        String colorName = boxColor.getColorName();
        int answer = colorName.length();
        log(answer, colorName); // also show name for visual check
    }

    /**
     * Which string has max length in color-boxes? <br>
     * (カラーボックスに入ってる文字列の中で、一番長い文字列は？)
     */
    public void test_length_findMax() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        int maxLength = 0;
        String maxContent;
        for (ColorBox colorBox : colorBoxList) {
            //            BoxSize boxSize = colorBox.getSize();
            //            BoxSize boxSize = colorBox.getSize();
            List<BoxSpace> colorBoxSpaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : colorBoxSpaceList) {
                Object boxText = boxSpace.getContent();
                int tmp_length = boxText.toString().length();
                String tmp_Content = boxText.toString();
                if (tmp_length < maxLength) {
                    maxLength = tmp_length;
                    maxContent = tmp_Content;
                }
            }
            //            for (int i = 0; i <= boxSize ; i++) {
            //                Object content = colorBox.getSpaceList().get(i).getContent();
            //            }

        }
        // how to solve class problem maxContent.var
        //        return maxContent;
        //        for (ColorBox colorBox : colorBoxList) {
        //            for (int i = 0; i <= 2; i++) {
        ////                String current_item = colorBox.getSpaceList().get(i);
        ////                current_item;
        //            }
        //        }
        //        String maxStr = null;
        //        for (ColorBox colorBox : colorBoxList) {
        //            List<BoxSpace> spaceList = colorBox.getSpaceList();
        //            for (BoxSpace space : spaceList) {
        //                Object content = space.getContent();
        //
        //            }
        //
        //        }
        //test commit form intellJ
    }

    /**
     * How many characters are difference between max and min length of string in color-boxes? <br>
     * (カラーボックスに入ってる文字列の中で、一番長いものと短いものの差は何文字？)
     */
    public void test_length_findMaxMinDiff() {
        //done in class
    }

    /**
     * Which value (toString() if non-string) has second-max legnth in color-boxes? (without sort)<br>
     * (カラーボックスに入ってる値 (文字列以外はtoString()) の中で、二番目に長い文字列は？ (ソートなしで))
     */
    public void test_length_findSecondMax() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        //        Collections.reverse(); //if reveres this list ?
        //done in class

    }

    /**
     * How many total lengths of strings in color-boxes? <br>
     * (カラーボックスに入ってる文字列の長さの合計は？)
     */
    public void test_length_calculateLengthSum() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        //done in class
    }

    /**
     * Which color name has max length in color-boxes? <br>
     * (カラーボックスの中で、色の名前が一番長いものは？)
     */
    public void test_length_findMaxColorSize() {
        //Declaration
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        int maxLength = 0;
        String maxColorName = "";

        for (ColorBox colorBox : colorBoxList) {

            BoxColor boxColor = colorBox.getColor();
            String colorName = boxColor.toString();
            int tmp_length = colorName.length();

            if (tmp_length > maxLength) {
                maxLength = tmp_length;
                maxColorName = colorName;
            }

        }
        log(maxLength != 0 ? maxColorName : "There is no Name");
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
        int match_name_exist = 0;
        String tmpContent = "";
        //        String tmpContent;
        for (ColorBox colorBox : colorBoxList) {

            BoxColor boxColor = colorBox.getColor();
            String colorName = boxColor.toString();

            List<BoxSpace> colorBoxSpaceList = colorBox.getSpaceList();

            //            outerloop:for (BoxSpace boxSpace : colorBoxSpaceList) {
            //            outerloop:
            for (BoxSpace boxSpace : colorBoxSpaceList) {
                Object boxText = boxSpace.getContent();
                //                boxText != null ? tmpContent = boxText.toString():;

                //                if (boxText != null) {
                //                    tmpContent = boxText.toString();
                //                }
                if (boxText != null)
                    tmpContent = boxText.toString();

                if (tmpContent.startsWith("Water")) {
                    log(colorName);
                    match_name_exist += 1;
                }
                //                break outerloop;
            }
            if (match_name_exist == 0) {
                log("There is no name to match");
            }

        }
        log("Sum: " + match_name_exist);
    }

    /**
     * What is color in the color-box that has string ending with "front"? <br>
     * ("front" で終わる文字列をしまっているカラーボックスの色は？)
     */
    public void test_endsWith_findLastWord() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        //done in class

        int match_name_exist = 0;
        for (ColorBox colorBox : colorBoxList) {

            BoxColor boxColor = colorBox.getColor();
            String colorName = boxColor.toString();

            if (colorName.endsWith("front")) {
                log(colorName);
                match_name_exist += 1;
            }
            if (match_name_exist == 0) {
                log("There is no name to match");
            }

        }
        log("Sum: " + match_name_exist);

    }

    // ===================================================================================
    //                                                            indexOf(), lastIndexOf()
    //                                                            ========================
    /**
     * What number character is starting with "front" of string ending with "front" in color-boxes? <br>
     * (あなたのカラーボックスに入ってる "front" で終わる文字列で、"front" は何文字目から始まる？)
     */
    public void test_indexOf_findIndex() {
        //done in class
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
    }

    /**
     * What number character is starting with the late "ど" of string containing plural "ど"s in color-boxes? (e.g. "どんどん" => 3) <br>
     * (あなたのカラーボックスに入ってる「ど」を二つ以上含む文字列で、最後の「ど」は何文字目から始まる？ (e.g. "どんどん" => 3))
     */
    public void test_lastIndexOf_findIndex() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        int match_name_count = 0;
        String targetText = "";
        for (ColorBox colorBox : colorBoxList) {
            List<BoxSpace> colorBoxSpaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : colorBoxSpaceList) {
                Object boxContent = boxSpace.getContent();
                if (boxContent != null)
                    targetText = boxContent.toString();
                if (targetText.lastIndexOf("ど") - targetText.indexOf("ど") > 0) {
                    int indexNumber = targetText.lastIndexOf("ど") + 1;
                    match_name_count += 1;
                    log(targetText, indexNumber);
                    //                    log(colorBox.getColor());
                }
            }
        }
        if (match_name_count == 0) {
            log("Nothing to match");
        } else {
            log(match_name_count + " is matched");
        }
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
        int match_name_count = 0;
        String target = "";
        for (ColorBox colorBox : colorBoxList) {
            List<BoxSpace> colorBoxSpaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : colorBoxSpaceList) {
                Object boxContent = boxSpace.getContent();
                if (boxContent != null)
                    target = boxContent.toString();
                if (target.endsWith("front")) {
                    char FirstChar = target.charAt(0);
                    match_name_count += 1;
                    log(target, FirstChar);
                }
            }
        }
        if (match_name_count == 0)
            log("Nothing to match");
    }

    /**
     * What character is last of string starting with "Water" in color-boxes? <br>
     * (カラーボックスに入ってる "Water" で始まる文字列の最後の一文字は？)
     */
    public void test_substring_findLastChar() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        int match_name_count = 0;
        String target = "";
        for (ColorBox colorBox : colorBoxList) {
            List<BoxSpace> colorBoxSpaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : colorBoxSpaceList) {
                Object boxContent = boxSpace.getContent();
                if (boxContent != null)
                    target = boxContent.toString();
                if (target.startsWith("Water")) {
                    int lengthOfContent = target.length();
                    char FirstChar = target.charAt(lengthOfContent - 1);
                    match_name_count += 1;
                    log(target, FirstChar);
                }
            }
        }
        if (match_name_count == 0)
            log("Nothing to match");
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
        //done in class
        //content instanceof String = String or not
    }

    /**
     * What string is path string of java.io.File in color-boxes, which is replaced with "/" to Windows file separator? <br>
     * カラーボックスに入ってる java.io.File のパス文字列のファイルセパレーターの "/" を、Windowsのファイルセパレーターに置き換えた文字列は？
     */
    public void test_replace_fileseparator() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        //done in class
        int match_name_count = 0;
        for (ColorBox colorBox : colorBoxList) {
            List<BoxSpace> colorBoxSpaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : colorBoxSpaceList) {
                Object boxContent = boxSpace.getContent();
                if (boxContent instanceof File) {
                    String targetPath = ((File) boxContent).getPath();
                    match_name_count += 1;
                    String replacedPath = targetPath.replace("/", "\\");
                    log("From: " + targetPath);
                    log("Re: " + replacedPath);
                }
            }
        }
        if (match_name_count == 0)
            log("Nothing to match");
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
        //done in class
        int matchCount = 0;
        int sumTextLength = 0;
        String devilText = "";
        //        Class<? extends List> aClass = colorBoxList.getClass();
        //        log(aClass);
        for (ColorBox colorBox : colorBoxList) {
            if (colorBox instanceof DevilBox)
                log("colorBox");
            List<BoxSpace> colorBoxSpaceList = colorBox.getSpaceList();
            if (colorBoxSpaceList instanceof DevilBox)
                log("SpaceLIst");
            for (BoxSpace boxSpace : colorBoxSpaceList) {
                Object tmpContent = boxSpace.getContent();
                if (tmpContent instanceof DevilBox) {
                    log("as Devil");
                    //                    String devilText = ((DevilBox) tmpContent).wakeUp();
                    ((DevilBox) tmpContent).wakeUp();
                    ((DevilBox) tmpContent).allowMe();
                    ((DevilBox) tmpContent).open();
                    try {
                        if (((DevilBox) tmpContent).getText() != null) {
                            devilText = ((DevilBox) tmpContent).getText();
                        }
                    }catch (DevilBoxTextNotFoundException ignored){

                    }
                    if (!devilText.equals("")){
                        sumTextLength += devilText.length();
                        matchCount +=1;
                    }
                }
                //                if (boxSpace instanceof DevilBox)
                //                    log("boxSpace");
            }
        }
        //            if(colorBox instanceof DevilBox)
        //
        //                Object boxContent = boxSpace.getContent();
        //                if(boxContent instanceof DevilBox){
        //                    Class<?> aClass = boxContent.getClass();
        //                    log(aClass);
        //                }
        //                //                Class<?> devilBoxClass = boxContent.getClass(DevilBox);
        ////                String string = devilBoxClass.toString();
        ////                log(string);
        //
        //            }

        if (matchCount == 0){
            log("Nothing to match");
        }else {
            log("Sum is {}",sumTextLength);
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
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        List<String> keys = null;
        for (ColorBox colorBox : colorBoxList) {
            List<BoxSpace> spaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : spaceList) {
                if (boxSpace.getContent() instanceof java.util.Map) {
//                    ((Map) boxSpace.getContent()).keySet().forEach(key -> keys.add(key));
                    for (Object key : ((Map) boxSpace.getContent()).keySet()) {
                        keys.add(key.toString());
                    }
                    for (String key : keys) {
                        System.out.println(key + ":" + ((Map) boxSpace.getContent()).get(key));
                    }
                }
            }
        }
        System.out.println("+++++++++Answer+++++++++");
    }

    /**
     * What string is converted to style "map:{ key = value ; key = map:{ key = value ; ... } ; ... }" from java.util.Map in color-boxes? <br>
     * (カラーボックスの中に入っている java.util.Map を "map:{ key = value ; key = map:{ key = value ; ... } ; ... }" という形式で表示すると？)
     */
    public void test_showMap_nested() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        // TODO yuki.komatsu  (2019-05-30)
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * What string of toString() is converted from text of SecretBox class in upper space on the "white" color-box to java.util.Map? <br>
     * (whiteのカラーボックスのupperスペースに入っているSecretBoxクラスのtextをMapに変換してtoString()すると？)
     */
    public void test_parseMap_flat() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        // TODO yuki.komatsu  (2019-05-30)
    }

    /**
     * What string of toString() is converted from text of SecretBox class in both middle and lower spaces on the "white" color-box to java.util.Map? <br>
     * (whiteのカラーボックスのmiddleおよびlowerスペースに入っているSecretBoxクラスのtextをMapに変換してtoString()すると？)
     */
    public void test_parseMap_nested() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        // TODO yuki.komatsu  (2019-05-30)
    }
}
