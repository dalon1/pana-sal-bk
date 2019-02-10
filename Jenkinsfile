pipeline {
    agent any
    stages {
        stage("Build & test") {
            steps {
                script {
                    echo "Building and testing..."
                    sh "mvn clean install test"
                }
            }
        }
        stage("Code Analysis") {
            steps {
                script {
                    echo "Running static code analysis tools..."
                }
            }
        }
        stage("Approval") {
            steps {
                script {
                    echo "Requesting approval.."
                }
            }
        }
        stage("Deploy") {
            steps {
                script {
                    echo "Deploying..."
                }
            }
        }
    }

    post {
        always {
            junit '**/surefire-reports/TEST*.xml'
        }
    }
}