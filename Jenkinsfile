pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps { 
               git url:'https://github.com/mansungjun/calculator.git',branch:'main'
                
            }

        }
        
        stage('Compile') {
            steps { 
               sh "chmod +x gradlew"
               sh "./gradlew compileJava"
                
            }

        }

        
        stage('test') {
            steps { 
               sh "./gradlew test"
                
            }

        }
        stage("Code coverage") { 
            steps { 
                sh "./gradlew jacocoTestReport" 
                sh "./gradlew jacocoTestCoverageVerification" 
            } 
        }


        
   
    }
}
