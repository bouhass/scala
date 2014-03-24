package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

case class Project(id: Long, name: String)

object Project {

  def all(): List[Project] = DB.withConnection { implicit c =>
    SQL("select * from project").as(project *)
  }

  def create(name: String) {
    DB.withConnection { implicit c =>
      SQL("insert into project (name) values ({name})").on(
        'name -> name
      ).executeUpdate()
    }
  }

  def delete(id: Long) {
    DB.withConnection { implicit c =>
      SQL("delete from project where id = {id}").on(
        'id -> id
      ).executeUpdate()
    }
  }

  val project = {
    get[Long]("id") ~
      get[String]("name") map {
      case id~name => Project(id, name)
    }
  }

}
