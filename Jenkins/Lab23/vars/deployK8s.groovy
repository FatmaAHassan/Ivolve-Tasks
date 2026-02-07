def call(String imageName, String imageTag) {
    sh "sed -i 's|image:.*|image: ${imageName}:${imageTag}|g' deployment.yaml"
    sh "kubectl apply -f deployment.yaml"
}
