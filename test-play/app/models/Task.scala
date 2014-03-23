package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

case class Task(id: Long, name: String)

object Task {

  def all(): List[Task] = DB.withConnection { implicit c =>
    SQL("select * from task").as(task *)
  }

  def create(name: String) {
    DB.withConnection { implicit c =>
      SQL("insert into task (name) values ({name})").on(
        'name -> name
      ).executeUpdate()
    }
  }

  def delete(id: Long) {
    DB.withConnection { implicit c =>
      SQL("delete from task where id = {id}").on(
        'id -> id
      ).executeUpdate()
    }
  }

  val task = {
    get[Long]("id") ~
      get[String]("name") map {
      case id~name => Task(id, name)
    }
  }

}

