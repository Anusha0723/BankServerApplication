pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/Anusha0723/BankServerApplication.git'
            }
        }
        stage('Build') {
            steps {
                echo 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'mvn deploy'
            }
        }
    }
}
