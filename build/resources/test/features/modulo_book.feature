#language:es
Característica: ModuloBooks
Yo como usuario,
realizó la búsqueda de un libro en la página de demoqa/books,
válido que sea el libro que busco y lo agrego a mi colección.


  Esquema del escenario: Validar nombre de usuario logueado
    Dado que el usuario se logue en la pagina
      | <nameUsuario> | <password> |
    Entonces se valida que el nombre del usuario sea "<nameUsuario>"
  Ejemplos:
    | nameUsuario | password  |
    | JUAN2023    | Juan1005* |

  #@prueba
  Esquema del escenario: Agregar Libro en la colección
    Dado que el usuario se logue en la pagina
      | <nameUsuario> | <password> |
    Cuando el usuario agregue un libro con nombre "<nombreLibro>"
    Entonces se validara que se muestre el siguiente mensaje "<mensaje>"
    Ejemplos:
      | nameUsuario | password  | nombreLibro                | mensaje                        |
      | JUAN2023    | Juan1005* | Understanding ECMAScript 6 | Book added to your collection. |

  #@prueba
  Esquema del escenario: Validar que Libro esta en la colección
    Dado que el usuario se logue en la pagina
      | <nameUsuario> | <password> |
    Cuando el usuario ingrese a la opcion profile
    Entonces se validara que el libro "<nombreLibro>" se agrego a la coleccion
    Ejemplos:
      | nameUsuario | password  | nombreLibro                | mensaje                        |
      | JUAN2023    | Juan1005* | Understanding ECMAScript 6 | Book added to your collection. |

  #@prueba
  Esquema del escenario: Eliminar libro de la colección
    Dado que el usuario se logue en la pagina
      | <nameUsuario> | <password> |
    Cuando el usuario elimine un libro con nombre "<nombreLibro>"
    Entonces se validar que se muestre mensaje "<mensaje>" que confirma el borrado
    Y se debe confirmar que el libro "<nombreLibro>" no se muestre en la tabla coleccion
    Ejemplos:
      | nameUsuario | password  | nombreLibro                | mensaje       |
      | JUAN2023    | Juan1005* | Understanding ECMAScript 6 | Book deleted. |


  @prueba
  Esquema del escenario: Agregar no Librono existente en la colección
    Dado que el usuario se logue en la pagina
      | <nameUsuario> | <password> |
    Cuando el usuario agregue un libro con nombre "<nombreLibro>"
    Entonces se validara que se muestre el siguiente mensaje "<mensaje>"
    Ejemplos:
      | nameUsuario | password  | nombreLibro          | mensaje       |
      | JUAN2023    | Juan1005* | Trucos de MarioBross | Book added to your collection. |
