pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/damiansawera/OrangeHRM-Testing.git']]])
            }
        }

        stage('Build') {
            steps {
                sh "mvn clean install"
            }
        }

        stage('Run Tests') {
            steps {
                withEnv(['IS_REMOTE=false']) {
                    sh "mvn clean test"
                }
            }
        }

        stage('Generate Allure Reports') {
            steps {
                sh "mvn allure:report"
            }
        }

        stage('Publish Allure Reports') {
            steps {
                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
}
