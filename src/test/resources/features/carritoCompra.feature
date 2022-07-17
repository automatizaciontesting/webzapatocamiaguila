Feature: Realizar compra de productos
  Como usuario de la plataforma de zapatoca deseo realizar la compra de productos y agregarlo al carrito de compras
  para finalizar la compra

  @realizarCompras
  Scenario: Realizar compra de productos
    Given como "comprador" en la plataforma
    When ingreso datos de las credenciales
      |Usuario|Clave|
      |necagreissauca-2829@yopmail.com|Julio*2022*|
    And realizo la compra de los productos
    |Categoria|Subcategoria|Producto|
    |      Abarrotes   | Alcaparras           |   ALCAPARRAS FINAS ALFRESCO X250G |
    |Carnes Frescas   | Blanco           |  PECHUGA BLANCA  |
