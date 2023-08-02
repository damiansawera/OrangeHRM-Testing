pipeline {
    agent any
    environment {
        isRemote = env.isRemote
    stages {
        stage('Prepare Environment') {
            steps {
                }
                script {
                    if (isRemote) {
                        bat 'powershell -Command "(gc configuration.properties) -replace \'isRemote=.*\', \'isRemote=true\' | Out-File configuration.properties"'
                    } else {
                        bat 'powershell -Command "(gc configuration.properties) -replace \'isRemote=.*\', \'isRemote=false\' | Out-File configuration.properties"'
                    }
                }
            }
        }
        stage('Run Tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'UNSTABLE') {
                    bat script: 'mvn clean test'
                }
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
