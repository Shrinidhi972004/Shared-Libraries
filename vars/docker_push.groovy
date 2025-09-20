def call(String imageName, String imageTag = "latest", String dockerHubUser) {
    def fullImageName = "${dockerHubUser}/${imageName}:${imageTag}"

    echo "Pushing Docker image: ${fullImageName}"

    withCredentials([usernamePassword(credentialsId: 'Dockerhub-cred', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh """
            echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
            docker push ${fullImageName}
            docker logout
        """
    }
}
