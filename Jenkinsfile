pipeline {
    agent any
    environment {
        isRemote = env.isRemote == "true" ? true : false
    }
    stages {
        stage('Prepare Environment') {
            steps {
                script {
                    def filePath = "configuration.properties"
                    def isRemoteValue = isRemote ? "true" : "false"


                    bat label: 'Update configuration.properties', script: '''
                        (Get-Content "%filePath%") | ForEach-Object { $_ -replace '^isRemote=.*', 'isRemote=%isRemoteValue%' } | Set-Content "%filePath%"
                    '''
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
