# Parts Manager
This program is intended to interface with *Powerlink* and print out pricing information using a virtual printer driver, then determine prices for the parts and add them to the index in an SQL database.

## Features

  - Relies on Java's [Robot][Rob]
  - Parses information from a file dump of part numbers (soon to be changed)
  - Asks user for pricing if no clear average can be found
  - Stores data in SQL database for future interfacing via [Powerlink-Interface][Pow]

### Installation

Clone the repository:
```sh
$ git clone https://github.com/Jaymus3/Parts-Manager
```
You'll also need [MySQL Connector][Mysq] in order for the SQL database interaction to work.  Open the project with your favorite Java editor, such as [Eclipse][Ecl]

### Development

See something that could use improvement?  Great!  Just fork the repo, make your changes, and make a pull request detailing what you fixed up.


   [Pow]: <https://github.com/Jaymus3/Powerlink-Interface>
   [Rob]: <https://docs.oracle.com/javase/7/docs/api/java/awt/Robot.html>
   [Mysq]: <https://www.mysql.com/products/connector/>
   [Ecl]: <https://eclipse.org/>
