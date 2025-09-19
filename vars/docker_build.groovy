def call(String imageName, String imageTag = "latest", String dockerHubUser = null) {
    def fullImageName = dockerHubUser ? "${dockerHubUser}/${imageName}:${imageTag}" : "${imageName}:${imageTag}"

    echo "Building Docker image: ${fullImageName}"

    sh """
        docker build -t ${fullImageName} .
    """
}
