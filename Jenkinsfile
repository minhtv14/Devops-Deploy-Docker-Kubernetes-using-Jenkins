pipeline {
    agent any
    tools{
        jdk 'jdk_11'
        maven 'maven_3'
    }
    stages{
//         stage('Update GIT') {
//           steps {
//             script {
//               catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
//                 withCredentials([usernamePassword(credentialsId: 'gitM', passwordVariable: 'GIT_PASSWORD', usernameVariable: 'GIT_USERNAME')]) {
//                     sh "git config user.email minhtv145@gmail.com"
//                     sh "git config user.name minhtv14"
//                     sh "git add ."
//                     sh "git diff --quiet && git diff --staged --quiet || git commit -am 'Added license headers'"
//                     sh "git remote set-url origin https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/${GIT_USERNAME}/Devops-Deploy-Docker-Kubernetes-using-Jenkins.git"
//                     sh "git push -u origin main"
//                 }
//               }
//             }
//           }
//         }
        stage('Build Maven'){
            steps{
                script{
                  node {
                  checkout scm
                  result = sh (script: "git log -1 | grep '\\[ci skip\\]'", returnStatus: true) 
                  if (result != 0) {
                    echo "performing build..."
                      checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/minhtv14/Devops-Deploy-Docker-Kubernetes-using-Jenkins.git']]])
                     sh 'mvn clean install'
                  } else {
                    echo "not running..."
                  }
                }
                }
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
