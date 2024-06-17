package com.i27academy.k8s

class K8s {
    def jenkins
    K8s(jenkins) {
        this.jenkins = jenkins
    }

    // Method to authenticate to kubernetes clusters
    def auth_login(){
        jenkins.sh """
        echo "Entering into Kuberentes Authentication/Login Method"
        gcloud compute instances list
        """
    }
}
//  # gcloud auth activate-service-account jenkins@quantum-weft-420714.iam.gserviceaccount.com --key-file=${gke_sa_json}