pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
		    notifyemail()
                }
            }
        }
      }
}


notifyemail(){
          def mailRecipients = "external.Prajwal.Gowda@de.bosch.com"
          def jobName = currentBuild.fullDisplayName
          emailext body: '''${SCRIPT, template="groovy-html.template"}''',
                   mimeType: 'text/html',
                   subject: "[Jenkins] ${jobName}",
                   to: "${mailRecipients}",
                   replyTo: "${mailRecipients}",
                   recipientProviders: [[$class: 'CulpritsRecipientProvider']]
		
      }


