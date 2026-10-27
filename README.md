# CiudadActiva - Backend
**CiudadActiva** es una plataforma backend desarrollada con Spring Boot diseñada para gestionar reportes ciudadanos, validaciones, asignaciones de operadores y seguimientos de incidencias urbanas.

---

## 🚀 Tecnologías Utilizadas
* **Java 17+**
* **Spring Boot** (Web, Data JPA)
* **PostgreSQL** (Base de datos alojada en Supabase)
* **SpringDoc OpenAPI / Swagger** (Documentación de API)
* **JUnit 5 & Mockito** (Pruebas unitarias)

---

## 📋 Funcionalidades Principales
* **Gestión de Reportes:** Registro, consulta por ID o ciudadano, y actualización de estados (`PENDIENTE`, `VALIDADO`, `RECHAZADO`, `EN_PROCESO`, `CERRADO`).
* **Reglas de Negocio:** Validación obligatoria de justificación ante rechazos, bloqueo de edición en reportes cerrados, y restricción de asignación exclusiva para usuarios con rol `OPERADOR`.
* **Seguimientos y Evidencias:** Registro de avances vinculados a cada reporte.

---

## ⚙️ Cómo Ejecutar el Proyecto Localmente
1. Clona este repositorio:

# CiudadActiva1
