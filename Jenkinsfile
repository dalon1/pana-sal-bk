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
                    // todo: fix connection refused error
                    //sh "mvn sonar:sonar -Dsonar.host.url=http://host.docker.internal:9000 -Dsonar.login=admin -Dsonar.password=admin"
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
        stage("Publish") {
            steps {
                script {
                    echo "Publishing..."
                    def artifactoryServer = Artifactory.server "MyArtifactory"
                    def rtMaven = Artifactory.newMavenBuild()
                    rtMaven.deployer server: artifactoryServer, releaseRepo: "lib-panasalbk-local", snapshotRepo: "lib-panasalbk-local"
                    def buildInfo = rtMaven.run pom: "pom.xml", goals: "clean install"
                    artifactoryServer.publishBuildInfo buildInfo
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