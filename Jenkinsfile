pipeline {
	agent any
	tools {
		jdk 'JAVA_HOME'
		maven 'Maven  3.10'
	}

	stages {
		stage('Checkout') {
			steps {
				checkout scm
			}
		}

		stage('Build') {
			steps {
				sh 'mvn clean compile'
			}
		}

		stage('Test') {
			steps {
				sh 'mvn test'
			}
		}

		stage('Report') {
			steps {
				sh 'mvn verify'
			}
		}

		stage('Publish Cucumber JVM Report') {
			steps {
				publishHTML(target: [
					allowMissing: false,
					alwaysLinkToLastBuild: true,
					keepAll: true,
					reportDir: 'target/cucumber-reports/cucumber-html-reports',
					reportFiles: 'overview-features.html',
					reportName: 'Cucumber JVM HTML Report'
				])
			}
		}

		stage('Publish Extent Report') {
			steps {
				publishHTML(target: [
					allowMissing: false,
					alwaysLinkToLastBuild: true,
					keepAll: true,
					reportDir: 'HTML_Report',
					reportFiles: 'Spark.html',
					reportName: 'Extent Spark HTML Report'
				])
			}
		}
	}

	//  post block must come here — outside "stages"
	post {
		always {
			echo "Cleaning workspace..."
			cleanWs()
		}
		success {
			echo "✅ Build and tests successful!"
		}
		failure {
			echo "❌ Build failed. Check the logs above."
		}
	}
}
