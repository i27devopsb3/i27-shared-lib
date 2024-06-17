package com.i27academy.builds

class Docker {
    def jenkins
    Docker(jenkins) {
        this.jenkins = jenkins
    }

   // Addition Method 
   def add(firstNumber, secondNumber) { // add(4,5)
    // business logic  
    return firstNumber+secondNumber
   }

   // Application Build 
    def buildApp(appName){
        jenkins.sh """
        echo "Building the Maven for $appName application using Shared Library"
        mvn clean package -DskipTests=true'
        """
    }

    // Docker build

    // Docker login 

    // Docker push 
}