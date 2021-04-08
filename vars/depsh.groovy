def call(String Jname) {
 
   
 sh 'scp -r /root/.jenkins/workspace/Jname/target/*.war root@52.152.229.140:/root/tool/apache-tomcat-8.5.64/webapps/'
  
}
