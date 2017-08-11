package app.components

import japgolly.scalajs.react.MonocleReact._
import japgolly.scalajs.react.{ScalaComponent, _}
import japgolly.scalajs.react.extra.StateSnapshot
import japgolly.scalajs.react.vdom.html_<^._
import monocle.macros._

object Main {

  case class Name(firstName: String, surname: String)

  class MainBackend($ : BackendScope[Unit, Name]) {
    def render(name: Name) = {
      val firstNameLens = GenLens[Name](_.surname)
      val firstNameV = StateSnapshot.zoomL(firstNameLens).of(name)

      val nameSnapshot = StateSnapshot.of(name)

      <.div(
        <.p(s"My name is ${name.firstName}")
      )
    }
  }

  val Main = ScalaComponent
    .builder[Unit]("StateSnapshot example")
    .initialState(Name("John", "Wick"))
    .renderBackend[MainBackend]
    .build

  def apply() = Main()
}
