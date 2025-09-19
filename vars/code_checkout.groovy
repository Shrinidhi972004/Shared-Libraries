def call(String repoUrl, String branch = "main") {
    checkout([
        $class: 'GitSCM',
        branches: [[name: branch]],
        doGenerateSubmoduleConfigurations: false,
        extensions: [[$class: 'CleanBeforeCheckout']],   // cleans workspace before pulling
        userRemoteConfigs: [[url: repoUrl]]
    ])
}
