def call(conf){
  def repoName = conf["repoName"]
  def pomfile = readMavenPom file: 'pom.xml'
  def version = pomfile.version
  def artifactId = pomfile.artifactId
  def type = pomfile.packaging
  def groupId = pomfile.groupId
  nexusArtifactUploader artifacts: [[artifactId: "${artifactId}", classifier: '', file: "target/${artifactId}-${version}.war", type: type]], credentialsId: 'Nexus3', groupId: groupId, nexusUrl: '3.17.70.234:8081/', nexusVersion: 'nexus3', protocol: 'http', repository: repoName, version: "${version}"
}
