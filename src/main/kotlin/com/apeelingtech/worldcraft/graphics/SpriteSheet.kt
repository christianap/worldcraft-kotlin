package com.apeelingtech.worldcraft.graphics

import java.awt.image.BufferedImage
import java.io.IOException
import javax.imageio.ImageIO

class SpriteSheet(path: String) {
	
	var image: BufferedImage
	var width: Int
	var height: Int

	init {
		try {
			image = ImgaeIO.read(SpriteSheet.class.getResource(path))
			width = image.getWidth()
			height = image.getHeight()
		} catch (e: IOException) {
			e.printStackTrace()
		}
	}

	fun getImage(): BufferedImage = image

}