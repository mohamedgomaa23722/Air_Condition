pipeline{
  agent any
  tools{
    maven 'maven-3.9.4'
  }
  stages{
    stage('Build'){
       steps{
            checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/mohamedgomaa23722/Air_Condition.git']])
            bat 'mvn clean install'
	    }
    }
    stage('Test'){
        steps{
            bat'mvn test'
        }
    }

    stage('Delivery'){
        steps{
            script{
              bat 'docker login -u gomaa123 -p 123456789'
              bat "docker build -t gomaa123/aircondition:V${BUILD_NUMBER} ."
              bat "docker push gomaa123/aircondition:V${BUILD_NUMBER}"
            //bat "docker run --network=springboot-mysql-net --name=springboot-containerwithV${BUILD_NUMBER} -p 8084:8080 -d gomaa123/aircondition:V${BUILD_NUMBER}"
            }
        }
    }

   }
}