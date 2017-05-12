package com.example.ianblanco.experimentgame.model;

/**
 * Created by IanBlanco on 10/11/2016.
 */

public class DirectionResult {

    private float directionX;
    private float directionY;

    public DirectionResult(float directionX, float directionY) {
        this.directionX = directionX;
        this.directionY = directionY;
    }

    public float getDirectionX() {
        return directionX;
    }

    public void setDirectionX(float directionX) {
        this.directionX = directionX;
    }

    public float getDirectionY() {
        return directionY;
    }

    public void setDirectionY(float directionY) {
        this.directionY = directionY;
    }
}
