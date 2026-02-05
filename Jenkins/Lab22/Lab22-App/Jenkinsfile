pipeline {
    agent any

    environment {
        IMAGE_NAME = "fatmaahassan/java_app"
        TAG = "${BUILD_NUMBER}"
    }

    stages {

        stage('Unit Test') {
            steps {
                dir('Jenkins/Lab22/Jenkins_App') {
                    sh 'mvn test'
                }
            }
        }

        stage('Build App') {
            steps {
                dir('Jenkins/Lab22/Jenkins_App') {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                dir('Jenkins/Lab22/Jenkins_App') {
                    sh "docker build -t $IMAGE_NAME:$TAG ."
                }
            }
        }

        stage('Push Image to DockerHub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '''
                        echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                        docker push $IMAGE_NAME:$TAG
                    '''
                }
            }
        }

        stage('Delete Local Image') {
            steps {
                sh "docker rmi $IMAGE_NAME:$TAG || true"
            }
        }

        stage('Update deployment.yaml') {
            steps {
                dir('Jenkins/Lab22/Jenkins_App') {
                    sh '''
                        sed -i "s|image:.*|image: $IMAGE_NAME:$TAG|" deployment.yaml
                    '''
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                dir('Jenkins/Lab22/Jenkins_App') {
                    sh 'kubectl apply -f deployment.yaml -n jenkins'
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline Finished'
        }
        success {
            echo 'Deployment Successful 🎉'
        }
        failure {
            echo 'Pipeline Failed ❌'
        }
    }
}

