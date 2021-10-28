def call(ip,credsID,warName){
  sshagent(["${CredsID}"]) {
    sh "scp -o StrictHostKeyChecking=no target/${warName}.war ec2-user@${ip}:/opt/tomcat8/webapps/"
   sh "ssh ec2-user@${ip} /opt/tomcat8/bin/shutdown.sh"
    sh "ssh ec2-user@${ip} /opt/tomcat8/bin/startup.sh"
               }
}
