pipeline {
    agent any
    tools {
        maven 'M3'
    }
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
                    sh "mvn findbugs:findbugs pmd:pmd"
                    def findbugs = scanForIssues tool: spotBugs(pattern: '**/target/findbugsXml.xml')
                    publishIssues issues: [findbugs]
                    def pmd = scanForIssues tool: pmdParser(pattern: '**/target/pmd.xml')
                    publishIssues issues: [pmd]
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
                    // creating docker image for this project
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