package com.i27academy.k8s

class K8s {
    def jenkins
    K8s(jenkins) {
        this.jenkins = jenkins
    }

    // Method to authenticate to kubernetes clusters
    def auth_login(gke_cluster_name, gke_zone, gke_project){
        jenkins.sh """
        echo "************************ Entering into Kuberentes Authentication/Login Method ************************"
        gcloud compute instances list
        gcloud container clusters get-credentials $gke_cluster_name --zone $gke_zone --project $gke_project
        echo "********************** Get nodes in the Cluster **********************"
        kubectl get nodes
        """
    }
    // Kubernetes Deployment 
    def k8sdeploy(fileName, namespace , docker_image){
        jenkins.sh """
        echo "************************ Executing K8S Deploy Method ************************"
        sed -i "s|DIT|${docker_image}|g" ./.cicd/$fileName
        kubectl apply -f ./.cicd/$fileName -n $namespace
        """
    }

    // Helm Deployment 
    def k8sHelmChartDeploy(appName, env, helmChartPath, imageTag){
        jenkins.sh """
        echo "************************ Executing Helm Groovy Method ************************"
        helm version
        echo "Installing the Chart"
        helm install ${appName}-${env}-chart -f ./.cicd/k8s/values_${env}.yaml --set image.tag=${imageTag} ${helmChartPath}
        """
    }


}

// Helm Deployment 


// helm install eureka-dev-chart 
// helm install chartName chartLocation -f values.yaml(these are specific to microservice)

//  # gcloud auth activate-service-account jenkins@quantum-weft-420714.iam.gserviceaccount.com --key-file=${gke_sa_json}


