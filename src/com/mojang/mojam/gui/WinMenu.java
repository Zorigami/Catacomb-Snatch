package com.mojang.mojam.gui;

import java.awt.event.KeyEvent;

import com.mojang.mojam.MojamComponent;
import com.mojang.mojam.screen.*;

public class WinMenu extends GuiMenu {
	private int selectedItem = 0;
	private final int gameWidth;
	private int winningPlayer;

	public WinMenu(int gameWidth, int gameHeight, int winningPlayer) {
		super();
		this.winningPlayer = winningPlayer;
		this.gameWidth = gameWidth;

		addButton(new Button(TitleMenu.RETURN_TO_TITLESCREEN, "Ok", (gameWidth - 128) / 2, 200));
	}

	@Override
	public void render(Screen screen) {
		screen.clear(0);
		screen.blit(Art.gameOverScreen, 0, 0);

		Font.draw(screen, MojamComponent.texts.playerWin(winningPlayer), 180, 160);

		super.render(screen);

		if (winningPlayer == 1)
			screen.blit(Art.getLocalPlayerArt()[0][6], (gameWidth - 128) / 2 - 40, 190 + selectedItem * 40);
		if (winningPlayer == 2)
			screen.blit(Art.herrSpeck[0][6], (gameWidth - 128) / 2 - 40, 190 + selectedItem * 40);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_E) {
			buttons.get(selectedItem).postClick();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void buttonPressed(ClickableComponent button) {
	}

}
