def call(String sonarEnv, String projectKey, String projectName, String sourceDir = ".") {
    echo "Running SonarQube analysis for project ${projectName} on ${sourceDir}"

    withSonarQubeEnv(sonarEnv) {
        sh """
            sonar-scanner \
              -Dsonar.projectKey=${projectKey} \
              -Dsonar.projectName=${projectName} \
              -Dsonar.sources=${sourceDir}
        """
    }
}
