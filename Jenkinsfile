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
        stage('Deploy Docker & Push image to Hub'){
            steps{
                script{
                    
		            sh "docker stop devops-auto"
		  
		            sh "docker rm devops-auto"
		  
		            sh "docker run --name devops-auto -d -p 8088:8080 m145/devops-auto:latest"

                    sh 'docker login -u m145 -p Minh@docker2002'
                    sh 'docker push m145/devops-auto'
                }
            }
        }
//         stage('Deploy k8s'){
//             steps{
//                  script{
//                     kubernetesDeploy (configs: 'deploymentservice.yaml',kubeconfigId: 'k8sconfigpwd')
//                  }
//             }
//         }
    }
}
