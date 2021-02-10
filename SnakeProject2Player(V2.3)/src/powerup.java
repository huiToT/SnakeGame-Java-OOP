import java.util.Random;

public class powerup{

    private String type;
    private int posX;
    private int posY;
    private int[] posXarray;
    private int[] posYarray;
    private Random random;
    private String picName;

    powerup(){

        random = new Random();

        posXarray = new int[]{25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325,
                350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650,
                675, 700, 725, 750, 775, 800, 825, 850};
        posYarray = new int[]{75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350,
                375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625};
        posX = posXarray[random.nextInt(34)];
        posY = posYarray[random.nextInt(23)];
        type = "apple";

    }
    public void powerupEffect(snakeObject affectedSnake){
        if(eatPowerup(affectedSnake)){

            int tempLength = affectedSnake.getSnakeLength();
            affectedSnake.setSnakeLength(tempLength+1);
            setPos();

        }
    }
    public void setType(String type){

        this.type = type;

    }
    public String getType(){

        return type;

    }
    public void setPos(){


        posX = posXarray[random.nextInt(34)];
        posY = posYarray[random.nextInt(23)];

    }
    public int getPosX(){

        return posX;

    }
    public int getPosY(){

        return posY;

    }
    public void setPicName(String picName){

        this.picName = picName;

    }
    public String getPicName(){

        return picName;

    }
    public boolean eatPowerup(snakeObject affectedSnake){

        int tempX = getPosX();
        int tempY = getPosY();
        if(tempX == affectedSnake.getXYPosition("x",0) && tempY == affectedSnake.getXYPosition("y",0)){

            return true;
        }

        return false;

    }


}

class apple extends powerup{

    apple(){

        setType("apple");
        setPicName("apple.png");


    }
    public void powerupEffect(snakeObject affectedSnake){


        if(eatPowerup(affectedSnake)){

            int tempLength = affectedSnake.getSnakeLength();
            affectedSnake.setSnakeLength(tempLength+1);
            setPos();

        }


    }
}

class muscle extends powerup{

    void muscle(){

        setType("muscle");
        setPicName("muscle.png");


    }
    public void powerupEffect(snakeObject affectedSnake){


        if(eatPowerup(affectedSnake)){

            int tempLength = affectedSnake.getSnakeLength();
            affectedSnake.setSnakeLength(tempLength+2);
            setPos();

        }


    }
}

class poison extends powerup{

    void poison(){

        setType("poison");
        setPicName("poison.png");


    }
    public void powerupEffect(snakeObject affectedSnake){

        System.out.println("checking if the apple is eaten");
        if(eatPowerup(affectedSnake)){
            System.out.println("the snake ate the apple");
            int tempLength = affectedSnake.getSnakeLength();
            affectedSnake.setSnakeLength(tempLength-1);
            setPos();

        }


    }
}