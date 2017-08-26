package com.tictactoeproject.model;

import com.tictactoeproject.R;

import java.util.ArrayList;

public class WinnerChecker {

    //possible win combinations
    private ArrayList<Integer> comb1;
    private ArrayList<Integer> comb2;
    private ArrayList<Integer> comb3;
    private ArrayList<Integer> comb4;
    private ArrayList<Integer> comb5;
    private ArrayList<Integer> comb6;
    private ArrayList<Integer> comb7;
    private ArrayList<Integer> comb8;


    private ArrayList<Integer> playerOneChecked;
    private ArrayList<Integer> playerTwoChecked;
    private int clickCounter = 0;
    private boolean someOneWon = false;

    public WinnerChecker() {
        resetModel();
    }

    public void resetModel(){
        clickCounter = 0;
        someOneWon = false;
        playerOneChecked = new ArrayList<>();
        playerTwoChecked = new ArrayList<>();

        comb1 = new ArrayList<>();
        comb2 = new ArrayList<>();
        comb3 = new ArrayList<>();
        comb4 = new ArrayList<>();
        comb5 = new ArrayList<>();
        comb6 = new ArrayList<>();
        comb7 = new ArrayList<>();
        comb8 = new ArrayList<>();

        comb1.add(R.id.img_0_0);
        comb1.add(R.id.img_0_1);
        comb1.add(R.id.img_0_2);

        comb2.add(R.id.img_0_0);
        comb2.add(R.id.img_1_0);
        comb2.add(R.id.img_2_0);

        comb3.add(R.id.img_2_0);
        comb3.add(R.id.img_2_1);
        comb3.add(R.id.img_2_2);

        comb4.add(R.id.img_0_2);
        comb4.add(R.id.img_1_2);
        comb4.add(R.id.img_2_2);

        comb5.add(R.id.img_0_1);
        comb5.add(R.id.img_1_1);
        comb5.add(R.id.img_2_1);

        comb6.add(R.id.img_1_0);
        comb6.add(R.id.img_1_1);
        comb6.add(R.id.img_1_2);

        comb7.add(R.id.img_0_0);
        comb7.add(R.id.img_1_1);
        comb7.add(R.id.img_2_2);

        comb8.add(R.id.img_0_2);
        comb8.add(R.id.img_1_1);
        comb8.add(R.id.img_2_0);
    }

    public boolean isTheGameDone(boolean isPlayerOne, int viewId) {
        clickCounter++;
        if (isPlayerOne) {
            playerOneChecked.add(viewId);
        } else {
            playerTwoChecked.add(viewId);
        }
        //no one can win in less then five clicks, no need to check
        if (clickCounter < 5) {
            return false;
        }

        //do the check
        if (isPlayerOne) {
            combinationIterator(playerOneChecked);
        } else {
            combinationIterator(playerTwoChecked);
        }

        return someOneWon;
    }

    private void combinationIterator(ArrayList<Integer> playerChecked) {
        int counter = 0;

        for (int i : comb1) {
            if (playerChecked.contains(i)) {
                counter++;
                if (counter == 3) {
                    someOneWon = true;
                    break;
                }
            }
        }

        if (someOneWon) {
            return;
        }

        counter = 0;

        for (int i : comb2) {
            if (playerChecked.contains(i)) {
                counter++;
                if (counter == 3) {
                    someOneWon = true;
                    break;
                }
            }
        }

        if (someOneWon) {
            return;
        }

        counter = 0;

        for (int i : comb3) {
            if (playerChecked.contains(i)) {
                counter++;
                if (counter == 3) {
                    someOneWon = true;
                    break;
                }
            }
        }

        if (someOneWon) {
            return;
        }

        counter = 0;

        for (int i : comb4) {
            if (playerChecked.contains(i)) {
                counter++;
                if (counter == 3) {
                    someOneWon = true;
                    break;
                }
            }
        }

        if (someOneWon) {
            return;
        }

        counter = 0;

        for (int i : comb5) {
            if (playerChecked.contains(i)) {
                counter++;
                if (counter == 3) {
                    someOneWon = true;
                    break;
                }
            }
        }

        if (someOneWon) {
            return;
        }

        counter = 0;

        for (int i : comb6) {
            if (playerChecked.contains(i)) {
                counter++;
                if (counter == 3) {
                    someOneWon = true;
                    break;
                }
            }
        }

        if (someOneWon) {
            return;
        }

        counter = 0;

        for (int i : comb7) {
            if (playerChecked.contains(i)) {
                counter++;
                if (counter == 3) {
                    someOneWon = true;
                    break;
                }
            }
        }

        if (someOneWon) {
            return;
        }

        counter = 0;

        for (int i : comb8) {
            if (playerChecked.contains(i)) {
                counter++;
                if (counter == 3) {
                    someOneWon = true;
                    break;
                }
            }
        }
    }

}
