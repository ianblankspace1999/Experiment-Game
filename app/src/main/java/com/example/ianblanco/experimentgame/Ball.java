package com.example.ianblanco.experimentgame;



import com.example.ianblanco.experimentgame.model.DirectionResult;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import java.util.Random;

public class Ball extends AnimatedSprite {
    private float DEMO_VELOCITY = 1000.0f;
    private static final int CAMERA_WIDTH = 1080;
    private static final int CAMERA_HEIGHT = 1920;
    private final PhysicsHandler mPhysicsHandler;
    private boolean rambleBall = true;

    public Ball(final float pX, final float pY, final TiledTextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager, int currentTile) {
        super(pX, pY, pTextureRegion, pVertexBufferObjectManager);
        this.mPhysicsHandler = new PhysicsHandler(this);
        this.registerUpdateHandler(this.mPhysicsHandler);
        this.setCurrentTileIndex(currentTile);
        this.setScale(2f);
        this.rambleBall = rambleBall;
        DirectionResult direction = directionResult();

        this.mPhysicsHandler.setVelocity(direction.getDirectionX(), direction.getDirectionY());

    }

    public Ball(final float pX, final float pY, final TiledTextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager, int currentTile, boolean rambleBall) {
        super(pX, pY, pTextureRegion, pVertexBufferObjectManager);
        this.mPhysicsHandler = new PhysicsHandler(this);
        this.registerUpdateHandler(this.mPhysicsHandler);
        this.setCurrentTileIndex(currentTile);
        this.setScale(2f);
        this.rambleBall = rambleBall;
    }

    @Override
    protected void onManagedUpdate(final float pSecondsElapsed) {
        if (rambleBall == true) {
            DEMO_VELOCITY = new Random().nextInt(1000 - 500 + 1) + 500;
            if (this.mX < 270) {
                this.mPhysicsHandler.setVelocityX(DEMO_VELOCITY);
            } else if (this.mX + this.getWidth() > CAMERA_WIDTH / 2 + 270) {
                this.mPhysicsHandler.setVelocityX(-DEMO_VELOCITY);
            }

            if (this.mY < 490) {
                this.mPhysicsHandler.setVelocityY(DEMO_VELOCITY);
            } else if (this.mY + this.getHeight() > CAMERA_HEIGHT / 2 + 460) {
                this.mPhysicsHandler.setVelocityY(-DEMO_VELOCITY);
            }
        }
        super.onManagedUpdate(pSecondsElapsed);
    }

    private float randomSpeed() {
        Random rand = new Random();
        int randomSpeed = rand.nextInt(3) + 7;
        float randomSpeedFinal = DEMO_VELOCITY * randomSpeed;
        return randomSpeedFinal;
    }


    private static boolean randomX() {
        Random rand = new Random();
        boolean boolRandX;
        int randomX = new Random().nextInt(CAMERA_HEIGHT - 100 + 1) + 100;
        if (randomX == 1) {
            boolRandX = true;
            return boolRandX;
        } else {
            boolRandX = false;
            return boolRandX;
        }
    }

    private static boolean randomY() {
        Random rand = new Random();
        boolean boolRandY;
        int randomY = new Random().nextInt(CAMERA_WIDTH - 100 + 1) + 100;
        if (randomY == 1) {
            boolRandY = true;
            return boolRandY;
        } else {
            boolRandY = false;
            return boolRandY;
        }
    }


    private DirectionResult directionResult() {
        float directionX;
        float directionY;

        if (randomX()) {
            directionX = randomSpeed();
        } else {
            directionX = -randomSpeed();
        }

        if (randomY()) {
            directionY = randomSpeed();
        } else {
            directionY = -randomSpeed();
        }

        return new DirectionResult(directionX, directionY);

    }


}