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
                publishHTML (target: [ 
                    reportDir: 'build/reports/jacoco/test/html', 
                    reportFiles: 'index.html', 
                    reportName: "JaCoCo Report" 
                ]) 
                sh "./gradlew jacocoTestCoverageVerification"

            } 
        }
        stage("Static code analysis") { 
            steps { 
                sh "./gradlew checkstyleMain" 
                publishHTML (target: [ 
                    reportDir: 'build/reports/checkstyle/', 
                    reportFiles: 'main.html', 
                    reportName: "Checkstyle Report" 
                ]) 
               

            } 
        }

        stage("Packaging") { 
            steps { 
                sh "./gradlew build" 
            } 
        }

        stage("Docker build") { 
            steps { 
                sh "docker build -t calculator" 
            } 
        }

        stage("Docker push") { 
            steps { 
                sh "docker push  msjun/calculator" 
            } 
        }  


        stage("Deploy to stage") { 
            steps { 
                sh "docker run -d --rm -p 8765:8080 --name calculator calculator"

            } 
        }

        stage("Acceptance test") { 
            steps { 
                sleep 60
                sh "chmod +x acceptance_test.sh && ./acceptance_test.sh"
 
            }

            post {
                always { sh "docker stop calculator" }

            }     
        }

        
       
   
    }
}
