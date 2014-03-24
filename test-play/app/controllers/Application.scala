package controllers

import play.api.mvc._
import models.{Project, Task}

import play.api.data._
import play.api.data.Forms._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index(Project.all(), projectForm, Task.all(), taskForm))
  }

  def newProject = Action { implicit request =>
    projectForm.bindFromRequest.fold(
      errors => BadRequest(views.html.index(Project.all(), errors, Task.all(), taskForm)),
      name => {
        Project.create(name)
        Redirect(routes.Application.index)
      }
    )
  }

  def deleteProject(id: Long) = Action {
    Project.delete(id)
    Redirect(routes.Application.index)
  }

  def newTask = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.index(Project.all(), projectForm, Task.all(), errors)),
      name => {
        Task.create(name)
        Redirect(routes.Application.index)
      }
    )
  }

  def deleteTask(id: Long) = Action {
    Task.delete(id)
    Redirect(routes.Application.index)
  }

  val projectForm = Form(
    "name" -> nonEmptyText
  )

  val taskForm = Form(
    "name" -> nonEmptyText
  )

}
