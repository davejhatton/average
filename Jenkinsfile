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
                sh 'mvn -Dmaven.test.failure.ignore=true verify'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
    }
}