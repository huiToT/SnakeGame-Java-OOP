package Entities;

public class SnakeObject extends controlClass {
    private int life;
    private int lengthOfSnake;
    private int[] snakeXlength;
    private int[] snakeYlength;

    public SnakeObject(){
        life = 3;
        lengthOfSnake = 3;
        snakeXlength = new int[750];
        snakeYlength = new int[750];



    }
    public int getLife() {

        return life;

    }
    public void setLife(int newLife) {

        life = newLife;

    }

    public int getSnakeLength() {

        return lengthOfSnake;
    }
    public void setSnakeLength(int length) {

        lengthOfSnake = length;
    }
    public int[] getSnakeArrayX() {

        return snakeXlength;

    }

    public int[] getSnakeArrayY() {

        return snakeYlength;

    }

    public void setInitialSnakePosition(int x0,int x1,int x2,int y0,int y1,int y2) { //this sets the first 3 body dots of snake( X 0,1,2 and Y 0,1,2 ) position for the snake body

        snakeXlength[0] = x0;
        snakeXlength[1] = x1;
        snakeXlength[2] = x2;

        snakeYlength[0] = y0;
        snakeYlength[1] = y1;
        snakeYlength[2] = y2;



    }
    public int getXYPosition(String axis,int index) {

        int tempPosition = 0;
        if(axis == "x") {

            if(index<snakeXlength.length) {

                tempPosition =  snakeXlength[index];

            }
        }
        else if(axis == "y") {

            if(index<snakeYlength.length) {

                tempPosition =  snakeYlength[index];

            }
        }

        return tempPosition;

    }
    public void setXYPosition(String axis,int index,int position) {

        if(axis == "x") {

            if(index<snakeXlength.length) {

                snakeXlength[index] = position;

            }
        }
        else if(axis == "y") {

            if(index<snakeYlength.length) {

                snakeYlength[index] = position;

            }
        }


    }
}