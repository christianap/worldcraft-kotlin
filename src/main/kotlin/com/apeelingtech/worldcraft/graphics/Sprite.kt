package com.apeelingtech.worldcraft.graphics

import com.apeelingtech.worldcraft.level.Level
import com.apeelingtech.worldcraft.utils.Resources

import java.awt.Graphics
import java.awt.image.BufferedImage

class Sprite(width: Int, height: Int, x: Int, y: Int, sheet: SpriteSheet) {

	init {
	}

	fun getImage(): BufferedImage {
		return sheet.getImage()
	}

	fun draw(g: Graphics, screenX: Int, screenY: Int) {
		g.drawImage(getImage(), screenX, screenY, screenX + width, screenY + height, this.x, this.y, this.x + this.width, this.y + this.height, null)
	}

	fun drawWithScale(g: Graphics, screenX: Int, screenY: Int, width: Int, height: Int) {
		var nX: Int = x * width
		var nY: Int = y * height
		
		g.drawImage(getImage(), nX, nY, nX + width, nY + height, screenX, screenY, screenX + this.width, screenY + this.height, null)
	}

	fun draw(g: Graphics, x: Double, y: Double, level: Level) {
		var nX: Int = (x as Int * Resources.tileSize) + ((x - x as Int) * Resources.tileSize) as Int // Position in pixels
		var nY: Int = (y as Int * Resources.tileSize) + ((y - y as Int) * Resources.tileSize) as Int

		g.drawImage(getImage(), nX - level.getXOffsetPixels(), nY - level.getYOffsetPixels(), nX + width - level.getXOffsetPixels(), nY + height - level.getYOffsetPixels(), this.x, this.y, this.x + this.width, this.y + this.height, null);
	}

	fun drawWithScale(g: Graphics, x: Double, y: Double, width: Int, height: Int, level: Level) {
		var nX: Int = (x as Int * Resources.tileSize) + ((x - x as Int) * Resources.tileSize) as Int // Convert's blocks to pixels
		var nY: Int = (y as Int * Resources.tileSize) + ((y - y as Int) * Resources.tileSize) as Int
		var nSX: Int = level.getXOffsetPixels();
		var nSY: Int = level.getYOffsetPixels();
		
		g.drawImage(getImage(), nX - nSX, nY - nSY, nX + width - nSX, nY + height - nSY, this.x, this.y, this.x + this.width, this.y + this.height, null);
	}

}