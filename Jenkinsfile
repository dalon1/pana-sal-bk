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
                    sh "mvn findbugs:findbugs pmd:pmd checkstyle:checkstyle"
                    def findbugs = scanForIssues tool: spotBugs(pattern: '**/target/findbugsXml.xml')
                    publishIssues issues: [findbugs]
                    def pmd = scanForIssues tool: pmdParser(pattern: '**/target/pmd.xml')
                    publishIssues issues: [pmd]
                    def checkstyle = scanForIssues tool: checkStyle(pattern: '**/target/checkstyle-result.xml')
                    publishIssues issues: [checkstyle]
                    sh "mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sonarqubetoken"
                }
            }
        }
        stage("Tag") {
            steps {
                script {
                    echo "Tagging..."
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