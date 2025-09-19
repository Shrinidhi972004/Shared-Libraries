def call(String target = ".") {
    echo "Running Trivy scan on ${target}"

    sh """
        trivy --version || (echo 'Trivy not installed' && exit 1)

        if [ -d "${target}" ]; then
          echo "Scanning filesystem: ${target}"
          trivy fs --exit-code 0 --severity HIGH,CRITICAL ${target} || true
        else
          echo "Scanning Docker image: ${target}"
          trivy image --exit-code 0 --severity HIGH,CRITICAL ${target} || true
        fi
    """
}
