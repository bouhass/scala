package controllers

import play.api._
import play.api.mvc._
import models.Task

import play.api.data._
import play.api.data.Forms._

object Application extends Controller {

  def index = Action {
    Redirect(routes.Application.tasks)
//    Ok(views.html.index("Your new application is ready!!!"))
  }

  def home = Action {
    Ok("Hello world")
  }

  def tasks = Action {
    Ok(views.html.index(Task.all(), taskForm))
  }

  def newTask = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.index(Task.all(), errors)),
      name => {
        Task.create(name)
        Redirect(routes.Application.tasks)
      }
    )
  }

  def deleteTask(id: Long) = Action {
    Task.delete(id)
    Redirect(routes.Application.tasks)
  }

  val taskForm = Form(
    "name" -> nonEmptyText
  )

}
