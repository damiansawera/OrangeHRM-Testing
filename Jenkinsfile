pipeline {
    agent any
    stages {
        stage('replace') {
            steps {
                script {
                    config = readFile "src/test/java/config/configuration.properties"
                    newConfig = config.replaceAll("isRemote=.*","isRemote=${isRemote}")
                    writeFile file: "src/test/java/config/configuration.properties", text: "${newConfig}"
                }
            }
        }
        stage('Run Tests') {
            steps {
                bat script: 'mvn clean test'
            }
        }
    }
    post {
        success {
            allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results']]
            ])
        }
    }
}
