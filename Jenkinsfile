pipeline {
    agent any
    tools{
        jdk 'jdk_11'
        maven 'maven_3'
    }
    stages{
        stage('Update GIT') {
          steps {
            script {
              catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                withCredentials([usernamePassword(credentialsId: 'gitM', passwordVariable: 'GIT_PASSWORD', usernameVariable: 'GIT_USERNAME')]) {
                    sh "git config user.email minhtv145@gmail.com"
                    sh "git config user.name minhtv14"
                    sh "git add ."
                    sh "git checkout main"
                    sh "git commit -m 'Triggered Build: ${env.BUILD_NUMBER}'"
                    sh "git push https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/${GIT_USERNAME}/Devops-Deploy-Docker-Kubernetes-using-Jenkins.git"
                }
              }
            }
          }
        }
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
