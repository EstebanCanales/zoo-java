# Sistema de Gestión de Zoológico - Java & Oracle Cloud

Este proyecto es una aplicación de escritorio desarrollada en **Java** que implementa un sistema de gestión para un zoológico. Utiliza una arquitectura orientada a objetos con herencia y polimorfismo, conectándose a una base de datos **Oracle Cloud Autonomous** mediante autenticación segura por **Wallet**.

## 🚀 Características

- **Arquitectura Robusta:** Implementación de Herencia (`Animal` -> `Mammal` -> `Elefante`/`Leon`).
- **Seguridad de Datos:** Conexión cifrada a Oracle Cloud usando **Oracle Wallet**.
- **Gestión de Secretos:** Uso de archivos `.env` para evitar el hardcoding de credenciales sensibles.
- **Interfaz Gráfica (GUI):** Desarrollada con **Java Swing**, incluyendo formularios CRUD y visualización de datos en `JTable`.
- **Persistencia:** Capa de datos profesional utilizando el patrón **DAO (Data Access Object)**.
- **Automatización:** Gestión de compilación y ejecución mediante **Apache Ant**.

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java 8+
- **Base de Datos:** Oracle Cloud Autonomous Database
- **Driver JDBC:** Oracle JDBC (OJDBC8)
- **Construcción:** Apache Ant
- **Seguridad:** Oracle Wallet & .env Loader

## 📋 Requisitos Previos

1.  **Java SDK** instalado y configurado.
2.  **Apache Ant** instalado.
3.  **Oracle Wallet** descargado de tu instancia de Oracle Cloud.
4.  Archivo **ojdbc8.jar** (disponible en la carpeta `lib/` después de descargarlo).

## ⚙️ Configuración e Instalación

### 1. Base de Datos
Ejecuta el script `database.sql` en tu consola de Oracle Cloud (SQL Developer Web o similar) para crear las tablas `ELEFANTES` y `LEONES`.

### 2. Configuración del Wallet
Descarga el archivo `.zip` del Wallet de tu base de datos y extrae su contenido en la carpeta `wallet/` ubicada en la raíz del proyecto.

### 3. Variables de Entorno
Copia el archivo de ejemplo y configura tus credenciales reales:
```bash
cp .env.example .env
```
Edita el archivo `.env` con tu usuario (`ADMIN`), contraseña, el nombre de la instancia TNS (ej. `db_low`) y la ruta al wallet (`./wallet`).

### 4. Librerías
Asegúrate de que el driver de Oracle esté presente en la ruta:
`zoo-java/lib/ojdbc8.jar`

## 🏃 Ejecución

Para compilar y ejecutar la aplicación, utiliza los siguientes comandos de Ant:

```bash
# Limpiar y compilar el proyecto
ant compile

# Ejecutar la aplicación
ant run
```

## 📁 Estructura del Proyecto

```text
zoo-java/
├── build.xml              # Configuración de compilación Ant
├── database.sql           # Script SQL para Oracle Cloud
├── .env                   # Archivo de secretos (IGNORADO POR GIT)
├── .env.example           # Plantilla para configuración
├── wallet/                # Certificados de conexión (IGNORADO POR GIT)
├── lib/                   # Librerías externas (.jar)
└── src/
    └── zoojava/
        ├── animal.java    # Clase base (Abstracta)
        ├── mammal.java    # Clase intermedia
        ├── elefante.java  # Clase concreta
        ├── leon.java      # Clase concreta
        ├── db/            # Capa de datos
        │   ├── DatabaseConnection.java
        │   ├── EnvLoader.java
        │   └── ElefanteDAO.java
        └── gui/           # Capa de interfaz gráfica
            ├── MenuPrincipal.java
            └── ElefanteForm.java
```

## 🔒 Seguridad
Este proyecto está configurado para ser **seguro en entornos públicos**:
- El archivo `.gitignore` excluye automáticamente el `.env` y la carpeta `wallet/`.
- Nunca subas tus credenciales reales al repositorio.
