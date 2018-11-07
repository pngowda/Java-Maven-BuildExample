
pipeline {
    agent any
    stages {
	stage('Build') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests  clean package'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn -Dmaven.test.failure.ignore=true test'
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
          def mailRecipients = "external.Prajwal.Gowda@de.bosch.com"
          def jobName = currentBuild.fullDisplayName
          emailext body: '''${SCRIPT, template="test_new.template"}''',
                   mimeType: 'text/html',
                   subject: "[Jenkins] ${jobName}",
                   to: "${mailRecipients}, external.Prajwal.Gowda@de.bosch.com"
                   replyTo: "${mailRecipients}"
                   recipientProviders: [[$class: 'CulpritsRecipientProvider']]
		
      }


