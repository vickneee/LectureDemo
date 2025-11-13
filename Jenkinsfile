pipeline {

    agent any


    environment {
        PATH = "/usr/local/bin:${env.PATH}"

        SONARQUBE_SERVER = 'SonarQubeServer'
        SONAR_TOKEN = 'squ_64629622ab9511b7773847e066837d4d8ba56cc0' // Make sure a right token is selected
        DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
        DOCKERHUB_REPO = 'vickneee/sonarqube_demo'
        DOCKER_IMAGE_TAG = 'latest'
    }

    tools {
        maven 'Maven3'
    }


    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/vickneee/LectureDemo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Code Coverage') {
            steps {
                sh 'mvn jacoco:report'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${env.SONARQUBE_SERVER}") {
                    sh """
                        /usr/local/sonarscanner/bin/sonar-scanner \
                        -Dsonar.projectKey=LectureDemo_SonarQube \
                        -Dsonar.sources=src \
                        -Dsonar.projectName=LectureDemo_SonarQube \
                        -Dsonar.host.url=http://localhost:9000 \
                        -Dsonar.token=${env.SONAR_TOKEN} \
                        -Dsonar.java.binaries=target/classes \
                    """
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                    // Or specify Dockerfile path explicitly if needed
                    // docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}", "-f ./Dockerfile .")
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_CREDENTIALS_ID}", usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh '''
                        docker login -u $DOCKER_USER -p $DOCKER_PASS
                        docker push $DOCKERHUB_REPO:$DOCKER_IMAGE_TAG
                    '''
                }
            }
        }
    }
}
