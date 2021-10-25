package com.example.desktopmodule;

import myGame.Game;
import com.jme3.system.AppSettings;

/**
 * Used to launch a jme application in desktop environment using native GLFW.
 *
 * @author pavl_g.
 */
public class DesktopLauncher {
    public static void main(String[] args) {
        final Game game = new Game();

        final AppSettings appSettings = new AppSettings(true);

        game.setSettings(appSettings);
        game.setShowSettings(true);
        game.start();
    }
}