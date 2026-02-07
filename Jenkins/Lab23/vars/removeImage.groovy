def call(String imageName, String imageTag) {
    sh "docker rmi ${imageName}:${imageTag}"
}
