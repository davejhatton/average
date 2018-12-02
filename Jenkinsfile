pipeline {
    agent any
    tools {
        maven 'Maven 3.6.0'
        jdk 'jdk9'
    }
    stages {
        stage ('Initialize') {
            steps {
                echo 'placeholder'
            }
        }

        stage ('Build') {
            steps {
                shell 'mvn -Dmaven.test.failure.ignore=true verify'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
    }
}