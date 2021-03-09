package org.foo
class Utilities {
static def mvn(script,args) {
script.sh "${script.tool 'Maven'}/bin/mvn -s ${script.env.HOME}/pom.xml -o ${args}"

 }
}
