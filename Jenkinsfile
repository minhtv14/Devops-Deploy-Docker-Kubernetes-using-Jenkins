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
			
		    sh 'docker run -p 9001:8080 m145/devops-auto:latest'
			
		    sh 'docker login -u m145 -p Minh@docker2002'
			
		    sh 'docker tag m145/devops-auto:latest m145/devops-auto:latest'
			
                    sh 'docker push m145/devops-auto'
		    
		    sh 'docker pull m145/devops-auto'
                }
            }
        }
	   
//         stage('Push image to Hub'){
//             steps{
//                 script{
//                     sh 'docker login -u m145 -p Minh@docker2002'
			
// 		    sh 'docker tag m145/devops-auto:latest m145/devops-auto:latest'
			
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
