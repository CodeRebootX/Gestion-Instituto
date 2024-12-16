Gestión de Entidades con DAO y SQLite  
  
Descripción: Esta aplicación es una implementación de gestión de datos utilizando el patrón DAO (Data Access Object) y SQLite para almacenar los datos en una base de datos, utilizando Java como lenguaje de programación y NetBeans como IDE.  

🔑 Características  
  
📊 Gestión de datos: Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)  
💾 Base de datos H2: Los datos se almacenan y gestionan de manera persistente utilizando una base de datos H2.  
🖥️ Interfaz de usuario: Dispone de una interfaz gráfica de usuario (GUI) creada con Java que permite gestionar fácilmente los elementos de la aplicación.  
🧩 Patrón DAO: Implementa el patrón DAO para separar la lógica de acceso a datos de la lógica de la aplicación.  
  
🛠️ Tecnologías Utilizadas  
  
IDE: NetBeans  
Lenguaje: Java  
Base de Datos: H2  
Patrón de Diseño: DAO (Data Access Object)  
JDBC: Para la conexión y operaciones con H2  
  
📋 Requisitos  
  
NetBeans IDE: Recomendado para el desarrollo de esta aplicación.  
H2: Necesitarás tener la base de datos H2 configurada correctamente en tu entorno de desarrollo.  
JDK: Java Development Kit 8 o superior.  
Bibliotecas JDBC: Asegúrate de tener configuradas las bibliotecas JDBC para conectar la aplicación con H2.  
  
⚙️ Instalación  
  
Clona o descarga el repositorio:  

git clone https://github.com/CodeRebootX/Gestion-Instituto-GUI.git  
Abre el proyecto en NetBeans:  
  
Inicia NetBeans y abre el proyecto descargado.  
Configura la base de datos H2  
Añade las bibliotecas JDBC:  
  
En NetBeans, agrega la biblioteca JDBC para SQLite si aún no está configurada.
  
Compila y ejecuta el proyecto desde NetBeans.  
  
🏃‍♂️ Uso  
  
La aplicación dispone de una interfaz gráfica con las siguientes opciones:  
  
Listado de elementos: Muestra los datos almacenados en la base de datos.  
Guardar elemento: Permite ingresar nuevos datos y guardarlos en la base de datos.  
Eliminar elemento: Permite eliminar un elemento seleccionado de la base de datos.  
Consultar elemento: Permite consultar detalles de un elemento seleccionado.  
  
🧑‍💻 Implementación del Patrón DAO  
  
DAO: El patrón DAO se implementa para separar la lógica de la base de datos de la lógica de la aplicación. Se crearon clases DAO que permiten interactuar con la base de datos, gestionando las operaciones CRUD de manera centralizada.  
Entidad: Son gestionadas a través del patrón DAO.  
  
🤝 Contribuciones 
  
Las contribuciones son bienvenidas. 
  
¡Espero que esta aplicación sea útil para entender y aplicar el patrón DAO con H2!
