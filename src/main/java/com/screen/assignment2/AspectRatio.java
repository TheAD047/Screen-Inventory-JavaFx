package com.screen.assignment2;

public class AspectRatio
{
    private int horizontal;
    private int vertical;

    public AspectRatio(int horizontal, int vertical)
    {
        setHorizontal(this.horizontal);
        setVertical(this.vertical);
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public void setHorizontal(int horizontal) {
        if (this.horizontal >= 1) {
            this.horizontal = horizontal;
        }
        else{
            throw new IllegalArgumentException("The horizontal component cant be less than 1...");
        }
    }

    public void setVertical(int vertical) {
        if(this.vertical >= 1) {
            this.vertical = vertical;
        }
        else{
            throw new IllegalArgumentException("The vertical component cant be less than 1...");
        }
    }

    public String ToString(){
        return horizontal + " : " + vertical;
    }
}
