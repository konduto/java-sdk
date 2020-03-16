* Run `gradle build && gradle jar && gradle signMavenJavaPublication`
* Login to https://oss.sonatype.org
* Go to Staging Upload
* Select `Artifact(s) with a POM`
* Upload the POM from `build/publications/mavenJava` (file should renamed to
 java-sdk-VERSION.pom before uploading)
* Select artifacts to upload
    * Signed pom (rename build/publications/mavenJava pom signature file to java
    -sdk-VERSION.pom.asc before uploading)
    * Javadoc and javadoc .asc
    * Sources and sources .asc
    * Jar and jar .asc
* Go to Staging Repositories and check all validations passed
* Refresh & release
