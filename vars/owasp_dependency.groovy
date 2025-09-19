def call(String projectName = "default-project", String scanPath = ".", String outputDir = "dependency-check-report") {
    echo "Running OWASP Dependency Check on ${scanPath} for project ${projectName}"

    sh """
        dependency-check.sh \
          --project "${projectName}" \
          --scan ${scanPath} \
          --format "ALL" \
          --out ${outputDir} || true
    """
}
