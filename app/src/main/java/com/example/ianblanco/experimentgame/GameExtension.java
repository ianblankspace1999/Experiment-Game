package com.example.ianblanco.experimentgame;


import com.example.ianblanco.experimentgame.constants.CatchTurn;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.primitive.Line;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.util.FPSLogger;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.debug.Debug;

import java.io.IOException;



public class GameExtension extends SimpleBaseGameActivity {

    protected static final int CAMERA_WIDTH = 1080;
    protected static final int CAMERA_HEIGHT = 1920;
    protected final Scene scene = new Scene();

    public static boolean test = false;
    public static BitmapTextureAtlas mBitmapTextureAtlas;
    public static TiledTextureRegion mFaceTextureRegion;
    public static BitmapTextureAtlas mBitmapTextureAtlasBox;
    public static TiledTextureRegion mBoxTextureRegion;
    protected static CatchTurn catchTurn = CatchTurn.DEFAULT;
    protected TiledTextureRegion mDisplayTextureRegion;

    protected static Music mMusic;

    protected static Line line = null;
    protected static Line line1 = null;
    protected static Line line2 = null;
    protected static Line line3 = null;

    private TextureRegion backgroundTextureRegion;
    private BitmapTextureAtlas backgroundTextureAtlas;


    @Override
    public EngineOptions onCreateEngineOptions() {
        final Camera camera = new Camera(0, 0, this.CAMERA_WIDTH, this.CAMERA_HEIGHT);

        EngineOptions engineOptions = new EngineOptions(true,
                ScreenOrientation.PORTRAIT_FIXED, new FillResolutionPolicy(),
                camera);
        engineOptions.getAudioOptions().setNeedsMusic(true);
        return engineOptions;
    }

    @Override
    protected Scene onCreateScene() {
        //   Declaring lines for collisions
        this.mEngine.registerUpdateHandler(new FPSLogger());
        scene.setBackground(new SpriteBackground(new Sprite(0, 0, backgroundTextureRegion,
                getVertexBufferObjectManager())));


        final VertexBufferObjectManager vertexBufferObjectManager = this.getVertexBufferObjectManager();
        line = new Line(CAMERA_WIDTH / 2 - 280, CAMERA_HEIGHT / 2 - 480, CAMERA_WIDTH / 2 + 280, CAMERA_HEIGHT / 2 - 480, 500, vertexBufferObjectManager);
        line1 = new Line(CAMERA_WIDTH / 2 - 280, CAMERA_HEIGHT / 2 + 480, CAMERA_WIDTH / 2 + 280, CAMERA_HEIGHT / 2 + 480, 500, vertexBufferObjectManager);
        line2 = new Line(CAMERA_WIDTH / 2 - 280, CAMERA_HEIGHT / 2 - 480, CAMERA_WIDTH / 2 - 280, CAMERA_HEIGHT / 2 + 480, 500, vertexBufferObjectManager);
        line3 = new Line(CAMERA_WIDTH / 2 + 280, CAMERA_HEIGHT / 2 - 480, CAMERA_WIDTH / 2 + 280, CAMERA_HEIGHT / 2 + 480, 500, vertexBufferObjectManager);
//        scene.attachChild(line);
        scene.attachChild(line1);
//        scene.attachChild(line2);
//        scene.attachChild(line3);


//
        mEngine.registerUpdateHandler(new IUpdateHandler() {
            float i = 0;
            float sec = (float) 0.01;

            @Override
            public void onUpdate(float pSecondsElapsed) {

                i = i + sec;
                if ((int) i == 3) {
                    catchTurn = CatchTurn.FIRST;
                } else if ((int) i == 6) {
                    catchTurn = CatchTurn.SECOND;
                } else if ((int) i == 9) {
                    catchTurn = CatchTurn.THIRD;
                } else if ((int) i == 12) {
                    catchTurn = CatchTurn.FOURTH;
                } else if ((int) i == 15) {
                    catchTurn = CatchTurn.FIFTH;
                } else if ((int) i == 18) {
                    catchTurn = CatchTurn.SIXTH;
                }
            }

            @Override
            public void reset() {

            }
        });
        return null;
    }


    @Override
    protected void onCreateResources() {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");

        this.mBitmapTextureAtlas = new BitmapTextureAtlas(this.getTextureManager(), 384, 252, TextureOptions.BILINEAR);
        this.mFaceTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "test.png", 0, 0, 8, 6);
        this.mDisplayTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "test.png", 0, 0, 8, 6);
        this.mBitmapTextureAtlas.load();

        this.mBitmapTextureAtlasBox = new BitmapTextureAtlas(this.getTextureManager(), 637, 1338, TextureOptions.BILINEAR);
        this.mBoxTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlasBox, this, "lotto_container.png", 0, 0, 1, 1);
        this.mBitmapTextureAtlasBox.load();


        this.backgroundTextureAtlas = new BitmapTextureAtlas(getTextureManager(),
                1080, 1920);
        this.backgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(backgroundTextureAtlas,
                this, "background.png", 0, 0);
        backgroundTextureAtlas.load();


        MusicFactory.setAssetBasePath("mfx/");
        try {

//            for (int i = 0; i < gameObjectLoop; ++i) {
            this.mMusic = MusicFactory.createMusicFromAsset(this.mEngine.getMusicManager(), this, "music_ball.mp3");
            this.mMusic.setLooping(true);
//                arrMusic.add(mMusic);
//            }

        } catch (final IOException e) {
            Debug.e(e);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mMusic.stop();
    }

}
