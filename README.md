# ChâTop - Backend Spring Boot


![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)




## 🚀 Présentation

**ChâTop** est une application backend moderne développée avec **Spring Boot** ☕ et conçue pour fonctionner avec un frontend **Angular** ⚡.
Elle repose sur une architecture robuste avec **JWT** pour l'authentification et **MySQL** comme base de données relationnelle.

## 📌 Prérequis

Avant de commencer, assurez-vous d'avoir installé les outils suivants sur votre machine :

✅ [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)  
✅ [Maven](https://maven.apache.org/download.cgi)  
✅ [Docker](https://www.docker.com/get-started)  
✅ [Git](https://git-scm.com/downloads)  
✅ [IntelliJ IDEA](https://www.jetbrains.com/idea/) ou un autre IDE Java

## 🔧 Installation & Exécution

### 🛠️ 1. Cloner le projet
```bash
 git https://github.com/christopheocr/chatop-backend
 cd chatop-backend
```

### 🐳 2. Lancer MySQL & phpMyAdmin avec Docker
```bash
 docker-compose up -d
```
📌 **Accès à phpMyAdmin** : [http://localhost:8090](http://localhost:8090)  
📌 **MySQL** tourne sur le port `3306`

⏹️ Pour arrêter les services Docker :
```bash
 docker-compose down
```

### 📂 3. Lancer l’application Spring Boot

Compile et exécute l'application avec Maven :
```bash
 mvn clean install
 mvn spring-boot:run
```
L'API est maintenant accessible sur **`http://localhost:3001`** 🚀

## 📜 API Documentation (Swagger)

✨ L'interface **Swagger** est disponible ici :
👉 [http://localhost:3001/api/swagger-ui/index.html](http://localhost:3001/api/swagger-ui/index.html)

## 📡 Endpoints Principaux

### 🔐 Authentification
| 🔹 Méthode | 🔹 Endpoint         | 🔹 Description |
|-----------|---------------------|--------------------------------|
| **POST**  | `api/auth/register` | Enregistrer un nouvel utilisateur |
| **POST**  | `api/auth/login`       | Authentifier un utilisateur |
| **GET**   | `api/auth/me`          | Récupérer les informations de l'utilisateur connecté |

### 🏠 Gestion des locations
| 🔹 Méthode | 🔹 Endpoint       | 🔹 Description |
|-----------|----------------|--------------------------------|
| **GET**   | `api/rentals/{id}`  | Récupérer une location par son ID |
| **PUT**   | `api/rentals/{id}`  | Met à jour une location existante |
| **GET**   | `api/rentals`       | Récupérer la liste de toutes les locations disponibles |
| **POST**  | `api/rentals`       | Créer une nouvelle location |

### ✉️ Gestion des messages
| 🔹 Méthode | 🔹 Endpoint       | 🔹 Description |
|-----------|----------------|--------------------------------|
| **POST**  | `api/messages`     | Envoyer un message |



## 🎨 Frontend Angular
Le frontend associé est disponible ici :
🔗 [Repo Frontend Angular](https://github.com/christopheocr/back-end-en-utilisant-Java-et-Spring)


---

💡 **Auteur** : [Christophe](https://github.com/christopheocr)  🚀

