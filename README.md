# Pico y Placa - Consulta de Circulación Vehicular

Aplicación web fullstack compuesta por dos repositorios:  
- **Backend** (Spring Boot, Java)
- **Frontend** (Angular)

---

## Tabla de Contenidos

- [Backend - Spring Boot](#backend---spring-boot)
  - [Requisitos](#requisitos-backend)
  - [Instalación y Ejecución](#instalación-y-ejecución-backend)
  - [Prueba de la API](#prueba-de-la-api)
- [Frontend - Angular](#frontend---angular)
  - [Requisitos](#requisitos-frontend)
  - [Instalación y Ejecución](#instalación-y-ejecución-frontend)
  - [Uso de la Aplicación](#uso-de-la-aplicación)
- [Notas y Consejos](#notas-y-consejos)
- [Autor](#autor)

---

# Backend - Spring Boot

## Requisitos Backend

- **Java 17** (o superior)
- **Maven 3.8+**
- Acceso a Internet (solo para la primera compilación)

---

## Instalación y Ejecución Backend

1. **Clona o descarga el repositorio del backend:**
    O descarga el ZIP desde GitHub y descomprímelo.

2. **Compila el proyecto:**

    Dentro del directorio del proyecto ejecuta la siguiente linea:
   ```bash
   mvn clean package
   ```

    Esto descargará todas las dependencias necesarias y generará el archivo JAR en la carpeta `target/`.

3. **Ejecuta el backend:**

    ```bash
    java -jar target/picoyplaca_backend-0.0.1-SNAPSHOT.jar
    ```

    El backend quedará disponible en [http://localhost:8080/](http://localhost:8080/)

---

## Prueba de la API

Puedes probar la API usando Postman, curl o desde el frontend.

**Endpoint principal:**

- Método: `POST`
- URL: `http://localhost:8080/api/picoyplaca/consulta`
- Ejemplo de Body (JSON):

    ```json
    {
      "placa": "ABC1234",
      "fecha": "2025-07-15",
      "hora": "08:23"
        }
    ```

La respuesta será un JSON indicando si el vehículo puede circular o no.

---

# Frontend - Angular

## Requisitos Frontend

- **Node.js 18** (o superior)
- **Angular CLI** (v16 o superior)

---

## Instalación y Ejecución Frontend

1. **Clona o descarga el repositorio del frontend:**
    O descarga el ZIP desde GitHub y descomprímelo.

2. **Instala las dependencias:**

   ```bash
   npm install
   ```
    

4. **Inicia el servidor de desarrollo:**

    ```bash
    ng serve --open
    ```
    - Esto abrirá la app automáticamente en tu navegador en  
      [http://localhost:4200/](http://localhost:4200/)

---

## Uso de la Aplicación

- Ingresa la placa, fecha y hora a consultar.
- Haz clic en **Consultar**.
- El sistema mostrará si el vehículo puede circular o no.

---

# Notas y Consejos

- **El backend debe estar ejecutándose en `http://localhost:8080/` antes de iniciar el frontend.**
- Si cambias el puerto del backend, actualiza la URL de la API en el frontend (en `environment.ts` de Angular).
- Asegúrate de usar versiones correctas de Java, Node y Angular CLI.
- Si es la primera vez que compilas o corres la app, necesitas acceso a internet para descargar dependencias.

---

# Autor

**Dylan Clerque**  
---

