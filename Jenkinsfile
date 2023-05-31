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
                    sh "docker stop m145/devops-auto"
		  
		    sh "docker rm m145/devops-auto"
		  
		    sh "docker run --name m145/devops-auto -d -p 2222:2222 m145/devops-auto:latest"
                }
            }
        }
//         stage('Push image to Hub'){
//             steps{
//                 script{
//                     sh 'docker login -u m145 -p Minh@docker2002'
//                     sh 'docker push m145/devops-auto'
//                 }
//             }
//         }
//         stage('Deploy to k8s'){
//             steps{
//                 script{
//                     kubernetesDeploy (configs: 'deploymentservice.yaml',kubeconfigId: 'k8sconfigpwd')
//                 }
//             }
//         }
    }
}
