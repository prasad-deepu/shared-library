def call( ) {
    
   
                  def  pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                 
            
    }
step([$class: 'NexusArtifactUploader',
     artifacts: [[artifactId: pom.artifactId, classifier: '', file: artifactPath, type: pom.packaging]], 
   credentialsId: NEXUS_CREDENTIAL_ID, 
   groupId: pom.groupId, 
   nexusUrl: NEXUS_URL, 
   nexusVersion: 'nexus3', 
   protocol: NEXUS_PROTOCOL, 
   repository: NEXUS_REPOSITORY,
   version: pom.version])
 
                    
    }
