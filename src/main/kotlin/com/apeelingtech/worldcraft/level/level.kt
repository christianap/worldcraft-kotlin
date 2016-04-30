package com.apeelingtech.worldcraft.level

import com.apeelingtech.worldcraft.blocks.Airblock
import com.apeelingtech.worldcraft.blocks.Grassblock
import com.apeelingtech.worldcraft.blocks.Dirtblock

import java.awt.Graphics
import java.util.ArrayList

class Level(seed: Long) {

	val worldWidth = 2000
	val worldHeight = 2000
	var blocks = ArrayList<Block>()
	var xOffset = 0
	var yOffset = 0

	init {
		newGenerateLevel()
	}

	fun newGenerateLevel() {
		var currentChunk = 0
		var startY = (worldHeight - 2) / 4
		for (x in 0..worldWidth) {
			if (x % 20 == 0) {
				currentChunk++
			}
			for (y in 0..worldHeight) {
				if (y == (int)(-((4.0 / 2.0) * Math.sin(x * 2.0 / 15.0) + 4)-(Math.cos(x / 10.0) - 1.0) + startY)) {
					blocks.add(Grassblock(x, y, this, currentChunk));
				} else if (y > (int)(-((4.0 / 2.0) * Math.sin(x * 2.0 / 15.0) + 4)-(Math.cos(x / 10.0) - 1.0) + startY)) {
					blocks.add(Dirtblock(x, y, this, currentChunk));
				} else {
					blocks.add(Airblock(x, y, this, currentChunk));
				}
			}
		}
	}

	fun render(g: Graphics) {
		for (block in blocks) {
			block.render(g, this)
		}
	}
}