# gherkin -> lenguaje de especificacion
# sintaxis, semantica
Feature: Busqueda en Google
  Como usuario web,
  Quiero buscar en Google
  Para reponder mis dudas.

  @Regresion @TestBC8
  Scenario: Busqueda Simple con barra Google
    Given estoy en un navegador con la pagina inicial de google
    When introduzco la palabra "arbol" en la barra
    And realizo la busqueda con Enter
    Then el navegador me muestra los resultados

  @TestBC8
  Scenario: Busqueda Simple con barra Google
    Given estoy en un navegador con la pagina inicial de google
    When introduzco la palabra "arbol" en la barra
    And realizo la busqueda con Enter
    Then el navegador me muestra los resultados

  @TestBC8
  Scenario: Busqueda Simple con barra Google
    Given estoy en un navegador con la pagina inicial de google
    When introduzco la palabra "arbol" en la barra
    And realizo la busqueda con Enter
    Then el navegador me muestra los resultados

  @TestBC8 @Regresion
  Scenario: Busqueda Simple con barra Google
    Given estoy en un navegador con la pagina inicial de google
    When introduzco la palabra "arbol" en la barra
    And realizo la busqueda con Enter
    Then el navegador me muestra los resultados
