pipeline {
    agent any
    stages {
        stage('run tests') {
            steps {
               sh './mvnw clean test'
            }
        }
    }
}
