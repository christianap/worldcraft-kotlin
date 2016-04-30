package com.apeelingtech.worldcraft.blocks

import com.apeelingtech.worldcraft.level.Level

import java.awt.Graphics

class Block(sprite: Sprite, x: Int, y: Int, solid: Boolean, chunk: Int) {

	var breakable = false
	var width: Int
	var height: Int

	init {
		width = sprite.width
		height = sprite.height
	}

	fun render(g: Graphics, level: Level) {
		sprite.draw(g, x, y, level)
	}
}

class Airblock(x: Int, y: Int, chunk: Int): Block(Sprite.air, x, y, false, chunk)
class Grassblock(x: Int, y: Int, chunk: Int): Block(Sprite.grass, x, y, true, chunk)
class Dirtblock(x: Int, y: Int, chunk: Int): Block(Sprite.dirt, x, y, true, chunk)