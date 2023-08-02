pipeline {
    agent any
    stages {
        stage('run tests') {
            steps {
               bat script: 'mvn clean test'
            }
        }
    }
}
