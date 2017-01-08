package com.company;

public class Main {

    public static void main(String[] args) {
        MineSweeperImpl mineSweeper = new MineSweeperImpl();
        mineSweeper.setMineField("**..\n....\n....");
        System.out.println(mineSweeper.getHintField());

    }
}
