package com.screen.assignment2;

/**Name: Arin Dhiman
 * Student no.: 2004897090
 * Date: 07/04/2022 Sat
 * Description: This class is built for aspect ratio attribute in Computer Screen class, this can be used multiple times since aspect ratios
 *              are very often common amongst a majority of screens unlike resolution
 * */

public class AspectRatio
{
    /**
     * Two attributes for aspect ratio
     */
    private int horizontal;
    private int vertical;

    /**
     * Constructor with the following
     * @param $horizontal
     * @param $vertical
     */
    public AspectRatio(int $horizontal, int $vertical)
    {
        setHorizontal($horizontal);
        setVertical($vertical);
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

    /**
     * ToString method for special string representation for aspect ratio object
     */
    public String ToString(){
        return horizontal + " : " + vertical;
    }


}
