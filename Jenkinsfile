pipeline {
    agent any
    stages {
        stage('replace') {
            steps {
                  script {
                      config = readFile "src/test/java/config/configuration.properties"
                      newConfig = config.replaceAll("isRemote=.*","browserName=${isRemote}")
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
        always {
            allure([
                includeProperties: false,
                jdk: '',
                results: [[path: 'allure-results']]
            ])
        }
    }
}