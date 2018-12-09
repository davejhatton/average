pipeline {
     agent {
         docker {
              image 'maven:3-jdk-10-slim'
              args '-v /root/.m2:/root/.m2'
         }
     }
     stages {
        stage ('Initialize') {
            steps {
                echo 'placeholder'
            }
        }
        stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
        stage('SonarQube analysis') {
                // requires SonarQube Scanner 2.8+
                def scannerHome = tool 'SonarQube Scanner 2.8';
                withSonarQubeEnv('My SonarQube Server') {
                sh "${scannerHome}/bin/sonar-scanner"
            }
        }
    }
}