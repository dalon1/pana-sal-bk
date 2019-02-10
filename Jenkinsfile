pipeline {
    agent any
    
    stages {
        stage("Build & test") {
            steps {
                script {
                    echo "Building and testing..."
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
            echo "Release orchestration completed..."
        }
    }
}