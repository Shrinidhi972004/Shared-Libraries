def call() {
    echo "Checking SonarQube quality gate status"

    timeout(time: 5, unit: 'MINUTES') {
        waitForQualityGate abortPipeline: true
    }
}
