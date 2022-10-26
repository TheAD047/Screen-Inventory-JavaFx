package com.screen.assignment2.Models;

/**Name: Arin Dhiman
 * Description: This class is built for aspect ratio attribute in Computer Screen class, this can be used multiple times since aspect ratios
 *              are very often common amongst a majority of screens unlike resolution
 * */

public class AspectRatio
{
    /**
     * Two attributes for aspect ratio
     */
    private int ID;
    private int horizontal;
    private int vertical;

    /**
     * Constructor with the following
     * @param horizontal
     * @param vertical
     */
    public AspectRatio(int ID, int horizontal, int vertical)
    {
        setID(ID);
        setHorizontal(horizontal);
        setVertical(vertical);
    }

    /**
     * get methods for each attribute
     */
    public int getHorizontal() {
        return horizontal;
    }
    public int getVertical() {
        return vertical;
    }
    public int getID(){return ID;}

    /**
     * Set methods for each attribute with verification
     */
    public void setHorizontal(int $horizontal) {
        if ($horizontal >= 1) {
            horizontal = $horizontal;
        }
        else{
            throw new IllegalArgumentException("The horizontal component cant be less than 1...");
        }
    }
    public void setVertical(int $vertical) {
        if($vertical>= 1) {
            vertical = $vertical;
        }
        else{
            throw new IllegalArgumentException("The vertical component cant be less than 1...");
        }
    }
    public void setID(int ID) {
        if(ID >= 1) {
            this.ID = ID;
        }
        else {
            throw new IllegalArgumentException("ID cant be less than 1...");
        }
    }

    /**
     * ToString method for special string representation for aspect ratio object
     */
    @Override
    public String toString(){
        return horizontal + " : " + vertical;
    }


}
