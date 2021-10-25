package myGame;

import com.jme3.app.SimpleApplication;

import gameLogic.Scene;

/**
 * The JMonkeyEngine game entry, you should only do initializations for your game here, game logic is handled by
 * Custom states {@link com.jme3.app.state.BaseAppState}, Custom controls {@link com.jme3.scene.control.AbstractControl}
 * and your custom entities implementations of the previous.
 *
 * @author pavl_g.
 */
public class Game extends SimpleApplication {
    @Override
    public void simpleInitApp() {
        flyCam.setDragToRotate(true);
        flyCam.setMoveSpeed(0.5f);

        stateManager.attach(new Scene());
    }
}