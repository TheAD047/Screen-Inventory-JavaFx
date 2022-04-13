package com.screen.assignment2;

public class AspectRatio
{
    private int horizontal;
    private int vertical;

    public AspectRatio(int $horizontal, int $vertical)
    {
        setHorizontal($horizontal);
        setVertical($vertical);
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

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

    public String ToString(){
        return horizontal + " : " + vertical;
    }


}
