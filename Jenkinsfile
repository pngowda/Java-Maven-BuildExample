
pipeline {
    agent any
    stages {
	stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=false test'
		//currentBuild.result = 'UNSTABLE'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
		    
		    notifyemail()
		    //load "vars/sendNotifications.groovy"
		    //sendNotifications currentBuild.result
                }
            }
        }
      }
}

@NonCPS
notifyemail(){
	 //def mailRecipients = emailextrecipients([[$class: 'CulpritsRecipientProvider'],
          //                       [$class: 'DevelopersRecipientProvider'],
          //                       [$class: 'RequesterRecipientProvider']])
	//println "${mailRecipients}"
          def mailRecipients = "prajwaln22@gmail.com"
          def jobName = currentBuild.fullDisplayName
          emailext attachLog: true,
		   body: '''${SCRIPT, template="test_html.template"}''',
                   mimeType: 'text/html',
                   subject: "[Jenkins] ${jobName}",
                   to: "${mailRecipients}, prajwaln22@gmail.com"
                   replyTo: "${mailRecipients}"
                   recipientProviders: [[$class: 'CulpritsRecipientProvider']]
		
      }


