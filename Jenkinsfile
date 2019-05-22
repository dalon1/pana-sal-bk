pipeline {
    agent any
    stages {
        stage("Build & test") {
            steps {
                script {
                    echo "Building and testing..."
                    //withSonarQubeEnv("MySonarQube") {
                        rtMaven = Artifactory.newMavenBuild()
                        rtMaven.tool = "M3"
                        buildInfo = rtMaven.run pom: "pom.xml", goals: "clean install findbugs:findbugs pmd:pmd checkstyle:checkstyle"
                    //}
                }
            }
        }
        stage("Code Analysis") {
            steps {
                script {
                    echo "Running static code analysis tools..."
                    def findbugs = scanForIssues tool: spotBugs(pattern: '**/target/findbugsXml.xml')
                    publishIssues issues: [findbugs]
                    def pmd = scanForIssues tool: pmdParser(pattern: '**/target/pmd.xml')
                    publishIssues issues: [pmd]
                    def checkstyle = scanForIssues tool: checkStyle(pattern: '**/target/checkstyle-result.xml')
                    publishIssues issues: [checkstyle]
                }
            }
        }
        stage("Publish") {
            steps {
                script {
                    echo "Publishing..."
                    def artifactoryServer = Artifactory.server "MyArtifactory"
                    rtMaven.deployer server: artifactoryServer, releaseRepo: "lib-panasalbk-local", snapshotRepo: "lib-panasalbk-local"
                    artifactoryServer.publishBuildInfo buildInfo
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
