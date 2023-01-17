pipeline {
    triggers {
        cron('45 6 * * 1-5')
    }
    agent any
    tools{
        jdk 'jdk_17'
        maven 'maven_3_8_6'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/minhtv14/Devops-Deploy-Docker-Kubernetes-using-Jenkins.git']]])
                bat 'mvn clean install'
            }
        }
        stage('Build Docker Image'){
            steps{
                script{
                    bat 'docker build -t m145/devops-auto .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                    bat 'docker login -u m145 -p Minh@docker2002'
                    bat 'docker push m145/devops-auto'
                }
            }
        }
        stage('Deploy k8s'){
            steps{
                kubernetesDeploy (configs: 'deploymentservice.yaml',kubeconfigId: 'k8sconfigpwd')
            }
        }
    }
}