pipeline {
  agent any
  tools { 
    gradle "gradle"
  }

  stages {
    stage("gradle --version") {
      steps {
        bat 'echo building'
      }
    }
    stage("test") {
      steps {
        bat 'echo test'
      }
    }
    stage("deploy") {
      steps {
        bat 'echo deploying'
      }
    }
  }
}
