Run the whole module with the following maven command: 
test jacoco:report pitest:mutationCoverage

To run a specific module add the -pl flag together with the module to build, e.g.:
test jacoco:report pitest:mutationCoverage -pl AddBinary

<img alt="img.png" height="350" src="maven-run-configuration.png" width="300"/>