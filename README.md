# FanApp

This repository contains the code for FanApp's backend and frontend components.

## Getting Started

These instructions will guide you on how to run the entire FanApp stack using Docker.

### Prerequisites

Ensure that you have Docker and Docker Compose installed on your system. If not, you can download them from the [official Docker website](https://www.docker.com/get-started).

### Running the App

1. **Clone the Fanapp-backend Repository (contains the `docker-compose.yml`)**: 

    ```bash
    git clone https://github.com/dahiyaajay2022/Fanapp-backend.git
    ```

2. **Navigate to the Repository Folder**:

    ```bash
    cd Fanapp-backend
    ```

3. **Pull the Docker Images**:

    For the backend:
    ```bash
    docker pull dahiyaajay2022/fanapp-backend:v1
    ```

    For the frontend:
    ```bash
    docker pull dahiyaajay2022/fanapp-frontend:v1.1
    ```

4. **Run Docker Compose**:

    ```bash
    docker-compose up
    ```

    This will start all the necessary services, including the backend API server, frontend application, and the PostgreSQL database.

5. **Access the FanApp**:

    Once the containers are up and running:

    - Frontend will be accessible at: [http://localhost:3000](http://localhost:3000)
    - Backend API will be accessible at: [http://localhost:8080](http://localhost:8080)

6. **Stopping the services**:

    Press `CTRL+C` in the terminal where `docker-compose up` is running.

    To completely stop the containers and remove them, run:

    ```bash
    docker-compose down
    ```
### Notes
FrontEnd Repositories for clone:
 ```bash
https://github.com/dahiyaajay2022/Fanapp-frontend.git
```
PostgreSQL Database
The FanApp backend utilizes a PostgreSQL database, which is also containerized for easy setup and use.
1) Accessing the Database:
With the containers running:
```bash
docker exec -it fanapp-postgres bash
```
2) Access the PostgreSQL CLI:
 ```bash
psql -U ajayd mydemoDB
```
You'll be prompted to enter the password. Use the password defined in the docker-compose.yml file (the password as per the one provided in compose file).
