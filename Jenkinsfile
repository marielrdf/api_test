pipeline {
  agent any
  tools { 
    gradle "gradle"
  }

  stages {
    stage("buil") {
      steps {
        bat 'gradle --version'
      }
    }
    stage("test") {
      steps {
        bat 'gradle cucumber'
      }
    }
    stage("deploy") {
      steps {
        bat 'echo deploying'
      }
    }
  }
}
