package com.company;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class MineSweeperImpl implements MineSweeper {
    private final List allowedCharacters = Arrays.asList('.', '*');
    private final char bomb = '*';
    private String mineField;
    private int horizontalSize;
    private int verticalSize;

    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {
        checkForCorrectCharacters(mineField);
        correctNumberOfNewLines(mineField);
        this.mineField = mineField;
        horizontalSize = mineField.indexOf("\n");
        verticalSize = StringUtils.countMatches(mineField, "\n") + 1;
    }

    private boolean correctNumberOfNewLines(String str) {
        String[] split = str.split("\n");
        final int numberOfCharsInRow = split[0].length();
        for (String s : split) {
            if (s.length() != numberOfCharsInRow)
                throw new IllegalArgumentException("Wrong number of characters in row " + s);
        }
        return true;
    }

    private void checkForCorrectCharacters(String str) {
        str = removeNewLineCharacters(str);
        for (char c : str.toCharArray()) {
            if (!allowedCharacters.contains(c))
                throw new IllegalArgumentException("Excepted " + allowedCharacters + " got " + c);
        }

    }

    private String removeNewLineCharacters(String str) {
        return str.replace("\n", "");
    }

    @Override
    public String getHintField() throws IllegalStateException {
        if(mineField == null) throw new IllegalStateException("Mine-field has not been initialised");
        String mineFieldWithoutNewLines = removeNewLineCharacters(mineField);
        List<Integer> increasedValueFields = new ArrayList<>();
        List<Integer> indexesOfBombs = calculateBombsIndexes(mineFieldWithoutNewLines);
        for (Integer i : indexesOfBombs) {
            increasedValueFields.addAll(calculateFieldsWithIncreasedValue(i));
        }
        Map<Integer, Integer> fieldValueMap = convertToMap(increasedValueFields);


        return prepareOutput(fieldValueMap, indexesOfBombs);
    }

    public List<Integer> calculateBombsIndexes(String mineField) {
        List<Integer> indexesOfBombs = new ArrayList<>();
        int index = mineField.indexOf(bomb);
        while (index >= 0) {
            indexesOfBombs.add(index);
            index = mineField.indexOf(bomb, index + 1);
        }
        return indexesOfBombs;
    }

    private List<Integer> calculateFieldsWithIncreasedValue(int fieldIndex) {
        List<Integer> fieldsToIncrease = new ArrayList<>();
        boolean ignoreLeftSide = false;
        boolean ignoreRightSide = false;
        if (fieldIndex % horizontalSize == 0) {
            ignoreLeftSide = true;
        }
        if (fieldIndex % horizontalSize == horizontalSize - 1) {
            ignoreRightSide = true;
        }
        int maxIndex = horizontalSize * verticalSize;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                switch (j) {
                    case -1:
                        if (fieldIndex - j + horizontalSize * i >= 0 && fieldIndex - j + horizontalSize * i < maxIndex && !ignoreRightSide) {
                            fieldsToIncrease.add(fieldIndex - j + horizontalSize * i);

                        }
                        break;
                    case 0:
                        if (fieldIndex - j + horizontalSize * i >= 0 && fieldIndex - j + horizontalSize * i < maxIndex) {
                            fieldsToIncrease.add(fieldIndex - j + horizontalSize * i);

                        }
                        break;
                    case 1:
                        if (fieldIndex - j + horizontalSize * i >= 0 && fieldIndex - j + horizontalSize * i < maxIndex && !ignoreLeftSide) {
                            fieldsToIncrease.add(fieldIndex - j + horizontalSize * i);

                        }
                        break;
                }

            }
        }

        return fieldsToIncrease;
    }

    private Map<Integer, Integer> convertToMap(List<Integer> increasedValueFields) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : increasedValueFields) {
            if (map.containsKey(i)) {
                Integer integer = map.get(i);
                map.replace(i, ++integer);
            } else map.put(i, 1);
        }
        return map;
    }

    private String prepareOutput(Map<Integer, Integer> fieldsWithValue, List<Integer> bombsIndexes) {
        char[] mineFields = new char[removeNewLineCharacters(mineField).length()];
        Arrays.fill(mineFields, '0');
        fieldsWithValue.forEach((k, v) -> mineFields[k] = Character.forDigit(v, 10));
        for (int bombIndex : bombsIndexes) {
            mineFields[bombIndex] = bomb;
        }
        return addNewLines(String.valueOf(mineFields));
    }

    private String addNewLines(String mineField) {
        String newLine = "\n";
        StringBuilder sb = new StringBuilder(mineField);
        for (int i = 1, j = 0; i < verticalSize; i++, j++) {
            sb.insert(horizontalSize * i + j, newLine);
        }
        return sb.toString();
    }
}
