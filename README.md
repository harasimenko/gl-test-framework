# gl-test-framework

This is a test framework for https://jsonplaceholder.typicode.com/ public api 

1.Clone repository
```bash
> git clone https://github.com/harasimenko/gl-test-framework
```
2.Command line for running tests with default settings:
```bash
> gradlew test
```
3.Command line for running tests on exact env:
```bash
> gradlew test -Denv=$env
```
$env= {Dev, QA}

4.Command line for generating Allure report:
```bash
> gradlew allureReport
```