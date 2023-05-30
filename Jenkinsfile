pipeline {
    agent any
    tools{
        jdk 'jdk_11'
        maven 'maven_3'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/minhtv14/Devops-Deploy-Docker-Kubernetes-using-Jenkins.git']]])
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image'){
            steps{
                script{
                    sh 'docker build -t m145/devops-auto .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                    sh 'docker login -u m145 -p Minh@docker2002'
                    sh 'docker push m145/devops-auto'
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
