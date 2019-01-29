package entryapp

import org.http4s.HttpRoutes
import cats.implicits._
import cats.effect._
import io.chrisdavenport.log4cats.{Logger, SelfAwareLogger}
import io.chrisdavenport.log4cats.log4s.Log4sLogger
import org.http4s.dsl.io._
import org.http4s.server.blaze._
import org.http4s.implicits._
import org.http4s.server.Router
import org.log4s.getLogger
import scala.collection.JavaConverters._

object WebApp extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {

    val hostname = System.getenv().asScala.getOrElse("HOSTNAME", "127.0.0.1")

    val log4sLogger = getLogger
    implicit val logger: SelfAwareLogger[IO] = Log4sLogger.fromLog4s[IO](log4sLogger)

    val service = HttpRoutes.of[IO] {
      case GET -> Root / "hello" / name => for {
        _ <- Logger[IO].info("Sending response from our app.")
        res <- Ok(s"Hello, $name.\n")
      } yield res
    }

    val app = Router("/" -> service).orNotFound

    val server = BlazeServerBuilder[IO]
      .bindHttp(8080, hostname)
      .withHttpApp(app)
      .resource.use(_ => IO.never)

    Logger[IO].info(s"Starting app. $hostname") *> server.as(ExitCode.Success)
  }
}
