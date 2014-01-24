package example

import org.scalajs.dom
import org.scalajs.dom._
import scala.scalajs.js

object ScalaJSExample {
  val paragraph = dom.document.createElement("p").asInstanceOf[HTMLParagraphElement]

  val console = dom.window.console

  def main(): Unit = {
    paragraph.innerHTML = "<strong>It works!</strong>"
    val container: dom.HTMLDivElement = dom.document.getElementById("playground").asInstanceOf[HTMLDivElement]
    val canvas = dom.document.createElement("canvas").asInstanceOf[HTMLCanvasElement]
    canvas.width = 100
    canvas.height = 100
    container.appendChild(paragraph)
    container.appendChild(canvas)


    val ctx = canvas.getContext("2d").asInstanceOf[CanvasRenderingContext2D]

    drawSomething(ctx)

    canvas.onclick = clickHandler
  }


  private def drawSomething(ctx: CanvasRenderingContext2D) {
    ctx.beginPath()
    ctx.lineWidth = 10
    ctx.strokeStyle = "#00ff00"
    ctx.moveTo(0, 0)
    ctx.lineTo(100, 100)
    ctx.stroke()
  }

  type MouseHandler  = ((MouseEvent) => js.Any)

  private val clickHandler: MouseHandler = {(e: MouseEvent) =>
    console.log("Works!")
    console.info(e)
  }

  /** Computes the square of an integer.
   *  This demonstrates unit testing.
   */
  def square(x: Int): Int = x*x
}
