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
        }
        stage ('Analysis') {
             steps {
                       sh '${M2_HOME}/bin/mvn --batch-mode -V -U -e checkstyle:checkstyle pmd:pmd pmd:cpd findbugs:findbugs spotbugs:spotbugs'
                    }
        }
     }
     post {
                always {
                    junit 'target/surefire-reports/**/*.xml'

                    recordIssues enabledForFailure: true,
                                    tools: [[tool: [$class: 'MavenConsole']],
                                            [tool: [$class: 'Java']],
                                            [tool: [$class: 'JavaDoc']]]
                                recordIssues enabledForFailure: true, tools: [[tool: [$class: 'CheckStyle']]]
                                recordIssues enabledForFailure: true, tools: [[tool: [$class: 'FindBugs']]]
                                recordIssues enabledForFailure: true, tools: [[tool: [$class: 'SpotBugs']]]
                                recordIssues enabledForFailure: true, tools: [[pattern: '**/target/cpd.xml', tool: [$class: 'Cpd']]]
                                recordIssues enabledForFailure: true, tools: [[pattern: '**/target/pmd.xml', tool: [$class: 'Pmd']]]
                }
            }
          }
    }
}