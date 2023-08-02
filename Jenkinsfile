pipeline {
    agent any
    stages {
        stage('Run Tests') {
            steps {
                bat script: 'mvn clean test'
            }
        }
    }
    post {
        always {
            allure([
                includeProperties: false,
                jdk: '',
                results: [[path: 'allure-results']]
            ])
        }
    }
}
