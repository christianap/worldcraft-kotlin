package com.apeelingtech.worldcraft

import java.awt.Canvas
import java.awt.Dimension
import java.awt.image.BufferStrategy
import java.awt.Graphics
import java.awt.Color;
import javax.swing.JFrame
import javax.swing.WindowConstants
import javax.swing.SwingUtilities


class Screen(width: Int, height: Int): Canvas() {

	var bs: BufferStrategy? = null
	var g: Graphics? = null

	init {
		setPreferredSize(Dimension(width, height))
	}

	fun initBufferStrategy() {
		createBufferStrategy(3)
	}

	fun beginRendering() {
		bs = bufferStrategy
		g = bs?.getDrawGraphics()
	}

	fun clear() {
		g?.setColor(Color.BLUE)
		g?.fillRect(0, 0, width, height)
	}

	fun getGraphicsObject(): Graphics? = g

	fun endRendering() {
		g?.dispose()
		bs?.show()
	}

}

class Window(title: String, screen: Screen, width: Int, height: Int): JFrame(title) {

	var level: Level

	init {
		setTitle(title)
		add(screen)
		pack()
		defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
		setLocationRelativeTo(null)
		isVisible = true

		screen.initBufferStrategy()

		level = Level()
	}

	fun run() {
		//onUpdate()
		screen.beginRendering()
		screen.clear()
		//onRender(screen.getGraphicsObject())
		screen.endRendering()
		try {
			Thread.sleep(20)
		} catch (e: InterruptedException) {
			e.printStackTrace()
		}

		SwingUtilities.invokeLater {
			run()
		}
	}

	fun onUpdate() {

	}

	fun onRender() {
		level.render(screen.getGraphicsObject());
	}
}

fun main(args: Array<String>) {
	var screen = Screen(width, height)
	val window = Window("Testing", screen, width, height)
	window.run()
}