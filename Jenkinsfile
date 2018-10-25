node('master') {
        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
		junit 'target/surefire-reports/*.xml'
            }
        }
        stage('Send email') {
          def mailRecipients = "external.Prajwal.Gowda@de.bosch.com"
          def jobName = currentBuild.fullDisplayName
          emailext body: '''${SCRIPT, template="groovy-html.template"}''',
                   mimeType: 'text/html',
                   subject: "[Jenkins] ${jobName}",
                   to: "${mailRecipients}",
                   replyTo: "${mailRecipients}",
                   recipientProviders: [[$class: 'CulpritsRecipientProvider']]
		
      }
}

