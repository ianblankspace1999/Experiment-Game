package com.example.ianblanco.experimentgame;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;

import java.util.ArrayList;
import java.util.Random;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga
 *
 * @author Nicolas Gramlich
 * @since 11:54:51 - 03.04.2010
 */
public class GameActivity extends GameExtension {






    final int gameObjectLoop = 40;
    ArrayList<Ball> balls = new ArrayList<>();
    ArrayList<Ball> ballsCatch = new ArrayList<>();
    ArrayList<PhysicsHandler> arrPhysicsHandler = new ArrayList<>();
    ArrayList<AnimatedSprite> arrBallDisplay = new ArrayList<>();
    public static AnimatedSprite ballBox;
    private AnimatedSprite ballDisplay;
    private PhysicsHandler mPhysicsHandler;



    @Override
    public Scene onCreateScene() {
        super.onCreateScene();

        float centerX;
        float centerY;

        ballBox = new AnimatedSprite(CAMERA_WIDTH / 2 - mBitmapTextureAtlasBox.getWidth() / 2, CAMERA_HEIGHT / 2 - mBitmapTextureAtlasBox.getHeight() / 2 - 55, this.mBoxTextureRegion, this.getVertexBufferObjectManager());

        for(int i = 0; i < 6; ++i) {
            ballDisplay = new AnimatedSprite(CAMERA_WIDTH / 8 * i + 220 - mBitmapTextureAtlas.getWidth() / 8, ballBox.getY() + ballBox.getHeight() + ballBox.getHeight() / 8, this.mDisplayTextureRegion, this.getVertexBufferObjectManager());
        arrBallDisplay.add(ballDisplay);
        ballDisplay.setCurrentTileIndex(41);
        ballDisplay.setScale(3f);
        scene.attachChild(ballDisplay);
        }
        scene.attachChild(ballBox);

        ArrayList<Float> randomWidths = new ArrayList<>();
        ArrayList<Float> randomHeights = new ArrayList<>();


        for (int i = 0; i < gameObjectLoop; ++i) {


            float randomWidth = new Random().nextInt(CAMERA_WIDTH / 2 - 270) + 270;
            float randomHeight = new Random().nextInt(CAMERA_HEIGHT / 2 - 480) + 480;


            centerX = (randomWidth - this.mFaceTextureRegion.getWidth()) / 2;
            centerY = (randomHeight - this.mFaceTextureRegion.getHeight()) / 2;
            final Ball ball = new Ball(centerX, centerY, this.mFaceTextureRegion, this.getVertexBufferObjectManager(), i);
            balls.add(ball);
            scene.attachChild(ball);
            randomWidths.add(randomWidth);
            randomHeights.add(randomHeight);

        }

        for (int i = 0; i < 6; ++i) {
            final Ball ball = new Ball(ballBox.getX() + ballBox.getWidth() / 2, ballBox.getY() + ballBox.getHeight() / 3, mFaceTextureRegion, getVertexBufferObjectManager(), i, false);
            scene.attachChild(ball);
            ballsCatch.add(ball);
            ball.setVisible(false);
            mPhysicsHandler = new PhysicsHandler(ballsCatch.get(i));
            ballsCatch.get(i).registerUpdateHandler(mPhysicsHandler);
            arrPhysicsHandler.add(mPhysicsHandler);
            ball.setX(ballBox.getX() + ballBox.getWidth() / 2);
            ball.setY(ballBox.getY() + ballBox.getHeight() / 2);
        }

        ballFunction();

        return scene;
    }


    private void ballFunction() {
        mEngine.registerUpdateHandler(new IUpdateHandler() {


            @Override
            public void onUpdate(float pSecondsElapsed) {

                for(int s = 0; s < balls.size(); s++){
                    if(line1.collidesWith(balls.get(s))){
                        if(!mMusic.isPlaying()){
                            mMusic.play();
                        }
                    }
                }

                switch (catchTurn) {
                    case FIRST:
                        scene.detachChild(balls.get(0));
                        ballsCatch.get(0).setVisible(true);

                        arrPhysicsHandler.get(0).setVelocityY(-600);
                    if (ballBox.getY() > ballsCatch.get(0).getY()) {
                        arrPhysicsHandler.get(0).setVelocityY(0);
                        scene.detachChild(ballsCatch.get(0));
                        arrBallDisplay.get(0).setCurrentTileIndex(0);
                    }

                        break;

                    case SECOND:
                        scene.detachChild(balls.get(1));
                        ballsCatch.get(1).setVisible(true);
                        arrPhysicsHandler.get(1).setVelocityY(-600);
                        if (ballBox.getY()  > ballsCatch.get(1).getY()) {
                            arrPhysicsHandler.get(1).setVelocityY(0);
                            scene.detachChild(ballsCatch.get(1));
                            arrBallDisplay.get(1).setCurrentTileIndex(1);
                        }

                        break;

                    case THIRD:
                        scene.detachChild(balls.get(1));
                        ballsCatch.get(2).setVisible(true);
                        arrPhysicsHandler.get(2).setVelocityY(-600);
                        if (ballBox.getY()  > ballsCatch.get(2).getY()) {
                            arrPhysicsHandler.get(2).setVelocityY(0);
                            scene.detachChild(ballsCatch.get(2));
                            arrBallDisplay.get(2).setCurrentTileIndex(2);
                        }
                        break;

                    case FOURTH:
                        scene.detachChild(balls.get(2));
                        ballsCatch.get(3).setVisible(true);
                        arrPhysicsHandler.get(3).setVelocityY(-600);
                        if (ballBox.getY()  > ballsCatch.get(3).getY()) {
                            arrPhysicsHandler.get(3).setVelocityY(0);
                            scene.detachChild(ballsCatch.get(3));
                            arrBallDisplay.get(3).setCurrentTileIndex(3);
                        }
                        break;

                    case FIFTH:
                        scene.detachChild(balls.get(3));
                        ballsCatch.get(4).setVisible(true);
                        arrPhysicsHandler.get(4).setVelocityY(-600);
                        if (ballBox.getY()  > ballsCatch.get(4).getY()) {
                            arrPhysicsHandler.get(4).setVelocityY(0);
                            scene.detachChild(ballsCatch.get(4));
                            arrBallDisplay.get(4).setCurrentTileIndex(4);
                        }
                        break;

                    case SIXTH:
                        scene.detachChild(balls.get(4));
                        ballsCatch.get(5).setVisible(true);
                        arrPhysicsHandler.get(5).setVelocityY(-600);
                        if (ballBox.getY()  > ballsCatch.get(5).getY()) {
                            arrPhysicsHandler.get(5).setVelocityY(0);
                            scene.detachChild(ballsCatch.get(5));
                            arrBallDisplay.get(5).setCurrentTileIndex(5);
                        }
                        break;
                }
            }

            @Override
            public void reset() {

            }
        });

    }


}
