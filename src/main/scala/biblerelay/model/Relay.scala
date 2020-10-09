package biblerelay.model

case class Relay(id: String, verses: List[Verse])

case class Verse(key: String, text: String, log: List[Log])

case class Log(user: User, timestamp: Long)

case class User(name: String)


