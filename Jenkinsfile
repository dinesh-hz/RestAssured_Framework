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
				bat 'mvn clean compile'
			}
		}

		stage('Test') {
			steps {
				bat 'mvn test'
			}
		}

		stage('Report') {
			steps {
				bat 'mvn verify'
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
		success {
			echo "✅ Build and tests successful!"
			cleanWs() // clean only on success to keep failed run data for debugging
		}
		failure {
			echo "❌ Build failed. Keeping workspace for debugging."
		}
		always {
			echo "Post build actions complete."
		}
	}

}
